package ventanas;

import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class InterfazPrincipal extends javax.swing.JFrame {

    public static String usuario = "";
    String contraseña = "";
    public InterfazPrincipal() {
        initComponents();
        this.setResizable(false);        
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

        jButtonRegistrarse = new javax.swing.JButton();
        jButtonIniciarSesion = new javax.swing.JButton();
        jButtonExit = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelContraseña = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        Contraseña = new javax.swing.JPasswordField();
        jLabelIcono = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonRegistrarse.setBackground(new java.awt.Color(0, 0, 0));
        jButtonRegistrarse.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrarse.setText("Registrarse");
        jButtonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarseActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 110, -1));

        jButtonIniciarSesion.setBackground(new java.awt.Color(0, 0, 0));
        jButtonIniciarSesion.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIniciarSesion.setText("Iniciar sesión");
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIniciarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, 150, -1));

        jButtonExit.setBackground(new java.awt.Color(0, 0, 0));
        jButtonExit.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("X");
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, -1, -1));

        jLabelUsuario.setBackground(new java.awt.Color(0, 0, 0, 100)
        );
        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario.setText("Usuario:");
        jLabelUsuario.setOpaque(true);
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 160, -1, 30));

        jLabelContraseña.setBackground(new java.awt.Color(0, 0, 0, 100));
        jLabelContraseña.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContraseña.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelContraseña.setText("Contraseña:");
        jLabelContraseña.setOpaque(true);
        getContentPane().add(jLabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, 30));

        Usuario.setBackground(new java.awt.Color(0, 0, 0, 150));
        Usuario.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 170, 30));

        Contraseña.setBackground(new java.awt.Color(0, 0, 0, 150));
        Contraseña.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 170, 30));

        jLabelIcono.setBackground(new java.awt.Color(0, 0, 0, 100));
        jLabelIcono.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabelIcono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIcono.setText("Stock UN");
        jLabelIcono.setOpaque(true);
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 70));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/unnamed.jpg"))); // NOI18N
        jLabelFondo.setText("jLabel1");
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 512, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarseActionPerformed
        this.dispose();
        new Registro().setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarseActionPerformed

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        usuario = Usuario.getText().trim(); 
        contraseña = Contraseña.getText().trim();
        if (usuario.equals("")|| contraseña.equals("")) {
            JOptionPane.showMessageDialog(this, "Campo de usuario o contraseña vacios");
        }else{//Falta confirmar que esten registrados
            dispose();
            new General().setVisible(true);
        }
            
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JButton jButtonRegistrarse;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelUsuario;
    // End of variables declaration//GEN-END:variables
}
