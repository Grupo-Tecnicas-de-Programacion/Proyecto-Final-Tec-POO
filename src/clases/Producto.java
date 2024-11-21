package clases;

import conexion.ConexionDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private int cantidadDisponible;
    private int cantidad; 

    public Producto() {
    }

    public Producto(String nombre, double precio, String categoria, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidad = 1; 
    }

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public void incrementarCantidad() {
        this.cantidad++;
    }
    
    public static boolean cargarProductosDesdeArchivo(File archivo) {
        if (archivo == null || !archivo.exists()) {
            System.out.println("El archivo no existe o no es válido.");
            return false;
        }

        String consultaEliminarProductos = "DELETE FROM productos";
        String consultaInsertarProductos = "INSERT INTO productos (nombre, precio, categoria, cantidad_disponible) VALUES (?, ?, ?, ?)";

        try (BufferedReader leer = new BufferedReader(new FileReader(archivo));
             Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaEliminar = conexion.prepareStatement(consultaEliminarProductos);
             PreparedStatement sentenciaInsertar = conexion.prepareStatement(consultaInsertarProductos)) {

                sentenciaEliminar.executeUpdate();

                String linea;
                while ((linea = leer.readLine()) != null) {
                    String[] partes = linea.split(",");
                    if (partes.length != 4) {
                        System.out.println("Formato incorrecto en la línea: " + linea);
                        continue;
                    }

                    String nombre = partes[0].trim();
                    double precio;
                    int cantidadDisponible;
                    try {
                        precio = Double.parseDouble(partes[1].trim());
                        cantidadDisponible = Integer.parseInt(partes[3].trim());
                    } catch (NumberFormatException e) {
                        System.out.println("Error en los valores numéricos de la línea: " + linea);
                        continue;
                    }
                    String categoria = partes[2].trim();

                    sentenciaInsertar.setString(1, nombre);
                    sentenciaInsertar.setDouble(2, precio);
                    sentenciaInsertar.setString(3, categoria);
                    sentenciaInsertar.setInt(4, cantidadDisponible);
                    sentenciaInsertar.addBatch();
                }

                sentenciaInsertar.executeBatch();
                System.out.println("Productos cargados correctamente.");
                return true;

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static Producto obtenerProductoDesdeBaseDatos(String nombreProducto) {
        String consultaProducto = "SELECT * FROM productos WHERE nombre = ?";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaConsulta = conexion.prepareStatement(consultaProducto)) {
                sentenciaConsulta.setString(1, nombreProducto);
                ResultSet resultado = sentenciaConsulta.executeQuery();
                if (resultado.next()) {
                    return new Producto(
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getString("categoria"),
                        resultado.getInt("cantidad_disponible")
                    );
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<Producto> obtenerProductosDePedido(int idPedido) {
        String consulta = "SELECT pr.nombre, pr.precio, pp.cantidad " +
                          "FROM pedido_productos pp " +
                          "INNER JOIN productos pr ON pp.id_producto = pr.id " +
                          "WHERE pp.id_pedido = ?";
        List<Producto> listaProductos = new ArrayList<>();

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setInt(1, idPedido);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    Producto producto = new Producto(
                        resultado.getString("nombre"),
                        resultado.getDouble("precio"),
                        resultado.getInt("cantidad")
                    );
                    listaProductos.add(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProductos;
    }
    
    public static boolean actualizarCantidadDisponibleProducto(String nombreProducto, int cantidad) {
        String conultaCantidad = "UPDATE productos SET cantidad_disponible = cantidad_disponible + ? WHERE nombre = ?";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaConsulta = conexion.prepareStatement(conultaCantidad)) {
                sentenciaConsulta.setInt(1, cantidad);
                sentenciaConsulta.setString(2, nombreProducto);
                int filasAfectadas = sentenciaConsulta.executeUpdate();
                return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
        
    public static boolean registrarProductosEnHistorial(int idPedido, List<Producto> productos, Date fecha) {
        String insertarHistorial = "INSERT INTO historial_pedidos (id_pedido, id_producto, cantidad, precio_unitario, fecha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaHistorial = conexion.prepareStatement(insertarHistorial)) {

            for (Producto producto : productos) {

                int idProducto = obtenerIdProductoDesdeBaseDatos(producto.getNombre());

                if (idProducto == -1) {
                    System.err.println("No se encontró el ID del producto con nombre: " + producto.getNombre());
                    return false;
                }

                sentenciaHistorial.setInt(1, idPedido);
                sentenciaHistorial.setInt(2, idProducto);
                sentenciaHistorial.setInt(3, producto.getCantidad());
                sentenciaHistorial.setDouble(4, producto.getPrecio());
                sentenciaHistorial.setDate(5, new java.sql.Date(fecha.getTime()));

                sentenciaHistorial.addBatch();
            }

            int[] resultados = sentenciaHistorial.executeBatch();
            for (int resultado : resultados) {
                if (resultado == PreparedStatement.EXECUTE_FAILED) {
                    System.err.println("Error al registrar un producto en el historial.");
                    return false;
                }
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al registrar productos en el historial: " + e.getMessage());
            return false;
        }
    }

    public static boolean agregarProductoEnBaseDeDatos(String nombre, double precio, String categoria, int cantidad) {
        String query = "INSERT INTO productos (nombre, precio, categoria, cantidad_disponible) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(query)) {

            sentencia.setString(1, nombre);
            sentencia.setDouble(2, precio);
            sentencia.setString(3, categoria);
            sentencia.setInt(4, cantidad);

            int filasAfectadas = sentencia.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al agregar producto a la base de datos: " + e.getMessage());
            return false;
        }
    }
    
    public static boolean actualizarProductoEnBaseDeDatos(int idProducto, String nuevoNombre, String nuevaCategoria, double nuevoPrecio, int nuevaCantidad) {
        String consulta = "UPDATE productos SET nombre = ?, categoria = ?, precio = ?, cantidad_disponible = ? WHERE id = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setString(1, nuevoNombre);
            sentencia.setString(2, nuevaCategoria);
            sentencia.setDouble(3, nuevoPrecio);
            sentencia.setInt(4, nuevaCantidad);
            sentencia.setInt(5, idProducto);

            int filasAfectadas = sentencia.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al actualizar el producto en la base de datos: " + e.getMessage());
            return false;
        }
    }

    public static Producto obtenerProductoPorIdDesdeBaseDeDatos(int idProducto) {
        String consulta = "SELECT nombre, categoria, precio, cantidad_disponible FROM productos WHERE id = ?";
        Producto producto = null;

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setInt(1, idProducto);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    String categoria = resultado.getString("categoria");
                    double precio = resultado.getDouble("precio");
                    int cantidad = resultado.getInt("cantidad_disponible");
                    
                    producto = new Producto(nombre, precio, categoria, cantidad);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el producto desde la base de datos: " + e.getMessage());
        }

        return producto;
    }
    
    public static int obtenerIdProductoDesdeBaseDatos(String nombreProducto) {
        String consulta = "SELECT id FROM productos WHERE nombre = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta)) {

            sentenciaConsulta.setString(1, nombreProducto);

            try (ResultSet resultado = sentenciaConsulta.executeQuery()) {
                if (resultado.next()) {
                    return resultado.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

}