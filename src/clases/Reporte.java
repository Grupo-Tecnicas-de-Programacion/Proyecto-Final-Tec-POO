package clases;

import java.util.Date;


public class Reporte {
    private Date fecha;
    private String nombre;
    private double totalGanancias;
    private int cantidadProductosVendidos;

    public Reporte() {
    }

    public Reporte(Date fecha, String nombre, double totalGanancias, int cantidadProductosVendidos) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.totalGanancias = totalGanancias;
        this.cantidadProductosVendidos = cantidadProductosVendidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTotalGanancias(double totalGanancias) {
        this.totalGanancias = totalGanancias;
    }

    public void setCantidadProductosVendidos(int cantidadProductosVendidos) {
        this.cantidadProductosVendidos = cantidadProductosVendidos;
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
    
    
}

