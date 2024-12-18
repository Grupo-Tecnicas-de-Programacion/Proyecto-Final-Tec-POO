
package visual;

import clases.Usuario;
//import clases.Mesero;
//import clases.Administrador;
import javax.swing.JOptionPane;

public class InicioSesion extends javax.swing.JFrame {

    private String rol;
    
    public InicioSesion(String rol) {
        this.setUndecorated(true);
        initComponents();
        this.rol = rol;
        this.setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombreUsuario = new javax.swing.JLabel();
        txtNombreUsuarioIniciarSesion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnIngresarInicioSesion = new javax.swing.JButton();
        btnCambiarContrasenia = new javax.swing.JButton();
        btnVolverAtrasInicioSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtContraseniaIniciarSesion = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreUsuario.setText("Nombre de usuario");
        jPanel1.add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 170, 26));

        txtNombreUsuarioIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtNombreUsuarioIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 315, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 150, 26));

        btnIngresarInicioSesion.setBackground(new java.awt.Color(134, 43, 13));
        btnIngresarInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnIngresarInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresarInicioSesion.setText("Ingresar");
        btnIngresarInicioSesion.setToolTipText("");
        btnIngresarInicioSesion.setBorderPainted(false);
        btnIngresarInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarInicioSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresarInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 140, 60));

        btnCambiarContrasenia.setBackground(new java.awt.Color(153, 77, 28));
        btnCambiarContrasenia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCambiarContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarContrasenia.setText("Cambiar contraseña");
        btnCambiarContrasenia.setBorderPainted(false);
        btnCambiarContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseniaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 210, 50));

        btnVolverAtrasInicioSesion.setBackground(new java.awt.Color(228, 143, 69));
        btnVolverAtrasInicioSesion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnVolverAtrasInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverAtrasInicioSesion.setText("Volver atras");
        btnVolverAtrasInicioSesion.setBorderPainted(false);
        btnVolverAtrasInicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAtrasInicioSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverAtrasInicioSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(107, 36, 12));
        jLabel1.setText("INICIO DE SESIÓN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        txtContraseniaIniciarSesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtContraseniaIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 310, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverAtrasInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasInicioSesionActionPerformed
        new Bievenida().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasInicioSesionActionPerformed

    private void btnIngresarInicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarInicioSesionActionPerformed
        String nombreUsuario = txtNombreUsuarioIniciarSesion.getText();
        String contrasenia = new String(txtContraseniaIniciarSesion.getPassword());

        Usuario usuario = Usuario.autenticarUsuario(nombreUsuario, contrasenia);

        if (usuario != null) {
            if (!usuario.isEstaActivo()) {
                JOptionPane.showMessageDialog(rootPane, "La cuenta está desactivada. Contacte al administrador.", "Cuenta desactivada", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (rol.equals("ADMINISTRADOR") && usuario.getRol().equals("ADMINISTRADOR")) {
                new JframeAdministrador().setVisible(true);
            } else if (rol.equals("MESERO") && usuario.getRol().equals("MESERO")) {
                new JframeMesero().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No tienes permiso para iniciar sesión con esta cuenta", "Acceso denegado", JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.dispose();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nombre de usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarInicioSesionActionPerformed

    private void btnCambiarContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseniaActionPerformed
        new CambiarContraseña().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCambiarContraseniaActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarContrasenia;
    private javax.swing.JButton btnIngresarInicioSesion;
    private javax.swing.JButton btnVolverAtrasInicioSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JPasswordField txtContraseniaIniciarSesion;
    private javax.swing.JTextField txtNombreUsuarioIniciarSesion;
    // End of variables declaration//GEN-END:variables
}
