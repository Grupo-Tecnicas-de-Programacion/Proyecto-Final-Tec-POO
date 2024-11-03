package clases;


import clases.Producto;
import java.util.ArrayList;


public class GestorProductos {
    private ArrayList<Producto> productos;

    public GestorProductos() {
        this.productos = new ArrayList<>();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
    
     // Método para agregar un producto
    public void agregarProducto(Producto producto){
        productos.add(producto);
        System.out.println("Producto agregado: "+producto.getNombre());
    }
    
    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            for (Producto producto : productos) {
                System.out.println("- "+producto);
            }
        }
    }

    public void modificarProducto(String nombre, double nuevoPrecio) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setPrecio(nuevoPrecio);
                System.out.println("Producto modificado: " + producto);
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        
        return null;
    }

    public void eliminarProducto(String nombre) {
        Producto productoAEliminar = buscarProducto(nombre);
        if (productoAEliminar != null) {
            productos.remove(productoAEliminar);
            System.out.println("Producto eliminado: " + productoAEliminar.getNombre());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
}
