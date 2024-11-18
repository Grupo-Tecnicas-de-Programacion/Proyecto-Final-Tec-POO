package clases;


import clases.Pedido;
import java.util.ArrayList;
import java.util.Date;

public class Mesero extends Usuario {
    private ArrayList<Pedido> pedidos;
    private ArrayList<Reporte> reportes;

    public Mesero(String nombreUsuario, String contrasenia) {
        super(nombreUsuario, contrasenia, "MESERO");
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

    public Reporte generarReporte(Date fecha, String nombre, double totalGanancia, int cantidadProductos) {
        Reporte nuevoReporte = new Reporte(fecha, nombre, totalGanancia, cantidadProductos);
        reportes.add(nuevoReporte);
        return nuevoReporte;
    }

    @Override
    public String toString() {
        return "Mesero{" + "nombreUsuario='" + nombreUsuario + '\'' + ", pedidos=" + pedidos + ", reportes=" + reportes + '}';
    }
}
