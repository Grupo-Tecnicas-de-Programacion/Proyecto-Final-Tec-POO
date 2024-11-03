package clases;


public class Reporte {
    private String fechaReporte;
    private String tituloReporte;
    private int cantidadProductosVendidos;
    private double totalGanancias;

    public Reporte() {
    }

    public Reporte(String fechaReporte, String tituloReporte, int cantidadProductosVendidos, double totalGanancias) {
        this.fechaReporte = fechaReporte;
        this.tituloReporte = tituloReporte;
        this.cantidadProductosVendidos = cantidadProductosVendidos;
        this.totalGanancias = totalGanancias;
    }

    public String getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(String fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getTituloReporte() {
        return tituloReporte;
    }

    public void setTituloReporte(String tituloReporte) {
        this.tituloReporte = tituloReporte;
    }

    public int getCantidadProductosVendidos() {
        return cantidadProductosVendidos;
    }

    public void setCantidadProductosVendidos(int cantidadProductosVendidos) {
        this.cantidadProductosVendidos = cantidadProductosVendidos;
    }

    public double getTotalGanancias() {
        return totalGanancias;
    }

    public void setTotalGanancias(double totalGanancias) {
        this.totalGanancias = totalGanancias;
    }

    @Override
    public String toString() {
        return "Reporte:" + " Fecha reporte = " + fechaReporte + " | Titulo del reporte = " + tituloReporte + " | Cantidad de productos vendidos = " + cantidadProductosVendidos + " | Total Ganancias = " + totalGanancias;
    }
    
    
    
}
