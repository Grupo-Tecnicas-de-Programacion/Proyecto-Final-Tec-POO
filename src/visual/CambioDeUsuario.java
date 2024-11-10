
package visual;

import clases.Usuario;
import javax.swing.JOptionPane;

public class CambioDeUsuario extends javax.swing.JFrame {

    public CambioDeUsuario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        iblCambioDeUsuario = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        txtNombreDeUsuario = new javax.swing.JTextField();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        txtNuevoNombreDeUsuario = new javax.swing.JTextField();
        btnActualizarNombreUsuario = new javax.swing.JButton();
        btnVolverAtras = new javax.swing.JButton();
        txtContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iblCambioDeUsuario.setBackground(new java.awt.Color(204, 204, 204));
        iblCambioDeUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        iblCambioDeUsuario.setForeground(new java.awt.Color(0, 0, 0));
        iblCambioDeUsuario.setText("CAMBIAR NOMBRE DE USUARIO");
        jPanel1.add(iblCambioDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, 60));

        jLabel98.setForeground(new java.awt.Color(0, 0, 0));
        jLabel98.setText("Ingrese nombre de usuario :");
        jPanel1.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));
        jPanel1.add(txtNombreDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 400, -1));

        jLabel99.setForeground(new java.awt.Color(0, 0, 0));
        jLabel99.setText("Ingrese su contraseña :");
        jPanel1.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        jLabel100.setForeground(new java.awt.Color(0, 0, 0));
        jLabel100.setText("Ingrese su nuevo nombre de usuario :");
        jPanel1.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));
        jPanel1.add(txtNuevoNombreDeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 400, -1));

        btnActualizarNombreUsuario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarNombreUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizarNombreUsuario.setText("Actualizar usuario");
        btnActualizarNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarNombreUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, 40));

        btnVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVolverAtras.setForeground(new java.awt.Color(0, 0, 0));
        btnVolverAtras.setText("Volver atras");
        btnVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, -1, 40));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 400, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarNombreUsuarioActionPerformed
        String nombreUsuario = txtNombreDeUsuario.getText();
        String contrasenia = new String(txtContraseña.getPassword());
        String nuevoNombreUsuario = txtNuevoNombreDeUsuario.getText();

        for (Usuario usuario : Usuario.getListaUsuarios()) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                boolean exito = usuario.cambiarNombreUsuario(contrasenia, nuevoNombreUsuario);
                if (exito) {
                    JOptionPane.showMessageDialog(this, "Nombre de usuario actualizado con éxito.");
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta. No se pudo actualizar el nombre de usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnActualizarNombreUsuarioActionPerformed

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        new Bievenida().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarNombreUsuario;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JLabel iblCambioDeUsuario;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JTextField txtNombreDeUsuario;
    private javax.swing.JTextField txtNuevoNombreDeUsuario;
    // End of variables declaration//GEN-END:variables
}
