import java.io.Serializable;

public class Producto implements Serializable{
    private String nombre;
    private double precio;
    private String categoria;

    public Producto() {
    }

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
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

    public void actualizarPrecio(double nuevoPrecio){
        if (nuevoPrecio > 0) {
            this.precio = nuevoPrecio;
        }else{
            System.out.println("El precio debe ser mayor que 0.");
        }
        
    }
    
    @Override
    public String toString() {
        return "Producto:  " + 
               "Nombre = " + this.getNombre() + " | " + 
               "Precio = " + this.getPrecio() + " | " +
               "Categoria = " + this.getCategoria() + ".";
    }
}
