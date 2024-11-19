package clases;

import java.util.ArrayList;
import java.util.List;


public class Usuario {
    protected String nombreUsuario;
    protected String contrasenia;
    protected boolean sesionIniciada;
    protected boolean estaActivo;
    protected String rol;
    
    public Usuario() {
        this.estaActivo = true;
    }

    public Usuario(String nombreUsuario, String contrasenia, String rol) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.sesionIniciada = false;
        this.estaActivo = true;
    }
    
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    static {
        Usuario admin = new Usuario("administrador", "administrador", "ADMINISTRADOR");
        listaUsuarios.add(admin);
        
        Usuario mesero = new Usuario("mesero", "mesero", "MESERO");
        listaUsuarios.add(mesero);
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
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
    
    public boolean cambiarNombreUsuario(String contrasenia, String nuevoNombreUsuario) {
        if (this.contrasenia.equals(contrasenia)) {
            this.nombreUsuario = nuevoNombreUsuario;
            return true;
        }
        return false;
    }
    
    public boolean cambiarContrasenia(String contraseniaActual, String nuevaContrasenia) {
        if (this.contrasenia.equals(contraseniaActual)) {
            this.contrasenia = nuevaContrasenia;
            return true;
        }
        return false;
    }
}