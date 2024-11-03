
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static GestorProductos gestorProductos = new GestorProductos();
    static ArchivosProductos gestorArchivoProductos = new ArchivosProductos();
    static ArrayList<Producto> listaProductos = new ArrayList<>();
    static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    static ArrayList<Mesa> listaMesas = new ArrayList<>();
    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    public static void main(String[] args) {
        
        int opcion;
        do {            
            System.out.println("\n--- Pollos y Parrilas El Gran Rancho ---");
            System.out.println("[1] Menu operaciones");
            System.out.println("[2] Menu archvios y colecciones");
            System.out.println("[0] Salir\n");
            System.out.print("Ingresa opcion: ");
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1: menuOperaciones(); break;
                case 2: menuArchivosColecciones();break;
                case 0: System.out.println("Hasta luego!"); break;
                default: System.out.println("Opción no válida.");break;
            }
        } while (opcion != 0);
        
    }
    
    public static void menuArchivosColecciones(){
        int opcion;
            
        do {
            
            
            System.out.println("\n--- Menu de Gestion de Productos ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Mostrar Productos");
            System.out.println("3. Modificar Producto");
            System.out.println("4. Buscar Producto");
            System.out.println("5. Eliminar Producto");
            System.out.println("6. Guardar Productos en Archivo");
            System.out.println("7. Cargar Productos desde Archivo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    agregarProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                   modificarProducto();
                    break;
                case 4:
                    buscarProducto();
                    break;
                case 5:
                    eliminarProducto();
                    break;
                case 6:
                    guardarProductos();
                    break;
                case 7:
                    cargarProductos();
                    break;
                case 0: System.out.println("Hasta luego!"); break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opcion != 0);
  
    }
    
    public static void menuOperaciones(){
        int opcion;
            
        do {
            
            System.out.println("--- Menu de Operaciones ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Actualizar Precio de Producto");
            System.out.println("3. Mostrar Productos");
            System.out.println("4. Agregar Pedido");
            System.out.println("5. Asignar Producto a Pedido");
            System.out.println("6. Agregar Mesa");
            System.out.println("7. Asignar Pedido a Mesa");
            System.out.println("8. Mostrar Mesa");
            System.out.println("9. Mostrar Pedidos");
            System.out.println("10. Agregar Usuario");
            System.out.println("11. Asignar Supervisor a Usuario");
            System.out.println("12. Iniciar Sesion");
            System.out.println("13. Cerrar Sesion");
            System.out.println("14. Cobrar cuenta de una Mesa");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");
            
            opcion = scanner.nextInt();

            scanner.nextLine();
            
            switch (opcion) {
                case 1: agregarProducto(); break;
                case 2: actualizarPrecioProducto(); break;
                case 3: mostrarProductosOperacion(); break;
                case 4: agregarPedido(); break;
                case 5: asignarProductoAPedido(); break;
                case 6: agregarMesa(); break;
                case 7: asignarPedidoAMesa(); break;
                case 8: mostrarInfoMesa(); break;
                case 9: mostrarPedidos(); break;
                case 10: agregarUsuario(); break;
                case 11: asignarSupervisor(); break;
                case 12: iniciarSesion(); break;
                case 13: cerrarSesion(); break;
                case 14: cobrarCuentaMesa(); break;
                case 0: System.out.println("Hasta luego!"); break;
                default: System.out.println("Opción no válida. Inténtalo de nuevo."); break;
            }
        } while (opcion != 0);
    }
    
    public static void actualizarPrecioProducto() {
        System.out.println("--- Actualizar Precio de Producto ---");
        System.out.print("Nombre del producto a actualizar: ");
        String nombre = scanner.nextLine();

        Producto producto = encontrarProductoPorNombre(nombre);
        if (producto != null) {
            System.out.print("Nuevo precio: ");
            double nuevoPrecio = scanner.nextDouble();
            producto.actualizarPrecio(nuevoPrecio);
            System.out.println("Precio actualizado correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void agregarPedido() {
        System.out.println("--- Agregar Pedido ---");
        System.out.print("Numero del pedido: ");
        int numPedido = scanner.nextInt();
        System.out.print("Tipo de pedido (Mesa o Llevar): ");
        String tipoPedido = scanner.next();

        Pedido nuevoPedido = new Pedido(numPedido, tipoPedido);
        listaPedidos.add(nuevoPedido);
        System.out.println("Pedido agregado correctamente.");
    }

    public static void mostrarPedidos() {
        System.out.println("--- Lista de Pedidos ---");
        if (listaPedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido pedido : listaPedidos) {
                pedido.mostrarInfoPedido();
            }
        }
    }

    public static void agregarMesa() {
        System.out.println("--- Agregar Mesa ---");
        System.out.print("Numero de la mesa: ");
        int numeroMesa = scanner.nextInt();
        System.out.print("Capacidad de la mesa: ");
        int capacidad = scanner.nextInt();

        Mesa nuevaMesa = new Mesa(numeroMesa, capacidad);
        listaMesas.add(nuevaMesa);
        System.out.println("Mesa agregada correctamente.");
    }

    public static void asignarPedidoAMesa() {
        System.out.println("--- Asignar Pedido a Mesa ---");
        System.out.print("Numero del pedido: ");
        int numPedido = scanner.nextInt();
        System.out.print("Numero de la mesa: ");
        int numeroMesa = scanner.nextInt();

        Pedido pedido = encontrarPedidoPorNumero(numPedido);
        Mesa mesa = encontrarMesaPorNumero(numeroMesa);

        if (pedido != null && mesa != null) {
            mesa.asignarPedido(pedido);
            pedido.agregarMesa(mesa);
            System.out.println("Pedido asignado a la mesa correctamente.");
        } else {
            System.out.println("Pedido o Mesa no encontrados.");
        }
    }

    public static void cobrarCuentaMesa() {
        System.out.println("--- Cobrar Cuenta de una Mesa ---");
        System.out.print("Numero de la mesa: ");
        int numeroMesa = scanner.nextInt();

        Mesa mesa = encontrarMesaPorNumero(numeroMesa);

        if (mesa != null) {
            if (mesa.getCuenta() == null) {
                System.out.print("Elige el tipo de pago (Efectivo o Tarjeta): ");
                String tipoPago = scanner.next();
                mesa.setCuenta(mesa.new Cuenta(tipoPago));
                mesa.getCuenta().calcularTotalCuenta();
            }
            mesa.getCuenta().mostrarInfoCuenta();
            System.out.print("Desea marcar la cuenta como pagada (Si o No): ");
            String respuesta = scanner.next();

            if (respuesta.equalsIgnoreCase("si")) {
                mesa.getCuenta().marcarComoPagada();
                System.out.println("Cuenta pagada correctamente.");

                liberarMesa(mesa);
            }
        } else {
            System.out.println("Mesa no encontrada.");
        }
    }
    
    public static void liberarMesa(Mesa mesa) {

        for (Pedido pedido : mesa.getListaPedidos()) {

            for (Producto producto : new ArrayList<>(pedido.getListaProductos())) {

                pedido.eliminarProducto(producto);

                listaProductos.remove(producto);
            }

            listaPedidos.remove(pedido);
        }

        mesa.liberarMesa();
        System.out.println("Mesa liberada correctamente. Todos los pedidos y productos asociados han sido eliminados.");
    }

    public static void agregarUsuario() {
        System.out.println("--- Agregar Usuario ---");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.next();
        System.out.print("Contrasenia: ");
        String contrasenia = scanner.next();

        Usuario nuevoUsuario = new Usuario(nombreUsuario, contrasenia);
        listaUsuarios.add(nuevoUsuario);
        System.out.println("Usuario agregado correctamente.");
    }

    public static void iniciarSesion() {
        System.out.println("--- Iniciar Sesion ---");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.next();
        System.out.print("Contrasenia: ");
        String contrasenia = scanner.next();

        Usuario usuario = encontrarUsuarioPorNombre(nombreUsuario);
        if (usuario != null) {
            usuario.iniciarSesion(nombreUsuario, contrasenia);
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void cerrarSesion() {
        System.out.println("--- Cerrar Sesion ---");
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.next();

        Usuario usuario = encontrarUsuarioPorNombre(nombreUsuario);
        if (usuario != null) {
            usuario.cerrarSesion();
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    public static void asignarProductoAPedido() {
        System.out.println("--- Asignar Producto a Pedido ---");
        
        System.out.print("Ingrese el numero de pedido: ");
        int numPedido = scanner.nextInt();
        scanner.nextLine();

        Pedido pedido = encontrarPedidoPorNumero(numPedido);
        if (pedido == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }

        System.out.println("--- Lista de Productos Disponibles ---");
        mostrarProductos();

        System.out.print("Ingrese el nombre del producto a agregar al pedido: ");
        String nombreProducto = scanner.nextLine();

        Producto producto = encontrarProductoPorNombre(nombreProducto);
        if (producto != null) {
            pedido.agregarProducto(producto);  // Asignar el producto al pedido
            System.out.println("Producto agregado al pedido correctamente.");
        } else {
            System.out.println("Producto no encontrado.");
        }
}
    
    public static void mostrarInfoMesa() {
        System.out.println("--- Lista de Mesas ---");
        if (listaMesas.isEmpty()) {
            System.out.println("No hay mesas registrados.");
        } else {
            for (Mesa mesa : listaMesas) {
                mesa.mostrarInfoMesa();
            }
        }
}
    
    public static void asignarSupervisor() {
        System.out.println("--- Asignar Supervisor a Usuario ---");

        System.out.print("Ingrese el nombre del usuario: ");
        String nombreUsuario = scanner.next();

        Usuario usuario = encontrarUsuarioPorNombre(nombreUsuario);
        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese el nombre del supervisor: ");
        String nombreSupervisor = scanner.next();

        Usuario supervisor = encontrarUsuarioPorNombre(nombreSupervisor);
        if (supervisor == null) {
            System.out.println("Supervisor no encontrado.");
            return;
        }

        usuario.asignarSupervisor(supervisor);
        System.out.println("Supervisor asignado correctamente a " + usuario.getNombreUsuario());
}
    
    public static Producto encontrarProductoPorNombre(String nombre) {
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public static Pedido encontrarPedidoPorNumero(int numPedido) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getNumPedido() == numPedido) {
                return pedido;
            }
        }
        return null;
    }

    public static Mesa encontrarMesaPorNumero(int numeroMesa) {
        for (Mesa mesa : listaMesas) {
            if (mesa.getNumeroMesa() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }

    public static Usuario encontrarUsuarioPorNombre(String nombreUsuario) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
    
    public static void agregarProducto(){
        
        String nombre, categoria;
        double precio;
        
        System.out.println("----- Agregar Producto ------");
        System.out.print("Ingresar nombre del producto: ");
        nombre = scanner.nextLine();
        
        System.out.print("Ingresar precio del producto: ");
        precio = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Ingresar categoria del producto: ");
        categoria = scanner.nextLine();
        
        Producto nuevoProducto = new Producto(nombre, precio, categoria);
        gestorProductos.agregarProducto(nuevoProducto);
        listaProductos.add(nuevoProducto);
    }
    
    public static void mostrarProductosOperacion(){
        System.out.println("--- Lista de Productos ---");
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto producto : listaProductos) {
                System.out.println(" - "+producto.toString());
            }
        }
    }
    
    public static void mostrarProductos(){
        System.out.println("----- Lista de Productos -----");
        gestorProductos.mostrarProductos();
        
    }
    public static void modificarProducto(){
        System.out.println("---- Modificar Precio de un Producto ----");
        System.out.print("Ingresar el nombre del producto: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingresar nuevo precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        
        gestorProductos.modificarProducto(nombre, precio);
    }
    public static void buscarProducto(){
        System.out.println("---- Buscar Producto ----");
        System.out.print("Ingresar nombre del producto a buscar: ");
        String nombre = scanner.nextLine();
        
        Producto nuevoProducto = gestorProductos.buscarProducto(nombre);
        
        if (nuevoProducto == null) {
            System.out.println("Producto no encontrado");
        }else{
            System.out.println("Producto encontrado:");
            System.out.println("- "+nuevoProducto);
        }
    }
    public static void eliminarProducto(){
        System.out.println("---- Eliminar Producto ----");
        System.out.print("Ingresar nombre del producto a eliminar: ");
        String nombre = scanner.nextLine();
        
        gestorProductos.eliminarProducto(nombre);
    }
    public static void guardarProductos(){
        System.out.println("---- Agregar Productos a un Archivo ----");
        gestorArchivoProductos.guardarProductos(gestorProductos.getProductos());
    }
    public static void cargarProductos(){
        System.out.println("---- Cargar Productos de un Documento ----");
        gestorArchivoProductos.cargarProductos(gestorProductos.getProductos());
    }
}
