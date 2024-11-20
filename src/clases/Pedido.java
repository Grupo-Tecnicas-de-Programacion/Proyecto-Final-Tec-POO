package clases;

import conexion.ConexionDB;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Pedido {
    private int numPedido;
    private ArrayList<Producto> listaProductos;
    private int cantidadTotalProductos;
    private double precioTotalPedido;
    private String tipoPedido;

    public Pedido() {
        this.listaProductos = new ArrayList<>();
        this.precioTotalPedido = 0;
        this.cantidadTotalProductos = 0;
    }

    public Pedido(int numPedido, String tipoPedido) {
        this.numPedido = numPedido;
        this.tipoPedido = tipoPedido;
        this.listaProductos = new ArrayList<>();
        this.precioTotalPedido = 0;
        this.cantidadTotalProductos = 0;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
        recalcularTotal();
    }

    public int getCantidadTotalProductos() {
        return cantidadTotalProductos;
    }

    public void setCantidadTotalProductos(int cantidadTotalProductos) {
        this.cantidadTotalProductos = cantidadTotalProductos;
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

    public double recalcularTotal() {
        this.precioTotalPedido = 0;
        for (Producto producto : this.listaProductos) {
            this.precioTotalPedido += producto.getPrecio();
        }
        
        return precioTotalPedido;
    }
    
    public void agregarProducto(Producto producto) {
        boolean productoExistente = false;
        for (Producto product : this.listaProductos) {
            if (product.getNombre().equals(producto.getNombre())) {
                product.setCantidad(product.getCantidad() + producto.getCantidad());
                productoExistente = true;
                break;
            }
        }
        if (!productoExistente) {
            this.listaProductos.add(producto);
        }
        this.cantidadTotalProductos += producto.getCantidad();
        this.recalcularTotal();
    }
    
    public boolean registrarPedidoEnBaseDatos() {
        String insertarPedido = "INSERT INTO pedidos (num_pedido, tipo_pedido, cantidad_total, precio_total) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaPedidos = conexion.prepareStatement(insertarPedido, Statement.RETURN_GENERATED_KEYS)) {

            sentenciaPedidos.setInt(1, this.numPedido);
            sentenciaPedidos.setString(2, this.tipoPedido.toUpperCase());
            sentenciaPedidos.setInt(3, this.cantidadTotalProductos);
            sentenciaPedidos.setDouble(4, this.precioTotalPedido);

            int filasAfectadas = sentenciaPedidos.executeUpdate();
            if (filasAfectadas > 0) {
                try (ResultSet generatedKeys = sentenciaPedidos.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int idPedido = generatedKeys.getInt(1);
                        return registrarProductosDelPedido(idPedido);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean registrarProductosDelPedido(int idPedido) {
        String insertarProductos = "INSERT INTO pedido_productos (id_pedido, id_producto, cantidad) VALUES (?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaRegistroProductos = conexion.prepareStatement(insertarProductos)) {

            for (Producto producto : this.listaProductos) {
                sentenciaRegistroProductos.setInt(1, idPedido);
                sentenciaRegistroProductos.setInt(2, obtenerIdProducto(producto.getNombre()));
                sentenciaRegistroProductos.setInt(3, producto.getCantidad());
                sentenciaRegistroProductos.addBatch();
            }
            sentenciaRegistroProductos.executeBatch();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private int obtenerIdProducto(String nombreProducto) {
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

    
}
