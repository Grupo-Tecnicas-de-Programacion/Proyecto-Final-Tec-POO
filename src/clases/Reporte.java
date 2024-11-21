package clases;

import conexion.ConexionDB;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Reporte {
    private Date fecha;
    private String nombre;
    private double totalGanancias;
    private int cantidadProductosVendidos;

    public Reporte() {
    }

    public Reporte(Date fecha, String nombre, double totalGanancias, int cantidadProductosVendidos) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.totalGanancias = totalGanancias;
        this.cantidadProductosVendidos = cantidadProductosVendidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotalGanancias() {
        return totalGanancias;
    }

    public void setTotalGanancias(double totalGanancias) {
        this.totalGanancias = totalGanancias;
    }

    public int getCantidadProductosVendidos() {
        return cantidadProductosVendidos;
    }

    public void setCantidadProductosVendidos(int cantidadProductosVendidos) {
        this.cantidadProductosVendidos = cantidadProductosVendidos;
    }
    
    public static double calcularTotalGananciasDesdeBD() {
        String query = "SELECT SUM(precio_unitario * cantidad) AS total_ganancias FROM historial_pedidos";
        double totalGanancias = 0.0;

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(query)) {

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    totalGanancias = resultado.getDouble("total_ganancias");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al calcular las ganancias totales: " + e.getMessage());
        }
        return totalGanancias;
    }
    
    
    public static int calcularCantidadProductosVendidosDesdeBD() {
        String query = "SELECT SUM(cantidad) AS total_cantidad FROM historial_pedidos";
        int totalCantidad = 0;

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(query)) {

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    totalCantidad = resultado.getInt("total_cantidad");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al calcular la cantidad total de productos vendidos: " + e.getMessage());
        }
        return totalCantidad;
    }


    public static boolean guardarReporteEnBaseDeDatos(Reporte reporte) {
        String query = "INSERT INTO reportes (fecha, nombre, total_ganancias, cantidad_productos_vendidos) " +
                       "VALUES (?, ?, ?, ?)";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            stmt.setDate(1, new java.sql.Date(reporte.getFecha().getTime()));
            stmt.setString(2, reporte.getNombre());
            stmt.setDouble(3, reporte.getTotalGanancias());
            stmt.setInt(4, reporte.getCantidadProductosVendidos());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean limpiarHistorialPedidos() {
        String query = "DELETE FROM historial_pedidos";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement stmt = conexion.prepareStatement(query)) {

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static List<Reporte> obtenerReportesPorRangoDeFechas(Date fechaDesde, Date fechaHasta) {
        List<Reporte> reportes = new ArrayList<>();
        String consulta = "SELECT * FROM reportes WHERE fecha BETWEEN ? AND ?";

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setDate(1, new java.sql.Date(fechaDesde.getTime()));
            sentencia.setDate(2, new java.sql.Date(fechaHasta.getTime()));

            try (ResultSet resultado = sentencia.executeQuery()) {
                while (resultado.next()) {
                    Reporte reporte = new Reporte();
                    reporte.setFecha(resultado.getDate("fecha"));
                    reporte.setNombre(resultado.getString("nombre"));
                    reporte.setTotalGanancias(resultado.getDouble("total_ganancias"));
                    reporte.setCantidadProductosVendidos(resultado.getInt("cantidad_productos_vendidos"));

                    reportes.add(reporte);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener reportes por rango de fechas: " + e.getMessage());
        }

        return reportes;
    }

    public static Reporte obtenerReportePorNombre(String nombreReporte) {
        String consulta = "SELECT * FROM reportes WHERE nombre = ?";
        Reporte reporte = null;

        try (Connection conexion = ConexionDB.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(consulta)) {

            sentencia.setString(1, nombreReporte);

            try (ResultSet resultado = sentencia.executeQuery()) {
                if (resultado.next()) {
                    reporte = new Reporte();
                    reporte.setFecha(resultado.getDate("fecha"));
                    reporte.setNombre(resultado.getString("nombre"));
                    reporte.setTotalGanancias(resultado.getDouble("total_ganancias"));
                    reporte.setCantidadProductosVendidos(resultado.getInt("cantidad_productos_vendidos"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el reporte por nombre: " + e.getMessage());
        }

        return reporte;
    }

}

