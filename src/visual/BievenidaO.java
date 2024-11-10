
package visual;

public class BievenidaO extends javax.swing.JFrame {

    public BievenidaO() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIniciarSesionAdministrador = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnIniciarSesionMesero = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnRegsitrarseIniciarSesion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("BIENVENIDO A");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 28, 101, 33));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Iniciar sesión como:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 141, 159, -1));

        btnIniciarSesionAdministrador.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciarSesionAdministrador.setText("ADMINISTRADOR");
        btnIniciarSesionAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesionAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 169, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("\"¿Eres nuevo?\"");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 204, 86, -1));

        btnIniciarSesionMesero.setForeground(new java.awt.Color(0, 0, 0));
        btnIniciarSesionMesero.setText("MESERO");
        btnIniciarSesionMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionMeseroActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesionMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 169, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Haz click en el siguiente botón para registrarte");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 232, -1, -1));

        btnRegsitrarseIniciarSesion.setForeground(new java.awt.Color(0, 0, 0));
        btnRegsitrarseIniciarSesion.setText("REGISTRARSE");
        btnRegsitrarseIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegsitrarseIniciarSesionActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegsitrarseIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 255, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("POLLOS Y PARILLAS \" EL GRAN RANCHO\"");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 67, 256, 56));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarSesionAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionAdministradorActionPerformed
        InicioSesion inicioSesion = new InicioSesion("ADMINISTRADOR");
        inicioSesion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIniciarSesionAdministradorActionPerformed

    private void btnIniciarSesionMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionMeseroActionPerformed
        InicioSesion inicioSesion = new InicioSesion("MESERO");
        inicioSesion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnIniciarSesionMeseroActionPerformed

    private void btnRegsitrarseIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegsitrarseIniciarSesionActionPerformed
        new Registrarse().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegsitrarseIniciarSesionActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BievenidaO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BievenidaO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BievenidaO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BievenidaO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BievenidaO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesionAdministrador;
    private javax.swing.JButton btnIniciarSesionMesero;
    private javax.swing.JButton btnRegsitrarseIniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
