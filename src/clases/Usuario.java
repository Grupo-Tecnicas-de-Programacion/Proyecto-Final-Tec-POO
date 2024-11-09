package clases;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    protected String nombreUsuario;
    protected String contrasenia;
    protected boolean sesionIniciada;
    protected Usuario supervisor;

    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nombreUsuario, String constrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = constrasenia;
        this.supervisor = null;
        this.sesionIniciada = false;
    }

    public boolean isSesionIniciada() {
        return sesionIniciada;
    }

    public void setSesionIniciada(boolean sesionIniciada) {
        this.sesionIniciada = sesionIniciada;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Usuario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Usuario supervisor) {
        this.supervisor = supervisor;
    }
    
    public static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static boolean registrarUsuario(String nombreUsuario, String contrasenia, String confirmarContrasenia) {

        if (!contrasenia.equals(confirmarContrasenia)) {
            System.out.println("Error: Las contraseñas no coinciden.");
            return false;
        }
        
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                System.out.println("Error: El nombre de usuario ya existe.");
                return false;
            }
        }

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasenia);
        listaUsuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado con éxito: " + nombreUsuario);
        return true;
    
    }
}