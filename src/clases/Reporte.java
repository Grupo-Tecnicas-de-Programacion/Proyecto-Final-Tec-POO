package clases;


public class Reporte {
    private String fecha;
    private String nombre;
    private double totalGanancias;
    private int cantidadProductosVendidos;

    public Reporte(String fecha, String nombre, double totalGanancias, int cantidadProductosVendidos) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.totalGanancias = totalGanancias;
        this.cantidadProductosVendidos = cantidadProductosVendidos;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTotalGanancias() {
        return totalGanancias;
    }

    public int getCantidadProductosVendidos() {
        return cantidadProductosVendidos;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "fecha='" + fecha + '\'' +
                ", nombre='" + nombre + '\'' +
                ", totalGanancias=" + totalGanancias +
                ", cantidadProductosVendidos=" + cantidadProductosVendidos +
                '}';
    }
}

