package clases;

import conexion.ConexionDB;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public static boolean registrarUsuario(String nombreUsuario, String contrasenia, String confirmarContrasenia, String rol) {
        
        if (!contrasenia.equals(confirmarContrasenia)) {
            return false; 
        }

        String consultaVerificar = "SELECT COUNT(*) AS cantidad FROM usuarios WHERE nombre_usuario = ?";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement verificarSentencia = conexion.prepareStatement(consultaVerificar)) {

            verificarSentencia.setString(1, nombreUsuario);
            ResultSet resultado = verificarSentencia.executeQuery();
            if (resultado.next() && resultado.getInt("cantidad") > 0) {
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String consultaInsertar = "INSERT INTO usuarios (nombre_usuario, contrasenia, rol, activo) VALUES (?, ?, ?, ?)";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement insertarStmt = conexion.prepareStatement(consultaInsertar)) {

            insertarStmt.setString(1, nombreUsuario);
            insertarStmt.setString(2, contrasenia);
            insertarStmt.setString(3, rol);
            insertarStmt.setBoolean(4, true);

            int filasAfectadas = insertarStmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } 
    }
    
    public boolean cambiarContrasenia(String contraseniaActual, String nuevaContrasenia) {
        String consultaSeleccion = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasenia = ?";
        String consultaActualizacion = "UPDATE usuarios SET contrasenia = ? WHERE nombre_usuario = ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaSeleccion = conexion.prepareStatement(consultaSeleccion)) {

            sentenciaSeleccion.setString(1, this.nombreUsuario);
            sentenciaSeleccion.setString(2, contraseniaActual);

            ResultSet resultado = sentenciaSeleccion.executeQuery();

            if (resultado.next()) {

                try (PreparedStatement sentenciaActualizacion = conexion.prepareStatement(consultaActualizacion)) {
                    sentenciaActualizacion.setString(1, nuevaContrasenia);
                    sentenciaActualizacion.setString(2, this.nombreUsuario);

                    int filasActualizadas = sentenciaActualizacion.executeUpdate();
                    if (filasActualizadas > 0) {
                        this.contrasenia = nuevaContrasenia;
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static Usuario autenticarUsuario(String nombreUsuario, String contrasenia) {
        String query = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasenia = ?";
        try (Connection conexion = ConexionDB.conectar();
            PreparedStatement sentenciaAutenticacion = conexion.prepareStatement(query)) {

            sentenciaAutenticacion.setString(1, nombreUsuario);
            sentenciaAutenticacion.setString(2, contrasenia);

            ResultSet resultado = sentenciaAutenticacion.executeQuery();
            if (resultado.next()) {
                Usuario usuario = new Usuario();
                usuario.nombreUsuario = resultado.getString("nombre_usuario");
                usuario.contrasenia = resultado.getString("contrasenia");
                usuario.rol = resultado.getString("rol");
                usuario.estaActivo = resultado.getBoolean("activo");
                return usuario;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static List<String> obtenerNombresMeseros() {
        List<String> nombresMeseros = new ArrayList<>();
        String consulta = "SELECT nombre_usuario FROM usuarios WHERE rol = 'MESERO'";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaConsulta = conexion.prepareStatement(consulta);
             ResultSet resultado = sentenciaConsulta.executeQuery()) {

            while (resultado.next()) {
                nombresMeseros.add(resultado.getString("nombre_usuario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombresMeseros;
    }

    public static boolean activarDesactivarCuenta(String nombreUsuario, String contraseniaAdmin, boolean activar) {
        String consultaAdministrador = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contrasenia = ? AND rol = 'ADMINISTRADOR'";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaAdministrador = conexion.prepareStatement(consultaAdministrador)) {

            sentenciaAdministrador.setString(1, "administrador");
            sentenciaAdministrador.setString(2, contraseniaAdmin);

            ResultSet resultadoAdmin = sentenciaAdministrador.executeQuery();
            if (!resultadoAdmin.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        String consultaActualizar = "UPDATE usuarios SET activo = ? WHERE nombre_usuario = ? AND rol = 'MESERO'";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentenciaActualizar = conexion.prepareStatement(consultaActualizar)) {

            sentenciaActualizar.setBoolean(1, activar);
            sentenciaActualizar.setString(2, nombreUsuario);

            int filasAfectadas = sentenciaActualizar.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String obtenerEstadoUsuario(String nombreUsuario) {
        String consulta = "SELECT activo FROM usuarios WHERE nombre_usuario = ? AND rol = 'MESERO'";
        try (Connection conexion = ConexionDB.conectar();
            PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setString(1, nombreUsuario);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                boolean estaActivo = resultado.getBoolean("activo");
                return estaActivo ? "Activa" : "Inactiva";
            } else {
                return "No encontrado";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }

}