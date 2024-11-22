
package visual;

import clases.Usuario;
import javax.swing.JOptionPane;


public class Registrarse extends javax.swing.JFrame {

    public Registrarse() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        btnRegistrarsse = new javax.swing.JButton();
        jLabel77 = new javax.swing.JLabel();
        txtRegistrarNombreUsuario = new javax.swing.JTextField();
        btnVolverAtras = new javax.swing.JButton();
        txtRegistrarContrasenia = new javax.swing.JPasswordField();
        txtRegistrarConfirmarContrasenia = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 0, 0));
        jLabel72.setText("REGISTRATE");
        jPanel1.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 170, 40));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 0, 0));
        jLabel75.setText("Nombre de usaurio");
        jPanel1.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 150, 30));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 0, 0));
        jLabel76.setText("Confirmar contraseña");
        jPanel1.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 170, 30));

        btnRegistrarsse.setBackground(new java.awt.Color(107, 36, 12));
        btnRegistrarsse.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarsse.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarsse.setText("Registrarme");
        btnRegistrarsse.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRegistrarsse.setBorderPainted(false);
        btnRegistrarsse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarsseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarsse, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 160, 100));

        jLabel77.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 0, 0));
        jLabel77.setText("Contraseña");
        jPanel1.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 243, 110, 30));

        txtRegistrarNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtRegistrarNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 160, 40));

        btnVolverAtras.setBackground(new java.awt.Color(153, 77, 28));
        btnVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolverAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverAtras.setText("Volver atrás");
        btnVolverAtras.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnVolverAtras.setBorderPainted(false);
        btnVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 160, 40));

        txtRegistrarContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtRegistrarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 160, 40));

        txtRegistrarConfirmarContrasenia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtRegistrarConfirmarContrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarsseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarsseActionPerformed
        
        String nombreUsuario = txtRegistrarNombreUsuario.getText().trim();
        String contrasenia = new String(txtRegistrarContrasenia.getPassword()).trim();
        String confirmarContrasenia = new String(txtRegistrarConfirmarContrasenia.getPassword()).trim();

        if (nombreUsuario.isEmpty() || contrasenia.isEmpty() || confirmarContrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!contrasenia.equals(confirmarContrasenia)) {
            JOptionPane.showMessageDialog(this, "La contraseña y la confirmación deben ser iguales.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] opciones = {"Mesero", "Administrador"};
        int seleccion = JOptionPane.showOptionDialog(
            this,
            "¿Qué rol tiene el usuario?",
            "Seleccionar rol",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (seleccion == JOptionPane.CLOSED_OPTION) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un rol para registrar al usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String rol = (seleccion == 0) ? "MESERO" : "ADMINISTRADOR";

        boolean exito = Usuario.registrarUsuario(nombreUsuario, contrasenia, confirmarContrasenia, rol);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Usuario registrado como " + rol + " exitosamente.");
            txtRegistrarNombreUsuario.setText("");
            txtRegistrarContrasenia.setText("");
            txtRegistrarConfirmarContrasenia.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario. El nombre de usuario ya existe o ocurrió un problema.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnRegistrarsseActionPerformed

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        new Bievenida().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarsse;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtRegistrarConfirmarContrasenia;
    private javax.swing.JPasswordField txtRegistrarContrasenia;
    private javax.swing.JTextField txtRegistrarNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
