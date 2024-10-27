
import java.util.ArrayList;


public class Mesa {
    private int numeroMesa;
    private String estado;
    private int capacidad;
    private ArrayList<Pedido> listaPedidos;
    public Cuenta cuenta;

    public Mesa() {
        this.listaPedidos = new ArrayList<> ();
        this.cuenta = null;
    }

    public Mesa(int numeroMesa, int capacidad) {
        this.numeroMesa = numeroMesa;
        this.estado = "Desocupado";
        this.capacidad = capacidad;
        this.listaPedidos = new ArrayList<> ();
        this.cuenta = null;
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
        this.estado = "Ocupado";
    }
    
    public void asignarPedido(Pedido pedido)
    {
        this.listaPedidos.add(pedido);
        this.estado = "Ocupado";
    }
    
    public void liberarMesa()
    {
        this.listaPedidos.clear();
        this.estado = "Desocupado";
        this.cuenta = null;
    }
    
    public void mostrarInfoMesa() {
        System.out.println("Informacion de la mesa:");
        System.out.println("Mesa numero: " + this.getNumeroMesa());
        System.out.println("Estado: " + this.getEstado());

        System.out.println(" -- Pedidos asociados a la mesa:");
        if (this.listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos asociados a esta mesa.");
        } else {
            for (Pedido pedido : this.getListaPedidos()) {
                System.out.println("Numero pedido: " + pedido.getNumPedido()+" | Tipo de pedido: "+pedido.getTipoPedido());
                System.out.println("Productos en el pedido:");
                for (Producto producto : pedido.getListaProductos()) {
                    System.out.println("- Nombre de producto: " + producto.getNombre() + " | Precio del producto: " + producto.getPrecio());
                }
                double total = pedido.calcularTotalPedido();
                System.out.println("Precio total del pedido: " + total);
            }
        }
    }
    
    public final class Cuenta{
    
        private double totalPagar; 
        private String tipoPago; 
        private String estadoPago;

        public Cuenta() {
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
        
        public double calcularTotalCuenta(){
            
            this.totalPagar = 0;
            
            for (Pedido pedido : getListaPedidos()) {
                this.totalPagar += pedido.getPrecioTotalPedido();
            }
            
            return this.totalPagar;
        }
        
        public void marcarComoPagada(){
            this.estadoPago = "Pagado";
        }
        
        public void mostrarInfoCuenta(){

            System.out.println("Informacion de la cuenta:");
            System.out.println(" - Total a pagar: " + this.getTotalPagar());
            System.out.println(" - Tipo de pago: " + this.getTipoPago());
            System.out.println(" - Estado del pago: " + this.getEstadoPago());

        }
        
    }
}
