
package visual;


import java.awt.CardLayout;
import javax.swing.JOptionPane;
import clases.GestionReportes;
import clases.Reporte;
import clases.Usuario;
import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.Timer;

public class JframeAdministrador extends javax.swing.JFrame {

    private Usuario usuarioActual;
    
    public JframeAdministrador(Usuario usuarioActual) {
        initComponents();
        jPanelMostrarAdmin.add(panelGestionMeseros, "panelEliminarUsuarios");
        jPanelMostrarAdmin.add(panelAgregarUsuarios, "panelAgregarUsuarios");
        jPanelMostrarAdmin.add(panelReporteVentas, "panelReporteVentas");
        jPanelMostrarAdmin.add(panelCerrarSesion, "panelCerrarSesion");
        this.usuarioActual = usuarioActual;
        setTitle("Panel de Administración - " + usuarioActual.getNombreUsuario());
        cargarListaDeMeseros(listaMeserosGestionar, listMeserosAgregar);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMostrarAdmin = new javax.swing.JPanel();
        panelGestionMeseros = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listaMeserosGestionar = new javax.swing.JList<>();
        btnDesactivarCuentaMesero = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        btnActivarCuentaMesero = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEstadoCuentaMesero = new javax.swing.JTextField();
        panelAgregarUsuarios = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnAgregarMesero = new javax.swing.JButton();
        txtUsuarioNuevoMesero = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        listMeserosAgregar = new javax.swing.JList<>();
        txtConfirmarContraseñaNuevoMesero = new javax.swing.JPasswordField();
        txtContraseñaNuevoMesero = new javax.swing.JPasswordField();
        panelReporteVentas = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        txtFechaInicioReporteBuscar = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        txtFechaFinalReporteBuscar = new javax.swing.JTextField();
        jScrollPane18 = new javax.swing.JScrollPane();
        listaReportesEncontrados = new javax.swing.JList<>();
        jLabel83 = new javax.swing.JLabel();
        btnBuscarReportes = new javax.swing.JButton();
        jLabel85 = new javax.swing.JLabel();
        btnVerReporte = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        txtGananciaReporteSeleccionado = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        txtFechaReporteSeleccionado = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txtCantidadReporteSeleccionado = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        txtNombreReporteSeleccionado = new javax.swing.JTextField();
        panelCerrarSesion = new javax.swing.JPanel();
        jLabel86 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtIngreseCodigoGenerado = new javax.swing.JTextField();
        btnCerrarSesionAdmnistrador = new javax.swing.JButton();
        txtCodigoGenerado = new javax.swing.JTextField();
        jMenuAdmin = new javax.swing.JMenuBar();
        menuUsuarios = new javax.swing.JMenu();
        menItemEliminarUsuario = new javax.swing.JMenuItem();
        menItemAgregarUsuario = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();
        menItemReporteVentas = new javax.swing.JMenuItem();
        menuCerrar = new javax.swing.JMenu();
        menItemCerrarSecsion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMostrarAdmin.setPreferredSize(new java.awt.Dimension(500, 500));
        jPanelMostrarAdmin.setLayout(new java.awt.CardLayout());

        panelGestionMeseros.setBackground(new java.awt.Color(153, 153, 153));
        panelGestionMeseros.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelGestionMeseros.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("GESTIÓN CUENTAS MESEROS");
        panelGestionMeseros.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        listaMeserosGestionar.setBackground(new java.awt.Color(204, 204, 204));
        listaMeserosGestionar.setForeground(new java.awt.Color(0, 0, 0));
        listaMeserosGestionar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaMeserosGestionarValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(listaMeserosGestionar);

        panelGestionMeseros.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 197, 300));

        btnDesactivarCuentaMesero.setBackground(new java.awt.Color(153, 0, 0));
        btnDesactivarCuentaMesero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDesactivarCuentaMesero.setForeground(new java.awt.Color(0, 0, 0));
        btnDesactivarCuentaMesero.setText("Desactivar cuenta mesero");
        btnDesactivarCuentaMesero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDesactivarCuentaMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesactivarCuentaMeseroActionPerformed(evt);
            }
        });
        panelGestionMeseros.add(btnDesactivarCuentaMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, 200, 60));

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Lista de meseros");
        panelGestionMeseros.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 20));

        btnActivarCuentaMesero.setBackground(new java.awt.Color(0, 153, 0));
        btnActivarCuentaMesero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActivarCuentaMesero.setForeground(new java.awt.Color(0, 0, 0));
        btnActivarCuentaMesero.setText("Activar cuenta mesero");
        btnActivarCuentaMesero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnActivarCuentaMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActivarCuentaMeseroActionPerformed(evt);
            }
        });
        panelGestionMeseros.add(btnActivarCuentaMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, 200, 60));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Estado de cuenta");
        panelGestionMeseros.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, -1, 30));
        panelGestionMeseros.add(txtEstadoCuentaMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, 150, 40));

        jPanelMostrarAdmin.add(panelGestionMeseros, "card6");

        panelAgregarUsuarios.setBackground(new java.awt.Color(153, 153, 153));
        panelAgregarUsuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelAgregarUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 0, 0));
        jLabel35.setText("AGREGAR MESERO");
        panelAgregarUsuarios.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 0, 0));
        jLabel39.setText("Nombre de usuario ");
        panelAgregarUsuarios.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 0, 0));
        jLabel40.setText("Contraseña ");
        panelAgregarUsuarios.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, -1, -1));

        jLabel41.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 0, 0));
        jLabel41.setText("Confirmacion de contraseña ");
        panelAgregarUsuarios.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

        btnAgregarMesero.setBackground(new java.awt.Color(0, 153, 0));
        btnAgregarMesero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarMesero.setForeground(new java.awt.Color(0, 0, 0));
        btnAgregarMesero.setText("Agregar mesero");
        btnAgregarMesero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnAgregarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMeseroActionPerformed(evt);
            }
        });
        panelAgregarUsuarios.add(btnAgregarMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 150, 50));
        panelAgregarUsuarios.add(txtUsuarioNuevoMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 233, -1));

        jLabel45.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 0, 0));
        jLabel45.setText("Lista de meseros");
        panelAgregarUsuarios.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, -1));

        listMeserosAgregar.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane9.setViewportView(listMeserosAgregar);

        panelAgregarUsuarios.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 151, 188, 269));
        panelAgregarUsuarios.add(txtConfirmarContraseñaNuevoMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 170, 30));
        panelAgregarUsuarios.add(txtContraseñaNuevoMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 170, 30));

        jPanelMostrarAdmin.add(panelAgregarUsuarios, "card7");

        panelReporteVentas.setBackground(new java.awt.Color(153, 153, 153));
        panelReporteVentas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelReporteVentas.setPreferredSize(new java.awt.Dimension(850, 500));
        panelReporteVentas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel79.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 0, 0));
        jLabel79.setText("REPORTE DE VENTAS");
        panelReporteVentas.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 24, 293, -1));

        jLabel80.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 0, 0));
        jLabel80.setText("Rango de fecha para ver los reportes");
        panelReporteVentas.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel81.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 0, 0));
        jLabel81.setText("Desde :");
        panelReporteVentas.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));

        txtFechaInicioReporteBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaInicioReporteBuscarMouseClicked(evt);
            }
        });
        panelReporteVentas.add(txtFechaInicioReporteBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 158, -1));

        jLabel82.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        jLabel82.setText("Hasta :");
        panelReporteVentas.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        txtFechaFinalReporteBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtFechaFinalReporteBuscarMouseClicked(evt);
            }
        });
        panelReporteVentas.add(txtFechaFinalReporteBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 158, -1));

        listaReportesEncontrados.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane18.setViewportView(listaReportesEncontrados);

        panelReporteVentas.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 206, 240));

        jLabel83.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 0));
        jLabel83.setText("Reportes encontrados");
        panelReporteVentas.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        btnBuscarReportes.setBackground(new java.awt.Color(102, 102, 0));
        btnBuscarReportes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarReportes.setText("Buscar reportes");
        btnBuscarReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarReportesActionPerformed(evt);
            }
        });
        panelReporteVentas.add(btnBuscarReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, -1, 60));

        jLabel85.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        jLabel85.setText("Visualizacion del reporte seleccionado");
        panelReporteVentas.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        btnVerReporte.setBackground(new java.awt.Color(102, 102, 0));
        btnVerReporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerReporte.setText("Ver reporte");
        btnVerReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReporteActionPerformed(evt);
            }
        });
        panelReporteVentas.add(btnVerReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 110, 50));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setText("Cantidad de productos vendidos");
        jPanel1.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 170, 30));
        jPanel1.add(txtGananciaReporteSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 150, 30));

        jLabel52.setText("Fecha del reporte");
        jPanel1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 108, 30));
        jPanel1.add(txtFechaReporteSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 150, 30));

        jLabel59.setText("Total ganancia");
        jPanel1.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, 30));
        jPanel1.add(txtCantidadReporteSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 150, 30));

        jLabel62.setText("Nombre");
        jPanel1.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 50, 30));
        jPanel1.add(txtNombreReporteSeleccionado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 150, 30));

        panelReporteVentas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 290, 340));

        jPanelMostrarAdmin.add(panelReporteVentas, "card11");

        panelCerrarSesion.setBackground(new java.awt.Color(102, 102, 102));
        panelCerrarSesion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelCerrarSesion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel86.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 0, 0));
        jLabel86.setText("CERRAR SESION");
        panelCerrarSesion.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(306, 44, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("Ingresar el codigo generado :");
        panelCerrarSesion.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 113, -1, -1));

        jLabel31.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("Codigo generado :");
        panelCerrarSesion.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 150, -1, -1));

        jLabel43.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 0, 0));
        jLabel43.setText("Ingresar codigo :");
        panelCerrarSesion.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 209, 136, -1));
        panelCerrarSesion.add(txtIngreseCodigoGenerado, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 233, 202, -1));

        btnCerrarSesionAdmnistrador.setBackground(new java.awt.Color(204, 0, 0));
        btnCerrarSesionAdmnistrador.setText("Cerrar sesion");
        btnCerrarSesionAdmnistrador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnCerrarSesionAdmnistrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionAdmnistradorActionPerformed(evt);
            }
        });
        panelCerrarSesion.add(btnCerrarSesionAdmnistrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(634, 175, 113, 64));

        txtCodigoGenerado.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        panelCerrarSesion.add(txtCodigoGenerado, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 175, 202, -1));

        jPanelMostrarAdmin.add(panelCerrarSesion, "card13");

        jMenuAdmin.setPreferredSize(new java.awt.Dimension(850, 51));

        menuUsuarios.setText("Usuarios");
        menuUsuarios.setPreferredSize(new java.awt.Dimension(122, 50));

        menItemEliminarUsuario.setText("Desactivar usuario");
        menItemEliminarUsuario.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemEliminarUsuarioActionPerformed(evt);
            }
        });
        menuUsuarios.add(menItemEliminarUsuario);

        menItemAgregarUsuario.setText("Agregar Usuario");
        menItemAgregarUsuario.setPreferredSize(new java.awt.Dimension(180, 40));
        menItemAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemAgregarUsuarioActionPerformed(evt);
            }
        });
        menuUsuarios.add(menItemAgregarUsuario);

        jMenuAdmin.add(menuUsuarios);

        menuReportes.setText("Reportes");
        menuReportes.setPreferredSize(new java.awt.Dimension(122, 50));

        menItemReporteVentas.setText("Reporte Ventas");
        menItemReporteVentas.setPreferredSize(new java.awt.Dimension(180, 30));
        menItemReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemReporteVentasActionPerformed(evt);
            }
        });
        menuReportes.add(menItemReporteVentas);

        jMenuAdmin.add(menuReportes);

        menuCerrar.setText("Cerrar");
        menuCerrar.setPreferredSize(new java.awt.Dimension(122, 50));

        menItemCerrarSecsion.setText("Cerrar Sesion");
        menItemCerrarSecsion.setPreferredSize(new java.awt.Dimension(180, 30));
        menItemCerrarSecsion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menItemCerrarSecsionActionPerformed(evt);
            }
        });
        menuCerrar.add(menItemCerrarSecsion);

        jMenuAdmin.add(menuCerrar);

        setJMenuBar(jMenuAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelMostrarAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 887, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMostrarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menItemCerrarSecsionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemCerrarSecsionActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrarAdmin.getLayout();
        layout.show(jPanelMostrarAdmin, "panelCerrarSesion");
        int numeroCerrarSesion = (int)( Math.random()*90000) + 10000;
        txtCodigoGenerado.setText(String.valueOf(numeroCerrarSesion));
    }//GEN-LAST:event_menItemCerrarSecsionActionPerformed

    private void menItemReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemReporteVentasActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrarAdmin.getLayout();
        layout.show(jPanelMostrarAdmin, "panelReporteVentas");
    }//GEN-LAST:event_menItemReporteVentasActionPerformed

    private void menItemEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemEliminarUsuarioActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrarAdmin.getLayout();
        layout.show(jPanelMostrarAdmin, "panelEliminarUsuarios");
    }//GEN-LAST:event_menItemEliminarUsuarioActionPerformed
    
    private void btnCerrarSesionAdmnistradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionAdmnistradorActionPerformed
        String numeroGenerado = txtCodigoGenerado.getText();
        String numeroIngresado = txtIngreseCodigoGenerado.getText();
        if (numeroIngresado.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Ingrese el numero generado", "Error", JOptionPane.WARNING_MESSAGE);
        }else if(numeroGenerado.equalsIgnoreCase(numeroIngresado)){
            Object[] opciones = {"Si" , "No"};
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
            
            if (seleccion == JOptionPane.YES_OPTION)
            {
                new Bievenida().setVisible(true);
                this.dispose();
            }
        }else
        {
            JOptionPane.showMessageDialog(rootPane, "Número ingresado incorrecto, Intentar otra vez." , "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCerrarSesionAdmnistradorActionPerformed

    private void btnBuscarReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarReportesActionPerformed
        String fechaDesdeTexto = txtFechaInicioReporteBuscar.getText().trim();
        String fechaHastaTexto = txtFechaFinalReporteBuscar.getText().trim();

        if (fechaDesdeTexto.isEmpty() || fechaHastaTexto.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese ambas fechas para buscar reportes.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaDesde = formatoFecha.parse(fechaDesdeTexto);
            Date fechaHasta = formatoFecha.parse(fechaHastaTexto);

            DefaultListModel<String> modeloReportes = new DefaultListModel<>();

            for (Reporte reporte : GestionReportes.getListaReportes()) {
                if (!reporte.getFecha().before(fechaDesde) && !reporte.getFecha().after(fechaHasta)) {
                    modeloReportes.addElement(reporte.getNombre() + " - Fecha: " + formatoFecha.format(reporte.getFecha()));
                }
            }

            if (modeloReportes.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "No se encontraron reportes en el rango de fechas especificado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

            listaReportesEncontrados.setModel(modeloReportes);

        } catch (ParseException e) {
            JOptionPane.showMessageDialog(rootPane, "Las fechas deben estar en formato dd/MM/yyyy.", "Formato de fecha incorrecto", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarReportesActionPerformed

    private void btnVerReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReporteActionPerformed
        
        int index = listaReportesEncontrados.getSelectedIndex();

        if (index >= 0) {

            String reporteSeleccionado = listaReportesEncontrados.getSelectedValue();
            String nombreReporte = reporteSeleccionado.split(" - Fecha:")[0].trim();

            Reporte reporte = buscarReportePorNombre(nombreReporte);

            if (reporte != null) {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

                txtNombreReporteSeleccionado.setText(reporte.getNombre());
                txtFechaReporteSeleccionado.setText(formatoFecha.format(reporte.getFecha()));
                txtCantidadReporteSeleccionado.setText(String.valueOf(reporte.getCantidadProductosVendidos()));
                txtGananciaReporteSeleccionado.setText(String.format("S/ %.2f", reporte.getTotalGanancias()));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error al cargar el reporte.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Por favor, seleccione un reporte de la lista.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnVerReporteActionPerformed

    private void menItemAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItemAgregarUsuarioActionPerformed
        CardLayout layout = (CardLayout) jPanelMostrarAdmin.getLayout();
        layout.show(jPanelMostrarAdmin, "panelAgregarUsuarios");
    }//GEN-LAST:event_menItemAgregarUsuarioActionPerformed

    private void cargarListaDeMeseros(JList listaMeseros, JList listaMeseroActualizados) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
    
        List<String> nombresMeseros = Usuario.obtenerNombresMeseros();
        for (String nombreMesero : nombresMeseros) {
            modelo.addElement(nombreMesero);
        }

        listaMeseros.setModel(modelo);
        listaMeseroActualizados.setModel(modelo);
    }

    
    private void btnAgregarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMeseroActionPerformed
        
        String nombreUsuario = txtUsuarioNuevoMesero.getText().trim();
        String contrasenia = new String(txtContraseñaNuevoMesero.getPassword());
        String confirmarContrasenia = new String(txtConfirmarContraseñaNuevoMesero.getPassword());

        if (nombreUsuario.isEmpty() || contrasenia.isEmpty() || confirmarContrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!contrasenia.equals(confirmarContrasenia)) {
            JOptionPane.showMessageDialog(rootPane, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean exito = Usuario.registrarUsuario(nombreUsuario, contrasenia, confirmarContrasenia, "MESERO");

        if (exito) {
            JOptionPane.showMessageDialog(rootPane, "Mesero registrado con éxito.");
            cargarListaDeMeseros(listaMeserosGestionar, listMeserosAgregar);
            txtUsuarioNuevoMesero.setText("");
            txtContraseñaNuevoMesero.setText("");
            txtConfirmarContraseñaNuevoMesero.setText("");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error al registrar el mesero. El nombre de usuario ya existe o las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarMeseroActionPerformed
    
    private void activardesactivarCuenta(boolean activar){
        
        String nombreMeseroSeleccionado = listaMeserosGestionar.getSelectedValue();
        if (nombreMeseroSeleccionado == null) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un mesero de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String mensajeConfirmacion = activar ? "activar" : "desactivar";
        String contraseniaAdmin = JOptionPane.showInputDialog(rootPane, 
            "Ingrese su contraseña para " + mensajeConfirmacion + " la cuenta:", 
            "Confirmación", JOptionPane.WARNING_MESSAGE);

        if (contraseniaAdmin == null || contraseniaAdmin.trim().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar la contraseña del administrador.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean exito = Usuario.activarDesactivarCuenta(nombreMeseroSeleccionado, contraseniaAdmin, activar);
        if (exito) {
            if (activar) {
                JOptionPane.showMessageDialog(rootPane, "La cuenta ha sido activada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                txtEstadoCuentaMesero.setText("Activa");
            } else {
                JOptionPane.showMessageDialog(rootPane, "La cuenta ha sido desactivada con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                txtEstadoCuentaMesero.setText("Inactiva");
            }
            listaMeserosGestionar.clearSelection();
        } else {
            JOptionPane.showMessageDialog(rootPane, 
                (activar ? "No se pudo activar la cuenta." : "No se pudo desactivar la cuenta.") + " Verifique los datos.", 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void btnActivarCuentaMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActivarCuentaMeseroActionPerformed
        
        activardesactivarCuenta(true);
    }//GEN-LAST:event_btnActivarCuentaMeseroActionPerformed

    private void btnDesactivarCuentaMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesactivarCuentaMeseroActionPerformed
        
        activardesactivarCuenta(false);
    }//GEN-LAST:event_btnDesactivarCuentaMeseroActionPerformed

    private void listaMeserosGestionarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaMeserosGestionarValueChanged
        String nombreMeseroSeleccionado = listaMeserosGestionar.getSelectedValue();
        if (nombreMeseroSeleccionado == null) {
            txtEstadoCuentaMesero.setText("");
            return;
        }

        String estado = Usuario.obtenerEstadoUsuario(nombreMeseroSeleccionado);
        txtEstadoCuentaMesero.setText(estado);
    }//GEN-LAST:event_listaMeserosGestionarValueChanged

    private void buscarFecha(JTextField txtMostrarFecha){
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
                
                txtMostrarFecha.setText(fechaFormateada);
            }
            dialogoFecha.dispose();
        });

        dialogoFecha.setSize(200, 100);
        dialogoFecha.setLocationRelativeTo(this);
        dialogoFecha.setVisible(true);
    }
    
    private void txtFechaInicioReporteBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaInicioReporteBuscarMouseClicked
        buscarFecha(txtFechaInicioReporteBuscar);
    }//GEN-LAST:event_txtFechaInicioReporteBuscarMouseClicked

    private void txtFechaFinalReporteBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtFechaFinalReporteBuscarMouseClicked
        buscarFecha(txtFechaFinalReporteBuscar);
    }//GEN-LAST:event_txtFechaFinalReporteBuscarMouseClicked
    
    private Reporte buscarReportePorNombre(String nombreReporte) {
        for (Reporte reporte : GestionReportes.getListaReportes()) {
            if (reporte.getNombre().equalsIgnoreCase(nombreReporte)) {
                return reporte;
            }
        }
        return null;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActivarCuentaMesero;
    private javax.swing.JButton btnAgregarMesero;
    private javax.swing.JButton btnBuscarReportes;
    private javax.swing.JButton btnCerrarSesionAdmnistrador;
    private javax.swing.JButton btnDesactivarCuentaMesero;
    private javax.swing.JButton btnVerReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JMenuBar jMenuAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelMostrarAdmin;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JList<String> listMeserosAgregar;
    private javax.swing.JList<String> listaMeserosGestionar;
    private javax.swing.JList<String> listaReportesEncontrados;
    private javax.swing.JMenuItem menItemAgregarUsuario;
    private javax.swing.JMenuItem menItemCerrarSecsion;
    private javax.swing.JMenuItem menItemEliminarUsuario;
    private javax.swing.JMenuItem menItemReporteVentas;
    private javax.swing.JMenu menuCerrar;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JPanel panelAgregarUsuarios;
    private javax.swing.JPanel panelCerrarSesion;
    private javax.swing.JPanel panelGestionMeseros;
    private javax.swing.JPanel panelReporteVentas;
    private javax.swing.JTextField txtCantidadReporteSeleccionado;
    private javax.swing.JTextField txtCodigoGenerado;
    private javax.swing.JPasswordField txtConfirmarContraseñaNuevoMesero;
    private javax.swing.JPasswordField txtContraseñaNuevoMesero;
    private javax.swing.JTextField txtEstadoCuentaMesero;
    private javax.swing.JTextField txtFechaFinalReporteBuscar;
    private javax.swing.JTextField txtFechaInicioReporteBuscar;
    private javax.swing.JTextField txtFechaReporteSeleccionado;
    private javax.swing.JTextField txtGananciaReporteSeleccionado;
    private javax.swing.JTextField txtIngreseCodigoGenerado;
    private javax.swing.JTextField txtNombreReporteSeleccionado;
    private javax.swing.JTextField txtUsuarioNuevoMesero;
    // End of variables declaration//GEN-END:variables
}
