
package clases;

import java.util.ArrayList;
import java.util.List;

public class GestionReportes {

    private static List<Reporte> listaReportes = new ArrayList<>();

    public static void agregarReporte(Reporte reporte) {
        listaReportes.add(reporte);
    }

    public static List<Reporte> getListaReportes() {
        return listaReportes;
    }
}
