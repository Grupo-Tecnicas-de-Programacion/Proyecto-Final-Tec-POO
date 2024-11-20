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

    public void asignarPedido(Pedido pedido) {
        this.listaPedidos.add(pedido);
        this.estado = "Ocupada";
        actualizarEstadoMesa();
    }
    
    public void actualizarEstadoMesa() {
        if (listaPedidos.isEmpty()) {
            this.estado = "Desocupada";
        } else {
            this.estado = "Ocupada";
        }
    }

    public void liberarMesa() {
        this.listaPedidos.clear();
        this.estado = "Desocupada";
        this.cuenta = new Cuenta(); 
        this.cliente = null;
    }
    
    public static boolean cargarMesasDesdeArchivo(File archivo) {
        if (archivo == null || !archivo.exists()) {
            System.out.println("El archivo no existe o no es válido.");
            return false;
        }

        String consultaEliminarMesas = "DELETE FROM mesas";
        String consultaInsertarMesas = "INSERT INTO mesas (numero_mesa, estado, capacidad) VALUES (?, ?, ?)";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo));
            Connection conexion = ConexionDB.conectar();
            PreparedStatement sentenciaEliminar = conexion.prepareStatement(consultaEliminarMesas);
            PreparedStatement sentenciaInsertar = conexion.prepareStatement(consultaInsertarMesas)) {

            sentenciaEliminar.executeUpdate();

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length != 3) {
                    System.out.println("Formato incorrecto en la línea: " + linea);
                    continue;
                }

                int numeroMesa = Integer.parseInt(partes[0].trim());
                String estado = partes[1].trim().toUpperCase();
                int capacidad = Integer.parseInt(partes[2].trim());

                sentenciaInsertar.setInt(1, numeroMesa);
                sentenciaInsertar.setString(2, estado);
                sentenciaInsertar.setInt(3, capacidad);
                sentenciaInsertar.addBatch();
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

        public String mostrarInfoCuenta() {
            return "Información de la cuenta:\n" +
                   " - Total a pagar: " + this.getTotalPagar() + "\n";
        }
    }
}
