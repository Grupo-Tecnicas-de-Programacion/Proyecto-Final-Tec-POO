
import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;


public class ArchivosProductos {

    public void guardarProductos(ArrayList<Producto> productos) {
        
        JFileChooser exploradorArchivos = new JFileChooser();
        
        int resultado = exploradorArchivos.showSaveDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) {
            
            File archivoSeleccionado = exploradorArchivos.getSelectedFile();
            
            try (BufferedWriter escribirDocumento = new BufferedWriter(new FileWriter(archivoSeleccionado))) {
                for (Producto producto : productos) {
                    escribirDocumento.write(producto.getNombre() + "," + producto.getPrecio() + "," + producto.getCategoria());
                    escribirDocumento.newLine();
                }
                System.out.println("Productos guardados en: " + archivoSeleccionado.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Error al guardar los productos en el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No se seleccionó ninguna ubicación para guardar.");
        }
    }

    public void cargarProductos(ArrayList<Producto> productosExistentes) {
        JFileChooser exploradorArchivos = new JFileChooser();
        
        int resultado = exploradorArchivos.showOpenDialog(null);
        
        if (resultado == JFileChooser.APPROVE_OPTION) {
            
            File archivoSeleccionado = exploradorArchivos.getSelectedFile();
            
            try (BufferedReader leerDocumento = new BufferedReader(new FileReader(archivoSeleccionado))) {
                
                String linea;
                
                while ((linea = leerDocumento.readLine()) != null) {
                    
                    String[] datosProducto = linea.split(",");
                    String nombre = datosProducto[0];
                    double precio = Double.parseDouble(datosProducto[1]);
                    String categoria = datosProducto[2];
                    
                    Producto nuevoProducto = new Producto(nombre, precio, categoria);
                    
                    boolean productoYaExiste = false;
                    
                    for (Producto producto : productosExistentes) {
                        if (producto.getNombre().equalsIgnoreCase(nombre)) {
                            productoYaExiste = true;
                            break;
                        }
                    }
                    
                    if (!productoYaExiste) {
                        productosExistentes.add(nuevoProducto);
                        System.out.println("Producto agregado: " + nuevoProducto);
                    } else {
                        System.out.println("El producto ya existe en la lista: " + nombre);
                    }
                }
                
            } catch (IOException e) {
                System.out.println("Error al cargar los productos del archivo: " + e.getMessage());
            }
        } else {
            System.out.println("No se seleccionó ningún archivo.");
        }
    }
}
