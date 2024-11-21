package clases;

import com.mysql.cj.jdbc.result.ResultSetImpl;
import conexion.ConexionDB;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Mesa {
    private int numeroMesa;
    private String estado;
    private int capacidad;
    private ArrayList<Pedido> listaPedidos;
    private Cuenta cuenta;
    private Cliente cliente;

    public Mesa() {
        this.listaPedidos = new ArrayList<>();
        this.cuenta = new Cuenta(); 
        this.estado = "Desocupada";
        this.cliente = null;
    }

    public Mesa(int numeroMesa, int capacidad) {
        this.numeroMesa = numeroMesa;
        this.estado = "Desocupada";
        this.capacidad = capacidad;
        this.listaPedidos = new ArrayList<>();
        this.cuenta = new Cuenta(); 
        this.cliente = null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
        this.estado = !listaPedidos.isEmpty() ? "Ocupada" : "Desocupada";
    }

    public static boolean cargarMesasDesdeArchivo(File archivo) {
        if (archivo == null || !archivo.exists()) {
            System.out.println("El archivo no existe o no es válido.");
            return false;
        }

        String consultaEliminarMesas = "DELETE FROM mesas";
        String consultaResetAutoIncrement = "ALTER TABLE mesas AUTO_INCREMENT = 1";
        String consultaInsertarMesas = "INSERT INTO mesas (numero_mesa, estado, capacidad) VALUES (?, ?, ?)";

        try (BufferedReader leer = new BufferedReader(new FileReader(archivo));
             Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaEliminar = conexion.prepareStatement(consultaEliminarMesas);
             PreparedStatement sentenciaResetAI = conexion.prepareStatement(consultaResetAutoIncrement);
             PreparedStatement sentenciaInsertar = conexion.prepareStatement(consultaInsertarMesas)) {

            sentenciaEliminar.executeUpdate();

            sentenciaResetAI.executeUpdate();

            String linea;
            while ((linea = leer.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length != 3) {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    continue;
                }

                try {
                    int numeroMesa = Integer.parseInt(partes[0].trim());
                    String estado = partes[1].trim().toUpperCase();
                    int capacidad = Integer.parseInt(partes[2].trim());

                    if (!estado.equals("DESOCUPADA") && !estado.equals("OCUPADA") && !estado.equals("NO DISPONIBLE")) {
                        System.out.println("Estado inválido en la línea: " + linea);
                        continue;
                    }

                    sentenciaInsertar.setInt(1, numeroMesa);
                    sentenciaInsertar.setString(2, estado);
                    sentenciaInsertar.setInt(3, capacidad);
                    sentenciaInsertar.addBatch();

                } catch (NumberFormatException e) {
                    System.out.println("Error en los valores numéricos de la línea: " + linea);
                }
            }

            sentenciaInsertar.executeBatch();
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

    public static String obtenerInformacionMesaBD(int numeroMesa) {
        String query = "SELECT numero_mesa, estado, capacidad FROM mesas WHERE numero_mesa = ?";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(query)) {

            sentencia.setInt(1, numeroMesa);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                int numero = resultado.getInt("numero_mesa");
                String estado = resultado.getString("estado");
                int capacidad = resultado.getInt("capacidad");

                return "Número de mesa: " + numero + "\n" +
                       "Estado: " + estado + "\n" +
                       "Capacidad: " + capacidad + "\n";
            } else {
                return "La mesa no se encontró en la base de datos.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error al consultar la base de datos: " + e.getMessage();
        }
    }

    public static boolean actualizarEstadoMesaEnBaseDatos(int numeroMesa, String nuevoEstado) {
        String query = "UPDATE mesas SET estado = ? WHERE numero_mesa = ?";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, numeroMesa);

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList<Pedido> obtenerPedidosDeMesa(int numeroMesa) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String query = "SELECT * FROM pedidos WHERE id_mesa = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(query)) {

            sentencia.setInt(1, numeroMesa);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Pedido pedido = new Pedido();
                pedido.setNumPedido(resultado.getInt("num_pedido"));
                pedido.setTipoPedido(resultado.getString("tipo_pedido"));
                pedido.setPrecioTotalPedido(resultado.getDouble("precio_total"));
                pedido.setFechaHora(resultado.getTimestamp("fecha_hora"));
                pedido.setListaProductos(obtenerProductosDePedido(pedido.getNumPedido()));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    public static Mesa obtenerMesaPorNumero(int numeroMesa) {
        Mesa mesa = null;
        String queryMesa = "SELECT * FROM mesas WHERE numero_mesa = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement stmtMesa = conexion.prepareStatement(queryMesa)) {

            stmtMesa.setInt(1, numeroMesa);
            try (ResultSet resultadoMesa = stmtMesa.executeQuery()) {
                if (resultadoMesa.next()) {
                    mesa = new Mesa();
                    mesa.setNumeroMesa(resultadoMesa.getInt("numero_mesa"));
                    mesa.setEstado(resultadoMesa.getString("estado"));
                    mesa.setCapacidad(resultadoMesa.getInt("capacidad"));
                    mesa.setListaPedidos(mesa.obtenerPedidosDeMesa(numeroMesa));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mesa;
    }

    private static ArrayList<Producto> obtenerProductosDePedido(int idPedido) {
        ArrayList<Producto> productos = new ArrayList<>();
        String query = "SELECT pp.cantidad, p.nombre, p.precio " +
                       "FROM pedido_productos pp " +
                       "JOIN productos p ON pp.id_producto = p.id " +
                       "WHERE pp.id_pedido = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setInt(1, idPedido);
            try (ResultSet resultado = stmt.executeQuery()) {
                while (resultado.next()) {
                    Producto producto = new Producto();
                    producto.setNombre(resultado.getString("nombre"));
                    producto.setCantidad(resultado.getInt("cantidad"));
                    producto.setPrecio(resultado.getDouble("precio"));
                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }
    
    public static double calcularTotalCuentaMesaDesdeDB(int numeroMesa) {
        double totalCuenta = 0;

        String queryPedidos = "SELECT p.id AS id_pedido, pp.cantidad, prod.precio " +
                              "FROM pedidos p " +
                              "JOIN pedido_productos pp ON p.id = pp.id_pedido " +
                              "JOIN productos prod ON pp.id_producto = prod.id " +
                              "WHERE p.id_mesa = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(queryPedidos)) {

            sentencia.setInt(1, numeroMesa);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                int cantidad = resultado.getInt("cantidad");
                double precio = resultado.getDouble("precio");
                totalCuenta += cantidad * precio;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return totalCuenta;
    }
    
    public static boolean eliminarPedidosDeMesaDesdeDB(int numeroMesa) {
        String consultaEliminarPedidos = "DELETE pp FROM pedido_productos pp " +
                                         "JOIN pedidos p ON pp.id_pedido = p.id " +
                                         "WHERE p.id_mesa = ?";

        String consultaEliminarPedidosTabla = "DELETE FROM pedidos WHERE id_mesa = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement eliminarProductos = conexion.prepareStatement(consultaEliminarPedidos);
             PreparedStatement eliminarPedidos = conexion.prepareStatement(consultaEliminarPedidosTabla)) {

            eliminarProductos.setInt(1, numeroMesa);
            eliminarProductos.executeUpdate();

            eliminarPedidos.setInt(1, numeroMesa);
            int filasAfectadas = eliminarPedidos.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al eliminar los pedidos de la mesa: " + e.getMessage());
            return false;
        }
    }

    
    public final class Cuenta {
        private double totalPagar;

        public Cuenta() {
            this.totalPagar = 0;
        }

        public Cuenta(double totalPagar) {
            this.totalPagar = 0;
        }

        public double getTotalPagar() {
            return totalPagar;
        }

        public void setTotalPagar(double totalPagar) {
            this.totalPagar = totalPagar;
        }

        public double calcularCuentaMesa(ArrayList<Pedido> pedidosMesa, ArrayList<Pedido> pedidosMesaLlevar) {
            double totalCuenta = 0;

            for (Pedido pedido : pedidosMesa) {
                for (Producto producto : pedido.getListaProductos()) {
                    totalCuenta += producto.getPrecio() * producto.getCantidad();
                }
            }

            for (Pedido pedido : pedidosMesaLlevar) {
                for (Producto producto : pedido.getListaProductos()) {
                    totalCuenta += producto.getPrecio() * producto.getCantidad();
                }
            }

            return totalCuenta;
        }

    }
}
