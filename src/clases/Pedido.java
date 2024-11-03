package clases;


import clases.Mesa;
import java.util.ArrayList;

public class Pedido {
    private int numPedido;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Mesa> listaMesas;
    private int cantidadTotalProductos;
    private double precioTotalPedido;
    private String tipoPedido;

    public Pedido() {
        this.listaProductos = new ArrayList<> ();
        this.listaMesas = new ArrayList<> ();
        this.precioTotalPedido = 0;
        this.cantidadTotalProductos = 0;
        
    }

    public Pedido(int numPedido, String tipoPedido) {
        this.numPedido = numPedido;
        this.tipoPedido = tipoPedido;
        this.listaProductos = new ArrayList<> ();
        this.listaMesas = new ArrayList<> ();
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
    }

    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    public void setListaMesas(ArrayList<Mesa> listaMesas) {
        this.listaMesas = listaMesas;
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
    
    public double calcularTotalPedido()
    {
        this.precioTotalPedido = 0;
        
        for (Producto producto : this.listaProductos)
        {
            this.precioTotalPedido += producto.getPrecio();
        }
        return this.precioTotalPedido;
    }
    
    public void agregarProducto(Producto producto)
    {
        this.listaProductos.add(producto);
        this.cantidadTotalProductos++;
        this.calcularTotalPedido();
    }
    
    public void eliminarProducto(Producto producto)
    {
        if (this.listaProductos.contains(producto)) {
            this.listaProductos.remove(producto);
            this.cantidadTotalProductos--;
            this.calcularTotalPedido();
        }else{
            
            System.out.println("El producto no está en la lista.");
        }
    }
    
    public void agregarMesa(Mesa mesa)
    {
        this.listaMesas.add(mesa);
    }
    
    public void mostrarInfoPedido() {
        this.calcularTotalPedido();
        
        System.out.println("Informacion del pedido:");
        System.out.println("Numero de pedido: " + this.getNumPedido());
        System.out.println("Tipo de pedido: " + this.getTipoPedido());
        System.out.println("Precio total del pedido: " + this.getPrecioTotalPedido());

        System.out.println(" -- Mesas asociadas a este pedido:");
        if (this.listaMesas.isEmpty()) {
            System.out.println("No hay mesas asociadas a este pedido.");
        } else {
            for (Mesa mesa : this.getListaMesas()) {
                System.out.println("Numero de mesa: " + mesa.getNumeroMesa()+" | Estado de mesa: "+mesa.getEstado());
                
            }
        }
    }
}
