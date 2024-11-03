package clases;


import clases.Reporte;
import clases.Usuario;
import java.util.ArrayList;


public class Administrador extends Usuario{
    private ArrayList<Reporte> reportes;

    public Administrador() {
        this.reportes = new ArrayList<>();
    }

    public Administrador(ArrayList<Reporte> reportes, String nombreUsuario, String constrasenia) {
        super(nombreUsuario, constrasenia);
        this.reportes = new ArrayList<>();
    }

    public ArrayList<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(ArrayList<Reporte> reportes) {
        this.reportes = reportes;
    }

    @Override
    public String toString() {
        return "Administrador{" + "reportes=" + reportes + '}';
    }
    
    
    public ArrayList<Reporte> obtenerTodosLosReportes(){
        return this.getReportes();
    }
    
}
