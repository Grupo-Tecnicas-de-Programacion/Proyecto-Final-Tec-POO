
package clases;
import conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
    private String tipoIdentificacion;
    private String identificacion; 
    private String nombre;
    private String apellido;

    public Cliente(String tipoIdentificacion, String identificacion, String nombre, String apellido) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public static boolean registrarClienteEnBaseDatos(Cliente cliente) {
        String consulta = "INSERT INTO clientes (tipo_identificacion, identificacion, nombre, apellido) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setString(1, cliente.getTipoIdentificacion());
            sentencia.setString(2, cliente.getIdentificacion());
            sentencia.setString(3, cliente.getNombre());
            sentencia.setString(4, cliente.getApellido());

            int filasAfectadas = sentencia.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al registrar el cliente en la base de datos: " + e.getMessage());
            return false;
        }
    }

    
    public static Cliente obtenerClienteDesdeBaseDatos(String identificacion) {
        String consulta = "SELECT tipo_identificacion, identificacion, nombre, apellido " +
                          "FROM clientes WHERE identificacion = ?";
        Cliente cliente = null;

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setString(1, identificacion);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    String tipoIdentificacion = resultado.getString("tipo_identificacion");
                    String nombre = resultado.getString("nombre");
                    String apellido = resultado.getString("apellido");

                    cliente = new Cliente(tipoIdentificacion, identificacion, nombre, apellido);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el cliente desde la base de datos: " + e.getMessage());
        }

        return cliente;
    }

    public boolean registrarClienteEnBaseDatos() {
        String consultaBuscar = "SELECT id FROM clientes WHERE identificacion = ?";
        String consultaInsertar = "INSERT INTO clientes (tipo_identificacion, identificacion, nombre, apellido) VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement buscarCliente = conexion.prepareStatement(consultaBuscar);
             PreparedStatement insertarCliente = conexion.prepareStatement(consultaInsertar)) {

            buscarCliente.setString(1, this.identificacion);
            try (ResultSet resultado = buscarCliente.executeQuery()) {
                if (resultado.next()) {
                    System.out.println("El cliente ya está registrado con el ID: " + resultado.getInt("id"));
                    return true;
                }
            }

            insertarCliente.setString(1, this.tipoIdentificacion);
            insertarCliente.setString(2, this.identificacion);
            insertarCliente.setString(3, this.nombre);
            insertarCliente.setString(4, this.apellido);

            int filasInsertadas = insertarCliente.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Cliente registrado exitosamente.");
                return true;
            } else {
                System.err.println("Error al registrar el cliente.");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al interactuar con la base de datos: " + e.getMessage());
            return false;
        }
    }
    
    public static Cliente buscarClienteEnBaseDatos(String tipoIdentificacion, String identificacion) {
        String consultaBuscar = "SELECT tipo_identificacion, identificacion, nombre, apellido FROM clientes WHERE tipo_identificacion = ? AND identificacion = ?";
        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement buscarCliente = conexion.prepareStatement(consultaBuscar)) {

            buscarCliente.setString(1, tipoIdentificacion);
            buscarCliente.setString(2, identificacion);

            try (ResultSet resultado = buscarCliente.executeQuery()) {
                if (resultado.next()) {
                    return new Cliente(
                        resultado.getString("tipo_identificacion"),
                        resultado.getString("identificacion"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al buscar cliente en la base de datos: " + e.getMessage());
        }
        return null;
    }


}