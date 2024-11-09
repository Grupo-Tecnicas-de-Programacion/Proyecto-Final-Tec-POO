package clases;


import clases.Pedido;
import java.util.ArrayList;

public class Mesero extends Usuario{
    
    private ArrayList<Pedido> pedidos;
    private ArrayList<Reporte> reportes;

    public Mesero() {
        this.pedidos = new ArrayList<>();
        this.reportes = new ArrayList<>();
    }

    public Mesero(String nombreUsuario, String constrasenia) {
        super(nombreUsuario, constrasenia);
        this.pedidos = new ArrayList<>();
        this.reportes = new ArrayList<>();
    }
    
    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(ArrayList<Reporte> reportes) {
        this.reportes = reportes;
    }
    
    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    public Reporte generarReporte(String fecha, String nombre, double totalGanancia, int cantidaProductos){
        Reporte nuevoReporte = new Reporte(fecha, nombre, totalGanancia, cantidaProductos);
        reportes.add(nuevoReporte);
        return nuevoReporte;
    }
}
