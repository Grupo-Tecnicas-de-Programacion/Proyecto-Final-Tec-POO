package clases;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private int cantidadDisponible;
    private int cantidad; 


    public Producto(String nombre, double precio, String categoria, int cantidadDisponible) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.cantidadDisponible = cantidadDisponible;
        this.cantidad = 1; 
    }

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public void incrementarCantidad() {
        this.cantidad++;
    }
}