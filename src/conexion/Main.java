
package conexion;

import conexion.ConexionDB;

public class Main {

    public static void main(String[] args) {
        ConexionDB.conectar();
        ConexionDB.cerrarConexion();
    }
    
}
