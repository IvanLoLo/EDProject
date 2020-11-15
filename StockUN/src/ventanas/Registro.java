package ventanas;

/**
 *
 * @author Diego
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        setResizable(false);        
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Permisos = new javax.swing.JComboBox<>();
        jLabelIcono = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelUsuario1 = new javax.swing.JLabel();
        jLabelUsuario3 = new javax.swing.JLabel();
        jLabelUsuario4 = new javax.swing.JLabel();
        jLabelUsuario5 = new javax.swing.JLabel();
        jLabelUsuario6 = new javax.swing.JLabel();
        jLabelUsuario7 = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldUsuario1 = new javax.swing.JTextField();
        jTextFieldUsuario2 = new javax.swing.JTextField();
        jTextFieldUsuario5 = new javax.swing.JTextField();
        jTextFieldUsuario7 = new javax.swing.JTextField();
        Contrasenia1 = new javax.swing.JPasswordField();
        jLabelUsuario10 = new javax.swing.JLabel();
        jTextFieldUsuario8 = new javax.swing.JTextField();
        Registrarse = new javax.swing.JButton();
        jLabelWalpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Permisos.setBackground(new java.awt.Color(0, 0, 0));
        Permisos.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Permisos.setForeground(new java.awt.Color(255, 255, 255));
        Permisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador" }));
        Permisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PermisosActionPerformed(evt);
            }
        });
        getContentPane().add(Permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 140, 30));

        jLabelIcono.setBackground(new java.awt.Color(0, 0, 0, 100));
        jLabelIcono.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabelIcono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIcono.setText("Registro");
        jLabelIcono.setOpaque(true);
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, 70));

        jLabelUsuario.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario.setText("Nombres:");
        jLabelUsuario.setOpaque(true);
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 90, 30));

        jLabelUsuario1.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario1.setText("Apellidos:");
        jLabelUsuario1.setOpaque(true);
        getContentPane().add(jLabelUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 90, 30));

        jLabelUsuario3.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario3.setText("Fecha de nacimiento:");
        jLabelUsuario3.setOpaque(true);
        getContentPane().add(jLabelUsuario3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 210, 30));

        jLabelUsuario4.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario4.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario4.setText("Email:");
        jLabelUsuario4.setOpaque(true);
        getContentPane().add(jLabelUsuario4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 60, 30));

        jLabelUsuario5.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario5.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario5.setText("Usuario:");
        jLabelUsuario5.setOpaque(true);
        getContentPane().add(jLabelUsuario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 90, 30));

        jLabelUsuario6.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario6.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario6.setText("Contraseña:");
        jLabelUsuario6.setOpaque(true);
        getContentPane().add(jLabelUsuario6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 120, 30));

        jLabelUsuario7.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario7.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario7.setText("Confirmar Contraseña:");
        jLabelUsuario7.setOpaque(true);
        getContentPane().add(jLabelUsuario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 210, 30));

        jTextFieldUsuario.setBackground(new java.awt.Color(0, 0, 0, 150));
        jTextFieldUsuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jTextFieldUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 160, 30));

        jTextFieldUsuario1.setBackground(new java.awt.Color(0, 0, 0, 150));
        jTextFieldUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuario1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 190, 30));

        jTextFieldUsuario2.setBackground(new java.awt.Color(0, 0, 0, 150));
        jTextFieldUsuario2.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUsuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuario2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 220, 30));

        jTextFieldUsuario5.setBackground(new java.awt.Color(0, 0, 0, 150));
        jTextFieldUsuario5.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUsuario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuario5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 220, 30));

        jTextFieldUsuario7.setBackground(new java.awt.Color(0, 0, 0, 150));
        jTextFieldUsuario7.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUsuario7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuario7ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 230, 30));

        Contrasenia1.setBackground(new java.awt.Color(0, 0, 0, 150));
        Contrasenia1.setForeground(new java.awt.Color(255, 255, 255));
        Contrasenia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Contrasenia1ActionPerformed(evt);
            }
        });
        getContentPane().add(Contrasenia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 230, 30));

        jLabelUsuario10.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario10.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario10.setText("Permisos:");
        jLabelUsuario10.setOpaque(true);
        getContentPane().add(jLabelUsuario10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 90, 30));

        jTextFieldUsuario8.setBackground(new java.awt.Color(0, 0, 0, 150));
        jTextFieldUsuario8.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldUsuario8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuario8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldUsuario8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 230, 30));

        Registrarse.setBackground(new java.awt.Color(0, 0, 0));
        Registrarse.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Registrarse.setForeground(new java.awt.Color(255, 255, 255));
        Registrarse.setText("Registrar");
        Registrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(Registrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 100, -1));

        jLabelWalpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/InicioNormal.jpg"))); // NOI18N
        getContentPane().add(jLabelWalpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PermisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PermisosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PermisosActionPerformed

    private void jTextFieldUsuario7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuario7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuario7ActionPerformed

    private void jTextFieldUsuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuario2ActionPerformed

    private void Contrasenia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Contrasenia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Contrasenia1ActionPerformed

    private void jTextFieldUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuario1ActionPerformed

    private void jTextFieldUsuario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuario5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuario5ActionPerformed

    private void jTextFieldUsuario8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsuario8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsuario8ActionPerformed

    private void RegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarseActionPerformed
      this.dispose();
       new InterfazPrincipal().setVisible(true);       

    }//GEN-LAST:event_RegistrarseActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contrasenia1;
    private javax.swing.JComboBox<String> Permisos;
    private javax.swing.JButton Registrarse;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelUsuario1;
    private javax.swing.JLabel jLabelUsuario10;
    private javax.swing.JLabel jLabelUsuario3;
    private javax.swing.JLabel jLabelUsuario4;
    private javax.swing.JLabel jLabelUsuario5;
    private javax.swing.JLabel jLabelUsuario6;
    private javax.swing.JLabel jLabelUsuario7;
    private javax.swing.JLabel jLabelWalpaper;
    private javax.swing.JTextField jTextFieldUsuario;
    private javax.swing.JTextField jTextFieldUsuario1;
    private javax.swing.JTextField jTextFieldUsuario2;
    private javax.swing.JTextField jTextFieldUsuario5;
    private javax.swing.JTextField jTextFieldUsuario7;
    private javax.swing.JTextField jTextFieldUsuario8;
    // End of variables declaration//GEN-END:variables
}
