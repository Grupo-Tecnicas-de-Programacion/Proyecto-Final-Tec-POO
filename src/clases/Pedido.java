package clases;

import conexion.ConexionDB;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.List;
import javax.swing.JList;


public class Pedido {
    private int id;
    private int numPedido;
    private List<Producto> listaProductos;
    private double precioTotalPedido;
    private String tipoPedido;
    private Timestamp fechaHora;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
        this.precioTotalPedido = 0;
    }

    public Pedido(int numPedido, String tipoPedido) {
        this.numPedido = numPedido;
        this.tipoPedido = tipoPedido;
        this.listaProductos = new ArrayList<>();
        this.precioTotalPedido = 0;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        recalcularTotal();
    }

    public double getPrecioTotalPedido() {
        return precioTotalPedido;
    }

    public void setPrecioTotalPedido(double precioTotalPedido) {
        this.precioTotalPedido = precioTotalPedido;
    }

    public String getTipoPedido() {
        return tipoPedido;
    }

    public void setTipoPedido(String tipoPedido) {
        this.tipoPedido = tipoPedido;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void recalcularTotal() {
        this.precioTotalPedido = 0;
        for (Producto producto : this.listaProductos) {
            this.precioTotalPedido += producto.getPrecio() * producto.getCantidad();
        }
    }
    
    public void agregarProducto(Producto producto) {
        boolean productoExistente = false;
        for (Producto productoEnPedido : this.listaProductos) {
            if (productoEnPedido.getNombre().equals(producto.getNombre())) {
                productoEnPedido.setCantidad(productoEnPedido.getCantidad() + producto.getCantidad());
                productoExistente = true;
                break;
            }
        }
        if (!productoExistente) {
            this.listaProductos.add(producto);
        }
        this.recalcularTotal();
    }
    
    public static double calcularCuenta(int numeroMesa) {
        String consulta = "SELECT SUM(precio_total) AS total_cuenta FROM pedidos WHERE id_mesa = ?";
        double totalCuenta = 0;

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setInt(1, numeroMesa);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    totalCuenta = resultado.getDouble("total_cuenta");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al calcular la cuenta de la mesa: " + e.getMessage());
        }

        return totalCuenta;
    }

    public static List<Pedido> obtenerPedidosDesdeBaseDatos(int numeroMesa, String tipoPedido) {
        String consulta = "SELECT p.id, p.num_pedido, p.tipo_pedido, p.precio_total, p.fecha_hora " +
                          "FROM pedidos p " +
                          "INNER JOIN mesas m ON p.id_mesa = m.id " +
                          "WHERE m.numero_mesa = ? AND p.tipo_pedido = ?";
        List<Pedido> listaPedidos = new ArrayList<>();

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setInt(1, numeroMesa);
            sentencia.setString(2, tipoPedido.toUpperCase());

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setId(resultado.getInt("id"));
                    pedido.setNumPedido(resultado.getInt("num_pedido"));
                    pedido.setTipoPedido(resultado.getString("tipo_pedido"));
                    pedido.setPrecioTotalPedido(resultado.getDouble("precio_total"));
                    pedido.setFechaHora(resultado.getTimestamp("fecha_hora"));

                    pedido.setListaProductos(Producto.obtenerProductosDePedido(pedido.getId()));

                    listaPedidos.add(pedido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener pedidos desde la base de datos: " + e.getMessage());
        }

        return listaPedidos;
    }
    
    public boolean registrarPedidoEnBaseDatos(int numeroMesa, List<Producto> productos) {
        this.setListaProductos(new ArrayList<>(productos));
        this.recalcularTotal();
        
        String insertarPedido = "INSERT INTO pedidos (num_pedido, tipo_pedido, precio_total, id_mesa) VALUES (?, ?, ?, ?)";
        
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaPedidos = conexion.prepareStatement(insertarPedido, Statement.RETURN_GENERATED_KEYS)) {

            sentenciaPedidos.setInt(1, this.numPedido);
            sentenciaPedidos.setString(2, this.tipoPedido.toUpperCase());
            sentenciaPedidos.setDouble(3, this.precioTotalPedido);
            sentenciaPedidos.setInt(4, numeroMesa);

            int filasAfectadas = sentenciaPedidos.executeUpdate();
            if (filasAfectadas > 0) {
                try (ResultSet generatedKeys = sentenciaPedidos.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idPedido = generatedKeys.getInt(1);
                        return registrarProductosDelPedido(idPedido, productos);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    private boolean registrarProductosDelPedido(int idPedido, List<Producto> productos) {
        String insertarProductos = "INSERT INTO pedido_productos (id_pedido, id_producto, cantidad) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaRegistroProductos = conexion.prepareStatement(insertarProductos)) {

            for (Producto producto : productos) {
                int idProducto = Producto.obtenerIdProductoDesdeBaseDatos(producto.getNombre());
                if (idProducto == -1) {
                    System.err.println("Producto no encontrado: " + producto.getNombre());
                    continue;
                }

                sentenciaRegistroProductos.setInt(1, idPedido);
                sentenciaRegistroProductos.setInt(2, idProducto);
                sentenciaRegistroProductos.setInt(3, producto.getCantidad());
                sentenciaRegistroProductos.addBatch();
            }

            int[] resultados = sentenciaRegistroProductos.executeBatch();
            for (int resultado : resultados) {
                if (resultado == PreparedStatement.EXECUTE_FAILED) {
                    System.err.println("Error al registrar un producto del pedido.");
                    return false;
                }
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int generarNumeroPedido() {
        String consulta = "SELECT IFNULL(MAX(num_pedido), 0) + 1 AS siguiente_pedido FROM pedidos";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
             ResultSet resultado = sentenciaConsulta.executeQuery()) {

            if (resultado.next()) {
                return resultado.getInt("siguiente_pedido");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }
    
    public static List<String> obtenerPedidosDesdeBaseDatos(String tipoPedido, int numeroMesa) {
        List<String> pedidos = new ArrayList<>();
        String consulta = "SELECT num_pedido, tipo_pedido FROM pedidos WHERE tipo_pedido = ? AND id_mesa = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setString(1, tipoPedido.toUpperCase());
            sentencia.setInt(2, numeroMesa);

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    int numPedido = resultado.getInt("num_pedido");
                    String tipo = resultado.getString("tipo_pedido");
                    pedidos.add("Pedido " + numPedido + " - " + tipo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
    
    public static List<Producto> obtenerProductosDePedidoDesdeBaseDatos(int numPedido) {
        List<Producto> productos = new ArrayList<>();
        String consulta = 
            "SELECT p.nombre, p.precio, pp.cantidad " +
            "FROM pedido_productos pp " +
            "JOIN productos p ON pp.id_producto = p.id " +
            "JOIN pedidos pe ON pp.id_pedido = pe.id " +
            "WHERE pe.num_pedido = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setInt(1, numPedido);
            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    String nombre = resultado.getString("nombre");
                    double precio = resultado.getDouble("precio");
                    int cantidad = resultado.getInt("cantidad");

                    Producto producto = new Producto(nombre, precio, cantidad);
                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public static boolean revertirProductosPedido(int numPedido) throws SQLException {
        String consultaProductos = "SELECT id_producto, cantidad FROM pedido_productos WHERE id_pedido = (SELECT id FROM pedidos WHERE num_pedido = ?)";
        String actualizarProductos = "UPDATE productos SET cantidad_disponible = cantidad_disponible + ? WHERE id = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement senetnciaProductos = conexion.prepareStatement(consultaProductos);
             PreparedStatement sentenciaActualizar = conexion.prepareStatement(actualizarProductos)) {

            senetnciaProductos.setInt(1, numPedido);
            ResultSet rs = senetnciaProductos.executeQuery();

            while (rs.next()) {
                int idProducto = rs.getInt("id_producto");
                int cantidad = rs.getInt("cantidad");

                sentenciaActualizar.setInt(1, cantidad);
                sentenciaActualizar.setInt(2, idProducto);
                sentenciaActualizar.addBatch();
            }

            int[] resultados = sentenciaActualizar.executeBatch();
            for (int resultado : resultados) {
                if (resultado == PreparedStatement.EXECUTE_FAILED) {
                    return false;
                }
            }

            return true;
        }
    }
    
    public static boolean eliminarPedidoDesdeBaseDatos(int numPedido) throws SQLException {
        String borrarPedidoProductos = "DELETE FROM pedido_productos WHERE id_pedido = (SELECT id FROM pedidos WHERE num_pedido = ?)";
        String borrarPedidos = "DELETE FROM pedidos WHERE num_pedido = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaPedidoProductos = conexion.prepareStatement(borrarPedidoProductos);
             PreparedStatement stmtPedido = conexion.prepareStatement(borrarPedidos)) {

            sentenciaPedidoProductos.setInt(1, numPedido);
            sentenciaPedidoProductos.executeUpdate();

            stmtPedido.setInt(1, numPedido);
            int filasAfectadas = stmtPedido.executeUpdate();

            return filasAfectadas > 0;
        }
    }
    
    public static boolean registrarPedidoEnHistorialPorNumero(int numPedido) {
        String queryPedido = "SELECT id, precio_total, fecha_hora FROM pedidos WHERE num_pedido = ?";
        String queryProductos = 
            "SELECT p.nombre, pp.cantidad, p.precio " +
            "FROM pedido_productos pp " +
            "JOIN productos p ON pp.id_producto = p.id " +
            "JOIN pedidos pe ON pp.id_pedido = pe.id " +
            "WHERE pe.num_pedido = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement stmtPedido = conexion.prepareStatement(queryPedido);
             PreparedStatement stmtProductos = conexion.prepareStatement(queryProductos)) {

            stmtPedido.setInt(1, numPedido);
            ResultSet rsPedido = stmtPedido.executeQuery();

            if (rsPedido.next()) {
                int idPedido = rsPedido.getInt("id");
                Timestamp fechaHora = rsPedido.getTimestamp("fecha_hora");

                stmtProductos.setInt(1, numPedido);
                ResultSet rsProductos = stmtProductos.executeQuery();

                List<Producto> productos = new ArrayList<>();
                while (rsProductos.next()) {
                    Producto producto = new Producto();
                    producto.setNombre(rsProductos.getString("nombre")); // Obtener el nombre del producto
                    producto.setCantidad(rsProductos.getInt("cantidad"));
                    producto.setPrecio(rsProductos.getDouble("precio"));
                    productos.add(producto);
                }

                return Producto.registrarProductosEnHistorial(idPedido, productos, new Date(fechaHora.getTime()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    
}