
package visual;

import clases.Usuario;
import javax.swing.JOptionPane;

public class CambiarContraseña extends javax.swing.JFrame {

    public CambiarContraseña() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombreUsuarioCambiarContraseña = new javax.swing.JTextField();
        btnVolverAtras = new javax.swing.JButton();
        btnCambiarContraseña = new javax.swing.JButton();
        txtAntiguaContraseña = new javax.swing.JPasswordField();
        txtNuevaContraseña = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 102));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nueva contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        txtNombreUsuarioCambiarContraseña.setColumns(12);
        txtNombreUsuarioCambiarContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtNombreUsuarioCambiarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 179, 40));

        btnVolverAtras.setBackground(new java.awt.Color(134, 43, 13));
        btnVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolverAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnVolverAtras.setText("Volver atrás");
        btnVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, -1, 40));

        btnCambiarContraseña.setBackground(new java.awt.Color(134, 43, 13));
        btnCambiarContraseña.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCambiarContraseña.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarContraseña.setText("Cambiar contraseña ");
        btnCambiarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, 50));

        txtAntiguaContraseña.setColumns(15);
        txtAntiguaContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtAntiguaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, 40));

        txtNuevaContraseña.setColumns(15);
        txtNuevaContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txtNuevaContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(107, 36, 12));
        jLabel4.setText("CAMBIAR CONTRASEÑA");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        new Bievenida().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed

    private void btnCambiarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarContraseñaActionPerformed
        String nombreUsuario = txtNombreUsuarioCambiarContraseña.getText().trim();
        String contraseniaActual = new String(txtAntiguaContraseña.getPassword()).trim();
        String nuevaContrasenia = new String(txtNuevaContraseña.getPassword()).trim();

        if (nombreUsuario.isEmpty() || contraseniaActual.isEmpty() || nuevaContrasenia.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(nombreUsuario);

        boolean exito = usuario.cambiarContrasenia(contraseniaActual, nuevaContrasenia);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Contraseña actualizada con éxito.");
            txtNombreUsuarioCambiarContraseña.setText("");
            txtAntiguaContraseña.setText("");
            txtNuevaContraseña.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Usuario no encontrado o contraseña actual incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCambiarContraseñaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiarContraseña;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtAntiguaContraseña;
    private javax.swing.JTextField txtNombreUsuarioCambiarContraseña;
    private javax.swing.JPasswordField txtNuevaContraseña;
    // End of variables declaration//GEN-END:variables
}
