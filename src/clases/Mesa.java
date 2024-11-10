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
        this.estado = "Desocupada";
    }

    public Mesa(int numeroMesa, int capacidad) {
        this.numeroMesa = numeroMesa;
        this.estado = "Desocupada";
        this.capacidad = capacidad;
        this.listaPedidos = new ArrayList<>();
        this.cuenta = new Cuenta(); 
    }


    public void asignarPedido(Pedido pedido) {
        this.listaPedidos.add(pedido);
        this.estado = "Ocupada";
        this.cuenta.calcularTotalCuenta(listaPedidos);
    }

    public void liberarMesa() {
        this.listaPedidos.clear();
        this.estado = "Desocupada";
        this.cuenta = new Cuenta();
    }

    public double obtenerTotalCuenta() {
        return this.cuenta.calcularTotalCuenta(listaPedidos);
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
        this.cuenta.calcularTotalCuenta(listaPedidos);
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

        public double calcularTotalCuenta(ArrayList<Pedido> pedidos) {
            this.totalPagar = 0;
            for (Pedido pedido : pedidos) {
                this.totalPagar += pedido.getPrecioTotalPedido();
            }
            return this.totalPagar;
        }

        public void marcarComoPagada() {
            this.estadoPago = "Pagado";
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
    }
}