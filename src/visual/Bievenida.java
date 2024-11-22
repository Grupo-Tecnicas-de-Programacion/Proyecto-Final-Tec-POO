
package visual;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Bievenida extends javax.swing.JFrame {

    public Bievenida() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelBienvenida = new javax.swing.JLabel();
        btnIniciarSesionAdministrador = new javax.swing.JButton();
        labelEresNuevo = new javax.swing.JLabel();
        btnIniciarSesionMesero = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        labelTituloPolleria = new javax.swing.JLabel();
        btnSalirPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelBienvenida.setBackground(new java.awt.Color(145, 9, 30));
        labelBienvenida.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        labelBienvenida.setForeground(new java.awt.Color(107, 36, 12));
        labelBienvenida.setText("BIENVENIDO A");
        jPanel1.add(labelBienvenida, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 190, 50));

        btnIniciarSesionAdministrador.setBackground(new java.awt.Color(134, 43, 13));
        btnIniciarSesionAdministrador.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIniciarSesionAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesionAdministrador.setText("ADMINISTRADOR");
        btnIniciarSesionAdministrador.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnIniciarSesionAdministrador.setBorderPainted(false);
        btnIniciarSesionAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionAdministradorActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesionAdministrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 190, 50));

        labelEresNuevo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelEresNuevo.setForeground(new java.awt.Color(0, 0, 0));
        labelEresNuevo.setText("\"¿Eres nuevo?\"");
        jPanel1.add(labelEresNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 130, -1));

        btnIniciarSesionMesero.setBackground(new java.awt.Color(134, 43, 13));
        btnIniciarSesionMesero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIniciarSesionMesero.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesionMesero.setText("MESERO");
        btnIniciarSesionMesero.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnIniciarSesionMesero.setBorderPainted(false);
        btnIniciarSesionMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionMeseroActionPerformed(evt);
            }
        });
        jPanel1.add(btnIniciarSesionMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 190, 50));

        btnRegistrar.setBackground(new java.awt.Color(153, 77, 28));
        btnRegistrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("REGISTRATE");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 160, 50));

        labelTituloPolleria.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        labelTituloPolleria.setForeground(new java.awt.Color(145, 9, 30));
        labelTituloPolleria.setText("POLLOS Y PARILLAS  \"EL GRAN RANCHO\"");
        jPanel1.add(labelTituloPolleria, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 410, 30));

        btnSalirPrincipal.setBackground(new java.awt.Color(61, 3, 1));
        btnSalirPrincipal.setFont(new java.awt.Font("OCR A Extended", 1, 36)); // NOI18N
        btnSalirPrincipal.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirPrincipal.setText("X");
        btnSalirPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPrincipalActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalirPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 70, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 460));

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

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        new Registrarse().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnSalirPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPrincipalActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirPrincipalActionPerformed


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
            java.util.logging.Logger.getLogger(Bievenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bievenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bievenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bievenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bievenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesionAdministrador;
    private javax.swing.JButton btnIniciarSesionMesero;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalirPrincipal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelBienvenida;
    private javax.swing.JLabel labelEresNuevo;
    private javax.swing.JLabel labelTituloPolleria;
    // End of variables declaration//GEN-END:variables
}
