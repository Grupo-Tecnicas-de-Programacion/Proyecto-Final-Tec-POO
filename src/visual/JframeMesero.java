
package visual;

import clases.Cliente;
import clases.GestionReportes;
import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;
import clases.Mesa;
import clases.Pedido;
import clases.Producto;
import clases.Reporte;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageDataFactory;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JDialog;


public class JframeMesero extends javax.swing.JFrame {

    private File archivoSeleccionado;
    private ArrayList<Mesa> mesas = new ArrayList<>();
    private JButton[] botonMesas = new JButton[12];
    private ArrayList<Producto> productos = new ArrayList<>();
    private File archivoSeleccionadoProductos;
    private Pedido pedidoMesa1 = new Pedido();
    private Pedido pedidoMesa2 = new Pedido();
    private Pedido pedidoMesa3 = new Pedido();
    private Pedido pedidoMesa4 = new Pedido();
    private Pedido pedidoMesa5 = new Pedido();
    private Pedido pedidoMesa6 = new Pedido();
    private Pedido pedidoMesa7 = new Pedido();
    private Pedido pedidoMesa8 = new Pedido();
    private Pedido pedidoMesa9 = new Pedido();
    private Pedido pedidoMesa10 = new Pedido();
    private Pedido pedidoMesa11 = new Pedido();
    private Pedido pedidoMesa12 = new Pedido();
    private ArrayList<Pedido> pedidosMesa1 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa1Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa2 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa2Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa3 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa3Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa4 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa4Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa5 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa5Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa6 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa6Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa7 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa7Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa8 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa8Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa9 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa9Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa10 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa10Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa11 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa11Llevar = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa12 = new ArrayList<>();
    private ArrayList<Pedido> pedidosMesa12Llevar = new ArrayList<>();
    private ArrayList<Producto> productosVendidos = new ArrayList<>();
    
    public JframeMesero() {
        initComponents();
        jPanelMostrar.add(panelCargarMesas, "panelCargarMesas");
        jPanelMostrar.add(panelCargarProductos, "panelCargarProductos");
        jPanelMostrar.add(panelCerrarSesion, "panelCerrarSesion");
        jPanelMostrar.add(panelGestionarMesas, "panelGestionarMesas");
        jPanelMostrar.add(panelModProducto, "panelModProducto");
        jPanelMostrar.add(panelElimProducto, "panelElimProducto");
        jPanelMostrar.add(panelBuscProducto, "panelBuscProducto");
        jPanelMostrar.add(panelProducAgotados, "panelProducAgotados");
        jPanelMostrar.add(panelProducDisponibles, "panelProducDisponibles");
        jPanelMostrar.add(panelAgreProducto, "panelAgreProducto");
        jPanelMostrar.add(panelGenerarReporte, "panelGenerarReporte");
        jPanelMostrar.add(verPedidoMesa1, "verPedidoMesa1");
        jPanelMostrar.add(verPedidoMesa2, "verPedidoMesa2");
        jPanelMostrar.add(verPedidoMesa3, "verPedidoMesa3");
        jPanelMostrar.add(verPedidoMesa4, "verPedidoMesa4");
        jPanelMostrar.add(verPedidoMesa5, "verPedidoMesa5");
        jPanelMostrar.add(verPedidoMesa6, "verPedidoMesa6");
        jPanelMostrar.add(verPedidoMesa7, "verPedidoMesa7");
        jPanelMostrar.add(verPedidoMesa8, "verPedidoMesa8");
        jPanelMostrar.add(verPedidoMesa9, "verPedidoMesa9");
        jPanelMostrar.add(verPedidoMesa10, "verPedidoMesa10");
        jPanelMostrar.add(verPedidoMesa11, "verPedidoMesa11");
        jPanelMostrar.add(verPedidoMesa12, "verPedidoMesa12");
        jPanelMostrarMesa.add(panelMesa1, "panelMesa1");
        jPanelMostrarMesa.add(panelMesa2, "panelMesa2");
        jPanelMostrarMesa.add(panelMesa3, "panelMesa3");
        jPanelMostrarMesa.add(panelMesa4, "panelMesa4");
        jPanelMostrarMesa.add(panelMesa5, "panelMesa5");
        jPanelMostrarMesa.add(panelMesa6, "panelMesa6");
        jPanelMostrarMesa.add(panelMesa7, "panelMesa7");
        jPanelMostrarMesa.add(panelMesa8, "panelMesa8");
        jPanelMostrarMesa.add(panelMesa9, "panelMesa9");
        jPanelMostrarMesa.add(panelMesa10, "panelMesa10");
        jPanelMostrarMesa.add(panelMesa11, "panelMesa11");
        jPanelMostrarMesa.add(panelMesa12, "panelMesa12");
        inicializarMesas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMostrar = new javax.swing.JPanel();
        panelCargarMesas = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btnBuscarRutaMesas = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtEstadoArchivoMesas = new javax.swing.JTextField();
        txtRutaArchivoMesas = new javax.swing.JTextField();
        btnCargarMesas = new javax.swing.JButton();
        panelCargarProductos = new javax.swing.JPanel();
        btnCargarProductos = new javax.swing.JButton();
        txtEstadoArchivoProductos = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtRutaArchivoProductos = new javax.swing.JTextField();
        btnBuscarRutaProductos = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        panelCerrarSesion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIngresarCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCodigoGenerado = new javax.swing.JTextField();
        panelGestionarMesas = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnMesa1 = new javax.swing.JButton();
        btnMesa2 = new javax.swing.JButton();
        btnMesa3 = new javax.swing.JButton();
        btnMesa4 = new javax.swing.JButton();
        btnMesa5 = new javax.swing.JButton();
        btnMesa6 = new javax.swing.JButton();
        btnMesa7 = new javax.swing.JButton();
        btnMesa8 = new javax.swing.JButton();
        btnMesa9 = new javax.swing.JButton();
        btnMesa10 = new javax.swing.JButton();
        btnMesa11 = new javax.swing.JButton();
        btnMesa12 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        mDisponible = new javax.swing.JButton();
        mOcupada = new javax.swing.JButton();
        mNoDisponible = new javax.swing.JButton();
        jPanelMostrarMesa = new javax.swing.JPanel();
        panelMesa1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productosPedidoMesa1 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaPedidosMesa1 = new javax.swing.JList<>();
        btnRealizarPedidoMesa1 = new javax.swing.JButton();
        btnTotalCuentaMesa1 = new javax.swing.JButton();
        btnGenerarReciboMesa1 = new javax.swing.JButton();
        btnVerPedidosMesa1 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa1 = new javax.swing.JButton();
        btnVerInfoMesa1 = new javax.swing.JButton();
        panelMesa2 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        productosPedidoMesa2 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa2 = new javax.swing.JButton();
        btnRealizarPedidoMesa2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaPedidosMesa2 = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        btnVerPedidosMesa2 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa2 = new javax.swing.JButton();
        btnTotalCuentaMesa2 = new javax.swing.JButton();
        btnGenerarReciboMesa2 = new javax.swing.JButton();
        btnVerInfoMesa2 = new javax.swing.JButton();
        panelMesa3 = new javax.swing.JPanel();
        jLabel92 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        productosPedidoMesa3 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa3 = new javax.swing.JButton();
        btnRealizarPedidoMesa3 = new javax.swing.JButton();
        jScrollPane28 = new javax.swing.JScrollPane();
        listaPedidosMesa3 = new javax.swing.JList<>();
        jLabel95 = new javax.swing.JLabel();
        btnVerPedidosMesa3 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa3 = new javax.swing.JButton();
        btnTotalCuentaMesa3 = new javax.swing.JButton();
        btnGenerarReciboMesa3 = new javax.swing.JButton();
        btnVerInfoMesa3 = new javax.swing.JButton();
        panelMesa4 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jScrollPane29 = new javax.swing.JScrollPane();
        productosPedidoMesa4 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa4 = new javax.swing.JButton();
        btnRealizarPedidoMesa4 = new javax.swing.JButton();
        jScrollPane30 = new javax.swing.JScrollPane();
        listaPedidosMesa4 = new javax.swing.JList<>();
        jLabel111 = new javax.swing.JLabel();
        btnVerPedidosMesa4 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa4 = new javax.swing.JButton();
        btnTotalCuentaMesa4 = new javax.swing.JButton();
        btnGenerarReciboMesa4 = new javax.swing.JButton();
        btnVerInfoMesa4 = new javax.swing.JButton();
        panelMesa5 = new javax.swing.JPanel();
        jLabel112 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        productosPedidoMesa5 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa5 = new javax.swing.JButton();
        btnRealizarPedidoMesa5 = new javax.swing.JButton();
        jScrollPane32 = new javax.swing.JScrollPane();
        listaPedidosMesa5 = new javax.swing.JList<>();
        jLabel115 = new javax.swing.JLabel();
        btnVerPedidosMesa5 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa5 = new javax.swing.JButton();
        btnTotalCuentaMesa5 = new javax.swing.JButton();
        btnGenerarReciboMesa5 = new javax.swing.JButton();
        btnVerInfoMesa5 = new javax.swing.JButton();
        panelMesa6 = new javax.swing.JPanel();
        jLabel116 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jScrollPane33 = new javax.swing.JScrollPane();
        productosPedidoMesa6 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa6 = new javax.swing.JButton();
        btnRealizarPedidoMesa6 = new javax.swing.JButton();
        jScrollPane34 = new javax.swing.JScrollPane();
        listaPedidosMesa6 = new javax.swing.JList<>();
        jLabel119 = new javax.swing.JLabel();
        btnVerPedidosMesa6 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa6 = new javax.swing.JButton();
        btnTotalCuentaMesa6 = new javax.swing.JButton();
        btnGenerarReciboMesa6 = new javax.swing.JButton();
        btnVerInfoMesa6 = new javax.swing.JButton();
        panelMesa7 = new javax.swing.JPanel();
        jLabel120 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jScrollPane35 = new javax.swing.JScrollPane();
        productosPedidoMesa7 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa7 = new javax.swing.JButton();
        btnRealizarPedidoMesa7 = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        btnVerPedidosMesa7 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa7 = new javax.swing.JButton();
        btnTotalCuentaMesa7 = new javax.swing.JButton();
        btnGenerarReciboMesa7 = new javax.swing.JButton();
        btnVerInfoMesa7 = new javax.swing.JButton();
        jScrollPane47 = new javax.swing.JScrollPane();
        listaPedidosMesa7 = new javax.swing.JList<>();
        panelMesa8 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        productosPedidoMesa8 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa8 = new javax.swing.JButton();
        btnRealizarPedidoMesa8 = new javax.swing.JButton();
        jLabel127 = new javax.swing.JLabel();
        btnVerPedidosMesa8 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa8 = new javax.swing.JButton();
        btnTotalCuentaMesa8 = new javax.swing.JButton();
        btnGenerarReciboMesa8 = new javax.swing.JButton();
        btnVerInfoMesa8 = new javax.swing.JButton();
        jScrollPane36 = new javax.swing.JScrollPane();
        listaPedidosMesa8 = new javax.swing.JList<>();
        panelMesa9 = new javax.swing.JPanel();
        jLabel128 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jScrollPane39 = new javax.swing.JScrollPane();
        productosPedidoMesa9 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa9 = new javax.swing.JButton();
        btnRealizarPedidoMesa9 = new javax.swing.JButton();
        jLabel131 = new javax.swing.JLabel();
        btnVerPedidosMesa9 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa9 = new javax.swing.JButton();
        btnTotalCuentaMesa9 = new javax.swing.JButton();
        btnGenerarReciboMesa9 = new javax.swing.JButton();
        btnVerInfoMesa9 = new javax.swing.JButton();
        jScrollPane38 = new javax.swing.JScrollPane();
        listaPedidosMesa9 = new javax.swing.JList<>();
        panelMesa10 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jScrollPane41 = new javax.swing.JScrollPane();
        productosPedidoMesa10 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa10 = new javax.swing.JButton();
        btnRealizarPedidoMesa10 = new javax.swing.JButton();
        jLabel135 = new javax.swing.JLabel();
        btnVerPedidosMesa10 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa10 = new javax.swing.JButton();
        btnTotalCuentaMesa10 = new javax.swing.JButton();
        btnGenerarReciboMesa10 = new javax.swing.JButton();
        btnVerInfoMesa10 = new javax.swing.JButton();
        jScrollPane40 = new javax.swing.JScrollPane();
        listaPedidosMesa10 = new javax.swing.JList<>();
        panelMesa11 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jScrollPane43 = new javax.swing.JScrollPane();
        productosPedidoMesa11 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa11 = new javax.swing.JButton();
        btnRealizarPedidoMesa11 = new javax.swing.JButton();
        jScrollPane44 = new javax.swing.JScrollPane();
        listaPedidosMesa11 = new javax.swing.JList<>();
        jLabel139 = new javax.swing.JLabel();
        btnVerPedidosMesa11 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa11 = new javax.swing.JButton();
        btnTotalCuentaMesa11 = new javax.swing.JButton();
        btnGenerarReciboMesa11 = new javax.swing.JButton();
        btnVerInfoMesa11 = new javax.swing.JButton();
        panelMesa12 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jScrollPane45 = new javax.swing.JScrollPane();
        productosPedidoMesa12 = new javax.swing.JList<>();
        btnAgregarProductoPedidoMesa12 = new javax.swing.JButton();
        btnRealizarPedidoMesa12 = new javax.swing.JButton();
        jScrollPane46 = new javax.swing.JScrollPane();
        listaPedidosMesa12 = new javax.swing.JList<>();
        jLabel143 = new javax.swing.JLabel();
        btnVerPedidosMesa12 = new javax.swing.JButton();
        btnBorrarProductoPedidoMesa12 = new javax.swing.JButton();
        btnTotalCuentaMesa12 = new javax.swing.JButton();
        btnGenerarReciboMesa12 = new javax.swing.JButton();
        btnVerInfoMesa12 = new javax.swing.JButton();
        panelAgreProducto = new javax.swing.JPanel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        txtPrecioNuevoProducto = new javax.swing.JTextField();
        txtCantidadNuevoProducto = new javax.swing.JTextField();
        btnAgregarProductoCarta = new javax.swing.JButton();
        jLabel102 = new javax.swing.JLabel();
        txtCategoriaNuevoProducto = new javax.swing.JTextField();
        txtNombreNuevoProducto = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        panelModProducto = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txtNombreProductoModificar = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        txtCantidadProductoActual = new javax.swing.JTextField();
        txtNombreProductoActual = new javax.swing.JTextField();
        txtCategoriaProductoActual = new javax.swing.JTextField();
        txtPrecioProductoActual = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        txtNombreProductoNuevo = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        txtCategoriaProductoNuevo = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txtPrecioProductoNuevo = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        txtCantidadProductoNuevo = new javax.swing.JTextField();
        buscarProductoModificar = new javax.swing.JButton();
        btnModificarProducto = new javax.swing.JButton();
        panelBuscProducto = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        txtNombreProductoBuscar = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        txtNombreProductoBuscado = new javax.swing.JTextField();
        txtCategoriaProductoBuscado = new javax.swing.JTextField();
        txtPrecioProductoBuscado = new javax.swing.JTextField();
        txtCantidadProductoBuscado = new javax.swing.JTextField();
        btnBuscandoProducto = new javax.swing.JButton();
        panelElimProducto = new javax.swing.JPanel();
        btnEliminarProducto = new javax.swing.JButton();
        txtNombreProductoEliminar = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        txtNombreProductoAEliminar = new javax.swing.JTextField();
        txtCategoriaProductoAEliminar = new javax.swing.JTextField();
        txtPrecioProductoAEliminar = new javax.swing.JTextField();
        txtCantidadProductoAEliminar = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        btnBuscarProductoEliminar = new javax.swing.JButton();
        panelProducDisponibles = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        listaProductosDisponibles = new javax.swing.JList<>();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        txtNombreProductoDisponible = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        txtCategoriaProductoDisponible = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        txtPrecioProductoDisponible = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        txtCantidadProductoDisponible = new javax.swing.JTextField();
        panelProducAgotados = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        txtCantidadProductoAgotado = new javax.swing.JTextField();
        txtPrecioProductoAgotado = new javax.swing.JTextField();
        txtCategoriaProductoAgotado = new javax.swing.JTextField();
        txtNombreProductoAgotado = new javax.swing.JTextField();
        jScrollPane27 = new javax.swing.JScrollPane();
        listaProductosAgotados = new javax.swing.JList<>();
        panelGenerarReporte = new javax.swing.JPanel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        txtFechaGenerarReporte = new javax.swing.JTextField();
        txtNombreGenerarReporte = new javax.swing.JTextField();
        btnGenerarReporteDia = new javax.swing.JButton();
        verPedidoMesa1 = new javax.swing.JPanel();
        volverAtrasMesa1 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa1 = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaVerPedidosMesa1 = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        detallePedidoMesa1 = new javax.swing.JList<>();
        cancelarPedidoMesa1 = new javax.swing.JButton();
        btnLimpiarMesa1 = new javax.swing.JButton();
        verPedidoMesa2 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        volverAtrasMesa2 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaVerPedidosMesa2 = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        detallePedidoMesa2 = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa2 = new javax.swing.JList<>();
        btnLimpiarMesa2 = new javax.swing.JButton();
        cancelarPedidoMesa2 = new javax.swing.JButton();
        verPedidoMesa3 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        volverAtrasMesa3 = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        listaVerPedidosMesa3 = new javax.swing.JList<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        detallePedidoMesa3 = new javax.swing.JList<>();
        jScrollPane13 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa3 = new javax.swing.JList<>();
        btnLimpiarMesa3 = new javax.swing.JButton();
        cancelarPedidoMesa3 = new javax.swing.JButton();
        verPedidoMesa4 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        volverAtrasMesa4 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        listaVerPedidosMesa4 = new javax.swing.JList<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        detallePedidoMesa4 = new javax.swing.JList<>();
        jScrollPane16 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa4 = new javax.swing.JList<>();
        cancelarPedidoMesa4 = new javax.swing.JButton();
        btnLimpiarMesa4 = new javax.swing.JButton();
        verPedidoMesa5 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        volverAtrasMesa5 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        listaVerPedidosMesa5 = new javax.swing.JList<>();
        jScrollPane18 = new javax.swing.JScrollPane();
        detallePedidoMesa5 = new javax.swing.JList<>();
        jScrollPane19 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa5 = new javax.swing.JList<>();
        cancelarPedidoMesa5 = new javax.swing.JButton();
        btnLimpiarMesa5 = new javax.swing.JButton();
        verPedidoMesa6 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        volverAtrasMesa6 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        listaVerPedidosMesa6 = new javax.swing.JList<>();
        jScrollPane21 = new javax.swing.JScrollPane();
        detallePedidoMesa6 = new javax.swing.JList<>();
        jScrollPane22 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa6 = new javax.swing.JList<>();
        cancelarPedidoMesa6 = new javax.swing.JButton();
        btnLimpiarMesa6 = new javax.swing.JButton();
        verPedidoMesa7 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        volverAtrasMesa7 = new javax.swing.JButton();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        listaVerPedidosMesa7 = new javax.swing.JList<>();
        jScrollPane24 = new javax.swing.JScrollPane();
        detallePedidoMesa7 = new javax.swing.JList<>();
        jScrollPane42 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa7 = new javax.swing.JList<>();
        cancelarPedidoMesa7 = new javax.swing.JButton();
        btnLimpiarMesa7 = new javax.swing.JButton();
        verPedidoMesa8 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        volverAtrasMesa8 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        listaVerPedidosMesa8 = new javax.swing.JList<>();
        jScrollPane49 = new javax.swing.JScrollPane();
        detallePedidoMesa8 = new javax.swing.JList<>();
        jScrollPane50 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa8 = new javax.swing.JList<>();
        cancelarPedidoMesa8 = new javax.swing.JButton();
        btnLimpiarMesa8 = new javax.swing.JButton();
        verPedidoMesa9 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        volverAtrasMesa9 = new javax.swing.JButton();
        jLabel93 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jScrollPane51 = new javax.swing.JScrollPane();
        listaVerPedidosMesa9 = new javax.swing.JList<>();
        jScrollPane52 = new javax.swing.JScrollPane();
        detallePedidoMesa9 = new javax.swing.JList<>();
        jScrollPane53 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa9 = new javax.swing.JList<>();
        cancelarPedidoMesa9 = new javax.swing.JButton();
        btnLimpiarMesa9 = new javax.swing.JButton();
        verPedidoMesa10 = new javax.swing.JPanel();
        jLabel117 = new javax.swing.JLabel();
        volverAtrasMesa10 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jScrollPane54 = new javax.swing.JScrollPane();
        listaVerPedidosMesa10 = new javax.swing.JList<>();
        jScrollPane55 = new javax.swing.JScrollPane();
        detallePedidoMesa10 = new javax.swing.JList<>();
        jScrollPane56 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa10 = new javax.swing.JList<>();
        cancelarPedidoMesa10 = new javax.swing.JButton();
        btnLimpiarMesa10 = new javax.swing.JButton();
        verPedidoMesa11 = new javax.swing.JPanel();
        jLabel133 = new javax.swing.JLabel();
        volverAtrasMesa11 = new javax.swing.JButton();
        jLabel137 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jScrollPane57 = new javax.swing.JScrollPane();
        listaVerPedidosMesa11 = new javax.swing.JList<>();
        jScrollPane58 = new javax.swing.JScrollPane();
        detallePedidoMesa11 = new javax.swing.JList<>();
        jScrollPane59 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa11 = new javax.swing.JList<>();
        cancelarPedidoMesa11 = new javax.swing.JButton();
        btnLimpiarMesa11 = new javax.swing.JButton();
        verPedidoMesa12 = new javax.swing.JPanel();
        jLabel149 = new javax.swing.JLabel();
        volverAtrasMesa12 = new javax.swing.JButton();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jScrollPane60 = new javax.swing.JScrollPane();
        listaVerPedidosMesa12 = new javax.swing.JList<>();
        jScrollPane61 = new javax.swing.JScrollPane();
        detallePedidoMesa12 = new javax.swing.JList<>();
        jScrollPane62 = new javax.swing.JScrollPane();
        listaVerPedidosLlevarMesa12 = new javax.swing.JList<>();
        cancelarPedidoMesa12 = new javax.swing.JButton();
        btnLimpiarMesa12 = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        menuMesero = new javax.swing.JMenu();
        menItemCargarMesas = new javax.swing.JMenuItem();
        menItemCargarProductos = new javax.swing.JMenuItem();
        menItemCerrarSesion = new javax.swing.JMenuItem();
        menuMesas = new javax.swing.JMenu();
        menItemGestionarMesas = new javax.swing.JMenuItem();
        menuProductos = new javax.swing.JMenu();
        menItemAgreProducto = new javax.swing.JMenuItem();
        menItemModProducto = new javax.swing.JMenuItem();
        menItemBuscProducto = new javax.swing.JMenuItem();
        menItemElimProducto = new javax.swing.JMenuItem();
        menItemProducDisponibles = new javax.swing.JMenuItem();
        menItemProducDAgotados = new javax.swing.JMenuItem();
        menuGenerarReporte = new javax.swing.JMenu();
        menItemGenerarReporte = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMostrar.setBackground(new java.awt.Color(0, 51, 51));
        jPanelMostrar.setVerifyInputWhenFocusTarget(false);
        jPanelMostrar.setLayout(new java.awt.CardLayout());

        panelCargarMesas.setBackground(new java.awt.Color(204, 204, 204));
        panelCargarMesas.setPreferredSize(new java.awt.Dimension(850, 450));
        panelCargarMesas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("CARGAR LISTA MESAS");
        panelCargarMesas.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 300, 25));

        btnBuscarRutaMesas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarRutaMesas.setText("Buscar archivo");
        btnBuscarRutaMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRutaMesasActionPerformed(evt);
            }
        });
        panelCargarMesas.add(btnBuscarRutaMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 140, 60));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Ruta del archivo");
        panelCargarMesas.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 110, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("Estado del archivo");
        panelCargarMesas.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 120, 30));

        txtEstadoArchivoMesas.setEditable(false);
        txtEstadoArchivoMesas.setEnabled(false);
        panelCargarMesas.add(txtEstadoArchivoMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 509, 30));

        txtRutaArchivoMesas.setEditable(false);
        txtRutaArchivoMesas.setEnabled(false);
        panelCargarMesas.add(txtRutaArchivoMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 509, 30));

        btnCargarMesas.setBackground(new java.awt.Color(0, 153, 0));
        btnCargarMesas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCargarMesas.setText("Cargar lista mesas");
        btnCargarMesas.setEnabled(false);
        btnCargarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarMesasActionPerformed(evt);
            }
        });
        panelCargarMesas.add(btnCargarMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 160, 70));

        jPanelMostrar.add(panelCargarMesas, "card2");

        panelCargarProductos.setBackground(new java.awt.Color(204, 204, 204));
        panelCargarProductos.setPreferredSize(new java.awt.Dimension(850, 450));
        panelCargarProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCargarProductos.setBackground(new java.awt.Color(0, 153, 0));
        btnCargarProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCargarProductos.setText("Cargar lista productos");
        btnCargarProductos.setEnabled(false);
        btnCargarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarProductosActionPerformed(evt);
            }
        });
        panelCargarProductos.add(btnCargarProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 330, 200, 70));

        txtEstadoArchivoProductos.setEditable(false);
        panelCargarProductos.add(txtEstadoArchivoProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 509, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Estado del archivo");
        panelCargarProductos.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 120, 30));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("Ruta del archivo");
        panelCargarProductos.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 110, 30));

        txtRutaArchivoProductos.setEditable(false);
        panelCargarProductos.add(txtRutaArchivoProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 509, 30));

        btnBuscarRutaProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarRutaProductos.setText("Buscar archivo");
        btnBuscarRutaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarRutaProductosActionPerformed(evt);
            }
        });
        panelCargarProductos.add(btnBuscarRutaProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 140, 60));

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("CARGAR LISTA PRODUCTOS");
        panelCargarProductos.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 360, 25));

        jPanelMostrar.add(panelCargarProductos, "card3");

        panelCerrarSesion.setBackground(new java.awt.Color(204, 204, 204));
        panelCerrarSesion.setPreferredSize(new java.awt.Dimension(850, 450));
        panelCerrarSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CERRAR SESIÓN");
        panelCerrarSesion.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 210, 45));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Ingresar el número generado");
        panelCerrarSesion.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 250, 43));

        btnCerrarSesion.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrarSesion.setForeground(new java.awt.Color(0, 0, 0));
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        panelCerrarSesion.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 150, 130));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Número generado");
        panelCerrarSesion.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 180, 60));

        txtIngresarCodigo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        panelCerrarSesion.add(txtIngresarCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 257, 44));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Ingresar el número");
        panelCerrarSesion.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 180, 60));

        txtCodigoGenerado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txtCodigoGenerado.setEnabled(false);
        panelCerrarSesion.add(txtCodigoGenerado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 257, 45));

        jPanelMostrar.add(panelCerrarSesion, "card4");

        panelGestionarMesas.setBackground(new java.awt.Color(204, 204, 204));
        panelGestionarMesas.setPreferredSize(new java.awt.Dimension(960, 455));
        panelGestionarMesas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Gestionar mesas");
        panelGestionarMesas.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 12, 220, 45));

        btnMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa1.setText("1");
        btnMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa1ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 69, 60, 58));

        btnMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa2.setText("2");
        btnMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa2ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 145, 60, 58));

        btnMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa3.setText("3");
        btnMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa3ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 221, 60, 58));

        btnMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa4.setText("4");
        btnMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa4ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 297, 60, 58));

        btnMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa5.setText("5");
        btnMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa5ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 69, 60, 58));

        btnMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa6.setText("6");
        btnMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa6ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 145, 60, 58));

        btnMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa7.setText("7");
        btnMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa7ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 221, 60, 58));

        btnMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa8.setText("8");
        btnMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa8ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 297, 60, 58));

        btnMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa9.setText("9");
        btnMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa9ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 69, 60, 58));

        btnMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa10.setText("10");
        btnMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa10ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 145, 60, 58));

        btnMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa11.setText("11");
        btnMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa11ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 221, 60, 58));

        btnMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnMesa12.setText("12");
        btnMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesa12ActionPerformed(evt);
            }
        });
        panelGestionarMesas.add(btnMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 297, 60, 58));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ocupada");
        panelGestionarMesas.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 59, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("No disponible");
        panelGestionarMesas.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 80, 20));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Disponible");
        panelGestionarMesas.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, 59, 20));

        mDisponible.setBackground(new java.awt.Color(51, 255, 0));
        mDisponible.setForeground(new java.awt.Color(0, 255, 0));
        panelGestionarMesas.add(mDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 27, 23));

        mOcupada.setBackground(new java.awt.Color(153, 0, 0));
        mOcupada.setForeground(new java.awt.Color(153, 0, 0));
        panelGestionarMesas.add(mOcupada, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 27, 23));

        mNoDisponible.setBackground(new java.awt.Color(204, 204, 204));
        mNoDisponible.setForeground(new java.awt.Color(204, 204, 204));
        mNoDisponible.setEnabled(false);
        panelGestionarMesas.add(mNoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 27, 23));

        jPanelMostrarMesa.setLayout(new java.awt.CardLayout());

        panelMesa1.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Mesa 1");
        panelMesa1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Productos del pedido");
        panelMesa1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        productosPedidoMesa1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(productosPedidoMesa1);

        panelMesa1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa1.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa1ActionPerformed(evt);
            }
        });
        panelMesa1.add(btnAgregarProductoPedidoMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Productos de la carta");
        panelMesa1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        listaPedidosMesa1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa1ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaPedidosMesa1);

        panelMesa1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        btnRealizarPedidoMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa1.setText("Realizar pedido");
        btnRealizarPedidoMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa1ActionPerformed(evt);
            }
        });
        panelMesa1.add(btnRealizarPedidoMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        btnTotalCuentaMesa1.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa1.setText("Total cuenta");
        btnTotalCuentaMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa1ActionPerformed(evt);
            }
        });
        panelMesa1.add(btnTotalCuentaMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa1.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa1.setText("Generar recibo");
        btnGenerarReciboMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa1ActionPerformed(evt);
            }
        });
        panelMesa1.add(btnGenerarReciboMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerPedidosMesa1.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa1.setText("Ver pedidos");
        btnVerPedidosMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa1ActionPerformed(evt);
            }
        });
        panelMesa1.add(btnVerPedidosMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa1.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa1.setText("Borrar producto");
        btnBorrarProductoPedidoMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa1ActionPerformed(evt);
            }
        });
        panelMesa1.add(btnBorrarProductoPedidoMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnVerInfoMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa1.setText("Información mesa");
        btnVerInfoMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa1ActionPerformed(evt);
            }
        });
        panelMesa1.add(btnVerInfoMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        jPanelMostrarMesa.add(panelMesa1, "card2");

        panelMesa2.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Mesa 2");
        panelMesa2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Productos de la carta");
        panelMesa2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa2ValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(productosPedidoMesa2);

        panelMesa2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa2.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa2ActionPerformed(evt);
            }
        });
        panelMesa2.add(btnAgregarProductoPedidoMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa2.setText("Realizar pedido");
        btnRealizarPedidoMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa2ActionPerformed(evt);
            }
        });
        panelMesa2.add(btnRealizarPedidoMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        listaPedidosMesa2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa2ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(listaPedidosMesa2);

        panelMesa2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Productos del pedido");
        panelMesa2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa2.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa2.setText("Ver pedidos");
        btnVerPedidosMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa2ActionPerformed(evt);
            }
        });
        panelMesa2.add(btnVerPedidosMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa2.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa2.setText("Borrar producto");
        btnBorrarProductoPedidoMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa2ActionPerformed(evt);
            }
        });
        panelMesa2.add(btnBorrarProductoPedidoMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa2.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa2.setText("Total cuenta");
        btnTotalCuentaMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa2ActionPerformed(evt);
            }
        });
        panelMesa2.add(btnTotalCuentaMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa2.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa2.setText("Generar recibo");
        btnGenerarReciboMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa2ActionPerformed(evt);
            }
        });
        panelMesa2.add(btnGenerarReciboMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa2.setText("Información mesa");
        btnVerInfoMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa2ActionPerformed(evt);
            }
        });
        panelMesa2.add(btnVerInfoMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        jPanelMostrarMesa.add(panelMesa2, "card3");

        panelMesa3.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel92.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(51, 51, 51));
        jLabel92.setText("Mesa 3");
        panelMesa3.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel94.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 0, 0));
        jLabel94.setText("Productos de la carta");
        panelMesa3.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa3ValueChanged(evt);
            }
        });
        jScrollPane26.setViewportView(productosPedidoMesa3);

        panelMesa3.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa3.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa3ActionPerformed(evt);
            }
        });
        panelMesa3.add(btnAgregarProductoPedidoMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa3.setText("Realizar pedido");
        btnRealizarPedidoMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa3ActionPerformed(evt);
            }
        });
        panelMesa3.add(btnRealizarPedidoMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        listaPedidosMesa3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa3ValueChanged(evt);
            }
        });
        jScrollPane28.setViewportView(listaPedidosMesa3);

        panelMesa3.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jLabel95.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 0, 0));
        jLabel95.setText("Productos del pedido");
        panelMesa3.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa3.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa3.setText("Ver pedidos");
        btnVerPedidosMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa3ActionPerformed(evt);
            }
        });
        panelMesa3.add(btnVerPedidosMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa3.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa3.setText("Borrar producto");
        btnBorrarProductoPedidoMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa3ActionPerformed(evt);
            }
        });
        panelMesa3.add(btnBorrarProductoPedidoMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa3.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa3.setText("Total cuenta");
        btnTotalCuentaMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa3ActionPerformed(evt);
            }
        });
        panelMesa3.add(btnTotalCuentaMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa3.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa3.setText("Generar recibo");
        btnGenerarReciboMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa3ActionPerformed(evt);
            }
        });
        panelMesa3.add(btnGenerarReciboMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa3.setText("Información mesa");
        btnVerInfoMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa3ActionPerformed(evt);
            }
        });
        panelMesa3.add(btnVerInfoMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        jPanelMostrarMesa.add(panelMesa3, "card4");

        panelMesa4.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(51, 51, 51));
        jLabel96.setText("Mesa 4");
        panelMesa4.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel110.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 0, 0));
        jLabel110.setText("Productos de la carta");
        panelMesa4.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa4.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa4ValueChanged(evt);
            }
        });
        jScrollPane29.setViewportView(productosPedidoMesa4);

        panelMesa4.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa4.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa4ActionPerformed(evt);
            }
        });
        panelMesa4.add(btnAgregarProductoPedidoMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa4.setText("Realizar pedido");
        btnRealizarPedidoMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa4ActionPerformed(evt);
            }
        });
        panelMesa4.add(btnRealizarPedidoMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        listaPedidosMesa4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa4.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa4ValueChanged(evt);
            }
        });
        jScrollPane30.setViewportView(listaPedidosMesa4);

        panelMesa4.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jLabel111.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 0, 0));
        jLabel111.setText("Productos del pedido");
        panelMesa4.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa4.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa4.setText("Ver pedidos");
        btnVerPedidosMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa4ActionPerformed(evt);
            }
        });
        panelMesa4.add(btnVerPedidosMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa4.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa4.setText("Borrar producto");
        btnBorrarProductoPedidoMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa4ActionPerformed(evt);
            }
        });
        panelMesa4.add(btnBorrarProductoPedidoMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa4.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa4.setText("Total cuenta");
        btnTotalCuentaMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa4ActionPerformed(evt);
            }
        });
        panelMesa4.add(btnTotalCuentaMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa4.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa4.setText("Generar recibo");
        btnGenerarReciboMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa4ActionPerformed(evt);
            }
        });
        panelMesa4.add(btnGenerarReciboMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa4.setText("Información mesa");
        btnVerInfoMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa4ActionPerformed(evt);
            }
        });
        panelMesa4.add(btnVerInfoMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        jPanelMostrarMesa.add(panelMesa4, "card5");

        panelMesa5.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel112.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(51, 51, 51));
        jLabel112.setText("Mesa 5");
        panelMesa5.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel114.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 0, 0));
        jLabel114.setText("Productos de la carta");
        panelMesa5.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa5.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa5.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa5ValueChanged(evt);
            }
        });
        jScrollPane31.setViewportView(productosPedidoMesa5);

        panelMesa5.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa5.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa5ActionPerformed(evt);
            }
        });
        panelMesa5.add(btnAgregarProductoPedidoMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa5.setText("Realizar pedido");
        btnRealizarPedidoMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa5ActionPerformed(evt);
            }
        });
        panelMesa5.add(btnRealizarPedidoMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        listaPedidosMesa5.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa5.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa5ValueChanged(evt);
            }
        });
        jScrollPane32.setViewportView(listaPedidosMesa5);

        panelMesa5.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jLabel115.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(0, 0, 0));
        jLabel115.setText("Productos del pedido");
        panelMesa5.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa5.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa5.setText("Ver pedidos");
        btnVerPedidosMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa5ActionPerformed(evt);
            }
        });
        panelMesa5.add(btnVerPedidosMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa5.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa5.setText("Borrar producto");
        btnBorrarProductoPedidoMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa5ActionPerformed(evt);
            }
        });
        panelMesa5.add(btnBorrarProductoPedidoMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa5.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa5.setText("Total cuenta");
        btnTotalCuentaMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa5ActionPerformed(evt);
            }
        });
        panelMesa5.add(btnTotalCuentaMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa5.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa5.setText("Generar recibo");
        btnGenerarReciboMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa5ActionPerformed(evt);
            }
        });
        panelMesa5.add(btnGenerarReciboMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa5.setText("Información mesa");
        btnVerInfoMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa5ActionPerformed(evt);
            }
        });
        panelMesa5.add(btnVerInfoMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        jPanelMostrarMesa.add(panelMesa5, "card6");

        panelMesa6.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel116.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel116.setForeground(new java.awt.Color(51, 51, 51));
        jLabel116.setText("Mesa 6");
        panelMesa6.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel118.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 0, 0));
        jLabel118.setText("Productos de la carta");
        panelMesa6.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa6.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa6ValueChanged(evt);
            }
        });
        jScrollPane33.setViewportView(productosPedidoMesa6);

        panelMesa6.add(jScrollPane33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa6.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa6ActionPerformed(evt);
            }
        });
        panelMesa6.add(btnAgregarProductoPedidoMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa6.setText("Realizar pedido");
        btnRealizarPedidoMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa6ActionPerformed(evt);
            }
        });
        panelMesa6.add(btnRealizarPedidoMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        listaPedidosMesa6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa6.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa6ValueChanged(evt);
            }
        });
        jScrollPane34.setViewportView(listaPedidosMesa6);

        panelMesa6.add(jScrollPane34, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jLabel119.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(0, 0, 0));
        jLabel119.setText("Productos del pedido");
        panelMesa6.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa6.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa6.setText("Ver pedidos");
        btnVerPedidosMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa6ActionPerformed(evt);
            }
        });
        panelMesa6.add(btnVerPedidosMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa6.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa6.setText("Borrar producto");
        btnBorrarProductoPedidoMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa6ActionPerformed(evt);
            }
        });
        panelMesa6.add(btnBorrarProductoPedidoMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa6.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa6.setText("Total cuenta");
        btnTotalCuentaMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa6ActionPerformed(evt);
            }
        });
        panelMesa6.add(btnTotalCuentaMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa6.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa6.setText("Generar recibo");
        btnGenerarReciboMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa6ActionPerformed(evt);
            }
        });
        panelMesa6.add(btnGenerarReciboMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa6.setText("Información mesa");
        btnVerInfoMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa6ActionPerformed(evt);
            }
        });
        panelMesa6.add(btnVerInfoMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        jPanelMostrarMesa.add(panelMesa6, "card7");

        panelMesa7.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel120.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(51, 51, 51));
        jLabel120.setText("Mesa 7");
        panelMesa7.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel122.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(0, 0, 0));
        jLabel122.setText("Productos de la carta");
        panelMesa7.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa7.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa7.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa7ValueChanged(evt);
            }
        });
        jScrollPane35.setViewportView(productosPedidoMesa7);

        panelMesa7.add(jScrollPane35, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa7.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa7ActionPerformed(evt);
            }
        });
        panelMesa7.add(btnAgregarProductoPedidoMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa7.setText("Realizar pedido");
        btnRealizarPedidoMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa7ActionPerformed(evt);
            }
        });
        panelMesa7.add(btnRealizarPedidoMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        jLabel123.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel123.setForeground(new java.awt.Color(0, 0, 0));
        jLabel123.setText("Productos del pedido");
        panelMesa7.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa7.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa7.setText("Ver pedidos");
        btnVerPedidosMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa7ActionPerformed(evt);
            }
        });
        panelMesa7.add(btnVerPedidosMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa7.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa7.setText("Borrar producto");
        btnBorrarProductoPedidoMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa7ActionPerformed(evt);
            }
        });
        panelMesa7.add(btnBorrarProductoPedidoMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa7.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa7.setText("Total cuenta");
        btnTotalCuentaMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa7ActionPerformed(evt);
            }
        });
        panelMesa7.add(btnTotalCuentaMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa7.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa7.setText("Generar recibo");
        btnGenerarReciboMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa7ActionPerformed(evt);
            }
        });
        panelMesa7.add(btnGenerarReciboMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa7.setText("Información mesa");
        btnVerInfoMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa7ActionPerformed(evt);
            }
        });
        panelMesa7.add(btnVerInfoMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        listaPedidosMesa7.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa7.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa7ValueChanged(evt);
            }
        });
        jScrollPane47.setViewportView(listaPedidosMesa7);

        panelMesa7.add(jScrollPane47, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jPanelMostrarMesa.add(panelMesa7, "card8");

        panelMesa8.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel124.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel124.setForeground(new java.awt.Color(51, 51, 51));
        jLabel124.setText("Mesa 8");
        panelMesa8.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel126.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel126.setForeground(new java.awt.Color(0, 0, 0));
        jLabel126.setText("Productos de la carta");
        panelMesa8.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa8.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa8.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa8ValueChanged(evt);
            }
        });
        jScrollPane37.setViewportView(productosPedidoMesa8);

        panelMesa8.add(jScrollPane37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa8.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa8ActionPerformed(evt);
            }
        });
        panelMesa8.add(btnAgregarProductoPedidoMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa8.setText("Realizar pedido");
        btnRealizarPedidoMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa8ActionPerformed(evt);
            }
        });
        panelMesa8.add(btnRealizarPedidoMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        jLabel127.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel127.setForeground(new java.awt.Color(0, 0, 0));
        jLabel127.setText("Productos del pedido");
        panelMesa8.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa8.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa8.setText("Ver pedidos");
        btnVerPedidosMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa8ActionPerformed(evt);
            }
        });
        panelMesa8.add(btnVerPedidosMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa8.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa8.setText("Borrar producto");
        btnBorrarProductoPedidoMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa8ActionPerformed(evt);
            }
        });
        panelMesa8.add(btnBorrarProductoPedidoMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa8.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa8.setText("Total cuenta");
        btnTotalCuentaMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa8ActionPerformed(evt);
            }
        });
        panelMesa8.add(btnTotalCuentaMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa8.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa8.setText("Generar recibo");
        btnGenerarReciboMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa8ActionPerformed(evt);
            }
        });
        panelMesa8.add(btnGenerarReciboMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa8.setText("Información mesa");
        btnVerInfoMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa8ActionPerformed(evt);
            }
        });
        panelMesa8.add(btnVerInfoMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        listaPedidosMesa8.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa8.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa8ValueChanged(evt);
            }
        });
        jScrollPane36.setViewportView(listaPedidosMesa8);

        panelMesa8.add(jScrollPane36, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jPanelMostrarMesa.add(panelMesa8, "card9");

        panelMesa9.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa9.setForeground(new java.awt.Color(0, 0, 0));
        panelMesa9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel128.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel128.setForeground(new java.awt.Color(51, 51, 51));
        jLabel128.setText("Mesa 9");
        panelMesa9.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel130.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel130.setForeground(new java.awt.Color(0, 0, 0));
        jLabel130.setText("Productos de la carta");
        panelMesa9.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa9.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa9.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa9ValueChanged(evt);
            }
        });
        jScrollPane39.setViewportView(productosPedidoMesa9);

        panelMesa9.add(jScrollPane39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa9.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa9.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa9ActionPerformed(evt);
            }
        });
        panelMesa9.add(btnAgregarProductoPedidoMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa9.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa9.setText("Realizar pedido");
        btnRealizarPedidoMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa9ActionPerformed(evt);
            }
        });
        panelMesa9.add(btnRealizarPedidoMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        jLabel131.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel131.setForeground(new java.awt.Color(0, 0, 0));
        jLabel131.setText("Productos del pedido");
        panelMesa9.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa9.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa9.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa9.setText("Ver pedidos");
        btnVerPedidosMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa9ActionPerformed(evt);
            }
        });
        panelMesa9.add(btnVerPedidosMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa9.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa9.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa9.setText("Borrar producto");
        btnBorrarProductoPedidoMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa9ActionPerformed(evt);
            }
        });
        panelMesa9.add(btnBorrarProductoPedidoMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa9.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa9.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa9.setText("Total cuenta");
        btnTotalCuentaMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa9ActionPerformed(evt);
            }
        });
        panelMesa9.add(btnTotalCuentaMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa9.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa9.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa9.setText("Generar recibo");
        btnGenerarReciboMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa9ActionPerformed(evt);
            }
        });
        panelMesa9.add(btnGenerarReciboMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa9.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa9.setText("Información mesa");
        btnVerInfoMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa9ActionPerformed(evt);
            }
        });
        panelMesa9.add(btnVerInfoMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        listaPedidosMesa9.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa9.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa9ValueChanged(evt);
            }
        });
        jScrollPane38.setViewportView(listaPedidosMesa9);

        panelMesa9.add(jScrollPane38, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jPanelMostrarMesa.add(panelMesa9, "card10");

        panelMesa10.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel132.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel132.setForeground(new java.awt.Color(51, 51, 51));
        jLabel132.setText("Mesa 10");
        panelMesa10.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel134.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel134.setForeground(new java.awt.Color(0, 0, 0));
        jLabel134.setText("Productos de la carta");
        panelMesa10.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa10.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa10.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa10ValueChanged(evt);
            }
        });
        jScrollPane41.setViewportView(productosPedidoMesa10);

        panelMesa10.add(jScrollPane41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa10.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa10.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa10ActionPerformed(evt);
            }
        });
        panelMesa10.add(btnAgregarProductoPedidoMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa10.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa10.setText("Realizar pedido");
        btnRealizarPedidoMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa10ActionPerformed(evt);
            }
        });
        panelMesa10.add(btnRealizarPedidoMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        jLabel135.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel135.setForeground(new java.awt.Color(0, 0, 0));
        jLabel135.setText("Productos del pedido");
        panelMesa10.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa10.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa10.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa10.setText("Ver pedidos");
        btnVerPedidosMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa10ActionPerformed(evt);
            }
        });
        panelMesa10.add(btnVerPedidosMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa10.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa10.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa10.setText("Borrar producto");
        btnBorrarProductoPedidoMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa10ActionPerformed(evt);
            }
        });
        panelMesa10.add(btnBorrarProductoPedidoMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa10.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa10.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa10.setText("Total cuenta");
        btnTotalCuentaMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa10ActionPerformed(evt);
            }
        });
        panelMesa10.add(btnTotalCuentaMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa10.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa10.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa10.setText("Generar recibo");
        btnGenerarReciboMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa10ActionPerformed(evt);
            }
        });
        panelMesa10.add(btnGenerarReciboMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa10.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa10.setText("Información mesa");
        btnVerInfoMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa10ActionPerformed(evt);
            }
        });
        panelMesa10.add(btnVerInfoMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        listaPedidosMesa10.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa10.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa10ValueChanged(evt);
            }
        });
        jScrollPane40.setViewportView(listaPedidosMesa10);

        panelMesa10.add(jScrollPane40, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jPanelMostrarMesa.add(panelMesa10, "card11");

        panelMesa11.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel136.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel136.setForeground(new java.awt.Color(51, 51, 51));
        jLabel136.setText("Mesa 11");
        panelMesa11.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel138.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel138.setForeground(new java.awt.Color(0, 0, 0));
        jLabel138.setText("Productos de la carta");
        panelMesa11.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa11.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa11.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa11ValueChanged(evt);
            }
        });
        jScrollPane43.setViewportView(productosPedidoMesa11);

        panelMesa11.add(jScrollPane43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa11.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa11.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa11ActionPerformed(evt);
            }
        });
        panelMesa11.add(btnAgregarProductoPedidoMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa11.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa11.setText("Realizar pedido");
        btnRealizarPedidoMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa11ActionPerformed(evt);
            }
        });
        panelMesa11.add(btnRealizarPedidoMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        listaPedidosMesa11.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa11.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa11ValueChanged(evt);
            }
        });
        jScrollPane44.setViewportView(listaPedidosMesa11);

        panelMesa11.add(jScrollPane44, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jLabel139.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel139.setForeground(new java.awt.Color(0, 0, 0));
        jLabel139.setText("Productos del pedido");
        panelMesa11.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa11.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa11.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa11.setText("Ver pedidos");
        btnVerPedidosMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa11ActionPerformed(evt);
            }
        });
        panelMesa11.add(btnVerPedidosMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa11.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa11.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa11.setText("Borrar producto");
        btnBorrarProductoPedidoMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa11ActionPerformed(evt);
            }
        });
        panelMesa11.add(btnBorrarProductoPedidoMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa11.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa11.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa11.setText("Total cuenta");
        btnTotalCuentaMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa11ActionPerformed(evt);
            }
        });
        panelMesa11.add(btnTotalCuentaMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa11.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa11.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa11.setText("Generar recibo");
        btnGenerarReciboMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa11ActionPerformed(evt);
            }
        });
        panelMesa11.add(btnGenerarReciboMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa11.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa11.setText("Información mesa");
        btnVerInfoMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa11ActionPerformed(evt);
            }
        });
        panelMesa11.add(btnVerInfoMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        jPanelMostrarMesa.add(panelMesa11, "card12");

        panelMesa12.setBackground(new java.awt.Color(153, 153, 153));
        panelMesa12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel140.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(51, 51, 51));
        jLabel140.setText("Mesa 12");
        panelMesa12.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 40));

        jLabel142.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel142.setForeground(new java.awt.Color(0, 0, 0));
        jLabel142.setText("Productos de la carta");
        panelMesa12.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 159, -1));

        productosPedidoMesa12.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productosPedidoMesa12.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productosPedidoMesa12ValueChanged(evt);
            }
        });
        jScrollPane45.setViewportView(productosPedidoMesa12);

        panelMesa12.add(jScrollPane45, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 200));

        btnAgregarProductoPedidoMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregarProductoPedidoMesa12.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoPedidoMesa12.setText("Agregar producto al pedido");
        btnAgregarProductoPedidoMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoPedidoMesa12ActionPerformed(evt);
            }
        });
        panelMesa12.add(btnAgregarProductoPedidoMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 200, 40));

        btnRealizarPedidoMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRealizarPedidoMesa12.setForeground(new java.awt.Color(0, 0, 0));
        btnRealizarPedidoMesa12.setText("Realizar pedido");
        btnRealizarPedidoMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPedidoMesa12ActionPerformed(evt);
            }
        });
        panelMesa12.add(btnRealizarPedidoMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 130, 40));

        listaPedidosMesa12.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaPedidosMesa12.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaPedidosMesa12ValueChanged(evt);
            }
        });
        jScrollPane46.setViewportView(listaPedidosMesa12);

        panelMesa12.add(jScrollPane46, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 100, 200, 200));

        jLabel143.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel143.setForeground(new java.awt.Color(0, 0, 0));
        jLabel143.setText("Productos del pedido");
        panelMesa12.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, 20));

        btnVerPedidosMesa12.setBackground(new java.awt.Color(204, 204, 0));
        btnVerPedidosMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerPedidosMesa12.setForeground(new java.awt.Color(0, 0, 0));
        btnVerPedidosMesa12.setText("Ver pedidos");
        btnVerPedidosMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidosMesa12ActionPerformed(evt);
            }
        });
        panelMesa12.add(btnVerPedidosMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 120, 40));

        btnBorrarProductoPedidoMesa12.setBackground(new java.awt.Color(204, 204, 0));
        btnBorrarProductoPedidoMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrarProductoPedidoMesa12.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrarProductoPedidoMesa12.setText("Borrar producto");
        btnBorrarProductoPedidoMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProductoPedidoMesa12ActionPerformed(evt);
            }
        });
        panelMesa12.add(btnBorrarProductoPedidoMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 120, 40));

        btnTotalCuentaMesa12.setBackground(new java.awt.Color(204, 204, 0));
        btnTotalCuentaMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotalCuentaMesa12.setForeground(new java.awt.Color(0, 0, 0));
        btnTotalCuentaMesa12.setText("Total cuenta");
        btnTotalCuentaMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalCuentaMesa12ActionPerformed(evt);
            }
        });
        panelMesa12.add(btnTotalCuentaMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 220, 120, 40));

        btnGenerarReciboMesa12.setBackground(new java.awt.Color(204, 204, 0));
        btnGenerarReciboMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReciboMesa12.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReciboMesa12.setText("Generar recibo");
        btnGenerarReciboMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReciboMesa12ActionPerformed(evt);
            }
        });
        panelMesa12.add(btnGenerarReciboMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 120, 40));

        btnVerInfoMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerInfoMesa12.setForeground(new java.awt.Color(0, 0, 0));
        btnVerInfoMesa12.setText("Información mesa");
        btnVerInfoMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerInfoMesa12ActionPerformed(evt);
            }
        });
        panelMesa12.add(btnVerInfoMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 140, 30));

        jPanelMostrarMesa.add(panelMesa12, "card13");

        panelGestionarMesas.add(jPanelMostrarMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(338, 69, 597, 360));

        jPanelMostrar.add(panelGestionarMesas, "card5");

        panelAgreProducto.setBackground(new java.awt.Color(204, 204, 204));
        panelAgreProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 0, 0));
        jLabel98.setText("AGREGAR  PRODUCTO A LA CARTA");
        panelAgreProducto.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        jLabel99.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 0, 0));
        jLabel99.setText("Complete la información del nuevo producto");
        panelAgreProducto.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, 20));

        jLabel100.setForeground(new java.awt.Color(0, 0, 0));
        jLabel100.setText("Nombre del plato ");
        panelAgreProducto.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, 30));
        panelAgreProducto.add(txtPrecioNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 110, 30));
        panelAgreProducto.add(txtCantidadNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 110, 30));

        btnAgregarProductoCarta.setBackground(new java.awt.Color(0, 153, 0));
        btnAgregarProductoCarta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarProductoCarta.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarProductoCarta.setText("Agregar producto");
        btnAgregarProductoCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoCartaActionPerformed(evt);
            }
        });
        panelAgreProducto.add(btnAgregarProductoCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 160, 80));

        jLabel102.setForeground(new java.awt.Color(0, 0, 0));
        jLabel102.setText("Precio");
        panelAgreProducto.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, -1, 30));
        panelAgreProducto.add(txtCategoriaNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 200, 30));
        panelAgreProducto.add(txtNombreNuevoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 200, 30));

        jLabel103.setForeground(new java.awt.Color(0, 0, 0));
        jLabel103.setText("Cantidad");
        panelAgreProducto.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 80, 30));

        jLabel104.setForeground(new java.awt.Color(0, 0, 0));
        jLabel104.setText("Categoría");
        panelAgreProducto.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, -1, 30));

        jPanelMostrar.add(panelAgreProducto, "card11");

        panelModProducto.setBackground(new java.awt.Color(204, 204, 204));
        panelModProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 0, 0));
        jLabel60.setText("MODIFICAR PRODUCTO");
        panelModProducto.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 300, 70));

        jLabel61.setForeground(new java.awt.Color(0, 0, 0));
        jLabel61.setText("Ingresar nombre del producto");
        panelModProducto.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 184, 35));
        panelModProducto.add(txtNombreProductoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 290, -1));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 0, 0));
        jLabel62.setText("Datos del producto");
        panelModProducto.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 130, 30));

        jLabel63.setForeground(new java.awt.Color(0, 0, 0));
        jLabel63.setText("Cantidad del producto");
        panelModProducto.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 146, 33));

        jLabel64.setForeground(new java.awt.Color(0, 0, 0));
        jLabel64.setText("Nombre del producto");
        panelModProducto.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 146, 33));

        jLabel65.setForeground(new java.awt.Color(0, 0, 0));
        jLabel65.setText("Categoría del producto");
        panelModProducto.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 146, 33));

        jLabel66.setForeground(new java.awt.Color(0, 0, 0));
        jLabel66.setText("Precio del producto");
        panelModProducto.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 146, 33));

        txtCantidadProductoActual.setEditable(false);
        panelModProducto.add(txtCantidadProductoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 160, 30));

        txtNombreProductoActual.setEditable(false);
        panelModProducto.add(txtNombreProductoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 160, 30));

        txtCategoriaProductoActual.setEditable(false);
        panelModProducto.add(txtCategoriaProductoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 160, 30));

        txtPrecioProductoActual.setEditable(false);
        panelModProducto.add(txtPrecioProductoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 160, 30));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 0, 0));
        jLabel67.setText("Datos del nuevo producto");
        panelModProducto.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 180, 190, 30));

        jLabel68.setForeground(new java.awt.Color(0, 0, 0));
        jLabel68.setText("Nombre del nuevo producto");
        panelModProducto.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 170, 33));
        panelModProducto.add(txtNombreProductoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 160, 30));

        jLabel69.setForeground(new java.awt.Color(0, 0, 0));
        jLabel69.setText("Categoría del nuevo producto");
        panelModProducto.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, 170, 33));
        panelModProducto.add(txtCategoriaProductoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 160, 30));

        jLabel70.setForeground(new java.awt.Color(0, 0, 0));
        jLabel70.setText("Precio del nuevo producto");
        panelModProducto.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 170, 33));
        panelModProducto.add(txtPrecioProductoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 330, 160, 30));

        jLabel71.setForeground(new java.awt.Color(0, 0, 0));
        jLabel71.setText("Cantidad del nuevo producto");
        panelModProducto.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 170, 33));
        panelModProducto.add(txtCantidadProductoNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, 160, 30));

        buscarProductoModificar.setBackground(new java.awt.Color(204, 204, 0));
        buscarProductoModificar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buscarProductoModificar.setForeground(new java.awt.Color(0, 0, 0));
        buscarProductoModificar.setText("Buscar producto");
        buscarProductoModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buscarProductoModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarProductoModificarActionPerformed(evt);
            }
        });
        panelModProducto.add(buscarProductoModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 170, 50));

        btnModificarProducto.setBackground(new java.awt.Color(204, 204, 0));
        btnModificarProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnModificarProducto.setForeground(new java.awt.Color(0, 0, 0));
        btnModificarProducto.setText("Modificar producto");
        btnModificarProducto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProductoActionPerformed(evt);
            }
        });
        panelModProducto.add(btnModificarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 260, 170, 120));

        jPanelMostrar.add(panelModProducto, "card6");

        panelBuscProducto.setBackground(new java.awt.Color(204, 204, 204));
        panelBuscProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jLabel72.setText("BUSCAR PRODUCTO");
        panelBuscProducto.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 250, 40));
        panelBuscProducto.add(txtNombreProductoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 290, -1));

        jLabel73.setForeground(new java.awt.Color(0, 0, 0));
        jLabel73.setText("Ingresar nombre del producto");
        panelBuscProducto.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 184, 35));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 0, 0));
        jLabel74.setText("Datos del producto");
        panelBuscProducto.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 140, 30));

        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setText("Nombre del producto");
        panelBuscProducto.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 146, 33));

        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        jLabel76.setText("Categoría del producto");
        panelBuscProducto.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 146, 33));

        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        jLabel77.setText("Precio del producto");
        panelBuscProducto.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 146, 33));

        jLabel78.setForeground(new java.awt.Color(0, 0, 0));
        jLabel78.setText("Cantidad del producto");
        panelBuscProducto.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 146, 33));

        txtNombreProductoBuscado.setEditable(false);
        panelBuscProducto.add(txtNombreProductoBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 160, 30));

        txtCategoriaProductoBuscado.setEditable(false);
        panelBuscProducto.add(txtCategoriaProductoBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 160, 30));

        txtPrecioProductoBuscado.setEditable(false);
        panelBuscProducto.add(txtPrecioProductoBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 160, 30));

        txtCantidadProductoBuscado.setEditable(false);
        panelBuscProducto.add(txtCantidadProductoBuscado, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 160, 30));

        btnBuscandoProducto.setBackground(new java.awt.Color(153, 153, 0));
        btnBuscandoProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscandoProducto.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscandoProducto.setText("Buscar producto");
        btnBuscandoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscandoProductoActionPerformed(evt);
            }
        });
        panelBuscProducto.add(btnBuscandoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 80, 160, 70));

        jPanelMostrar.add(panelBuscProducto, "card7");

        panelElimProducto.setBackground(new java.awt.Color(204, 204, 204));
        panelElimProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarProducto.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        panelElimProducto.add(btnEliminarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 260, 160, 70));
        panelElimProducto.add(txtNombreProductoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 120, 290, -1));

        jLabel79.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setText("Datos del producto a eliminar");
        panelElimProducto.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 210, 30));

        txtNombreProductoAEliminar.setEditable(false);
        panelElimProducto.add(txtNombreProductoAEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 160, 30));

        txtCategoriaProductoAEliminar.setEditable(false);
        panelElimProducto.add(txtCategoriaProductoAEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 160, 30));

        txtPrecioProductoAEliminar.setEditable(false);
        panelElimProducto.add(txtPrecioProductoAEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 160, 30));

        txtCantidadProductoAEliminar.setEditable(false);
        panelElimProducto.add(txtCantidadProductoAEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 160, 30));

        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setText("Cantidad del producto");
        panelElimProducto.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 146, 33));

        jLabel81.setForeground(new java.awt.Color(0, 0, 0));
        jLabel81.setText("Precio del producto");
        panelElimProducto.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 146, 33));

        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        jLabel82.setText("Categoría del producto");
        panelElimProducto.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 146, 33));

        jLabel83.setForeground(new java.awt.Color(0, 0, 0));
        jLabel83.setText("Nombre del producto");
        panelElimProducto.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 146, 33));

        jLabel84.setForeground(new java.awt.Color(0, 0, 0));
        jLabel84.setText("Ingresar nombre del producto");
        panelElimProducto.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 184, 20));

        jLabel85.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        jLabel85.setText("ELIMINAR PRODUCTO");
        panelElimProducto.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 300, 40));

        btnBuscarProductoEliminar.setBackground(new java.awt.Color(153, 153, 153));
        btnBuscarProductoEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBuscarProductoEliminar.setForeground(new java.awt.Color(0, 0, 0));
        btnBuscarProductoEliminar.setText("Buscar producto a eliminar");
        btnBuscarProductoEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoEliminarActionPerformed(evt);
            }
        });
        panelElimProducto.add(btnBuscarProductoEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 220, 50));

        jPanelMostrar.add(panelElimProducto, "card8");

        panelProducDisponibles.setBackground(new java.awt.Color(204, 204, 204));
        panelProducDisponibles.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 0));
        jLabel86.setText("PRODUCTOS DISPONIBLES");
        panelProducDisponibles.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 340, 60));

        listaProductosDisponibles.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaProductosDisponibles.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaProductosDisponiblesValueChanged(evt);
            }
        });
        jScrollPane25.setViewportView(listaProductosDisponibles);

        panelProducDisponibles.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 330, 310));

        jLabel87.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 0, 0));
        jLabel87.setText("Datos del producto ");
        panelProducDisponibles.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 140, 30));

        jLabel88.setForeground(new java.awt.Color(0, 0, 0));
        jLabel88.setText("Nombre del producto");
        panelProducDisponibles.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 146, 33));

        txtNombreProductoDisponible.setEditable(false);
        panelProducDisponibles.add(txtNombreProductoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 160, 30));

        jLabel89.setForeground(new java.awt.Color(0, 0, 0));
        jLabel89.setText("Categoría del producto");
        panelProducDisponibles.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 146, 33));

        txtCategoriaProductoDisponible.setEditable(false);
        panelProducDisponibles.add(txtCategoriaProductoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 160, 30));

        jLabel90.setForeground(new java.awt.Color(0, 0, 0));
        jLabel90.setText("Precio del producto");
        panelProducDisponibles.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 146, 33));

        txtPrecioProductoDisponible.setEditable(false);
        panelProducDisponibles.add(txtPrecioProductoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 160, 30));

        jLabel91.setForeground(new java.awt.Color(0, 0, 0));
        jLabel91.setText("Cantidad del producto");
        panelProducDisponibles.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 146, 33));

        txtCantidadProductoDisponible.setEditable(false);
        panelProducDisponibles.add(txtCantidadProductoDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 160, 30));

        jPanelMostrar.add(panelProducDisponibles, "card9");

        panelProducAgotados.setBackground(new java.awt.Color(204, 204, 204));
        panelProducAgotados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 0, 0));
        jLabel101.setText("PRODUCTOS AGOTADOS");
        panelProducAgotados.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 340, 60));

        jLabel105.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 0, 0));
        jLabel105.setText("Datos del producto ");
        panelProducAgotados.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 140, 30));

        jLabel106.setForeground(new java.awt.Color(0, 0, 0));
        jLabel106.setText("Nombre del producto");
        panelProducAgotados.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 146, 33));

        jLabel107.setForeground(new java.awt.Color(0, 0, 0));
        jLabel107.setText("Categoría del producto");
        panelProducAgotados.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 146, 33));

        jLabel108.setForeground(new java.awt.Color(0, 0, 0));
        jLabel108.setText("Precio del producto");
        panelProducAgotados.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 146, 33));

        jLabel109.setForeground(new java.awt.Color(0, 0, 0));
        jLabel109.setText("Cantidad del producto");
        panelProducAgotados.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 146, 33));

        txtCantidadProductoAgotado.setEditable(false);
        txtCantidadProductoAgotado.setText("Cantidad del producto");
        txtCantidadProductoAgotado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadProductoAgotadoActionPerformed(evt);
            }
        });
        panelProducAgotados.add(txtCantidadProductoAgotado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 160, 30));

        txtPrecioProductoAgotado.setEditable(false);
        txtPrecioProductoAgotado.setText("Precio del producto");
        panelProducAgotados.add(txtPrecioProductoAgotado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 160, 30));

        txtCategoriaProductoAgotado.setEditable(false);
        txtCategoriaProductoAgotado.setText("Categoría del producto");
        panelProducAgotados.add(txtCategoriaProductoAgotado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 160, 30));

        txtNombreProductoAgotado.setEditable(false);
        txtNombreProductoAgotado.setText("Nombre del producto");
        panelProducAgotados.add(txtNombreProductoAgotado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 160, 30));

        listaProductosAgotados.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaProductosAgotados.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaProductosAgotadosValueChanged(evt);
            }
        });
        jScrollPane27.setViewportView(listaProductosAgotados);

        panelProducAgotados.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 330, 310));

        jPanelMostrar.add(panelProducAgotados, "card10");

        panelGenerarReporte.setBackground(new java.awt.Color(204, 204, 204));
        panelGenerarReporte.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel144.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel144.setForeground(new java.awt.Color(0, 0, 0));
        jLabel144.setText("Datos del reporte");
        panelGenerarReporte.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 140, 30));

        jLabel145.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel145.setForeground(new java.awt.Color(0, 0, 0));
        jLabel145.setText("GENERAR REPORTE");
        panelGenerarReporte.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 340, 60));

        jLabel146.setForeground(new java.awt.Color(0, 0, 0));
        jLabel146.setText("Fecha del reporte");
        panelGenerarReporte.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 146, 33));

        jLabel147.setForeground(new java.awt.Color(0, 0, 0));
        jLabel147.setText("Nombre del reporte");
        panelGenerarReporte.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 146, 33));

        txtFechaGenerarReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaGenerarReporteMouseClicked(evt);
            }
        });
        panelGenerarReporte.add(txtFechaGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 160, 30));
        panelGenerarReporte.add(txtNombreGenerarReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 160, 30));

        btnGenerarReporteDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGenerarReporteDia.setForeground(new java.awt.Color(0, 0, 0));
        btnGenerarReporteDia.setText("Generar reporte");
        btnGenerarReporteDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteDiaActionPerformed(evt);
            }
        });
        panelGenerarReporte.add(btnGenerarReporteDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 200, 160, 130));

        jPanelMostrar.add(panelGenerarReporte, "card12");

        verPedidoMesa1.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa1.setPreferredSize(new java.awt.Dimension(950, 450));
        verPedidoMesa1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        volverAtrasMesa1.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa1.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa1.setText("Volver atrás");
        volverAtrasMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa1ActionPerformed(evt);
            }
        });
        verPedidoMesa1.add(volverAtrasMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Detalle pedido");
        verPedidoMesa1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Pedidos mesa 1");
        verPedidoMesa1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Pedidos mesa");
        verPedidoMesa1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        jLabel30.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("Pedidos llevar");
        verPedidoMesa1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        listaVerPedidosLlevarMesa1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa1MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa1ValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(listaVerPedidosLlevarMesa1);

        verPedidoMesa1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        listaVerPedidosMesa1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa1MouseClicked(evt);
            }
        });
        listaVerPedidosMesa1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa1ValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(listaVerPedidosMesa1);

        verPedidoMesa1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa1.setEnabled(false);
        jScrollPane7.setViewportView(detallePedidoMesa1);

        verPedidoMesa1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        cancelarPedidoMesa1.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa1.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa1.setText("Cancelar pedido");
        cancelarPedidoMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa1ActionPerformed(evt);
            }
        });
        verPedidoMesa1.add(cancelarPedidoMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa1.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa1.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa1.setText("Limpiar");
        btnLimpiarMesa1.setEnabled(false);
        btnLimpiarMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa1ActionPerformed(evt);
            }
        });
        verPedidoMesa1.add(btnLimpiarMesa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa1, "card13");

        verPedidoMesa2.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Pedidos mesa 2");
        verPedidoMesa2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        volverAtrasMesa2.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa2.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa2.setText("Volver atrás");
        volverAtrasMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa2ActionPerformed(evt);
            }
        });
        verPedidoMesa2.add(volverAtrasMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel32.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("Pedidos llevar");
        verPedidoMesa2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel33.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("Detalle pedido");
        verPedidoMesa2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Pedidos mesa");
        verPedidoMesa2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa2MouseClicked(evt);
            }
        });
        listaVerPedidosMesa2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa2ValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(listaVerPedidosMesa2);

        verPedidoMesa2.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa2.setEnabled(false);
        jScrollPane9.setViewportView(detallePedidoMesa2);

        verPedidoMesa2.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa2MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa2ValueChanged(evt);
            }
        });
        jScrollPane10.setViewportView(listaVerPedidosLlevarMesa2);

        verPedidoMesa2.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        btnLimpiarMesa2.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa2.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa2.setText("Limpiar");
        btnLimpiarMesa2.setEnabled(false);
        btnLimpiarMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa2ActionPerformed(evt);
            }
        });
        verPedidoMesa2.add(btnLimpiarMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        cancelarPedidoMesa2.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa2.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa2.setText("Cancelar pedido");
        cancelarPedidoMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa2ActionPerformed(evt);
            }
        });
        verPedidoMesa2.add(cancelarPedidoMesa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 80, 120, 46));

        jPanelMostrar.add(verPedidoMesa2, "card14");

        verPedidoMesa3.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("Pedidos mesa 3");
        verPedidoMesa3.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        volverAtrasMesa3.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa3.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa3.setText("Volver atrás");
        volverAtrasMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa3ActionPerformed(evt);
            }
        });
        verPedidoMesa3.add(volverAtrasMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel36.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 0, 0));
        jLabel36.setText("Pedidos llevar");
        verPedidoMesa3.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel37.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 0, 0));
        jLabel37.setText("Detalle pedido");
        verPedidoMesa3.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel38.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 0, 0));
        jLabel38.setText("Pedidos mesa");
        verPedidoMesa3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa3MouseClicked(evt);
            }
        });
        listaVerPedidosMesa3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa3ValueChanged(evt);
            }
        });
        jScrollPane11.setViewportView(listaVerPedidosMesa3);

        verPedidoMesa3.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa3.setEnabled(false);
        jScrollPane12.setViewportView(detallePedidoMesa3);

        verPedidoMesa3.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa3.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa3MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa3.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa3ValueChanged(evt);
            }
        });
        jScrollPane13.setViewportView(listaVerPedidosLlevarMesa3);

        verPedidoMesa3.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        btnLimpiarMesa3.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa3.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa3.setText("Limpiar");
        btnLimpiarMesa3.setEnabled(false);
        btnLimpiarMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa3ActionPerformed(evt);
            }
        });
        verPedidoMesa3.add(btnLimpiarMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        cancelarPedidoMesa3.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa3.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa3.setText("Cancelar pedido");
        cancelarPedidoMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa3ActionPerformed(evt);
            }
        });
        verPedidoMesa3.add(cancelarPedidoMesa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 80, 120, 46));

        jPanelMostrar.add(verPedidoMesa3, "card15");

        verPedidoMesa4.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Pedidos mesa 4");
        verPedidoMesa4.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        volverAtrasMesa4.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa4.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa4.setText("Volver atrás");
        volverAtrasMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa4ActionPerformed(evt);
            }
        });
        verPedidoMesa4.add(volverAtrasMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Pedidos llevar");
        verPedidoMesa4.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel41.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Detalle pedido");
        verPedidoMesa4.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel42.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 0, 0));
        jLabel42.setText("Pedidos mesa");
        verPedidoMesa4.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa4MouseClicked(evt);
            }
        });
        listaVerPedidosMesa4.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa4ValueChanged(evt);
            }
        });
        jScrollPane14.setViewportView(listaVerPedidosMesa4);

        verPedidoMesa4.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa4.setEnabled(false);
        jScrollPane15.setViewportView(detallePedidoMesa4);

        verPedidoMesa4.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa4.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa4MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa4.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa4ValueChanged(evt);
            }
        });
        jScrollPane16.setViewportView(listaVerPedidosLlevarMesa4);

        verPedidoMesa4.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa4.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa4.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa4.setText("Cancelar pedido");
        cancelarPedidoMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa4ActionPerformed(evt);
            }
        });
        verPedidoMesa4.add(cancelarPedidoMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa4.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa4.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa4.setText("Limpiar");
        btnLimpiarMesa4.setEnabled(false);
        btnLimpiarMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa4ActionPerformed(evt);
            }
        });
        verPedidoMesa4.add(btnLimpiarMesa4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa4, "card16");

        verPedidoMesa5.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Pedidos mesa 5");
        verPedidoMesa5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        volverAtrasMesa5.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa5.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa5.setText("Volver atrás");
        volverAtrasMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa5ActionPerformed(evt);
            }
        });
        verPedidoMesa5.add(volverAtrasMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel44.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 0, 0));
        jLabel44.setText("Pedidos llevar");
        verPedidoMesa5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel45.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Detalle pedido");
        verPedidoMesa5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Pedidos mesa");
        verPedidoMesa5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa5.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa5MouseClicked(evt);
            }
        });
        listaVerPedidosMesa5.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa5ValueChanged(evt);
            }
        });
        jScrollPane17.setViewportView(listaVerPedidosMesa5);

        verPedidoMesa5.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa5.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa5.setEnabled(false);
        jScrollPane18.setViewportView(detallePedidoMesa5);

        verPedidoMesa5.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa5.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa5MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa5.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa5ValueChanged(evt);
            }
        });
        jScrollPane19.setViewportView(listaVerPedidosLlevarMesa5);

        verPedidoMesa5.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa5.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa5.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa5.setText("Cancelar pedido");
        cancelarPedidoMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa5ActionPerformed(evt);
            }
        });
        verPedidoMesa5.add(cancelarPedidoMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa5.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa5.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa5.setText("Limpiar");
        btnLimpiarMesa5.setEnabled(false);
        btnLimpiarMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa5ActionPerformed(evt);
            }
        });
        verPedidoMesa5.add(btnLimpiarMesa5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa5, "card17");

        verPedidoMesa6.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 0, 0));
        jLabel47.setText("Pedidos mesa 6");
        verPedidoMesa6.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        volverAtrasMesa6.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa6.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa6.setText("Volver atrás");
        volverAtrasMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa6ActionPerformed(evt);
            }
        });
        verPedidoMesa6.add(volverAtrasMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel48.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 0, 0));
        jLabel48.setText("Pedidos llevar");
        verPedidoMesa6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel49.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(0, 0, 0));
        jLabel49.setText("Detalle pedido");
        verPedidoMesa6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel50.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(0, 0, 0));
        jLabel50.setText("Pedidos mesa");
        verPedidoMesa6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa6MouseClicked(evt);
            }
        });
        listaVerPedidosMesa6.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa6ValueChanged(evt);
            }
        });
        jScrollPane20.setViewportView(listaVerPedidosMesa6);

        verPedidoMesa6.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa6.setEnabled(false);
        jScrollPane21.setViewportView(detallePedidoMesa6);

        verPedidoMesa6.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa6.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa6MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa6.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa6ValueChanged(evt);
            }
        });
        jScrollPane22.setViewportView(listaVerPedidosLlevarMesa6);

        verPedidoMesa6.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa6.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa6.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa6.setText("Cancelar pedido");
        cancelarPedidoMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa6ActionPerformed(evt);
            }
        });
        verPedidoMesa6.add(cancelarPedidoMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa6.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa6.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa6.setText("Limpiar");
        btnLimpiarMesa6.setEnabled(false);
        btnLimpiarMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa6ActionPerformed(evt);
            }
        });
        verPedidoMesa6.add(btnLimpiarMesa6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa6, "card18");

        verPedidoMesa7.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 0, 0));
        jLabel51.setText("Pedidos mesa 7");
        verPedidoMesa7.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        volverAtrasMesa7.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa7.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa7.setText("Volver atrás");
        volverAtrasMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa7ActionPerformed(evt);
            }
        });
        verPedidoMesa7.add(volverAtrasMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel52.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 0, 0));
        jLabel52.setText("Pedidos llevar");
        verPedidoMesa7.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel53.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(0, 0, 0));
        jLabel53.setText("Detalle pedido");
        verPedidoMesa7.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel54.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 0, 0));
        jLabel54.setText("Pedidos mesa");
        verPedidoMesa7.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa7.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa7MouseClicked(evt);
            }
        });
        listaVerPedidosMesa7.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa7ValueChanged(evt);
            }
        });
        jScrollPane23.setViewportView(listaVerPedidosMesa7);

        verPedidoMesa7.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa7.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa7.setEnabled(false);
        jScrollPane24.setViewportView(detallePedidoMesa7);

        verPedidoMesa7.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa7.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa7MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa7.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa7ValueChanged(evt);
            }
        });
        jScrollPane42.setViewportView(listaVerPedidosLlevarMesa7);

        verPedidoMesa7.add(jScrollPane42, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa7.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa7.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa7.setText("Cancelar pedido");
        cancelarPedidoMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa7ActionPerformed(evt);
            }
        });
        verPedidoMesa7.add(cancelarPedidoMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa7.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa7.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa7.setText("Limpiar");
        btnLimpiarMesa7.setEnabled(false);
        btnLimpiarMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa7ActionPerformed(evt);
            }
        });
        verPedidoMesa7.add(btnLimpiarMesa7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa7, "card19");

        verPedidoMesa8.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(0, 0, 0));
        jLabel55.setText("Pedidos mesa 8");
        verPedidoMesa8.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        volverAtrasMesa8.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa8.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa8.setText("Volver atrás");
        volverAtrasMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa8ActionPerformed(evt);
            }
        });
        verPedidoMesa8.add(volverAtrasMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel56.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(0, 0, 0));
        jLabel56.setText("Pedidos llevar");
        verPedidoMesa8.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel57.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(0, 0, 0));
        jLabel57.setText("Detalle pedido");
        verPedidoMesa8.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel58.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 0, 0));
        jLabel58.setText("Pedidos mesa");
        verPedidoMesa8.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa8.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa8MouseClicked(evt);
            }
        });
        listaVerPedidosMesa8.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa8ValueChanged(evt);
            }
        });
        jScrollPane48.setViewportView(listaVerPedidosMesa8);

        verPedidoMesa8.add(jScrollPane48, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa8.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa8.setEnabled(false);
        jScrollPane49.setViewportView(detallePedidoMesa8);

        verPedidoMesa8.add(jScrollPane49, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa8.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa8MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa8.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa8ValueChanged(evt);
            }
        });
        jScrollPane50.setViewportView(listaVerPedidosLlevarMesa8);

        verPedidoMesa8.add(jScrollPane50, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa8.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa8.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa8.setText("Cancelar pedido");
        cancelarPedidoMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa8ActionPerformed(evt);
            }
        });
        verPedidoMesa8.add(cancelarPedidoMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa8.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa8.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa8.setText("Limpiar");
        btnLimpiarMesa8.setEnabled(false);
        btnLimpiarMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa8ActionPerformed(evt);
            }
        });
        verPedidoMesa8.add(btnLimpiarMesa8, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa8, "card20");

        verPedidoMesa9.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 0, 0));
        jLabel59.setText("Pedidos mesa 9");
        verPedidoMesa9.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 200, 25));

        volverAtrasMesa9.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa9.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa9.setText("Volver atrás");
        volverAtrasMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa9ActionPerformed(evt);
            }
        });
        verPedidoMesa9.add(volverAtrasMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel93.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 0, 0));
        jLabel93.setText("Pedidos llevar");
        verPedidoMesa9.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel97.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 0, 0));
        jLabel97.setText("Detalle pedido");
        verPedidoMesa9.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel113.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 0, 0));
        jLabel113.setText("Pedidos mesa");
        verPedidoMesa9.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa9.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa9MouseClicked(evt);
            }
        });
        listaVerPedidosMesa9.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa9ValueChanged(evt);
            }
        });
        jScrollPane51.setViewportView(listaVerPedidosMesa9);

        verPedidoMesa9.add(jScrollPane51, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa9.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa9.setEnabled(false);
        jScrollPane52.setViewportView(detallePedidoMesa9);

        verPedidoMesa9.add(jScrollPane52, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa9.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa9MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa9.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa9ValueChanged(evt);
            }
        });
        jScrollPane53.setViewportView(listaVerPedidosLlevarMesa9);

        verPedidoMesa9.add(jScrollPane53, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa9.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa9.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa9.setText("Cancelar pedido");
        cancelarPedidoMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa9ActionPerformed(evt);
            }
        });
        verPedidoMesa9.add(cancelarPedidoMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa9.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa9.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa9.setText("Limpiar");
        btnLimpiarMesa9.setEnabled(false);
        btnLimpiarMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa9ActionPerformed(evt);
            }
        });
        verPedidoMesa9.add(btnLimpiarMesa9, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa9, "card21");

        verPedidoMesa10.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa10.setForeground(new java.awt.Color(0, 0, 0));
        verPedidoMesa10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel117.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel117.setForeground(new java.awt.Color(0, 0, 0));
        jLabel117.setText("Pedidos mesa 10");
        verPedidoMesa10.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 210, 25));

        volverAtrasMesa10.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa10.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa10.setText("Volver atrás");
        volverAtrasMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa10ActionPerformed(evt);
            }
        });
        verPedidoMesa10.add(volverAtrasMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel121.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(0, 0, 0));
        jLabel121.setText("Pedidos llevar");
        verPedidoMesa10.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel125.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(0, 0, 0));
        jLabel125.setText("Detalle pedido");
        verPedidoMesa10.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel129.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel129.setForeground(new java.awt.Color(0, 0, 0));
        jLabel129.setText("Pedidos mesa");
        verPedidoMesa10.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa10.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa10MouseClicked(evt);
            }
        });
        listaVerPedidosMesa10.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa10ValueChanged(evt);
            }
        });
        jScrollPane54.setViewportView(listaVerPedidosMesa10);

        verPedidoMesa10.add(jScrollPane54, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa10.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa10.setEnabled(false);
        jScrollPane55.setViewportView(detallePedidoMesa10);

        verPedidoMesa10.add(jScrollPane55, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa10.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa10MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa10.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa10ValueChanged(evt);
            }
        });
        jScrollPane56.setViewportView(listaVerPedidosLlevarMesa10);

        verPedidoMesa10.add(jScrollPane56, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa10.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa10.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa10.setText("Cancelar pedido");
        cancelarPedidoMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa10ActionPerformed(evt);
            }
        });
        verPedidoMesa10.add(cancelarPedidoMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa10.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa10.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa10.setText("Limpiar");
        btnLimpiarMesa10.setEnabled(false);
        btnLimpiarMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa10ActionPerformed(evt);
            }
        });
        verPedidoMesa10.add(btnLimpiarMesa10, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa10, "card22");

        verPedidoMesa11.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel133.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel133.setForeground(new java.awt.Color(0, 0, 0));
        jLabel133.setText("Pedidos mesa 11");
        verPedidoMesa11.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 220, 25));

        volverAtrasMesa11.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa11.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa11.setText("Volver atrás");
        volverAtrasMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa11ActionPerformed(evt);
            }
        });
        verPedidoMesa11.add(volverAtrasMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel137.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel137.setForeground(new java.awt.Color(0, 0, 0));
        jLabel137.setText("Pedidos llevar");
        verPedidoMesa11.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel141.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel141.setForeground(new java.awt.Color(0, 0, 0));
        jLabel141.setText("Detalle pedido");
        verPedidoMesa11.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel148.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel148.setForeground(new java.awt.Color(0, 0, 0));
        jLabel148.setText("Pedidos mesa");
        verPedidoMesa11.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa11.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa11MouseClicked(evt);
            }
        });
        listaVerPedidosMesa11.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa11ValueChanged(evt);
            }
        });
        jScrollPane57.setViewportView(listaVerPedidosMesa11);

        verPedidoMesa11.add(jScrollPane57, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa11.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa11.setEnabled(false);
        jScrollPane58.setViewportView(detallePedidoMesa11);

        verPedidoMesa11.add(jScrollPane58, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa11.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa11MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa11.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa11ValueChanged(evt);
            }
        });
        jScrollPane59.setViewportView(listaVerPedidosLlevarMesa11);

        verPedidoMesa11.add(jScrollPane59, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa11.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa11.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa11.setText("Cancelar pedido");
        cancelarPedidoMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa11ActionPerformed(evt);
            }
        });
        verPedidoMesa11.add(cancelarPedidoMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa11.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa11.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa11.setText("Limpiar");
        btnLimpiarMesa11.setEnabled(false);
        btnLimpiarMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa11ActionPerformed(evt);
            }
        });
        verPedidoMesa11.add(btnLimpiarMesa11, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa11, "card23");

        verPedidoMesa12.setBackground(new java.awt.Color(204, 204, 204));
        verPedidoMesa12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel149.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel149.setForeground(new java.awt.Color(0, 0, 0));
        jLabel149.setText("Pedidos mesa 12");
        verPedidoMesa12.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 210, 25));

        volverAtrasMesa12.setBackground(new java.awt.Color(204, 204, 0));
        volverAtrasMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        volverAtrasMesa12.setForeground(new java.awt.Color(0, 0, 0));
        volverAtrasMesa12.setText("Volver atrás");
        volverAtrasMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverAtrasMesa12ActionPerformed(evt);
            }
        });
        verPedidoMesa12.add(volverAtrasMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(811, 20, 120, 46));

        jLabel150.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel150.setForeground(new java.awt.Color(0, 0, 0));
        jLabel150.setText("Pedidos llevar");
        verPedidoMesa12.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 150, 25));

        jLabel151.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel151.setForeground(new java.awt.Color(0, 0, 0));
        jLabel151.setText("Detalle pedido");
        verPedidoMesa12.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 150, 25));

        jLabel152.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel152.setForeground(new java.awt.Color(0, 0, 0));
        jLabel152.setText("Pedidos mesa");
        verPedidoMesa12.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 140, 25));

        listaVerPedidosMesa12.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosMesa12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosMesa12MouseClicked(evt);
            }
        });
        listaVerPedidosMesa12.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosMesa12ValueChanged(evt);
            }
        });
        jScrollPane60.setViewportView(listaVerPedidosMesa12);

        verPedidoMesa12.add(jScrollPane60, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 220, 240));

        detallePedidoMesa12.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        detallePedidoMesa12.setEnabled(false);
        jScrollPane61.setViewportView(detallePedidoMesa12);

        verPedidoMesa12.add(jScrollPane61, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 220, 240));

        listaVerPedidosLlevarMesa12.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaVerPedidosLlevarMesa12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaVerPedidosLlevarMesa12MouseClicked(evt);
            }
        });
        listaVerPedidosLlevarMesa12.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaVerPedidosLlevarMesa12ValueChanged(evt);
            }
        });
        jScrollPane62.setViewportView(listaVerPedidosLlevarMesa12);

        verPedidoMesa12.add(jScrollPane62, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 220, 240));

        cancelarPedidoMesa12.setBackground(new java.awt.Color(204, 204, 0));
        cancelarPedidoMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cancelarPedidoMesa12.setForeground(new java.awt.Color(0, 0, 0));
        cancelarPedidoMesa12.setText("Cancelar pedido");
        cancelarPedidoMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarPedidoMesa12ActionPerformed(evt);
            }
        });
        verPedidoMesa12.add(cancelarPedidoMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 80, 120, 46));

        btnLimpiarMesa12.setBackground(new java.awt.Color(204, 204, 0));
        btnLimpiarMesa12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLimpiarMesa12.setForeground(new java.awt.Color(0, 0, 0));
        btnLimpiarMesa12.setText("Limpiar");
        btnLimpiarMesa12.setEnabled(false);
        btnLimpiarMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarMesa12ActionPerformed(evt);
            }
        });
        verPedidoMesa12.add(btnLimpiarMesa12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 120, 46));

        jPanelMostrar.add(verPedidoMesa12, "card24");

        menuMesero.setText("Mesero");
        menuMesero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuMesero.setPreferredSize(new java.awt.Dimension(122, 50));

        menItemCargarMesas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemCargarMesas.setText("Cargar mesas");
        menItemCargarMesas.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemCargarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemCargarMesasActionPerformed(evt);
            }
        });
        menuMesero.add(menItemCargarMesas);

        menItemCargarProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemCargarProductos.setText("Cargar productos");
        menItemCargarProductos.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemCargarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemCargarProductosActionPerformed(evt);
            }
        });
        menuMesero.add(menItemCargarProductos);

        menItemCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemCerrarSesion.setText("Cerrar sesión");
        menItemCerrarSesion.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemCerrarSesionActionPerformed(evt);
            }
        });
        menuMesero.add(menItemCerrarSesion);

        jMenuBar2.add(menuMesero);

        menuMesas.setText("Mesas");
        menuMesas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuMesas.setPreferredSize(new java.awt.Dimension(122, 50));

        menItemGestionarMesas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemGestionarMesas.setText("Gestionar mesas");
        menItemGestionarMesas.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemGestionarMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemGestionarMesasActionPerformed(evt);
            }
        });
        menuMesas.add(menItemGestionarMesas);

        jMenuBar2.add(menuMesas);

        menuProductos.setText("Productos");
        menuProductos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuProductos.setPreferredSize(new java.awt.Dimension(122, 50));

        menItemAgreProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemAgreProducto.setText("Agregar producto");
        menItemAgreProducto.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemAgreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemAgreProductoActionPerformed(evt);
            }
        });
        menuProductos.add(menItemAgreProducto);

        menItemModProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemModProducto.setText("Modificar producto");
        menItemModProducto.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemModProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemModProductoActionPerformed(evt);
            }
        });
        menuProductos.add(menItemModProducto);

        menItemBuscProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemBuscProducto.setText("BuscarProducto");
        menItemBuscProducto.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemBuscProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemBuscProductoActionPerformed(evt);
            }
        });
        menuProductos.add(menItemBuscProducto);

        menItemElimProducto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemElimProducto.setText("Eliminar producto");
        menItemElimProducto.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemElimProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemElimProductoActionPerformed(evt);
            }
        });
        menuProductos.add(menItemElimProducto);

        menItemProducDisponibles.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemProducDisponibles.setText("Productos disponibles");
        menItemProducDisponibles.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemProducDisponibles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemProducDisponiblesActionPerformed(evt);
            }
        });
        menuProductos.add(menItemProducDisponibles);

        menItemProducDAgotados.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemProducDAgotados.setText("Productos agotados");
        menItemProducDAgotados.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemProducDAgotados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemProducDAgotadosActionPerformed(evt);
            }
        });
        menuProductos.add(menItemProducDAgotados);

        jMenuBar2.add(menuProductos);

        menuGenerarReporte.setText("Reporte");
        menuGenerarReporte.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuGenerarReporte.setPreferredSize(new java.awt.Dimension(122, 50));

        menItemGenerarReporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menItemGenerarReporte.setText("Generar reporte");
        menItemGenerarReporte.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemGenerarReporteActionPerformed(evt);
            }
        });
        menuGenerarReporte.add(menItemGenerarReporte);

        jMenuBar2.add(menuGenerarReporte);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void menItemProducDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemProducDisponiblesActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelProducDisponibles");
        
        DefaultListModel<String> modeloProductosDisponibles = new DefaultListModel<>();
        for (Producto producto : productos) {
            if (producto.getCantidadDisponible() > 0) {
                modeloProductosDisponibles.addElement(producto.getNombre());
            }
        }
        listaProductosDisponibles.setModel(modeloProductosDisponibles);
    }//GEN-LAST:event_menItemProducDisponiblesActionPerformed

    private void menItemCargarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemCargarMesasActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelCargarMesas");
    }//GEN-LAST:event_menItemCargarMesasActionPerformed

    private void menItemCargarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemCargarProductosActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelCargarProductos");
    }//GEN-LAST:event_menItemCargarProductosActionPerformed

    private void menItemCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemCerrarSesionActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelCerrarSesion");
        
        int numeroConfirmacionCerrarSesion = (int)(Math.random()*90000)+10000;
        txtCodigoGenerado.setText(String.valueOf(numeroConfirmacionCerrarSesion));
        
    }//GEN-LAST:event_menItemCerrarSesionActionPerformed

    private void menItemGestionarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemGestionarMesasActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelGestionarMesas");
    }//GEN-LAST:event_menItemGestionarMesasActionPerformed

    private void menItemModProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemModProductoActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelModProducto");
    }//GEN-LAST:event_menItemModProductoActionPerformed

    private void menItemBuscProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemBuscProductoActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelBuscProducto");
    }//GEN-LAST:event_menItemBuscProductoActionPerformed

    private void menItemElimProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemElimProductoActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelElimProducto");
    }//GEN-LAST:event_menItemElimProductoActionPerformed

    private void menItemProducDAgotadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemProducDAgotadosActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelProducAgotados");

        DefaultListModel<String> modeloProductosDisponibles = new DefaultListModel<>();
        for (Producto producto : productos) {
            if (producto.getCantidadDisponible() == 0) {
                modeloProductosDisponibles.addElement(producto.getNombre());
            }
        }
        listaProductosAgotados.setModel(modeloProductosDisponibles);
    }//GEN-LAST:event_menItemProducDAgotadosActionPerformed

    private Producto buscarProductoPorNombre(String nombreProducto) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                return producto;
            }
        }
        return null;
    }
    
    private void mostrarProductosEnMesa(JList<String> listaProductosMesa) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        for (Producto producto : productos) {
            modeloLista.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible()+ " - Precio: " + producto.getPrecio());
        }
        listaProductosMesa.setModel(modeloLista);
    }
    
    private void showPanel(String panelName) {
        CardLayout layout = (CardLayout) jPanelMostrarMesa.getLayout();
        layout.show(jPanelMostrarMesa, panelName);
    }
    
    private void btnMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa1ActionPerformed
        showPanel("panelMesa1");
        mostrarProductosEnMesa(productosPedidoMesa1);
    }//GEN-LAST:event_btnMesa1ActionPerformed

    private void btnMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa5ActionPerformed
        showPanel("panelMesa5");
        mostrarProductosEnMesa(productosPedidoMesa5);
    }//GEN-LAST:event_btnMesa5ActionPerformed

    private void btnMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa2ActionPerformed
        showPanel("panelMesa2");
        mostrarProductosEnMesa(productosPedidoMesa2);
    }//GEN-LAST:event_btnMesa2ActionPerformed

    private void btnMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa3ActionPerformed
        showPanel("panelMesa3");
        mostrarProductosEnMesa(productosPedidoMesa3);
    }//GEN-LAST:event_btnMesa3ActionPerformed

    private void btnMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa4ActionPerformed
        showPanel("panelMesa4");
        mostrarProductosEnMesa(productosPedidoMesa4);
    }//GEN-LAST:event_btnMesa4ActionPerformed

    private void btnMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa6ActionPerformed
        showPanel("panelMesa6");
        mostrarProductosEnMesa(productosPedidoMesa6);
    }//GEN-LAST:event_btnMesa6ActionPerformed

    private void btnMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa7ActionPerformed
        showPanel("panelMesa7");
        mostrarProductosEnMesa(productosPedidoMesa7);
    }//GEN-LAST:event_btnMesa7ActionPerformed

    private void btnMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa8ActionPerformed
        showPanel("panelMesa8");
        mostrarProductosEnMesa(productosPedidoMesa8);
    }//GEN-LAST:event_btnMesa8ActionPerformed

    private void btnMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa9ActionPerformed
        showPanel("panelMesa9");
        mostrarProductosEnMesa(productosPedidoMesa9);
    }//GEN-LAST:event_btnMesa9ActionPerformed

    private void btnMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa10ActionPerformed
        showPanel("panelMesa10");
        mostrarProductosEnMesa(productosPedidoMesa10);
    }//GEN-LAST:event_btnMesa10ActionPerformed

    private void btnMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa11ActionPerformed
        showPanel("panelMesa11");
        mostrarProductosEnMesa(productosPedidoMesa11);
    }//GEN-LAST:event_btnMesa11ActionPerformed

    private void btnMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesa12ActionPerformed
        showPanel("panelMesa12");
        mostrarProductosEnMesa(productosPedidoMesa12);
    }//GEN-LAST:event_btnMesa12ActionPerformed

    private void menItemAgreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemAgreProductoActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelAgreProducto");
    }//GEN-LAST:event_menItemAgreProductoActionPerformed

    private void txtCantidadProductoAgotadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadProductoAgotadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadProductoAgotadoActionPerformed

    private void inicializarMesas(){
        botonMesas = new JButton[] {
            btnMesa1, btnMesa2, btnMesa3, btnMesa4, btnMesa5, btnMesa6,
            btnMesa7, btnMesa8, btnMesa9, btnMesa10, btnMesa11, btnMesa12
        };
        
        for (JButton boton : botonMesas) {
            boton.setBackground(Color.RED);
            boton.setEnabled(false);
        }
    }    
    
    private void cargarMesasDesdeArchivo(File file) {
        mesas.clear(); 

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                int numeroMesa = Integer.parseInt(partes[0].trim()) - 1; 
                String estado = partes[1].trim();
                int capacidad = Integer.parseInt(partes[2].trim());

                
                Mesa mesa = new Mesa(numeroMesa + 1, capacidad);
                mesa.setEstado(estado);
                mesas.add(mesa);

               
                if (numeroMesa >= 0 && numeroMesa < botonMesas.length) {
                    if (estado.equalsIgnoreCase("Desocupada")) {
                        botonMesas[numeroMesa].setBackground(Color.GREEN);
                        botonMesas[numeroMesa].setEnabled(true);
                    } else {
                        botonMesas[numeroMesa].setBackground(Color.RED);
                        botonMesas[numeroMesa].setEnabled(false);
                    }
                }
            }

            panelGestionarMesas.revalidate();
            panelGestionarMesas.repaint();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de mesas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnCargarMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarMesasActionPerformed
        
        if (archivoSeleccionado != null && validarArchivo(archivoSeleccionado)) {
            cargarMesasDesdeArchivo(archivoSeleccionado);
            JOptionPane.showMessageDialog(null, "Se cargaron correctamente las mesas.", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Archivo no válido o no seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCargarMesasActionPerformed

    private void btnCargarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarProductosActionPerformed
        if (archivoSeleccionadoProductos != null && validarArchivoProductos(archivoSeleccionadoProductos)) {
            cargarProductosDesdeArchivo(archivoSeleccionadoProductos);
            JOptionPane.showMessageDialog(this, "Se cargaron correctamente los productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Archivo no válido o no seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnCargarProductosActionPerformed

    private void btnBuscarRutaMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRutaMesasActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionado = fileChooser.getSelectedFile(); 
            txtRutaArchivoMesas.setText(archivoSeleccionado.getAbsolutePath());

            if (validarArchivo(archivoSeleccionado)) {
                txtEstadoArchivoMesas.setText("Archivo válido y listo para cargar.");
                txtEstadoArchivoMesas.setForeground(Color.GREEN);
                btnCargarMesas.setEnabled(true);
            } else {
                txtEstadoArchivoMesas.setText("El archivo no es válido.");
                txtEstadoArchivoMesas.setForeground(Color.RED);
                btnCargarMesas.setEnabled(false); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se seleccionó ningún archivo", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarRutaMesasActionPerformed
    
    private boolean validarArchivo(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                if (partes.length != 3) {
                    return false; 
                }
                try {
                    Integer.parseInt(partes[0].trim()); 
                    partes[1].trim(); 
                    Integer.parseInt(partes[2].trim()); 
                } catch (NumberFormatException e) {
                    return false; 
                }
            }
        } catch (IOException e) {
            return false; 
        }
        return true; 
    }
    
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        
        String numeroGenerado = txtCodigoGenerado.getText();
        String numeroIngresaUsuario = txtIngresarCodigo.getText();
        
        if (numeroIngresaUsuario.isEmpty()) {
            
            JOptionPane.showMessageDialog(rootPane, "No ha ingresado un número, ingrese el número generado", "Error", JOptionPane.WARNING_MESSAGE);
        
        }else if (numeroGenerado.equalsIgnoreCase(numeroIngresaUsuario)) {
            
            Object[] opciones = {"Si", "No"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Seguro que quieres cerrar sesión?",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );


            if (seleccion == JOptionPane.YES_OPTION) { 
                
                new Bievenida().setVisible(true);
                this.dispose();  
            } 
            
        }else{
            
            JOptionPane.showMessageDialog(rootPane, "Número ingresado incorrecto, intentar otra vez", "Error", JOptionPane.WARNING_MESSAGE);
            
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed
    
    private void mostrarInformacionMesa(int numeroMesa) {
        Mesa mesaSeleccionada = mesas.get(numeroMesa - 1); 
        String infoMesa = "Número de mesa: " + mesaSeleccionada.getNumeroMesa() + "\n" +
                          "Estado: " + mesaSeleccionada.getEstado() + "\n" +
                          "Capacidad: " + mesaSeleccionada.getCapacidad() + "\n";

        JOptionPane.showMessageDialog(this, infoMesa, "Información de la Mesa", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void btnVerInfoMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa1ActionPerformed
        mostrarInformacionMesa(1);
        
    }//GEN-LAST:event_btnVerInfoMesa1ActionPerformed

    private void btnVerInfoMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa2ActionPerformed
        mostrarInformacionMesa(2);
    }//GEN-LAST:event_btnVerInfoMesa2ActionPerformed

    private void btnVerInfoMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa3ActionPerformed
        mostrarInformacionMesa(3);
    }//GEN-LAST:event_btnVerInfoMesa3ActionPerformed

    private void btnVerInfoMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa4ActionPerformed
        mostrarInformacionMesa(4);
    }//GEN-LAST:event_btnVerInfoMesa4ActionPerformed

    private void btnVerInfoMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa5ActionPerformed
        mostrarInformacionMesa(5);
    }//GEN-LAST:event_btnVerInfoMesa5ActionPerformed

    private void btnVerInfoMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa6ActionPerformed
        mostrarInformacionMesa(6);
    }//GEN-LAST:event_btnVerInfoMesa6ActionPerformed

    private void btnVerInfoMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa7ActionPerformed
        mostrarInformacionMesa(7);
    }//GEN-LAST:event_btnVerInfoMesa7ActionPerformed

    private void btnVerInfoMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa8ActionPerformed
        mostrarInformacionMesa(8);
    }//GEN-LAST:event_btnVerInfoMesa8ActionPerformed

    private void btnVerInfoMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa9ActionPerformed
        mostrarInformacionMesa(9);
    }//GEN-LAST:event_btnVerInfoMesa9ActionPerformed

    private void btnVerInfoMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa10ActionPerformed
        mostrarInformacionMesa(10);
    }//GEN-LAST:event_btnVerInfoMesa10ActionPerformed

    private void btnVerInfoMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa11ActionPerformed
        mostrarInformacionMesa(11);
    }//GEN-LAST:event_btnVerInfoMesa11ActionPerformed

    private void btnVerInfoMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerInfoMesa12ActionPerformed
        mostrarInformacionMesa(12);
    }//GEN-LAST:event_btnVerInfoMesa12ActionPerformed

    private void btnBuscarRutaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarRutaProductosActionPerformed
        
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionadoProductos = fileChooser.getSelectedFile();
            txtRutaArchivoProductos.setText(archivoSeleccionadoProductos.getAbsolutePath());

            if (validarArchivoProductos(archivoSeleccionadoProductos)) {
                txtEstadoArchivoProductos.setText("Archivo correcto");
                txtEstadoArchivoProductos.setForeground(Color.GREEN);
                btnCargarProductos.setEnabled(true); 
            } else {
                txtEstadoArchivoProductos.setText("Archivo incorrecto o vacío");
                txtEstadoArchivoProductos.setForeground(Color.RED);
                btnCargarProductos.setEnabled(false); 
            }
        }
        
    }//GEN-LAST:event_btnBuscarRutaProductosActionPerformed

    DefaultListModel<String> modeloProductosMesa1 = new DefaultListModel<>();
    private void cargarProductosEnLista1() {
        modeloProductosMesa1.clear();
        for (Producto producto : productos) {
            modeloProductosMesa1.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa1.setModel(modeloProductosMesa1);
    }
    
    DefaultListModel<String> modeloProductosMesa2 = new DefaultListModel<>();
    private void cargarProductosEnLista2() {
        modeloProductosMesa2.clear();
        for (Producto producto : productos) {
            modeloProductosMesa2.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa2.setModel(modeloProductosMesa2);
    }
    
    DefaultListModel<String> modeloProductosMesa3 = new DefaultListModel<>();
    private void cargarProductosEnLista3() {
        modeloProductosMesa3.clear();
        for (Producto producto : productos) {
            modeloProductosMesa3.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa3.setModel(modeloProductosMesa3);
    }
    
    DefaultListModel<String> modeloProductosMesa4 = new DefaultListModel<>();
    private void cargarProductosEnLista4() {
        modeloProductosMesa4.clear();
        for (Producto producto : productos) {
            modeloProductosMesa4.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa4.setModel(modeloProductosMesa4);
    }
    
    DefaultListModel<String> modeloProductosMesa5 = new DefaultListModel<>();
    private void cargarProductosEnLista5() {
        modeloProductosMesa5.clear();
        for (Producto producto : productos) {
            modeloProductosMesa5.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa5.setModel(modeloProductosMesa5);
    }
    
    DefaultListModel<String> modeloProductosMesa6 = new DefaultListModel<>();
    private void cargarProductosEnLista6() {
        modeloProductosMesa6.clear();
        for (Producto producto : productos) {
            modeloProductosMesa6.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa6.setModel(modeloProductosMesa6);
    }
    
    DefaultListModel<String> modeloProductosMesa7 = new DefaultListModel<>();
    private void cargarProductosEnLista7() {
        modeloProductosMesa7.clear();
        for (Producto producto : productos) {
            modeloProductosMesa7.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa7.setModel(modeloProductosMesa7);
    }
    
    DefaultListModel<String> modeloProductosMesa8 = new DefaultListModel<>();
    private void cargarProductosEnLista8() {
        modeloProductosMesa8.clear();
        for (Producto producto : productos) {
            modeloProductosMesa8.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa8.setModel(modeloProductosMesa8);
    }
    
    DefaultListModel<String> modeloProductosMesa9 = new DefaultListModel<>();
    private void cargarProductosEnLista9() {
        modeloProductosMesa9.clear();
        for (Producto producto : productos) {
            modeloProductosMesa9.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa9.setModel(modeloProductosMesa9);
    }
    
    DefaultListModel<String> modeloProductosMesa10 = new DefaultListModel<>();
    private void cargarProductosEnLista10() {
        modeloProductosMesa10.clear();
        for (Producto producto : productos) {
            modeloProductosMesa10.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa10.setModel(modeloProductosMesa10);
    }
    
    DefaultListModel<String> modeloProductosMesa11 = new DefaultListModel<>();
    private void cargarProductosEnLista11() {
        modeloProductosMesa11.clear();
        for (Producto producto : productos) {
            modeloProductosMesa11.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa11.setModel(modeloProductosMesa11);
    }
    
    DefaultListModel<String> modeloProductosMesa12 = new DefaultListModel<>();
    private void cargarProductosEnLista12() {
        modeloProductosMesa12.clear();
        for (Producto producto : productos) {
            modeloProductosMesa12.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        productosPedidoMesa12.setModel(modeloProductosMesa12);
    }
    
    private void agregarProductoAPedido(
        JList<String> listaProductos,
        Pedido pedidoMesa,
        Runnable actualizarListaProductos,
        Runnable mostrarProductosEnMesa
    ) {
        String nombreProductoSeleccionado = listaProductos.getSelectedValue();

        if (nombreProductoSeleccionado != null) {
            String nombreProducto = nombreProductoSeleccionado.split(" -")[0].trim();
            Producto productoSeleccionado = null;

            for (Producto producto : productos) {
                if (producto.getNombre().equals(nombreProducto)) {
                    productoSeleccionado = producto;
                    break;
                }
            }

            if (productoSeleccionado != null && productoSeleccionado.getCantidadDisponible() > 0) {
                while (true) {
                    String inputCantidad = JOptionPane.showInputDialog(this, 
                        "Ingresa la cantidad de platos:", 
                        "Agregar Producto", 
                        JOptionPane.QUESTION_MESSAGE);

                    if (inputCantidad != null) {
                        try {
                            int cantidad = Integer.parseInt(inputCantidad.trim());

                            if (cantidad > 0 && cantidad <= productoSeleccionado.getCantidadDisponible()) {
                                productoSeleccionado.setCantidadDisponible(productoSeleccionado.getCantidadDisponible() - cantidad);

                                boolean productoYaEnPedido = false;
                                for (Producto productoEnPedido : pedidoMesa.getListaProductos()) {
                                    if (productoEnPedido.getNombre().equals(nombreProducto)) {
                                        productoEnPedido.setCantidadDisponible(productoEnPedido.getCantidadDisponible() + cantidad);
                                        productoYaEnPedido = true;
                                        break;
                                    }
                                }

                                if (!productoYaEnPedido) {
                                    Producto productoParaPedido = new Producto(
                                        productoSeleccionado.getNombre(),
                                        productoSeleccionado.getPrecio(),
                                        productoSeleccionado.getCategoria(),
                                        cantidad
                                    );
                                    pedidoMesa.agregarProducto(productoParaPedido);
                                }

                                actualizarListaProductos.run();
                                mostrarProductosEnMesa.run();
                                break;
                            } else {
                                JOptionPane.showMessageDialog(this, 
                                    "Cantidad ingresada no disponible", 
                                    "Cantidad inválida", 
                                    JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(this, 
                                "Por favor, ingresa un número entero válido.", 
                                "Error de entrada", 
                                JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, 
                    "No hay suficiente cantidad disponible de este producto.", 
                    "Advertencia", 
                    JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Por favor, selecciona un producto de la lista.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
        }
    }

    
    private void btnAgregarProductoPedidoMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa1ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa1,
            pedidoMesa1,
            () -> actualizarListaProductosDelPedido(pedidoMesa1, listaPedidosMesa1),
            () -> mostrarProductosEnMesa(productosPedidoMesa1)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa1ActionPerformed
    
    private void btnAgregarProductoPedidoMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa2ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa2,
            pedidoMesa2,
            () -> actualizarListaProductosDelPedido(pedidoMesa2, listaPedidosMesa2), 
            () -> mostrarProductosEnMesa(productosPedidoMesa2)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa2ActionPerformed
    
    private void btnAgregarProductoPedidoMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa3ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa3,
            pedidoMesa3,
            () -> actualizarListaProductosDelPedido(pedidoMesa3, listaPedidosMesa3), 
            () -> mostrarProductosEnMesa(productosPedidoMesa3)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa3ActionPerformed

    private void btnAgregarProductoPedidoMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa4ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa4,
            pedidoMesa4,
            () -> actualizarListaProductosDelPedido(pedidoMesa4, listaPedidosMesa4), 
            () -> mostrarProductosEnMesa(productosPedidoMesa4)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa4ActionPerformed

    private void btnAgregarProductoPedidoMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa5ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa5,
            pedidoMesa5,
            () -> actualizarListaProductosDelPedido(pedidoMesa5, listaPedidosMesa5), 
            () -> mostrarProductosEnMesa(productosPedidoMesa5)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa5ActionPerformed

    private void btnAgregarProductoPedidoMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa6ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa6,
            pedidoMesa6,
            () -> actualizarListaProductosDelPedido(pedidoMesa6, listaPedidosMesa6), 
            () -> mostrarProductosEnMesa(productosPedidoMesa6)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa6ActionPerformed

    private void btnAgregarProductoPedidoMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa7ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa7,
            pedidoMesa7,
            () -> actualizarListaProductosDelPedido(pedidoMesa7, listaPedidosMesa7), 
            () -> mostrarProductosEnMesa(productosPedidoMesa7)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa7ActionPerformed

    private void btnAgregarProductoPedidoMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa8ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa8,
            pedidoMesa8,
            () -> actualizarListaProductosDelPedido(pedidoMesa8, listaPedidosMesa8), 
            () -> mostrarProductosEnMesa(productosPedidoMesa8)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa8ActionPerformed

    private void btnAgregarProductoPedidoMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa9ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa9,
            pedidoMesa9,
            () -> actualizarListaProductosDelPedido(pedidoMesa9, listaPedidosMesa9), 
            () -> mostrarProductosEnMesa(productosPedidoMesa9)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa9ActionPerformed

    private void btnAgregarProductoPedidoMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa10ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa10,
            pedidoMesa10,
            () -> actualizarListaProductosDelPedido(pedidoMesa10, listaPedidosMesa10), 
            () -> mostrarProductosEnMesa(productosPedidoMesa10)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa10ActionPerformed

    private void btnAgregarProductoPedidoMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa11ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa11,
            pedidoMesa11,
            () -> actualizarListaProductosDelPedido(pedidoMesa11, listaPedidosMesa11), 
            () -> mostrarProductosEnMesa(productosPedidoMesa11)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa11ActionPerformed

    private void btnAgregarProductoPedidoMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoPedidoMesa12ActionPerformed
        agregarProductoAPedido(
            productosPedidoMesa12,
            pedidoMesa12,
            () -> actualizarListaProductosDelPedido(pedidoMesa12, listaPedidosMesa12), 
            () -> mostrarProductosEnMesa(productosPedidoMesa12)
        );
    }//GEN-LAST:event_btnAgregarProductoPedidoMesa12ActionPerformed

    int contadorPedidosMesa1 = 1;
    int contadorPedidosMesa1Llevar = 1;
    private void realizarPedidoMesa1() {
        
        if (!pedidoMesa1.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa1.getNumPedido(), pedidoMesa1.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa1.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa1.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa1);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa1.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa1.setBackground(Color.red);
                contadorPedidosMesa1++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa1Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa1Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa1.setBackground(Color.red);
                contadorPedidosMesa1Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa1 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa1,listaPedidosMesa1);
            mesas.get(0).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    int contadorPedidosMesa2 = 1;
    int contadorPedidosMesa2Llevar = 1;
    private void realizarPedidoMesa2() {

        if (!pedidoMesa2.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa2.getNumPedido(), pedidoMesa2.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa2.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa2.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa2);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa2.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa2.setBackground(Color.red);
                contadorPedidosMesa2++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa2Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa2Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa2.setBackground(Color.red);
                contadorPedidosMesa2Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa2 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa2, listaPedidosMesa2);
            mesas.get(1).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa3 = 1;
    int contadorPedidosMesa3Llevar = 1;
    
    private void realizarPedidoMesa3() {

        if (!pedidoMesa3.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa3.getNumPedido(), pedidoMesa3.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa3.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa3.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa3);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa3.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa3.setBackground(Color.red);
                contadorPedidosMesa3++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa3Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa3Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa3.setBackground(Color.red);
                contadorPedidosMesa3Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa3 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa3, listaPedidosMesa3);
            mesas.get(2).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    int contadorPedidosMesa4 = 1;
    int contadorPedidosMesa4Llevar = 1;
    private void realizarPedidoMesa4() {

        if (!pedidoMesa4.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa4.getNumPedido(), pedidoMesa4.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa4.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa4.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa4);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa4.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa4.setBackground(Color.red);
                contadorPedidosMesa4++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa4Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa4Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa4.setBackground(Color.red);
                contadorPedidosMesa4Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa4 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa4, listaPedidosMesa4);
            mesas.get(3).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa5 = 1;
    int contadorPedidosMesa5Llevar = 1;
    private void realizarPedidoMesa5() {

        if (!pedidoMesa5.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa5.getNumPedido(), pedidoMesa5.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa5.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa5.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa5);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa5.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa5.setBackground(Color.red);
                contadorPedidosMesa5++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa5Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa5Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa5.setBackground(Color.red);
                contadorPedidosMesa5Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa5 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa5, listaPedidosMesa5);
            mesas.get(4).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa6 = 1;
    int contadorPedidosMesa6Llevar = 1;
    private void realizarPedidoMesa6() {

        if (!pedidoMesa6.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa6.getNumPedido(), pedidoMesa6.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa6.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa6.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa6);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa6.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa6.setBackground(Color.red);
                contadorPedidosMesa6++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa6Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa6Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa6.setBackground(Color.red);
                contadorPedidosMesa6Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa6 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa6, listaPedidosMesa6);
            mesas.get(5).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa7 = 1;
    int contadorPedidosMesa7Llevar = 1;
    private void realizarPedidoMesa7() {

        if (!pedidoMesa7.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa7.getNumPedido(), pedidoMesa7.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa7.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa7.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa7);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa7.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa7.setBackground(Color.red);
                contadorPedidosMesa7++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa7Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa7Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa7.setBackground(Color.red);
                contadorPedidosMesa7Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa7 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa7, listaPedidosMesa7);
            mesas.get(6).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa8 = 1;
    int contadorPedidosMesa8Llevar = 1;
    private void realizarPedidoMesa8() {

        if (!pedidoMesa8.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa8.getNumPedido(), pedidoMesa8.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa8.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa8.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa8);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa8.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa8.setBackground(Color.red);
                contadorPedidosMesa8++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa8Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa8Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa8.setBackground(Color.red);
                contadorPedidosMesa8Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa8 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa8, listaPedidosMesa8);
            mesas.get(7).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa9 = 1;
    int contadorPedidosMesa9Llevar = 1;
    private void realizarPedidoMesa9() {

        if (!pedidoMesa9.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa9.getNumPedido(), pedidoMesa9.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa9.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa9.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa9);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa9.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa9.setBackground(Color.red);
                contadorPedidosMesa9++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa9Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa9Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa9.setBackground(Color.red);
                contadorPedidosMesa9Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa9 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa9, listaPedidosMesa9);
            mesas.get(8).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa10 = 1;
    int contadorPedidosMesa10Llevar = 1;
    private void realizarPedidoMesa10() {

        if (!pedidoMesa10.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa10.getNumPedido(), pedidoMesa10.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa10.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa10.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa10);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa10.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa10.setBackground(Color.red);
                contadorPedidosMesa10++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa10Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa10Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa10.setBackground(Color.red);
                contadorPedidosMesa10Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa10 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa10, listaPedidosMesa10);
            mesas.get(9).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa11 = 1;
    int contadorPedidosMesa11Llevar = 1;
    private void realizarPedidoMesa11() {

        if (!pedidoMesa11.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa11.getNumPedido(), pedidoMesa11.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa11.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa11.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa11);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa11.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa11.setBackground(Color.red);
                contadorPedidosMesa11++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa11Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa11Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa11.setBackground(Color.red);
                contadorPedidosMesa11Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa11 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa11, listaPedidosMesa11);
            mesas.get(10).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    int contadorPedidosMesa12 = 1;
    int contadorPedidosMesa12Llevar = 1;
    private void realizarPedidoMesa12() {

        if (!pedidoMesa12.getListaProductos().isEmpty()) {

            Object[] opciones = {"Para mesa", "Para llevar"};
            int seleccion = JOptionPane.showOptionDialog(
                    this,
                    "¿Este pedido es para mesa o para llevar?",
                    "Confirmar tipo de pedido",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            Pedido nuevoPedido = new Pedido(pedidoMesa12.getNumPedido(), pedidoMesa12.getTipoPedido());
            for (int i = 0; i < listaPedidosMesa12.getModel().getSize(); i++) {
                String productoTexto = listaPedidosMesa12.getModel().getElementAt(i);

                String[] partes = productoTexto.split(" - Cantidad: ");
                if (partes.length == 2) {
                    String nombreProducto = partes[0].trim();
                    int cantidadProducto = Integer.parseInt(partes[1].trim());

                    Producto productoOriginal = null;
                    for (Producto producto : productos) {
                        if (producto.getNombre().equals(nombreProducto)) {
                            productoOriginal = producto;
                            break;
                        }
                    }

                    if (productoOriginal != null) {

                        Producto producto = new Producto(
                            nombreProducto,
                            productoOriginal.getPrecio(), 
                            cantidadProducto
                        );
                        nuevoPedido.agregarProducto(producto);
                    }
                }
            }

            if (seleccion == JOptionPane.YES_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa12);
                nuevoPedido.setTipoPedido("Mesa");
                
                pedidosMesa12.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para mesa realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa12.setBackground(Color.red);
                contadorPedidosMesa12++;
            } else if (seleccion == JOptionPane.NO_OPTION) {
                nuevoPedido.setNumPedido(contadorPedidosMesa12Llevar);
                nuevoPedido.setTipoPedido("Llevar");

                pedidosMesa12Llevar.add(nuevoPedido);
                JOptionPane.showMessageDialog(this, "Pedido para llevar realizado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                btnMesa12.setBackground(Color.red);
                contadorPedidosMesa12Llevar++;
            } else {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            pedidoMesa12 = new Pedido();
            actualizarListaProductosDelPedido(pedidoMesa12, listaPedidosMesa12);
            mesas.get(11).setEstado("Ocupada");
        } else {
            JOptionPane.showMessageDialog(this, "No hay productos en el pedido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void btnRealizarPedidoMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa1ActionPerformed
        realizarPedidoMesa1();
        
    }//GEN-LAST:event_btnRealizarPedidoMesa1ActionPerformed

    private void btnRealizarPedidoMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa2ActionPerformed
        realizarPedidoMesa2();
    }//GEN-LAST:event_btnRealizarPedidoMesa2ActionPerformed

    private void btnRealizarPedidoMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa3ActionPerformed
        realizarPedidoMesa3();
    }//GEN-LAST:event_btnRealizarPedidoMesa3ActionPerformed

    private void btnRealizarPedidoMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa4ActionPerformed
        realizarPedidoMesa4();
    }//GEN-LAST:event_btnRealizarPedidoMesa4ActionPerformed

    private void btnRealizarPedidoMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa5ActionPerformed
        realizarPedidoMesa5();
    }//GEN-LAST:event_btnRealizarPedidoMesa5ActionPerformed

    private void btnRealizarPedidoMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa6ActionPerformed
        realizarPedidoMesa6();
    }//GEN-LAST:event_btnRealizarPedidoMesa6ActionPerformed

    private void btnRealizarPedidoMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa7ActionPerformed
        realizarPedidoMesa7();
    }//GEN-LAST:event_btnRealizarPedidoMesa7ActionPerformed

    private void btnRealizarPedidoMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa8ActionPerformed
        realizarPedidoMesa8();
    }//GEN-LAST:event_btnRealizarPedidoMesa8ActionPerformed

    private void btnRealizarPedidoMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa9ActionPerformed
        realizarPedidoMesa9();
    }//GEN-LAST:event_btnRealizarPedidoMesa9ActionPerformed

    private void btnRealizarPedidoMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa10ActionPerformed
        realizarPedidoMesa10();
    }//GEN-LAST:event_btnRealizarPedidoMesa10ActionPerformed

    private void btnRealizarPedidoMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa11ActionPerformed
        realizarPedidoMesa11();
    }//GEN-LAST:event_btnRealizarPedidoMesa11ActionPerformed

    private void btnRealizarPedidoMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPedidoMesa12ActionPerformed
        realizarPedidoMesa12();
        
    }//GEN-LAST:event_btnRealizarPedidoMesa12ActionPerformed

    
    private void menItemGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemGenerarReporteActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelGenerarReporte");
    }//GEN-LAST:event_menItemGenerarReporteActionPerformed
    
    private void actualizarListaPedidos(ArrayList<Pedido> pedidosMesa, 
            JList<String> listaPedidosMesa,
            ArrayList<Pedido> pedidosLlevar,
            JList<String> listaPedidosLlevar) 
        {
        DefaultListModel<String> modeloPedidosMesa = new DefaultListModel<>();
        for (Pedido pedido : pedidosMesa) {
            modeloPedidosMesa.addElement("Pedido " + pedido.getNumPedido() + " - " + pedido.getTipoPedido());
        }
        listaPedidosMesa.setModel(modeloPedidosMesa);

        DefaultListModel<String> modeloPedidosLlevar = new DefaultListModel<>();
        for (Pedido pedido : pedidosLlevar) {
            modeloPedidosLlevar.addElement("Pedido " + pedido.getNumPedido() + " - " + pedido.getTipoPedido());
        }
        listaPedidosLlevar.setModel(modeloPedidosLlevar);
    }

    private void mostrarDetallePedidoMesa1(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa1.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa2(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa2.setModel(modeloDetalle); 
    }

    private void mostrarDetallePedidoMesa3(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa3.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa4(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa4.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa5(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa5.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa6(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa6.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa7(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa7.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa8(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa8.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa9(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa9.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa10(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa10.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa11(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa11.setModel(modeloDetalle); 
    }
    
    private void mostrarDetallePedidoMesa12(Pedido pedido) {
        DefaultListModel<String> modeloDetalle = new DefaultListModel<>();
        for (Producto producto : pedido.getListaProductos()) {
            modeloDetalle.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidad());
        }
        detallePedidoMesa12.setModel(modeloDetalle); 
    }
    private void btnVerPedidosMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa1ActionPerformed
        actualizarListaPedidos(pedidosMesa1, listaVerPedidosMesa1, pedidosMesa1Llevar, listaVerPedidosLlevarMesa1);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa1");
    }//GEN-LAST:event_btnVerPedidosMesa1ActionPerformed

    private void volverAtrasPanelMesas(){
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "panelGestionarMesas");
    }
    private void volverAtrasMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa1ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa1ActionPerformed

    private void volverAtrasMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa2ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa2ActionPerformed

    private void volverAtrasMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa3ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa3ActionPerformed

    private void volverAtrasMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa4ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa4ActionPerformed

    private void volverAtrasMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa5ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa5ActionPerformed

    private void volverAtrasMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa6ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa6ActionPerformed

    private void volverAtrasMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa7ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa7ActionPerformed

    private void volverAtrasMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa8ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa8ActionPerformed

    private void volverAtrasMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa9ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa9ActionPerformed

    private void volverAtrasMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa10ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa10ActionPerformed

    private void volverAtrasMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa11ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa11ActionPerformed

    private void volverAtrasMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverAtrasMesa12ActionPerformed
        volverAtrasPanelMesas();
    }//GEN-LAST:event_volverAtrasMesa12ActionPerformed

    private void listaVerPedidosMesa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa1MouseClicked
        int index = listaVerPedidosMesa1.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa1.get(index);
            mostrarDetallePedidoMesa1(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa1MouseClicked

    private void listaVerPedidosLlevarMesa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa1MouseClicked
        int index = listaVerPedidosLlevarMesa1.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa1Llevar.get(index);
            mostrarDetallePedidoMesa1(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa1MouseClicked

    private void btnVerPedidosMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa2ActionPerformed
        actualizarListaPedidos(pedidosMesa2, listaVerPedidosMesa2, pedidosMesa2Llevar, listaVerPedidosLlevarMesa2);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa2");
    }//GEN-LAST:event_btnVerPedidosMesa2ActionPerformed

    private void btnVerPedidosMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa3ActionPerformed
        actualizarListaPedidos(pedidosMesa3, listaVerPedidosMesa3, pedidosMesa3Llevar, listaVerPedidosLlevarMesa3);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa3");
    }//GEN-LAST:event_btnVerPedidosMesa3ActionPerformed

    private void btnVerPedidosMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa4ActionPerformed
        actualizarListaPedidos(pedidosMesa4, listaVerPedidosMesa4, pedidosMesa4Llevar, listaVerPedidosLlevarMesa4);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa4");
    }//GEN-LAST:event_btnVerPedidosMesa4ActionPerformed

    private void btnVerPedidosMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa5ActionPerformed
        actualizarListaPedidos(pedidosMesa5, listaVerPedidosMesa5, pedidosMesa5Llevar, listaVerPedidosLlevarMesa5);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa5");
    }//GEN-LAST:event_btnVerPedidosMesa5ActionPerformed

    private void btnVerPedidosMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa6ActionPerformed
        actualizarListaPedidos(pedidosMesa6, listaVerPedidosMesa6, pedidosMesa6Llevar, listaVerPedidosLlevarMesa6);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa6");
    }//GEN-LAST:event_btnVerPedidosMesa6ActionPerformed

    private void btnVerPedidosMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa7ActionPerformed
        actualizarListaPedidos(pedidosMesa7, listaVerPedidosMesa7, pedidosMesa7Llevar, listaVerPedidosLlevarMesa7);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa7");
    }//GEN-LAST:event_btnVerPedidosMesa7ActionPerformed

    private void btnVerPedidosMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa8ActionPerformed
        actualizarListaPedidos(pedidosMesa8, listaVerPedidosMesa8, pedidosMesa8Llevar, listaVerPedidosLlevarMesa8);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa8");
    }//GEN-LAST:event_btnVerPedidosMesa8ActionPerformed

    private void btnVerPedidosMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa9ActionPerformed
        actualizarListaPedidos(pedidosMesa9, listaVerPedidosMesa9, pedidosMesa9Llevar, listaVerPedidosLlevarMesa9);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa9");
    }//GEN-LAST:event_btnVerPedidosMesa9ActionPerformed

    private void btnVerPedidosMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa10ActionPerformed
        actualizarListaPedidos(pedidosMesa10, listaVerPedidosMesa10, pedidosMesa10Llevar, listaVerPedidosLlevarMesa10);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa10");
    }//GEN-LAST:event_btnVerPedidosMesa10ActionPerformed

    private void btnVerPedidosMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa11ActionPerformed
        actualizarListaPedidos(pedidosMesa11, listaVerPedidosMesa11, pedidosMesa11Llevar, listaVerPedidosLlevarMesa11);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa11");
    }//GEN-LAST:event_btnVerPedidosMesa11ActionPerformed

    private void btnVerPedidosMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidosMesa12ActionPerformed
        actualizarListaPedidos(pedidosMesa12, listaVerPedidosMesa12, pedidosMesa12Llevar, listaVerPedidosLlevarMesa12);
        CardLayout layout = (CardLayout) jPanelMostrar.getLayout();
        layout.show(jPanelMostrar, "verPedidoMesa12");
    }//GEN-LAST:event_btnVerPedidosMesa12ActionPerformed

    private void listaVerPedidosMesa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa2MouseClicked
        int index = listaVerPedidosMesa2.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa2.get(index);
            mostrarDetallePedidoMesa2(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa2MouseClicked

    private void listaVerPedidosLlevarMesa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa2MouseClicked
        int index = listaVerPedidosLlevarMesa2.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa2Llevar.get(index);
            mostrarDetallePedidoMesa2(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa2MouseClicked

    private void listaVerPedidosMesa3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa3MouseClicked
        int index = listaVerPedidosMesa3.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa3.get(index);
            mostrarDetallePedidoMesa3(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa3MouseClicked

    private void listaVerPedidosLlevarMesa3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa3MouseClicked
        int index = listaVerPedidosLlevarMesa3.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa3Llevar.get(index);
            mostrarDetallePedidoMesa3(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa3MouseClicked

    private void listaVerPedidosMesa4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa4MouseClicked
        int index = listaVerPedidosMesa4.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa4.get(index);
            mostrarDetallePedidoMesa4(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa4MouseClicked

    private void listaVerPedidosLlevarMesa4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa4MouseClicked
        int index = listaVerPedidosLlevarMesa4.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa4Llevar.get(index);
            mostrarDetallePedidoMesa4(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa4MouseClicked

    private void listaVerPedidosMesa5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa5MouseClicked
        int index = listaVerPedidosMesa5.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa5.get(index);
            mostrarDetallePedidoMesa5(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa5MouseClicked

    private void listaVerPedidosLlevarMesa5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa5MouseClicked
        int index = listaVerPedidosLlevarMesa5.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa5Llevar.get(index);
            mostrarDetallePedidoMesa5(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa5MouseClicked

    private void listaVerPedidosMesa6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa6MouseClicked
        int index = listaVerPedidosMesa6.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa6.get(index);
            mostrarDetallePedidoMesa6(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa6MouseClicked

    private void listaVerPedidosLlevarMesa6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa6MouseClicked
        int index = listaVerPedidosLlevarMesa6.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa6Llevar.get(index);
            mostrarDetallePedidoMesa6(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa6MouseClicked

    private void listaVerPedidosMesa7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa7MouseClicked
        int index = listaVerPedidosMesa7.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa7.get(index);
            mostrarDetallePedidoMesa7(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa7MouseClicked

    private void listaVerPedidosLlevarMesa7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa7MouseClicked
        int index = listaVerPedidosLlevarMesa7.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa7Llevar.get(index);
            mostrarDetallePedidoMesa7(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa7MouseClicked

    private void listaVerPedidosMesa8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa8MouseClicked
        int index = listaVerPedidosMesa8.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa8.get(index);
            mostrarDetallePedidoMesa8(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa8MouseClicked

    private void listaVerPedidosLlevarMesa8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa8MouseClicked
        int index = listaVerPedidosLlevarMesa8.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa8Llevar.get(index);
            mostrarDetallePedidoMesa8(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa8MouseClicked

    private void listaVerPedidosMesa9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa9MouseClicked
        int index = listaVerPedidosMesa9.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa9.get(index);
            mostrarDetallePedidoMesa9(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa9MouseClicked

    private void listaVerPedidosLlevarMesa9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa9MouseClicked
        int index = listaVerPedidosLlevarMesa9.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa9Llevar.get(index);
            mostrarDetallePedidoMesa9(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa9MouseClicked

    private void listaVerPedidosMesa10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa10MouseClicked
        int index = listaVerPedidosMesa10.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa10.get(index);
            mostrarDetallePedidoMesa10(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa10MouseClicked

    private void listaVerPedidosLlevarMesa10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa10MouseClicked
        int index = listaVerPedidosLlevarMesa10.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa10Llevar.get(index);
            mostrarDetallePedidoMesa10(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa10MouseClicked

    private void listaVerPedidosMesa11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa11MouseClicked
        int index = listaVerPedidosMesa11.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa11.get(index);
            mostrarDetallePedidoMesa11(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa11MouseClicked

    private void listaVerPedidosLlevarMesa11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa11MouseClicked
        int index = listaVerPedidosLlevarMesa11.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa11Llevar.get(index);
            mostrarDetallePedidoMesa11(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa11MouseClicked

    private void listaVerPedidosMesa12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa12MouseClicked
        int index = listaVerPedidosMesa12.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa12.get(index);
            mostrarDetallePedidoMesa12(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosMesa12MouseClicked

    private void listaVerPedidosLlevarMesa12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa12MouseClicked
        int index = listaVerPedidosLlevarMesa12.getSelectedIndex();
        if (index >= 0) {
            Pedido pedidoSeleccionado = pedidosMesa12Llevar.get(index);
            mostrarDetallePedidoMesa12(pedidoSeleccionado);
        }
    }//GEN-LAST:event_listaVerPedidosLlevarMesa12MouseClicked

    private void cancelarPedido(
        JList<String> listaPedidosMesa, 
        JList<String> listaPedidosLlevar,
        ArrayList<Pedido> pedidosMesa, 
        ArrayList<Pedido> pedidosLlevar, 
        JList<String> detallePedido, 
        Runnable actualizarListaPedidos, 
        Runnable mostrarProductosEnMesa
        ) {
            int indexMesa = listaPedidosMesa.getSelectedIndex();
            int indexLlevar = listaPedidosLlevar.getSelectedIndex();

            if (indexMesa >= 0) {
                Object[] opciones = {"Sí", "No"};
                int confirmacion = JOptionPane.showOptionDialog(
                    this, 
                    "¿Estás seguro de que deseas cancelar el pedido para mesa?", 
                    "Confirmación de Cancelación", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    Pedido pedidoCancelado = pedidosMesa.get(indexMesa);

                    for (Producto productoCancelado : pedidoCancelado.getListaProductos()) {
                        for (Producto producto : productos) {
                            if (producto.getNombre().equals(productoCancelado.getNombre())) {
                                producto.setCantidadDisponible(producto.getCantidadDisponible() + productoCancelado.getCantidad());
                                break;
                            }
                        }
                    }

                    pedidosMesa.remove(indexMesa);
                    actualizarListaPedidos.run();
                    mostrarProductosEnMesa.run();
                    JOptionPane.showMessageDialog(this, "Pedido para mesa cancelado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    detallePedido.setModel(new DefaultListModel<>());
                }
            } else if (indexLlevar >= 0) {
                Object[] opciones = {"Sí", "No"};
                int confirmacion = JOptionPane.showOptionDialog(
                    this, 
                    "¿Estás seguro de que deseas cancelar el pedido para mesa?", 
                    "Confirmación de Cancelación", 
                    JOptionPane.YES_NO_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    opciones, 
                    opciones[0]
                );

                if (confirmacion == JOptionPane.YES_OPTION) {
                    Pedido pedidoCancelado = pedidosLlevar.get(indexLlevar);

                    for (Producto productoCancelado : pedidoCancelado.getListaProductos()) {
                        for (Producto producto : productos) {
                            if (producto.getNombre().equals(productoCancelado.getNombre())) {
                                producto.setCantidadDisponible(producto.getCantidadDisponible() + productoCancelado.getCantidad());
                                break;
                            }
                        }
                    }

                    pedidosLlevar.remove(indexLlevar);
                    actualizarListaPedidos.run();
                    mostrarProductosEnMesa.run();
                    JOptionPane.showMessageDialog(this, "Pedido para llevar cancelado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    detallePedido.setModel(new DefaultListModel<>());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor selecciona un pedido para cancelar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
    }

    
    private void cancelarPedidoMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa1ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa1, 
            listaVerPedidosLlevarMesa1, 
            pedidosMesa1, 
            pedidosMesa1Llevar, 
            detallePedidoMesa1, 
            () -> actualizarListaPedidos(pedidosMesa1, listaVerPedidosMesa1, pedidosMesa1Llevar, listaVerPedidosLlevarMesa1), 
            () -> mostrarProductosEnMesa(productosPedidoMesa1)
        );
    }//GEN-LAST:event_cancelarPedidoMesa1ActionPerformed

    private void btnLimpiarMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa2ActionPerformed
        limpiarMesa(pedidosMesa2, pedidosMesa2Llevar, btnMesa2, 1, detallePedidoMesa2,
                () -> actualizarListaPedidos(pedidosMesa2, listaVerPedidosMesa2, pedidosMesa2Llevar, listaVerPedidosLlevarMesa2));
    }//GEN-LAST:event_btnLimpiarMesa2ActionPerformed

    private void btnLimpiarMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa3ActionPerformed
        limpiarMesa(pedidosMesa3, pedidosMesa3Llevar, btnMesa3, 2, detallePedidoMesa3, 
                () -> actualizarListaPedidos(pedidosMesa3, listaVerPedidosMesa3, pedidosMesa3Llevar, listaVerPedidosLlevarMesa3));
    }//GEN-LAST:event_btnLimpiarMesa3ActionPerformed

    private void cancelarPedidoMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa4ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa4, 
            listaVerPedidosLlevarMesa4, 
            pedidosMesa4, 
            pedidosMesa4Llevar, 
            detallePedidoMesa4, 
            () -> actualizarListaPedidos(pedidosMesa4, listaVerPedidosMesa4, pedidosMesa4Llevar, listaVerPedidosLlevarMesa4), 
            () -> mostrarProductosEnMesa(productosPedidoMesa4)
        );
    }//GEN-LAST:event_cancelarPedidoMesa4ActionPerformed

    private void cancelarPedidoMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa5ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa5, 
            listaVerPedidosLlevarMesa5, 
            pedidosMesa5, 
            pedidosMesa5Llevar, 
            detallePedidoMesa5, 
            () -> actualizarListaPedidos(pedidosMesa5, listaVerPedidosMesa5, pedidosMesa5Llevar, listaVerPedidosLlevarMesa5), 
            () -> mostrarProductosEnMesa(productosPedidoMesa5)
        );
    }//GEN-LAST:event_cancelarPedidoMesa5ActionPerformed

    private void cancelarPedidoMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa6ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa6, 
            listaVerPedidosLlevarMesa6, 
            pedidosMesa6, 
            pedidosMesa6Llevar, 
            detallePedidoMesa6, 
            () -> actualizarListaPedidos(pedidosMesa6, listaVerPedidosMesa6, pedidosMesa6Llevar, listaVerPedidosLlevarMesa6), 
            () -> mostrarProductosEnMesa(productosPedidoMesa6)
        );
    }//GEN-LAST:event_cancelarPedidoMesa6ActionPerformed

    private void cancelarPedidoMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa7ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa7, 
            listaVerPedidosLlevarMesa7, 
            pedidosMesa7, 
            pedidosMesa7Llevar, 
            detallePedidoMesa7, 
            () -> actualizarListaPedidos(pedidosMesa7, listaVerPedidosMesa7, pedidosMesa7Llevar, listaVerPedidosLlevarMesa7), 
            () -> mostrarProductosEnMesa(productosPedidoMesa7)
        );
    }//GEN-LAST:event_cancelarPedidoMesa7ActionPerformed

    private void cancelarPedidoMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa8ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa8, 
            listaVerPedidosLlevarMesa8, 
            pedidosMesa8, 
            pedidosMesa8Llevar, 
            detallePedidoMesa8, 
            () -> actualizarListaPedidos(pedidosMesa8, listaVerPedidosMesa8, pedidosMesa8Llevar, listaVerPedidosLlevarMesa8), 
            () -> mostrarProductosEnMesa(productosPedidoMesa8)
        );
    }//GEN-LAST:event_cancelarPedidoMesa8ActionPerformed

    private void cancelarPedidoMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa9ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa9, 
            listaVerPedidosLlevarMesa9, 
            pedidosMesa9, 
            pedidosMesa9Llevar, 
            detallePedidoMesa9, 
            () -> actualizarListaPedidos(pedidosMesa9, listaVerPedidosMesa9, pedidosMesa9Llevar, listaVerPedidosLlevarMesa9),  
            () -> mostrarProductosEnMesa(productosPedidoMesa9)
        );
    }//GEN-LAST:event_cancelarPedidoMesa9ActionPerformed

    private void cancelarPedidoMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa10ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa10, 
            listaVerPedidosLlevarMesa10, 
            pedidosMesa10, 
            pedidosMesa10Llevar, 
            detallePedidoMesa10, 
            () -> actualizarListaPedidos(pedidosMesa10, listaVerPedidosMesa10, pedidosMesa10Llevar, listaVerPedidosLlevarMesa10),
            () -> mostrarProductosEnMesa(productosPedidoMesa10)
        );
    }//GEN-LAST:event_cancelarPedidoMesa10ActionPerformed

    private void cancelarPedidoMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa11ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa11, 
            listaVerPedidosLlevarMesa11, 
            pedidosMesa11, 
            pedidosMesa11Llevar, 
            detallePedidoMesa11, 
            () -> actualizarListaPedidos(pedidosMesa11, listaVerPedidosMesa11, pedidosMesa11Llevar, listaVerPedidosLlevarMesa11), 
            () -> mostrarProductosEnMesa(productosPedidoMesa11)
        );
    }//GEN-LAST:event_cancelarPedidoMesa11ActionPerformed

    private void cancelarPedidoMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa12ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa12, 
            listaVerPedidosLlevarMesa12, 
            pedidosMesa12, 
            pedidosMesa12Llevar, 
            detallePedidoMesa12, 
            () -> actualizarListaPedidos(pedidosMesa12, listaVerPedidosMesa12, pedidosMesa12Llevar, listaVerPedidosLlevarMesa12), 
            () -> mostrarProductosEnMesa(productosPedidoMesa12)
        );
    }//GEN-LAST:event_cancelarPedidoMesa12ActionPerformed

    private void cambioSeleccionVerPedidos(JList<String> listaSeleccionada, JList<String> listaOpuesta) {
        if (!listaSeleccionada.isSelectionEmpty()) {
            listaOpuesta.clearSelection();
        }
    }

    
    private void listaVerPedidosMesa1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa1ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa1, listaVerPedidosLlevarMesa1);
    }//GEN-LAST:event_listaVerPedidosMesa1ValueChanged

    private void listaVerPedidosLlevarMesa1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa1ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa1, listaVerPedidosMesa1);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa1ValueChanged

    private void listaVerPedidosMesa2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa2ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa2, listaVerPedidosLlevarMesa2);
    }//GEN-LAST:event_listaVerPedidosMesa2ValueChanged

    private void listaVerPedidosLlevarMesa2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa2ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa2, listaVerPedidosMesa2);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa2ValueChanged

    private void listaVerPedidosMesa3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa3ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa3, listaVerPedidosLlevarMesa3);
    }//GEN-LAST:event_listaVerPedidosMesa3ValueChanged

    private void listaVerPedidosLlevarMesa3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa3ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa3, listaVerPedidosMesa3);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa3ValueChanged

    private void listaVerPedidosMesa4ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa4ValueChanged
       cambioSeleccionVerPedidos(listaVerPedidosMesa4, listaVerPedidosLlevarMesa4);
    }//GEN-LAST:event_listaVerPedidosMesa4ValueChanged

    private void listaVerPedidosLlevarMesa4ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa4ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa4, listaVerPedidosMesa4);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa4ValueChanged

    private void listaVerPedidosMesa5ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa5ValueChanged
       cambioSeleccionVerPedidos(listaVerPedidosMesa5, listaVerPedidosLlevarMesa5);
    }//GEN-LAST:event_listaVerPedidosMesa5ValueChanged

    private void listaVerPedidosLlevarMesa5ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa5ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa5, listaVerPedidosMesa5);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa5ValueChanged

    private void listaVerPedidosMesa6ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa6ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa6, listaVerPedidosLlevarMesa6);
    }//GEN-LAST:event_listaVerPedidosMesa6ValueChanged

    private void listaVerPedidosLlevarMesa6ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa6ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa6, listaVerPedidosMesa6);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa6ValueChanged

    private void listaVerPedidosMesa7ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa7ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa7, listaVerPedidosLlevarMesa7);
    }//GEN-LAST:event_listaVerPedidosMesa7ValueChanged

    private void listaVerPedidosLlevarMesa7ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa7ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa7, listaVerPedidosMesa7);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa7ValueChanged

    private void listaVerPedidosMesa8ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa8ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa8, listaVerPedidosLlevarMesa8);
    }//GEN-LAST:event_listaVerPedidosMesa8ValueChanged

    private void listaVerPedidosLlevarMesa8ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa8ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa8, listaVerPedidosMesa8);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa8ValueChanged

    private void listaVerPedidosMesa10ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa10ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa10, listaVerPedidosLlevarMesa10);
    }//GEN-LAST:event_listaVerPedidosMesa10ValueChanged

    private void listaVerPedidosLlevarMesa10ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa10ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa10, listaVerPedidosMesa10);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa10ValueChanged

    private void listaVerPedidosMesa11ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa11ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa11, listaVerPedidosLlevarMesa11);
    }//GEN-LAST:event_listaVerPedidosMesa11ValueChanged

    private void listaVerPedidosLlevarMesa11ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa11ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa11, listaVerPedidosMesa11);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa11ValueChanged

    private void listaVerPedidosMesa12ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa12ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa12, listaVerPedidosLlevarMesa12);
    }//GEN-LAST:event_listaVerPedidosMesa12ValueChanged

    private void listaVerPedidosLlevarMesa12ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa12ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa12, listaVerPedidosMesa12);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa12ValueChanged

    private void listaVerPedidosMesa9ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosMesa9ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosMesa9, listaVerPedidosLlevarMesa9);
    }//GEN-LAST:event_listaVerPedidosMesa9ValueChanged

    private void listaVerPedidosLlevarMesa9ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaVerPedidosLlevarMesa9ValueChanged
        cambioSeleccionVerPedidos(listaVerPedidosLlevarMesa9, listaVerPedidosMesa9);
    }//GEN-LAST:event_listaVerPedidosLlevarMesa9ValueChanged
    
    private void btnTotalCuentaMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa1ActionPerformed
        
        double totalCuentaMesa = mesas.get(0).getCuenta().calcularCuentaMesa(pedidosMesa1, pedidosMesa1Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 1 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa1.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa1ActionPerformed

    private void btnTotalCuentaMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa2ActionPerformed

        double totalCuentaMesa = mesas.get(1).getCuenta().calcularCuentaMesa(pedidosMesa2, pedidosMesa2Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 2 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa2.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa2ActionPerformed

    private void btnTotalCuentaMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa3ActionPerformed

        double totalCuentaMesa = mesas.get(2).getCuenta().calcularCuentaMesa(pedidosMesa3, pedidosMesa3Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 3 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa3.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa3ActionPerformed

    private void btnTotalCuentaMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa4ActionPerformed
       
        double totalCuentaMesa = mesas.get(3).getCuenta().calcularCuentaMesa(pedidosMesa4, pedidosMesa4Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 4 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa4.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa4ActionPerformed

    private void btnTotalCuentaMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa5ActionPerformed
        
        double totalCuentaMesa = mesas.get(4).getCuenta().calcularCuentaMesa(pedidosMesa5, pedidosMesa5Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 5 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa5.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa5ActionPerformed

    private void btnTotalCuentaMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa6ActionPerformed
        
        double totalCuentaMesa = mesas.get(5).getCuenta().calcularCuentaMesa(pedidosMesa6, pedidosMesa6Llevar);
        
         JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 6 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa6.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa6ActionPerformed

    private void btnTotalCuentaMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa7ActionPerformed
        
        double totalCuentaMesa = mesas.get(6).getCuenta().calcularCuentaMesa(pedidosMesa7, pedidosMesa7Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 7 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa7.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa7ActionPerformed

    private void btnTotalCuentaMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa8ActionPerformed
        
        double totalCuentaMesa = mesas.get(7).getCuenta().calcularCuentaMesa(pedidosMesa8, pedidosMesa8Llevar);
       
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 8 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa8.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa8ActionPerformed

    private void btnTotalCuentaMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa9ActionPerformed
        
        double totalCuentaMesa = mesas.get(8).getCuenta().calcularCuentaMesa(pedidosMesa9, pedidosMesa9Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 9 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa9.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa9ActionPerformed

    private void btnTotalCuentaMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa10ActionPerformed
        
        double totalCuentaMesa = mesas.get(9).getCuenta().calcularCuentaMesa(pedidosMesa10, pedidosMesa10Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 10 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa10.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa10ActionPerformed

    private void btnTotalCuentaMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa11ActionPerformed
        
        double totalCuentaMesa = mesas.get(10).getCuenta().calcularCuentaMesa(pedidosMesa11, pedidosMesa11Llevar);
        
        JOptionPane.showMessageDialog(rootPane, "El total de la cuenta de la Mesa 11 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa11.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa11ActionPerformed

    private void btnTotalCuentaMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalCuentaMesa12ActionPerformed
        
        double totalCuentaMesa = mesas.get(11).getCuenta().calcularCuentaMesa(pedidosMesa12, pedidosMesa12Llevar);
        
        JOptionPane.showMessageDialog(this, "El total de la cuenta de la Mesa 12 es: S/ " + totalCuentaMesa, "Total de la Cuenta", JOptionPane.INFORMATION_MESSAGE);
        
        if (totalCuentaMesa == 0) {
            btnLimpiarMesa12.setEnabled(false);
        }
    }//GEN-LAST:event_btnTotalCuentaMesa12ActionPerformed

    private void registrarProductoVendido(Producto producto) {
        boolean productoExistente = false;
        for (Producto p : productosVendidos) {
            if (p.getNombre().equals(producto.getNombre())) {
                p.setCantidad(p.getCantidad() + producto.getCantidad());
                productoExistente = true;
                break;
            }
        }
        if (!productoExistente) {
            productosVendidos.add(new Producto(producto.getNombre(), producto.getPrecio(), producto.getCantidad()));
        }
    }
    
    private void generarRecibo(int numeroMesa, ArrayList<Pedido> pedidosEnMesa, ArrayList<Pedido> pedidosParaLlevar, JButton btnLimpiarMesa) {
        
        double totalCuenta = mesas.get(numeroMesa).getCuenta().calcularCuentaMesa(pedidosEnMesa, pedidosParaLlevar);

        if (totalCuenta == 0) {
            JOptionPane.showMessageDialog(rootPane, "No se puede generar un recibo. La cuenta total es 0.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {

            String[] opciones = {"DNI", "Pasaporte"};
            String tipoIdentificacion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el tipo de identificación:",
                    "Identificación del cliente",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (tipoIdentificacion == null) {
                return;
            }

            String identificacion = JOptionPane.showInputDialog("Ingrese el número de " + tipoIdentificacion + ":");
            
            while (identificacion == null || identificacion.trim().isEmpty() ||
                    (tipoIdentificacion.equals("DNI") && !identificacion.matches("\\d{8}")) ||
                    (tipoIdentificacion.equals("Pasaporte") && !identificacion.matches("[a-zA-Z0-9]+"))) {
                if (identificacion == null) {
                    return;
                }else{
                    identificacion = JOptionPane.showInputDialog("Número de " + tipoIdentificacion + " no válido. Ingrese correctamente:");
                }
            }

            String nombreCliente = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
            while (nombreCliente == null || nombreCliente.trim().isEmpty() || !nombreCliente.matches("[a-zA-Z\\s]+")) {
                if (nombreCliente == null) {
                    return;
                }else{
                    nombreCliente = JOptionPane.showInputDialog("Nombre no válido. Ingrese el nombre del cliente correctamente (solo letras y espacios):");
                }   
            }

            String apellidoCliente = JOptionPane.showInputDialog("Ingrese el apellido del cliente:");
            while (apellidoCliente == null || apellidoCliente.trim().isEmpty() || !apellidoCliente.matches("[a-zA-Z\\s]+")) {
                if (apellidoCliente == null) {
                    return;
                }else{
                    apellidoCliente = JOptionPane.showInputDialog("Apellido no válido. Ingrese el apellido del cliente correctamente (solo letras y espacios):");
                }
            }

            Cliente cliente = new Cliente(tipoIdentificacion, identificacion, nombreCliente, apellidoCliente);

            LocalDateTime fechaActual = LocalDateTime.now();
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            String fechaFormateada = fechaActual.format(formatoFecha);

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar recibo");
            fileChooser.setSelectedFile(new File("Recibo Mesa" + (numeroMesa + 1) + "_" + cliente.getNombre() + " " + cliente.getApellido() + ".pdf"));

            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();

                try {
                    PdfWriter writer = new PdfWriter(fileToSave.getAbsolutePath());
                    PdfDocument pdfDoc = new PdfDocument(writer);
                    Document document = new Document(pdfDoc);

                    try (InputStream logoStream = getClass().getResourceAsStream("/imagenes/logo.jpg")) {
                        if (logoStream == null) {
                            throw new FileNotFoundException("El archivo logo.jpg no fue encontrado en /imagenes/");
                        }
                        ImageData data = ImageDataFactory.create(logoStream.readAllBytes());
                        Image logo = new Image(data);
                        logo.scaleToFit(150, 150);
                        logo.setFixedPosition(pdfDoc.getDefaultPageSize().getWidth() - 200, pdfDoc.getDefaultPageSize().getHeight() - 150);
                        document.add(logo);
                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(rootPane, "Error cargando el logo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    document.add(new Paragraph("Recibo Mesa " + (numeroMesa + 1)).setBold().setFontSize(16));
                    document.add(new Paragraph("Fecha: " + fechaFormateada).setFontSize(10));
                    document.add(new Paragraph("========================================"));
                    document.add(new Paragraph("Cliente: " + cliente.getNombre() + " " + cliente.getApellido()));
                    document.add(new Paragraph("Tipo de identificación: "+cliente.getTipoIdentificacion()));
                    document.add(new Paragraph("Número de identificación: " + cliente.getIdentificacion()));
                    document.add(new Paragraph("========================================").setMarginBottom(10));

                    Table table = new Table(5);
                    table.addCell(new Cell().add(new Paragraph("Producto").setBold()));
                    table.addCell(new Cell().add(new Paragraph("Cantidad").setBold()));
                    table.addCell(new Cell().add(new Paragraph("Precio Unitario").setBold()));
                    table.addCell(new Cell().add(new Paragraph("Subtotal").setBold()));
                    table.addCell(new Cell().add(new Paragraph("Tipo Pedido").setBold()));

                   for (Pedido pedido : pedidosEnMesa) {
                        for (Producto producto : pedido.getListaProductos()) {
                            table.addCell(new Cell().add(new Paragraph(producto.getNombre())));
                            table.addCell(new Cell().add(new Paragraph(String.valueOf(producto.getCantidad()))));
                            table.addCell(new Cell().add(new Paragraph(String.format("S/ %.2f", producto.getPrecio()))));
                            table.addCell(new Cell().add(new Paragraph(String.format("S/ %.2f", producto.getCantidad() * producto.getPrecio()))));
                            table.addCell(new Cell().add(new Paragraph(pedido.getTipoPedido())));

                            registrarProductoVendido(producto);
                        }
                    }

                    for (Pedido pedido : pedidosParaLlevar) {
                        for (Producto producto : pedido.getListaProductos()) {
                            table.addCell(new Cell().add(new Paragraph(producto.getNombre())));
                            table.addCell(new Cell().add(new Paragraph(String.valueOf(producto.getCantidad()))));
                            table.addCell(new Cell().add(new Paragraph(String.format("S/ %.2f", producto.getPrecio()))));
                            table.addCell(new Cell().add(new Paragraph(String.format("S/ %.2f", producto.getCantidad() * producto.getPrecio()))));
                            table.addCell(new Cell().add(new Paragraph(pedido.getTipoPedido())));

                            registrarProductoVendido(producto);
                        }
                    }

                    document.add(table);

                    document.add(new Paragraph("========================================"));
                    document.add(new Paragraph("Total de la cuenta: S/ " + String.format("%.2f", totalCuenta)).setBold());


                    document.close();

                    JOptionPane.showMessageDialog(rootPane, "Recibo generado correctamente en " + fileToSave.getAbsolutePath(), "Recibo Generado", JOptionPane.INFORMATION_MESSAGE);
                    btnLimpiarMesa.setEnabled(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(rootPane, "Error al generar el recibo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Guardado cancelado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    
    private void btnGenerarReciboMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa1ActionPerformed
        
        generarRecibo(0, pedidosMesa1, pedidosMesa1Llevar, btnLimpiarMesa1);
    }//GEN-LAST:event_btnGenerarReciboMesa1ActionPerformed

    private void productosPedidoMesa1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa1ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa1, listaPedidosMesa1);
    }//GEN-LAST:event_productosPedidoMesa1ValueChanged

    private void listaPedidosMesa1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa1ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa1, productosPedidoMesa1);
    }//GEN-LAST:event_listaPedidosMesa1ValueChanged

    private void btnBorrarProductoPedidoMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa1ActionPerformed

        int index = listaPedidosMesa1.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa1.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa1.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa1, listaPedidosMesa2);
                cargarProductosEnLista1();
                mostrarProductosEnMesa(productosPedidoMesa1);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa1ActionPerformed

    private void limpiarMesa(
        ArrayList<Pedido> pedidosMesa, 
        ArrayList<Pedido> pedidosLlevar, 
        JButton botonMesa, 
        int indiceMesa, 
        JList<String> detallePedido, 
        Runnable actualizarListaPedidos
        ) {
            pedidosMesa.clear();
            pedidosLlevar.clear();
            botonMesa.setBackground(Color.green);
            mesas.get(indiceMesa).setEstado("Desocupada");
            actualizarListaPedidos.run();
            detallePedido.setModel(new DefaultListModel<>());

            JOptionPane.showMessageDialog(
                rootPane, 
                "Todos los pedidos han sido limpiados.", 
                "Confirmación", 
                JOptionPane.INFORMATION_MESSAGE
            );
    }

    
    private void btnLimpiarMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa1ActionPerformed
        limpiarMesa(pedidosMesa1, pedidosMesa1Llevar, btnMesa1, 0, detallePedidoMesa1,
            () -> actualizarListaPedidos(pedidosMesa1, listaVerPedidosMesa1, pedidosMesa1Llevar, listaVerPedidosLlevarMesa1));
    }//GEN-LAST:event_btnLimpiarMesa1ActionPerformed

    private void btnAgregarProductoCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoCartaActionPerformed
        
        String nombre = txtNombreNuevoProducto.getText().trim();
        String categoria = txtCategoriaNuevoProducto.getText().trim();
        String precioTexto = txtPrecioNuevoProducto.getText().trim();
        String cantidadTexto = txtCantidadNuevoProducto.getText().trim();


        if (nombre.isEmpty() || categoria.isEmpty() || precioTexto.isEmpty() || cantidadTexto.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            double precio = Double.parseDouble(precioTexto);
            int cantidad = Integer.parseInt(cantidadTexto);

            Producto nuevoProducto = new Producto(nombre, precio, categoria, cantidad);

            productos.add(nuevoProducto);
            mostrarProductosEnMesa(productosPedidoMesa1);
            JOptionPane.showMessageDialog(rootPane, "Producto agregado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

            txtNombreNuevoProducto.setText("");
            txtCategoriaNuevoProducto.setText("");
            txtPrecioNuevoProducto.setText("");
            txtCantidadNuevoProducto.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "El precio y la cantidad deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarProductoCartaActionPerformed

    private void btnModificarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProductoActionPerformed
        
        String nombreProductoActual = txtNombreProductoModificar.getText().trim();

        if (nombreProductoActual.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Primero busca un producto para modificarlo.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Producto productoEncontrado = buscarProductoPorNombre(nombreProductoActual);

        if (productoEncontrado != null) {

            String nuevoNombre = txtNombreProductoNuevo.getText().trim();
            String nuevaCategoria = txtCategoriaProductoNuevo.getText().trim();
            String nuevoPrecioTexto = txtPrecioProductoNuevo.getText().trim();
            String nuevaCantidadTexto = txtCantidadProductoNuevo.getText().trim();

            if (nuevoNombre.isEmpty() || nuevaCategoria.isEmpty() || nuevoPrecioTexto.isEmpty() || nuevaCantidadTexto.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Por favor, complete todos los campos de datos nuevos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                return;
            }

            try {
                double nuevoPrecio = Double.parseDouble(nuevoPrecioTexto);
                int nuevaCantidad = Integer.parseInt(nuevaCantidadTexto);

                productoEncontrado.setNombre(nuevoNombre);
                productoEncontrado.setCategoria(nuevaCategoria);
                productoEncontrado.setPrecio(nuevoPrecio);
                productoEncontrado.setCantidadDisponible(nuevaCantidad);

                JOptionPane.showMessageDialog(this, "Producto modificado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                mostrarProductosEnMesa(productosPedidoMesa1);
                
                txtNombreProductoModificar.setText("");
                txtNombreProductoNuevo.setText("");
                txtCategoriaProductoNuevo.setText("");
                txtCantidadProductoNuevo.setText("");
                txtPrecioProductoNuevo.setText("");
                txtNombreProductoActual.setText("");
                txtCategoriaProductoActual.setText("");
                txtPrecioProductoActual.setText("");
                txtCantidadProductoActual.setText("");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El precio y la cantidad deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnModificarProductoActionPerformed

    private void buscarProductoModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarProductoModificarActionPerformed
        String nombreProductoBuscado = txtNombreProductoModificar.getText().trim();

        if (nombreProductoBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del producto a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Producto productoEncontrado = buscarProductoPorNombre(nombreProductoBuscado);

        if (productoEncontrado != null) {
            
            txtNombreProductoActual.setText(productoEncontrado.getNombre());
            txtCategoriaProductoActual.setText(productoEncontrado.getCategoria());
            txtPrecioProductoActual.setText(String.valueOf(productoEncontrado.getPrecio()));
            txtCantidadProductoActual.setText(String.valueOf(productoEncontrado.getCantidadDisponible()));

            JOptionPane.showMessageDialog(rootPane, "Producto encontrado. Puedes proceder a modificarlo.", "Producto Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buscarProductoModificarActionPerformed

    private void btnBuscandoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscandoProductoActionPerformed
        String nombreProductoBuscado = txtNombreProductoBuscar.getText().trim();

        if (nombreProductoBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del producto a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Producto productoEncontrado = buscarProductoPorNombre(nombreProductoBuscado);

        if (productoEncontrado != null) {
            
            txtNombreProductoBuscado.setText(productoEncontrado.getNombre());
            txtCantidadProductoBuscado.setText(productoEncontrado.getCategoria());
            txtPrecioProductoBuscado.setText(String.valueOf(productoEncontrado.getPrecio()));
            txtCantidadProductoBuscado.setText(String.valueOf(productoEncontrado.getCantidadDisponible()));

            JOptionPane.showMessageDialog(rootPane, "Producto encontrado.", "Producto Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscandoProductoActionPerformed

    private void btnBuscarProductoEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoEliminarActionPerformed
        
        String nombreProductoBuscado = txtNombreProductoEliminar.getText().trim();

        if (nombreProductoBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del producto a buscar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Producto productoEncontrado = buscarProductoPorNombre(nombreProductoBuscado);

        if (productoEncontrado != null) {
            
            txtNombreProductoAEliminar.setText(productoEncontrado.getNombre());
            txtCantidadProductoAEliminar.setText(productoEncontrado.getCategoria());
            txtPrecioProductoAEliminar.setText(String.valueOf(productoEncontrado.getPrecio()));
            txtCantidadProductoAEliminar.setText(String.valueOf(productoEncontrado.getCantidadDisponible()));

            JOptionPane.showMessageDialog(rootPane, "Producto encontrado.", "Producto Encontrado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarProductoEliminarActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        
        String nombreProductoBuscado = txtNombreProductoEliminar.getText().trim();

        if (nombreProductoBuscado.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese el nombre del producto a eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Producto productoEncontrado = buscarProductoPorNombre(nombreProductoBuscado);

        if (productoEncontrado != null) {
            int confirmacion = JOptionPane.showConfirmDialog(
                    this, 
                    "¿Está seguro de que desea eliminar el producto: " + productoEncontrado.getNombre() + "?", 
                    "Confirmación de Eliminación", 
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                productos.remove(productoEncontrado); 
                mostrarProductosEnMesa(productosPedidoMesa1); 
                txtNombreProductoAEliminar.setText("");
                txtCategoriaProductoAEliminar.setText("");
                txtPrecioProductoAEliminar.setText("");
                txtCantidadProductoAEliminar.setText("");
                txtNombreProductoEliminar.setText("");

                JOptionPane.showMessageDialog(this, "Producto eliminado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void listaProductosDisponiblesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProductosDisponiblesValueChanged
        
        if (!evt.getValueIsAdjusting()) { 
            int index = listaProductosDisponibles.getSelectedIndex();
            if (index >= 0) {
                String nombreProductoSeleccionado = listaProductosDisponibles.getSelectedValue();
                Producto productoSeleccionado = buscarProductoPorNombre(nombreProductoSeleccionado);

                if (productoSeleccionado != null) {
                    txtNombreProductoDisponible.setText(productoSeleccionado.getNombre());
                    txtCategoriaProductoDisponible.setText(productoSeleccionado.getCategoria());
                    txtPrecioProductoDisponible.setText(String.valueOf(productoSeleccionado.getPrecio()));
                    txtCantidadProductoDisponible.setText(String.valueOf(productoSeleccionado.getCantidadDisponible()));
                }
            }
        }
        
    }//GEN-LAST:event_listaProductosDisponiblesValueChanged

    private void listaProductosAgotadosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaProductosAgotadosValueChanged
        if (!evt.getValueIsAdjusting()) { 
            int index = listaProductosAgotados.getSelectedIndex();
            if (index >= 0) {
                String nombreProductoSeleccionado = listaProductosAgotados.getSelectedValue();
                Producto productoSeleccionado = buscarProductoPorNombre(nombreProductoSeleccionado);

                if (productoSeleccionado != null) {
                    txtNombreProductoAgotado.setText(productoSeleccionado.getNombre());
                    txtCategoriaProductoAgotado.setText(productoSeleccionado.getCategoria());
                    txtPrecioProductoAgotado.setText(String.valueOf(productoSeleccionado.getPrecio()));
                    txtCantidadProductoAgotado.setText(String.valueOf(productoSeleccionado.getCantidadDisponible()));
                }
            }
        }
    }//GEN-LAST:event_listaProductosAgotadosValueChanged

    private void cancelarPedidoMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa3ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa3, 
            listaVerPedidosLlevarMesa3, 
            pedidosMesa3, 
            pedidosMesa3Llevar, 
            detallePedidoMesa3, 
            () -> actualizarListaPedidos(pedidosMesa3, listaVerPedidosMesa3, pedidosMesa3Llevar, listaVerPedidosLlevarMesa3), 
            () -> mostrarProductosEnMesa(productosPedidoMesa3)
        );
    }//GEN-LAST:event_cancelarPedidoMesa3ActionPerformed

    private void btnLimpiarMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa4ActionPerformed
        limpiarMesa(pedidosMesa4, pedidosMesa4Llevar, btnMesa4, 3, detallePedidoMesa4,
            () -> actualizarListaPedidos(pedidosMesa4, listaVerPedidosMesa4, pedidosMesa4Llevar, listaVerPedidosLlevarMesa4));
    }//GEN-LAST:event_btnLimpiarMesa4ActionPerformed

    private void btnLimpiarMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa5ActionPerformed
        limpiarMesa(pedidosMesa5, pedidosMesa5Llevar, btnMesa5, 4, detallePedidoMesa5, 
            () -> actualizarListaPedidos(pedidosMesa5, listaVerPedidosMesa5, pedidosMesa5Llevar, listaVerPedidosLlevarMesa5));
    }//GEN-LAST:event_btnLimpiarMesa5ActionPerformed

    private void btnLimpiarMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa6ActionPerformed
        limpiarMesa(pedidosMesa6, pedidosMesa6Llevar, btnMesa6, 5, detallePedidoMesa6, 
            () -> actualizarListaPedidos(pedidosMesa6, listaVerPedidosMesa6, pedidosMesa6Llevar, listaVerPedidosLlevarMesa6));
    }//GEN-LAST:event_btnLimpiarMesa6ActionPerformed

    private void btnLimpiarMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa7ActionPerformed
        limpiarMesa(pedidosMesa7, pedidosMesa7Llevar, btnMesa7, 6, detallePedidoMesa7, 
            () -> actualizarListaPedidos(pedidosMesa7, listaVerPedidosMesa7, pedidosMesa7Llevar, listaVerPedidosLlevarMesa7));
    }//GEN-LAST:event_btnLimpiarMesa7ActionPerformed

    private void btnLimpiarMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa8ActionPerformed
        limpiarMesa(pedidosMesa8, pedidosMesa8Llevar, btnMesa8, 7, detallePedidoMesa8, 
            () -> actualizarListaPedidos(pedidosMesa8, listaVerPedidosMesa8, pedidosMesa8Llevar, listaVerPedidosLlevarMesa8));
    }//GEN-LAST:event_btnLimpiarMesa8ActionPerformed

    private void btnLimpiarMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa9ActionPerformed
        limpiarMesa(pedidosMesa9, pedidosMesa9Llevar, btnMesa9, 8, detallePedidoMesa9, 
            () -> actualizarListaPedidos(pedidosMesa9, listaVerPedidosMesa9, pedidosMesa9Llevar, listaVerPedidosLlevarMesa9));
    }//GEN-LAST:event_btnLimpiarMesa9ActionPerformed

    private void btnLimpiarMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa10ActionPerformed
        limpiarMesa(pedidosMesa10, pedidosMesa10Llevar, btnMesa10, 9, detallePedidoMesa10, 
            () -> actualizarListaPedidos(pedidosMesa10, listaVerPedidosMesa10, pedidosMesa10Llevar, listaVerPedidosLlevarMesa10));
    }//GEN-LAST:event_btnLimpiarMesa10ActionPerformed

    private void btnLimpiarMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa11ActionPerformed
        limpiarMesa(pedidosMesa11, pedidosMesa11Llevar, btnMesa11, 10, detallePedidoMesa11,
            () -> actualizarListaPedidos(pedidosMesa11, listaVerPedidosMesa11, pedidosMesa11Llevar, listaVerPedidosLlevarMesa11));
    }//GEN-LAST:event_btnLimpiarMesa11ActionPerformed

    private void btnLimpiarMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarMesa12ActionPerformed
        limpiarMesa(pedidosMesa12, pedidosMesa12Llevar, btnMesa12, 11, detallePedidoMesa12, 
            () -> actualizarListaPedidos(pedidosMesa12, listaVerPedidosMesa12, pedidosMesa12Llevar, listaVerPedidosLlevarMesa12));
    }//GEN-LAST:event_btnLimpiarMesa12ActionPerformed

    private void cancelarPedidoMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarPedidoMesa2ActionPerformed
        cancelarPedido(
            listaVerPedidosMesa2, 
            listaVerPedidosLlevarMesa2, 
            pedidosMesa2, 
            pedidosMesa2Llevar, 
            detallePedidoMesa2, 
            () -> actualizarListaPedidos(pedidosMesa2, listaVerPedidosMesa2, pedidosMesa2Llevar, listaVerPedidosLlevarMesa2), 
            () -> mostrarProductosEnMesa(productosPedidoMesa2)
        );
    }//GEN-LAST:event_cancelarPedidoMesa2ActionPerformed

    private void btnBorrarProductoPedidoMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa2ActionPerformed
        int index = listaPedidosMesa2.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa2.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa2.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa2, listaPedidosMesa2);
                cargarProductosEnLista2();
                mostrarProductosEnMesa(productosPedidoMesa2);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa2ActionPerformed

    private void btnBorrarProductoPedidoMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa3ActionPerformed
        int index = listaPedidosMesa3.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa3.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa3.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa3, listaPedidosMesa3);
                cargarProductosEnLista3();
                mostrarProductosEnMesa(productosPedidoMesa3);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa3ActionPerformed

    private void btnBorrarProductoPedidoMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa4ActionPerformed
        int index = listaPedidosMesa4.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa4.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa4.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa4, listaPedidosMesa4);
                cargarProductosEnLista4();
                mostrarProductosEnMesa(productosPedidoMesa4);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa4ActionPerformed

    private void btnBorrarProductoPedidoMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa5ActionPerformed
        int index = listaPedidosMesa5.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa5.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa5.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa5, listaPedidosMesa5);
                cargarProductosEnLista5();
                mostrarProductosEnMesa(productosPedidoMesa5);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa5ActionPerformed

    private void btnBorrarProductoPedidoMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa6ActionPerformed
        int index = listaPedidosMesa6.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa6.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa6.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa6, listaPedidosMesa6);
                cargarProductosEnLista6();
                mostrarProductosEnMesa(productosPedidoMesa6);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa6ActionPerformed

    private void btnBorrarProductoPedidoMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa7ActionPerformed
        int index = listaPedidosMesa7.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa7.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa7.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa7, listaPedidosMesa7);
                cargarProductosEnLista7();
                mostrarProductosEnMesa(productosPedidoMesa7);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa7ActionPerformed

    private void btnBorrarProductoPedidoMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa8ActionPerformed
        int index = listaPedidosMesa8.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa8.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa8.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa8, listaPedidosMesa8);
                cargarProductosEnLista8();
                mostrarProductosEnMesa(productosPedidoMesa8);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa8ActionPerformed

    private void btnBorrarProductoPedidoMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa9ActionPerformed
        int index = listaPedidosMesa9.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa9.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa9.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa9, listaPedidosMesa9);
                cargarProductosEnLista9();
                mostrarProductosEnMesa(productosPedidoMesa9);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa9ActionPerformed

    private void btnBorrarProductoPedidoMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa10ActionPerformed
        int index = listaPedidosMesa10.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa10.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa10.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa10, listaPedidosMesa10);
                cargarProductosEnLista10();
                mostrarProductosEnMesa(productosPedidoMesa10);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa10ActionPerformed

    private void btnBorrarProductoPedidoMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa11ActionPerformed
        int index = listaPedidosMesa11.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa11.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa11.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa11, listaPedidosMesa11);
                cargarProductosEnLista11();
                mostrarProductosEnMesa(productosPedidoMesa11);
                
                JOptionPane.showMessageDialog(rootPane, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa11ActionPerformed

    private void btnBorrarProductoPedidoMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProductoPedidoMesa12ActionPerformed
        int index = listaPedidosMesa12.getSelectedIndex(); 
        if (index >= 0) {
            
            String productoTexto = listaPedidosMesa12.getSelectedValue();
            
            String[] partes = productoTexto.split(" - Cantidad: ");
            if (partes.length == 2) {
                String nombreProducto = partes[0].trim();
                int cantidadProducto = Integer.parseInt(partes[1].trim());

                
                for (Producto producto : productos) {
                    if (producto.getNombre().equals(nombreProducto)) {
                        producto.setCantidadDisponible(producto.getCantidadDisponible() + cantidadProducto);
                        break;
                    }
                }

                
                pedidoMesa12.getListaProductos().remove(index);

                actualizarListaProductosDelPedido(pedidoMesa12, listaPedidosMesa12);
                cargarProductosEnLista12();
                mostrarProductosEnMesa(productosPedidoMesa12);
                
                JOptionPane.showMessageDialog(this, "Producto eliminado del pedido y cantidad devuelta a la lista de productos.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al parsear la cantidad del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un producto para eliminar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarProductoPedidoMesa12ActionPerformed

    private void productosPedidoMesa2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa2ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa2, listaPedidosMesa2);
    }//GEN-LAST:event_productosPedidoMesa2ValueChanged

    private void listaPedidosMesa2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa2ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa2, productosPedidoMesa2);
    }//GEN-LAST:event_listaPedidosMesa2ValueChanged

    private void productosPedidoMesa3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa3ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa3, listaPedidosMesa3);
    }//GEN-LAST:event_productosPedidoMesa3ValueChanged

    private void listaPedidosMesa3ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa3ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa3, productosPedidoMesa3);
    }//GEN-LAST:event_listaPedidosMesa3ValueChanged

    private void productosPedidoMesa4ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa4ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa4, listaPedidosMesa4);
    }//GEN-LAST:event_productosPedidoMesa4ValueChanged

    private void listaPedidosMesa4ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa4ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa4, productosPedidoMesa4);
    }//GEN-LAST:event_listaPedidosMesa4ValueChanged

    private void productosPedidoMesa5ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa5ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa5, listaPedidosMesa5);
    }//GEN-LAST:event_productosPedidoMesa5ValueChanged

    private void listaPedidosMesa5ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa5ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa5, productosPedidoMesa5);
    }//GEN-LAST:event_listaPedidosMesa5ValueChanged

    private void productosPedidoMesa6ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa6ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa6, listaPedidosMesa6);
    }//GEN-LAST:event_productosPedidoMesa6ValueChanged

    private void listaPedidosMesa6ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa6ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa6, productosPedidoMesa6);
    }//GEN-LAST:event_listaPedidosMesa6ValueChanged

    private void productosPedidoMesa7ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa7ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa7, listaPedidosMesa7);
    }//GEN-LAST:event_productosPedidoMesa7ValueChanged

    private void listaPedidosMesa7ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa7ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa7, productosPedidoMesa7);
    }//GEN-LAST:event_listaPedidosMesa7ValueChanged

    private void productosPedidoMesa8ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa8ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa8, listaPedidosMesa8);
    }//GEN-LAST:event_productosPedidoMesa8ValueChanged

    private void listaPedidosMesa8ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa8ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa8, productosPedidoMesa8);
    }//GEN-LAST:event_listaPedidosMesa8ValueChanged

    private void productosPedidoMesa9ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa9ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa9, listaPedidosMesa9);
    }//GEN-LAST:event_productosPedidoMesa9ValueChanged

    private void listaPedidosMesa9ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa9ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa9, productosPedidoMesa9);
    }//GEN-LAST:event_listaPedidosMesa9ValueChanged

    private void productosPedidoMesa10ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa10ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa10, listaPedidosMesa10);
    }//GEN-LAST:event_productosPedidoMesa10ValueChanged

    private void listaPedidosMesa10ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa10ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa10, productosPedidoMesa10);
    }//GEN-LAST:event_listaPedidosMesa10ValueChanged

    private void productosPedidoMesa11ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa11ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa11, listaPedidosMesa11);
    }//GEN-LAST:event_productosPedidoMesa11ValueChanged

    private void listaPedidosMesa11ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa11ValueChanged
        cambioSeleccionVerPedidos(listaPedidosMesa11, productosPedidoMesa11);
    }//GEN-LAST:event_listaPedidosMesa11ValueChanged

    private void productosPedidoMesa12ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productosPedidoMesa12ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa12, productosPedidoMesa12);
    }//GEN-LAST:event_productosPedidoMesa12ValueChanged

    private void listaPedidosMesa12ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaPedidosMesa12ValueChanged
        cambioSeleccionVerPedidos(productosPedidoMesa12, listaPedidosMesa12);
    }//GEN-LAST:event_listaPedidosMesa12ValueChanged

    private void btnGenerarReciboMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa2ActionPerformed
        
        generarRecibo(1, pedidosMesa2, pedidosMesa2Llevar, btnLimpiarMesa2);
    }//GEN-LAST:event_btnGenerarReciboMesa2ActionPerformed

    private void btnGenerarReciboMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa3ActionPerformed
     
        generarRecibo(2, pedidosMesa3, pedidosMesa3Llevar, btnLimpiarMesa3);
    }//GEN-LAST:event_btnGenerarReciboMesa3ActionPerformed

    private void btnGenerarReciboMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa4ActionPerformed
        
        generarRecibo(3, pedidosMesa4, pedidosMesa4Llevar, btnLimpiarMesa4);
    }//GEN-LAST:event_btnGenerarReciboMesa4ActionPerformed

    private void btnGenerarReciboMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa5ActionPerformed
        
        generarRecibo(4, pedidosMesa5, pedidosMesa5Llevar, btnLimpiarMesa5);
    }//GEN-LAST:event_btnGenerarReciboMesa5ActionPerformed

    private void btnGenerarReciboMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa6ActionPerformed
        
        generarRecibo(5, pedidosMesa6, pedidosMesa6Llevar, btnLimpiarMesa6);
    }//GEN-LAST:event_btnGenerarReciboMesa6ActionPerformed

    private void btnGenerarReciboMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa7ActionPerformed
        
        generarRecibo(6, pedidosMesa7, pedidosMesa7Llevar, btnLimpiarMesa7);
    }//GEN-LAST:event_btnGenerarReciboMesa7ActionPerformed

    private void btnGenerarReciboMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa8ActionPerformed
        
        generarRecibo(7, pedidosMesa8, pedidosMesa8Llevar, btnLimpiarMesa8);
    }//GEN-LAST:event_btnGenerarReciboMesa8ActionPerformed

    private void btnGenerarReciboMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa9ActionPerformed
        
        generarRecibo(8, pedidosMesa9, pedidosMesa9Llevar, btnLimpiarMesa9);
    }//GEN-LAST:event_btnGenerarReciboMesa9ActionPerformed

    private void btnGenerarReciboMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa10ActionPerformed
        
        generarRecibo(9, pedidosMesa10, pedidosMesa10Llevar, btnLimpiarMesa10);
    }//GEN-LAST:event_btnGenerarReciboMesa10ActionPerformed

    private void btnGenerarReciboMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa11ActionPerformed
        
        generarRecibo(10, pedidosMesa11, pedidosMesa11Llevar, btnLimpiarMesa11);
    }//GEN-LAST:event_btnGenerarReciboMesa11ActionPerformed

    private void btnGenerarReciboMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReciboMesa12ActionPerformed
        
        generarRecibo(11, pedidosMesa12, pedidosMesa12Llevar, btnLimpiarMesa12);
    }//GEN-LAST:event_btnGenerarReciboMesa12ActionPerformed

    private double calcularTotalGananciasGlobal() {
        double total = 0;
        
        for (Producto producto : productosVendidos) {
            total += producto.getCantidad() * producto.getPrecio();
        }
        
        return total;
    }

    private int calcularCantidadProductosVendidosGlobal() {

        int totalCantidad = 0;

        for (Producto producto : productosVendidos) {
            totalCantidad += producto.getCantidad();
        }

        return totalCantidad;

    }
    
    private void btnGenerarReporteDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteDiaActionPerformed
        String fechaTexto = txtFechaGenerarReporte.getText().trim();
        String nombre = txtNombreGenerarReporte.getText().trim();

        if (fechaTexto.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, complete todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha = formatoFecha.parse(fechaTexto);

            double totalGanancias = calcularTotalGananciasGlobal();
            int cantidadProductosVendidos = calcularCantidadProductosVendidosGlobal();

            Reporte nuevoReporte = new Reporte(fecha, nombre, totalGanancias, cantidadProductosVendidos);
            GestionReportes.agregarReporte(nuevoReporte);

            JOptionPane.showMessageDialog(rootPane, "Reporte generado correctamente.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);

            txtFechaGenerarReporte.setText("");
            txtNombreGenerarReporte.setText("");

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(rootPane, "La fecha debe estar en formato dd/MM/yyyy.", "Formato de fecha incorrecto", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnGenerarReporteDiaActionPerformed

    private void txtFechaGenerarReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaGenerarReporteMouseClicked
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("dd/MM/yyyy");

        JDialog dialogoFecha = new JDialog(this, "Seleccionar Fecha", true);
        dialogoFecha.setLayout(new BorderLayout());
        dialogoFecha.add(dateChooser, BorderLayout.CENTER);

        JButton btnAceptar = new JButton("Aceptar");
        dialogoFecha.add(btnAceptar, BorderLayout.SOUTH);

        btnAceptar.addActionListener(e -> {
            
            Date fechaSeleccionada = dateChooser.getDate();
            if (fechaSeleccionada != null) {
                
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                String fechaFormateada = formatoFecha.format(fechaSeleccionada);
                
                txtFechaGenerarReporte.setText(fechaFormateada);
            }
            dialogoFecha.dispose();
        });

        dialogoFecha.setSize(200, 100);
        dialogoFecha.setLocationRelativeTo(this);
        dialogoFecha.setVisible(true);
    }//GEN-LAST:event_txtFechaGenerarReporteMouseClicked
    
    private void actualizarListaProductosDelPedido(Pedido pedidoMesa, JList<String> listaPedidosMesa) {
        DefaultListModel<String> modeloPedido = new DefaultListModel<>();
        for (Producto producto : pedidoMesa.getListaProductos()) {
            modeloPedido.addElement(producto.getNombre() + " - Cantidad: " + producto.getCantidadDisponible());
        }
        listaPedidosMesa.setModel(modeloPedido);
    }
    
    private void cargarProductosDesdeArchivo(File archivo) {
        productos.clear(); 

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombre = partes[0].trim();
                double precio = Double.parseDouble(partes[1].trim());
                String categoria = partes[2].trim();
                int cantidadDisponible = Integer.parseInt(partes[3].trim());

                Producto producto = new Producto(nombre, precio, categoria,cantidadDisponible);
                productos.add(producto);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(rootPane, "Error al leer el archivo de productos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validarArchivoProductos(File archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean tieneDatos = false;

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes.length != 4) {
                    return false;
                }

                try {
                    Double.parseDouble(partes[1].trim());
                } catch (NumberFormatException e) {
                    return false;
                }

       
                try {
                    Integer.parseInt(partes[3].trim());
                } catch (NumberFormatException e) {
                    return false;
                }

                tieneDatos = true; 
            }

            return tieneDatos;
        } catch (IOException e) {
            return false;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProductoCarta;
    private javax.swing.JButton btnAgregarProductoPedidoMesa1;
    private javax.swing.JButton btnAgregarProductoPedidoMesa10;
    private javax.swing.JButton btnAgregarProductoPedidoMesa11;
    private javax.swing.JButton btnAgregarProductoPedidoMesa12;
    private javax.swing.JButton btnAgregarProductoPedidoMesa2;
    private javax.swing.JButton btnAgregarProductoPedidoMesa3;
    private javax.swing.JButton btnAgregarProductoPedidoMesa4;
    private javax.swing.JButton btnAgregarProductoPedidoMesa5;
    private javax.swing.JButton btnAgregarProductoPedidoMesa6;
    private javax.swing.JButton btnAgregarProductoPedidoMesa7;
    private javax.swing.JButton btnAgregarProductoPedidoMesa8;
    private javax.swing.JButton btnAgregarProductoPedidoMesa9;
    private javax.swing.JButton btnBorrarProductoPedidoMesa1;
    private javax.swing.JButton btnBorrarProductoPedidoMesa10;
    private javax.swing.JButton btnBorrarProductoPedidoMesa11;
    private javax.swing.JButton btnBorrarProductoPedidoMesa12;
    private javax.swing.JButton btnBorrarProductoPedidoMesa2;
    private javax.swing.JButton btnBorrarProductoPedidoMesa3;
    private javax.swing.JButton btnBorrarProductoPedidoMesa4;
    private javax.swing.JButton btnBorrarProductoPedidoMesa5;
    private javax.swing.JButton btnBorrarProductoPedidoMesa6;
    private javax.swing.JButton btnBorrarProductoPedidoMesa7;
    private javax.swing.JButton btnBorrarProductoPedidoMesa8;
    private javax.swing.JButton btnBorrarProductoPedidoMesa9;
    private javax.swing.JButton btnBuscandoProducto;
    private javax.swing.JButton btnBuscarProductoEliminar;
    private javax.swing.JButton btnBuscarRutaMesas;
    private javax.swing.JButton btnBuscarRutaProductos;
    private javax.swing.JButton btnCargarMesas;
    private javax.swing.JButton btnCargarProductos;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGenerarReciboMesa1;
    private javax.swing.JButton btnGenerarReciboMesa10;
    private javax.swing.JButton btnGenerarReciboMesa11;
    private javax.swing.JButton btnGenerarReciboMesa12;
    private javax.swing.JButton btnGenerarReciboMesa2;
    private javax.swing.JButton btnGenerarReciboMesa3;
    private javax.swing.JButton btnGenerarReciboMesa4;
    private javax.swing.JButton btnGenerarReciboMesa5;
    private javax.swing.JButton btnGenerarReciboMesa6;
    private javax.swing.JButton btnGenerarReciboMesa7;
    private javax.swing.JButton btnGenerarReciboMesa8;
    private javax.swing.JButton btnGenerarReciboMesa9;
    private javax.swing.JButton btnGenerarReporteDia;
    private javax.swing.JButton btnLimpiarMesa1;
    private javax.swing.JButton btnLimpiarMesa10;
    private javax.swing.JButton btnLimpiarMesa11;
    private javax.swing.JButton btnLimpiarMesa12;
    private javax.swing.JButton btnLimpiarMesa2;
    private javax.swing.JButton btnLimpiarMesa3;
    private javax.swing.JButton btnLimpiarMesa4;
    private javax.swing.JButton btnLimpiarMesa5;
    private javax.swing.JButton btnLimpiarMesa6;
    private javax.swing.JButton btnLimpiarMesa7;
    private javax.swing.JButton btnLimpiarMesa8;
    private javax.swing.JButton btnLimpiarMesa9;
    private javax.swing.JButton btnMesa1;
    private javax.swing.JButton btnMesa10;
    private javax.swing.JButton btnMesa11;
    private javax.swing.JButton btnMesa12;
    private javax.swing.JButton btnMesa2;
    private javax.swing.JButton btnMesa3;
    private javax.swing.JButton btnMesa4;
    private javax.swing.JButton btnMesa5;
    private javax.swing.JButton btnMesa6;
    private javax.swing.JButton btnMesa7;
    private javax.swing.JButton btnMesa8;
    private javax.swing.JButton btnMesa9;
    private javax.swing.JButton btnModificarProducto;
    private javax.swing.JButton btnRealizarPedidoMesa1;
    private javax.swing.JButton btnRealizarPedidoMesa10;
    private javax.swing.JButton btnRealizarPedidoMesa11;
    private javax.swing.JButton btnRealizarPedidoMesa12;
    private javax.swing.JButton btnRealizarPedidoMesa2;
    private javax.swing.JButton btnRealizarPedidoMesa3;
    private javax.swing.JButton btnRealizarPedidoMesa4;
    private javax.swing.JButton btnRealizarPedidoMesa5;
    private javax.swing.JButton btnRealizarPedidoMesa6;
    private javax.swing.JButton btnRealizarPedidoMesa7;
    private javax.swing.JButton btnRealizarPedidoMesa8;
    private javax.swing.JButton btnRealizarPedidoMesa9;
    private javax.swing.JButton btnTotalCuentaMesa1;
    private javax.swing.JButton btnTotalCuentaMesa10;
    private javax.swing.JButton btnTotalCuentaMesa11;
    private javax.swing.JButton btnTotalCuentaMesa12;
    private javax.swing.JButton btnTotalCuentaMesa2;
    private javax.swing.JButton btnTotalCuentaMesa3;
    private javax.swing.JButton btnTotalCuentaMesa4;
    private javax.swing.JButton btnTotalCuentaMesa5;
    private javax.swing.JButton btnTotalCuentaMesa6;
    private javax.swing.JButton btnTotalCuentaMesa7;
    private javax.swing.JButton btnTotalCuentaMesa8;
    private javax.swing.JButton btnTotalCuentaMesa9;
    private javax.swing.JButton btnVerInfoMesa1;
    private javax.swing.JButton btnVerInfoMesa10;
    private javax.swing.JButton btnVerInfoMesa11;
    private javax.swing.JButton btnVerInfoMesa12;
    private javax.swing.JButton btnVerInfoMesa2;
    private javax.swing.JButton btnVerInfoMesa3;
    private javax.swing.JButton btnVerInfoMesa4;
    private javax.swing.JButton btnVerInfoMesa5;
    private javax.swing.JButton btnVerInfoMesa6;
    private javax.swing.JButton btnVerInfoMesa7;
    private javax.swing.JButton btnVerInfoMesa8;
    private javax.swing.JButton btnVerInfoMesa9;
    private javax.swing.JButton btnVerPedidosMesa1;
    private javax.swing.JButton btnVerPedidosMesa10;
    private javax.swing.JButton btnVerPedidosMesa11;
    private javax.swing.JButton btnVerPedidosMesa12;
    private javax.swing.JButton btnVerPedidosMesa2;
    private javax.swing.JButton btnVerPedidosMesa3;
    private javax.swing.JButton btnVerPedidosMesa4;
    private javax.swing.JButton btnVerPedidosMesa5;
    private javax.swing.JButton btnVerPedidosMesa6;
    private javax.swing.JButton btnVerPedidosMesa7;
    private javax.swing.JButton btnVerPedidosMesa8;
    private javax.swing.JButton btnVerPedidosMesa9;
    private javax.swing.JButton buscarProductoModificar;
    private javax.swing.JButton cancelarPedidoMesa1;
    private javax.swing.JButton cancelarPedidoMesa10;
    private javax.swing.JButton cancelarPedidoMesa11;
    private javax.swing.JButton cancelarPedidoMesa12;
    private javax.swing.JButton cancelarPedidoMesa2;
    private javax.swing.JButton cancelarPedidoMesa3;
    private javax.swing.JButton cancelarPedidoMesa4;
    private javax.swing.JButton cancelarPedidoMesa5;
    private javax.swing.JButton cancelarPedidoMesa6;
    private javax.swing.JButton cancelarPedidoMesa7;
    private javax.swing.JButton cancelarPedidoMesa8;
    private javax.swing.JButton cancelarPedidoMesa9;
    private javax.swing.JList<String> detallePedidoMesa1;
    private javax.swing.JList<String> detallePedidoMesa10;
    private javax.swing.JList<String> detallePedidoMesa11;
    private javax.swing.JList<String> detallePedidoMesa12;
    private javax.swing.JList<String> detallePedidoMesa2;
    private javax.swing.JList<String> detallePedidoMesa3;
    private javax.swing.JList<String> detallePedidoMesa4;
    private javax.swing.JList<String> detallePedidoMesa5;
    private javax.swing.JList<String> detallePedidoMesa6;
    private javax.swing.JList<String> detallePedidoMesa7;
    private javax.swing.JList<String> detallePedidoMesa8;
    private javax.swing.JList<String> detallePedidoMesa9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanelMostrar;
    private javax.swing.JPanel jPanelMostrarMesa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane53;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane55;
    private javax.swing.JScrollPane jScrollPane56;
    private javax.swing.JScrollPane jScrollPane57;
    private javax.swing.JScrollPane jScrollPane58;
    private javax.swing.JScrollPane jScrollPane59;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane60;
    private javax.swing.JScrollPane jScrollPane61;
    private javax.swing.JScrollPane jScrollPane62;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> listaPedidosMesa1;
    private javax.swing.JList<String> listaPedidosMesa10;
    private javax.swing.JList<String> listaPedidosMesa11;
    private javax.swing.JList<String> listaPedidosMesa12;
    private javax.swing.JList<String> listaPedidosMesa2;
    private javax.swing.JList<String> listaPedidosMesa3;
    private javax.swing.JList<String> listaPedidosMesa4;
    private javax.swing.JList<String> listaPedidosMesa5;
    private javax.swing.JList<String> listaPedidosMesa6;
    private javax.swing.JList<String> listaPedidosMesa7;
    private javax.swing.JList<String> listaPedidosMesa8;
    private javax.swing.JList<String> listaPedidosMesa9;
    private javax.swing.JList<String> listaProductosAgotados;
    private javax.swing.JList<String> listaProductosDisponibles;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa1;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa10;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa11;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa12;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa2;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa3;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa4;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa5;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa6;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa7;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa8;
    private javax.swing.JList<String> listaVerPedidosLlevarMesa9;
    private javax.swing.JList<String> listaVerPedidosMesa1;
    private javax.swing.JList<String> listaVerPedidosMesa10;
    private javax.swing.JList<String> listaVerPedidosMesa11;
    private javax.swing.JList<String> listaVerPedidosMesa12;
    private javax.swing.JList<String> listaVerPedidosMesa2;
    private javax.swing.JList<String> listaVerPedidosMesa3;
    private javax.swing.JList<String> listaVerPedidosMesa4;
    private javax.swing.JList<String> listaVerPedidosMesa5;
    private javax.swing.JList<String> listaVerPedidosMesa6;
    private javax.swing.JList<String> listaVerPedidosMesa7;
    private javax.swing.JList<String> listaVerPedidosMesa8;
    private javax.swing.JList<String> listaVerPedidosMesa9;
    private javax.swing.JButton mDisponible;
    private javax.swing.JButton mNoDisponible;
    private javax.swing.JButton mOcupada;
    private javax.swing.JMenuItem menItemAgreProducto;
    private javax.swing.JMenuItem menItemBuscProducto;
    private javax.swing.JMenuItem menItemCargarMesas;
    private javax.swing.JMenuItem menItemCargarProductos;
    private javax.swing.JMenuItem menItemCerrarSesion;
    private javax.swing.JMenuItem menItemElimProducto;
    private javax.swing.JMenuItem menItemGenerarReporte;
    private javax.swing.JMenuItem menItemGestionarMesas;
    private javax.swing.JMenuItem menItemModProducto;
    private javax.swing.JMenuItem menItemProducDAgotados;
    private javax.swing.JMenuItem menItemProducDisponibles;
    private javax.swing.JMenu menuGenerarReporte;
    private javax.swing.JMenu menuMesas;
    private javax.swing.JMenu menuMesero;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JPanel panelAgreProducto;
    private javax.swing.JPanel panelBuscProducto;
    private javax.swing.JPanel panelCargarMesas;
    private javax.swing.JPanel panelCargarProductos;
    private javax.swing.JPanel panelCerrarSesion;
    private javax.swing.JPanel panelElimProducto;
    private javax.swing.JPanel panelGenerarReporte;
    private javax.swing.JPanel panelGestionarMesas;
    private javax.swing.JPanel panelMesa1;
    private javax.swing.JPanel panelMesa10;
    private javax.swing.JPanel panelMesa11;
    private javax.swing.JPanel panelMesa12;
    private javax.swing.JPanel panelMesa2;
    private javax.swing.JPanel panelMesa3;
    private javax.swing.JPanel panelMesa4;
    private javax.swing.JPanel panelMesa5;
    private javax.swing.JPanel panelMesa6;
    private javax.swing.JPanel panelMesa7;
    private javax.swing.JPanel panelMesa8;
    private javax.swing.JPanel panelMesa9;
    private javax.swing.JPanel panelModProducto;
    private javax.swing.JPanel panelProducAgotados;
    private javax.swing.JPanel panelProducDisponibles;
    private javax.swing.JList<String> productosPedidoMesa1;
    private javax.swing.JList<String> productosPedidoMesa10;
    private javax.swing.JList<String> productosPedidoMesa11;
    private javax.swing.JList<String> productosPedidoMesa12;
    private javax.swing.JList<String> productosPedidoMesa2;
    private javax.swing.JList<String> productosPedidoMesa3;
    private javax.swing.JList<String> productosPedidoMesa4;
    private javax.swing.JList<String> productosPedidoMesa5;
    private javax.swing.JList<String> productosPedidoMesa6;
    private javax.swing.JList<String> productosPedidoMesa7;
    private javax.swing.JList<String> productosPedidoMesa8;
    private javax.swing.JList<String> productosPedidoMesa9;
    private javax.swing.JTextField txtCantidadNuevoProducto;
    private javax.swing.JTextField txtCantidadProductoAEliminar;
    private javax.swing.JTextField txtCantidadProductoActual;
    private javax.swing.JTextField txtCantidadProductoAgotado;
    private javax.swing.JTextField txtCantidadProductoBuscado;
    private javax.swing.JTextField txtCantidadProductoDisponible;
    private javax.swing.JTextField txtCantidadProductoNuevo;
    private javax.swing.JTextField txtCategoriaNuevoProducto;
    private javax.swing.JTextField txtCategoriaProductoAEliminar;
    private javax.swing.JTextField txtCategoriaProductoActual;
    private javax.swing.JTextField txtCategoriaProductoAgotado;
    private javax.swing.JTextField txtCategoriaProductoBuscado;
    private javax.swing.JTextField txtCategoriaProductoDisponible;
    private javax.swing.JTextField txtCategoriaProductoNuevo;
    private javax.swing.JTextField txtCodigoGenerado;
    private javax.swing.JTextField txtEstadoArchivoMesas;
    private javax.swing.JTextField txtEstadoArchivoProductos;
    private javax.swing.JTextField txtFechaGenerarReporte;
    private javax.swing.JTextField txtIngresarCodigo;
    private javax.swing.JTextField txtNombreGenerarReporte;
    private javax.swing.JTextField txtNombreNuevoProducto;
    private javax.swing.JTextField txtNombreProductoAEliminar;
    private javax.swing.JTextField txtNombreProductoActual;
    private javax.swing.JTextField txtNombreProductoAgotado;
    private javax.swing.JTextField txtNombreProductoBuscado;
    private javax.swing.JTextField txtNombreProductoBuscar;
    private javax.swing.JTextField txtNombreProductoDisponible;
    private javax.swing.JTextField txtNombreProductoEliminar;
    private javax.swing.JTextField txtNombreProductoModificar;
    private javax.swing.JTextField txtNombreProductoNuevo;
    private javax.swing.JTextField txtPrecioNuevoProducto;
    private javax.swing.JTextField txtPrecioProductoAEliminar;
    private javax.swing.JTextField txtPrecioProductoActual;
    private javax.swing.JTextField txtPrecioProductoAgotado;
    private javax.swing.JTextField txtPrecioProductoBuscado;
    private javax.swing.JTextField txtPrecioProductoDisponible;
    private javax.swing.JTextField txtPrecioProductoNuevo;
    private javax.swing.JTextField txtRutaArchivoMesas;
    private javax.swing.JTextField txtRutaArchivoProductos;
    private javax.swing.JPanel verPedidoMesa1;
    private javax.swing.JPanel verPedidoMesa10;
    private javax.swing.JPanel verPedidoMesa11;
    private javax.swing.JPanel verPedidoMesa12;
    private javax.swing.JPanel verPedidoMesa2;
    private javax.swing.JPanel verPedidoMesa3;
    private javax.swing.JPanel verPedidoMesa4;
    private javax.swing.JPanel verPedidoMesa5;
    private javax.swing.JPanel verPedidoMesa6;
    private javax.swing.JPanel verPedidoMesa7;
    private javax.swing.JPanel verPedidoMesa8;
    private javax.swing.JPanel verPedidoMesa9;
    private javax.swing.JButton volverAtrasMesa1;
    private javax.swing.JButton volverAtrasMesa10;
    private javax.swing.JButton volverAtrasMesa11;
    private javax.swing.JButton volverAtrasMesa12;
    private javax.swing.JButton volverAtrasMesa2;
    private javax.swing.JButton volverAtrasMesa3;
    private javax.swing.JButton volverAtrasMesa4;
    private javax.swing.JButton volverAtrasMesa5;
    private javax.swing.JButton volverAtrasMesa6;
    private javax.swing.JButton volverAtrasMesa7;
    private javax.swing.JButton volverAtrasMesa8;
    private javax.swing.JButton volverAtrasMesa9;
    // End of variables declaration//GEN-END:variables
}
