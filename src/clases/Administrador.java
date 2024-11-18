package clases;


import clases.Reporte;
import clases.Usuario;
import java.util.ArrayList;


public class Administrador extends Usuario {
    private ArrayList<Reporte> reportes;

    public Administrador(String nombreUsuario, String contrasenia) {
        super(nombreUsuario, contrasenia, "ADMINISTRADOR");
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
        return "Administrador{" + "nombreUsuario='" + nombreUsuario + '\'' + ", reportes=" + reportes + '}';
    }

    public ArrayList<Reporte> obtenerTodosLosReportes() {
        return this.getReportes();
    }
}