package clases;

import java.util.ArrayList;

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

    
    
    public String mostrarInfoMesa() {
        StringBuilder info = new StringBuilder();
        info.append("Información de la mesa:\n");
        info.append("Mesa número: ").append(this.getNumeroMesa()).append("\n");
        info.append("Estado: ").append(this.getEstado()).append("\n");

        info.append(" -- Pedidos asociados a la mesa:\n");
        if (this.listaPedidos.isEmpty()) {
            info.append("No hay pedidos asociados a esta mesa.\n");
        } else {
            for (Pedido pedido : this.getListaPedidos()) {
                info.append("Número de pedido: ").append(pedido.getNumPedido())
                    .append(" | Tipo de pedido: ").append(pedido.getTipoPedido()).append("\n");
                info.append("Productos en el pedido:\n");
                for (Producto producto : pedido.getListaProductos()) {
                    info.append("- Nombre de producto: ").append(producto.getNombre())
                        .append(" | Precio del producto: ").append(producto.getPrecio()).append("\n");
                }
                double total = pedido.getPrecioTotalPedido();
                info.append("Precio total del pedido: ").append(total).append("\n");
            }
        }
        return info.toString();
    }

    public final class Cuenta {
        private double totalPagar;

        public Cuenta() {
            this.totalPagar = 0;
        }

        public Cuenta(String tipoPago) {
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
