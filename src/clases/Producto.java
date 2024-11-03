package clases;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private int cantidadDisponible;

    public Producto() {}

    public Producto(String nombre, double precio, String categoria, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    // Método para reducir la cantidad
    public boolean reducirCantidad(int cantidad) {
        if (cantidad <= cantidadDisponible) {
            cantidadDisponible -= cantidad;
            return true;
        } else {
            return false; // No hay suficiente cantidad
        }
    }

    @Override
    public String toString() {
        return "Producto: " + 
               "Nombre = " + this.getNombre() + " | " + 
               "Precio = " + this.getPrecio() + " | " +
               "Cantidad Disponible = " + this.getCantidadDisponible() + " | " +
               "Categoria = " + this.getCategoria() + ".";
    }
}