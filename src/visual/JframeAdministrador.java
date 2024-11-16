
package visual;


import java.awt.CardLayout;
import javax.swing.JOptionPane;
import clases.GestionReportes;
import clases.Reporte;
import clases.Usuario;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.Timer;

public class JframeAdministrador extends javax.swing.JFrame {

    private Usuario usuarioActual;
    
    public JframeAdministrador(Usuario usuarioActual) {
        initComponents();
        jPanelMostrarAdmin.add(panelEliminarUsuarios, "panelEliminarUsuarios");
        jPanelMostrarAdmin.add(panelAgregarUsuarios, "panelAgregarUsuarios");
        jPanelMostrarAdmin.add(panelGestionarUsuarios, "panelGestionarUsuarios");
        jPanelMostrarAdmin.add(panelReporteVentas, "panelReporteVentas");
        jPanelMostrarAdmin.add(panelCerrarSesion, "panelCerrarSesion");
        this.usuarioActual = usuarioActual;
        setTitle("Panel de Administración - " + usuarioActual.getNombreUsuario());
        cargarListaDeMeseros(listMeseros, listMeseroActualizados, listGestionMeseros);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMostrarAdmin = new javax.swing.JPanel();
        panelEliminarUsuarios = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listMeseros = new javax.swing.JList<>();
        btnEliminarMesero = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtContraseñaAdministrador = new javax.swing.JPasswordField();
        jLabel46 = new javax.swing.JLabel();
        panelAgregarUsuarios = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        btnAgregarMesero = new javax.swing.JButton();
        txtUsuarioNuevoMesero = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        listMeseroActualizados = new javax.swing.JList<>();
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

        panelEliminarUsuarios.setBackground(new java.awt.Color(153, 153, 153));
        panelEliminarUsuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelEliminarUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 2, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("DESACTIVAR CUENTA DEL MESERO");
        panelEliminarUsuarios.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        listMeseros.setBackground(new java.awt.Color(204, 204, 204));
        listMeseros.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane7.setViewportView(listMeseros);

        panelEliminarUsuarios.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 96, 197, 340));

        btnEliminarMesero.setBackground(new java.awt.Color(0, 153, 0));
        btnEliminarMesero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarMesero.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminarMesero.setText("Desactivar cuenta mesero");
        btnEliminarMesero.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnEliminarMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMeseroActionPerformed(evt);
            }
        });
        panelEliminarUsuarios.add(btnEliminarMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 200, 60));

        jLabel34.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 0, 0));
        jLabel34.setText("Ingrese la contraseña para desactivar la cuenta :");
        panelEliminarUsuarios.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, 30));

        txtContraseñaAdministrador.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtContraseñaAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaAdministradorActionPerformed(evt);
            }
        });
        panelEliminarUsuarios.add(txtContraseñaAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 150, 30));

        jLabel46.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 0, 0));
        jLabel46.setText("Lista de meseros");
        panelEliminarUsuarios.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 69, -1, 20));

        jPanelMostrarAdmin.add(panelEliminarUsuarios, "card6");

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

        listMeseroActualizados.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane9.setViewportView(listMeseroActualizados);

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
        panelReporteVentas.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabel81.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 0, 0));
        jLabel81.setText("Desde :");
        panelReporteVentas.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, -1));
        panelReporteVentas.add(txtFechaInicioReporteBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 158, -1));

        jLabel82.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 0, 0));
        jLabel82.setText("Hasta :");
        panelReporteVentas.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));
        panelReporteVentas.add(txtFechaFinalReporteBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 158, -1));

        listaReportesEncontrados.setBackground(new java.awt.Color(255, 204, 51));
        jScrollPane18.setViewportView(listaReportesEncontrados);

        panelReporteVentas.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 206, 240));

        jLabel83.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 0, 0));
        jLabel83.setText("Reportes encontrados");
        panelReporteVentas.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        btnBuscarReportes.setBackground(new java.awt.Color(102, 102, 0));
        btnBuscarReportes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscarReportes.setText("Buscar reportes");
        btnBuscarReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarReportesActionPerformed(evt);
            }
        });
        panelReporteVentas.add(btnBuscarReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, -1, 60));

        jLabel85.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 0, 0));
        jLabel85.setText("Visualizacion del reporte seleccionado");
        panelReporteVentas.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, -1, -1));

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

        panelReporteVentas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 290, 340));

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

        menItemEliminarUsuario.setText("Eliminar Usuario");
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
                .addComponent(jPanelMostrarAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
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
        String fechaDesde = txtFechaInicioReporteBuscar.getText().trim();
        String fechaHasta = txtFechaFinalReporteBuscar.getText().trim();

        if (!fechaDesde.matches("\\d{2}/\\d{2}/\\d{4}") || !fechaHasta.matches("\\d{2}/\\d{2}/\\d{4}")) {
            JOptionPane.showMessageDialog(rootPane, "Las fechas deben estar en formato dd/MM/yyyy.", "Formato de fecha incorrecto", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (fechaDesde.isEmpty() || fechaHasta.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese ambas fechas para buscar reportes.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DefaultListModel<String> modeloReportes = new DefaultListModel<>();
        for (Reporte reporte : GestionReportes.getListaReportes()) {
            if (reporte.getFecha().compareTo(fechaDesde) >= 0 && reporte.getFecha().compareTo(fechaHasta) <= 0) {
                modeloReportes.addElement(reporte.getNombre() + " - Fecha: " + reporte.getFecha());
            }
        }

        if (modeloReportes.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "No se encontraron reportes en el rango de fechas especificado.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }

        listaReportesEncontrados.setModel(modeloReportes);
    }//GEN-LAST:event_btnBuscarReportesActionPerformed

    private void btnVerReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReporteActionPerformed
        int index = listaReportesEncontrados.getSelectedIndex();

        if (index >= 0) {
            String reporteSeleccionado = listaReportesEncontrados.getSelectedValue();
            String nombreReporte = reporteSeleccionado.split(" -")[0].trim();

            Reporte reporte = buscarReportePorNombre(nombreReporte);

            if (reporte != null) {
                txtNombreReporteSeleccionado.setText(reporte.getNombre());
                txtFechaReporteSeleccionado.setText(reporte.getFecha());
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

    private void cargarListaDeMeseros(JList listaMeseros, JList listaMeseroActualizados, JList listaGestionMeseros) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Usuario usuario : Usuario.getListaUsuarios()) {
            if (usuario.getRol().equals("MESERO")) {
                modelo.addElement(usuario.getNombreUsuario());
            }
        }
        listaMeseros.setModel(modelo);
        listaMeseroActualizados.setModel(modelo);
        listaGestionMeseros.setModel(modelo);
    }

    
    private void btnEliminarMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMeseroActionPerformed
        
        String nombreMeseroSeleccionado = listMeseros.getSelectedValue();
        if (nombreMeseroSeleccionado == null) {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un mesero de la lista para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String contraseniaAdmin = new String(txtContraseñaAdministrador.getPassword());

        if (!usuarioActual.getContrasenia().equals(contraseniaAdmin)) {
            JOptionPane.showMessageDialog(rootPane, "Contraseña incorrecta. No se puede eliminar el mesero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (int i = 0; i < Usuario.getListaUsuarios().size(); i++) {
            Usuario usuario = Usuario.getListaUsuarios().get(i);
            if (usuario.getNombreUsuario().equals(nombreMeseroSeleccionado) && usuario.getRol().equals("MESERO")) {
                Usuario.getListaUsuarios().remove(i);
                JOptionPane.showMessageDialog(rootPane, "Mesero eliminado con éxito.");
                cargarListaDeMeseros(listMeseros, listMeseroActualizados, listGestionMeseros); 
                return;
            }
        }

        JOptionPane.showMessageDialog(rootPane, "No se pudo encontrar el mesero para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_btnEliminarMeseroActionPerformed

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

        for (Usuario usuario : Usuario.getListaUsuarios()) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                JOptionPane.showMessageDialog(rootPane, "El nombre de usuario ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        Usuario nuevoMesero = new Usuario(nombreUsuario, contrasenia, "MESERO");
        Usuario.getListaUsuarios().add(nuevoMesero);

        JOptionPane.showMessageDialog(rootPane, "Mesero agregado con éxito.");

        txtUsuarioNuevoMesero.setText("");
        txtContraseñaNuevoMesero.setText("");
        txtConfirmarContraseñaNuevoMesero.setText("");

        cargarListaDeMeseros(listMeseros, listMeseroActualizados, listGestionMeseros);
    }//GEN-LAST:event_btnAgregarMeseroActionPerformed
    
    private void txtContraseñaAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaAdministradorActionPerformed

    private Reporte buscarReportePorNombre(String nombreReporte) {
        for (Reporte reporte : GestionReportes.getListaReportes()) {
            if (reporte.getNombre().equalsIgnoreCase(nombreReporte)) {
                return reporte;
            }
        }
        return null;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarMesero;
    private javax.swing.JButton btnBuscarReportes;
    private javax.swing.JButton btnCerrarSesionAdmnistrador;
    private javax.swing.JButton btnEliminarMesero;
    private javax.swing.JButton btnVerReporte;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel34;
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
    private javax.swing.JList<String> listMeseroActualizados;
    private javax.swing.JList<String> listMeseros;
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
    private javax.swing.JPanel panelEliminarUsuarios;
    private javax.swing.JPanel panelReporteVentas;
    private javax.swing.JTextField txtCantidadReporteSeleccionado;
    private javax.swing.JTextField txtCodigoGenerado;
    private javax.swing.JPasswordField txtConfirmarContraseñaNuevoMesero;
    private javax.swing.JPasswordField txtContraseñaAdministrador;
    private javax.swing.JPasswordField txtContraseñaNuevoMesero;
    private javax.swing.JTextField txtFechaFinalReporteBuscar;
    private javax.swing.JTextField txtFechaInicioReporteBuscar;
    private javax.swing.JTextField txtFechaReporteSeleccionado;
    private javax.swing.JTextField txtGananciaReporteSeleccionado;
    private javax.swing.JTextField txtIngreseCodigoGenerado;
    private javax.swing.JTextField txtNombreReporteSeleccionado;
    private javax.swing.JTextField txtUsuarioNuevoMesero;
    // End of variables declaration//GEN-END:variables
}
