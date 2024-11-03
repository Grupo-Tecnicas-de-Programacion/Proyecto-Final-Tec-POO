package clases;

import java.util.ArrayList;

public class Mesa {
    private int numeroMesa;
    private String estado;
    private int capacidad;
    private ArrayList<Pedido> listaPedidos;
    private Cuenta cuenta;

    public Mesa() {
        this.listaPedidos = new ArrayList<>();
        this.cuenta = new Cuenta(); 
        this.estado = "Desocupado";
    }

    public Mesa(int numeroMesa, int capacidad) {
        this.numeroMesa = numeroMesa;
        this.estado = "Desocupado";
        this.capacidad = capacidad;
        this.listaPedidos = new ArrayList<>();
        this.cuenta = new Cuenta(); 
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
        this.estado = !listaPedidos.isEmpty() ? "Ocupado" : "Desocupado";
    }

    public void asignarPedido(Pedido pedido) {
        this.listaPedidos.add(pedido);
        this.estado = "Ocupado";
    }

    public void liberarMesa() {
        this.listaPedidos.clear();
        this.estado = "Desocupado";
        this.cuenta = new Cuenta(); 
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
                double total = pedido.calcularTotalPedido();
                info.append("Precio total del pedido: ").append(total).append("\n");
            }
        }
        return info.toString();
    }

    public final class Cuenta {
        private double totalPagar;
        private String tipoPago;
        private String estadoPago;

        public Cuenta() {
            this.totalPagar = 0;
            this.tipoPago = "Desconocido";
            this.estadoPago = "Pendiente";
        }

        public Cuenta(String tipoPago) {
            this.totalPagar = 0;
            this.tipoPago = tipoPago;
            this.estadoPago = "Pendiente";
        }

        public double getTotalPagar() {
            return totalPagar;
        }

        public void setTotalPagar(double totalPagar) {
            this.totalPagar = totalPagar;
        }

        public String getTipoPago() {
            return tipoPago;
        }

        public void setTipoPago(String tipoPago) {
            this.tipoPago = tipoPago;
        }

        public String getEstadoPago() {
            return estadoPago;
        }

        public void setEstadoPago(String estadoPago) {
            this.estadoPago = estadoPago;
        }

        public double calcularTotalCuenta() {
            this.totalPagar = 0;
            for (Pedido pedido : getListaPedidos()) {
                this.totalPagar += pedido.calcularTotalPedido();
            }
            return this.totalPagar;
        }

        public void marcarComoPagada() {
            this.estadoPago = "Pagado";
        }

        public String mostrarInfoCuenta() {
            return "Información de la cuenta:\n" +
                   " - Total a pagar: " + this.getTotalPagar() + "\n" +
                   " - Tipo de pago: " + this.getTipoPago() + "\n" +
                   " - Estado del pago: " + this.getEstadoPago();
        }
    }
}
