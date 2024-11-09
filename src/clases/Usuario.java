package clases;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    protected String nombreUsuario;
    protected String contrasenia;
    protected boolean sesionIniciada;
    protected String rol;

    private static List<Usuario> listaUsuarios = new ArrayList<>();

    public Usuario() {}

    public Usuario(String nombreUsuario, String contrasenia, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public static List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public static boolean registrarUsuario(String nombreUsuario, String contrasenia, String confirmarContrasenia, String rol) {

        if (!contrasenia.equals(confirmarContrasenia)) {
            return false; 
        }

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return false; 
            }
        }

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasenia, rol);
        listaUsuarios.add(nuevoUsuario);
        return true; 
    }
}