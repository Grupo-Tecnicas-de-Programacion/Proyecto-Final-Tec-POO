package clases;


import clases.Mesa;
import java.util.ArrayList;

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


    public void eliminarProducto(Producto producto) {
        if (this.listaProductos.contains(producto)) {
            this.listaProductos.remove(producto);
            this.cantidadTotalProductos--;
            recalcularTotal();
        } else {
            System.out.println("El producto no está en la lista.");
        }
    }

    public void mostrarInfoPedido() {
        recalcularTotal();
        System.out.println("Información del pedido:");
        System.out.println("Número de pedido: " + this.getNumPedido());
        System.out.println("Tipo de pedido: " + this.getTipoPedido());
        System.out.println("Precio total del pedido: " + this.getPrecioTotalPedido());

        System.out.println("Productos en el pedido:");
        for (Producto producto : this.getListaProductos()) {
            System.out.println("- " + producto.getNombre() + " | Precio: " + producto.getPrecio());
        }
    }

    @Override
    public String toString() {
        return "Pedido #" + numPedido + " - Tipo: " + tipoPedido + " - Total: S/ " + precioTotalPedido;
    }
}
