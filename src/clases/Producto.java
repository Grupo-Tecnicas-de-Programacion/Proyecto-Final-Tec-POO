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

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private int cantidadDisponible;
    private int cantidad; 


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

}