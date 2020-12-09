package ventanas;

import javax.swing.JOptionPane;
import principal.Producto;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class VentanaProducto extends javax.swing.JDialog {

    public static boolean pulsado;
    private Producto temp;
    private String nameBtn;
    String Nombre;
    String Precio;
    String Stock;

    public Producto getTemp() {
        return temp;
    }
    public void setTemp(Producto temp) {
        this.temp = temp;
    }
    
    public VentanaProducto(java.awt.Frame parent, boolean modal, String name) {
        super(parent, modal);        
        pulsado = false;
        nameBtn = name;
        initComponents();
        this.setResizable(false);        
        this.setLocationRelativeTo(null);
        if(btn.getText().equals("Guardar Cambios")){
            nombreText.setText(GeneralPrueba.getInformation()[0]);
            nombreText.setEditable(false);
            precioText.setText(GeneralPrueba.getInformation()[1]);
            stockText.setText(GeneralPrueba.getInformation()[2]);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelUsuario = new javax.swing.JLabel();
        jLabelUsuario1 = new javax.swing.JLabel();
        jLabelUsuario2 = new javax.swing.JLabel();
        jLabelIcono = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        stockText = new javax.swing.JTextField();
        precioText = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUsuario.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario.setText("Precio:");
        jLabelUsuario.setOpaque(true);
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 70, 30));

        jLabelUsuario1.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario1.setText("Cantidad:");
        jLabelUsuario1.setOpaque(true);
        getContentPane().add(jLabelUsuario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 90, 30));

        jLabelUsuario2.setBackground(new java.awt.Color(0, 0, 0, 75)
        );
        jLabelUsuario2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelUsuario2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUsuario2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelUsuario2.setText("Nombre:");
        jLabelUsuario2.setOpaque(true);
        getContentPane().add(jLabelUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, 30));

        jLabelIcono.setBackground(new java.awt.Color(0, 0, 0, 100));
        jLabelIcono.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabelIcono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIcono.setText("Producto");
        jLabelIcono.setOpaque(true);
        getContentPane().add(jLabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, 70));

        nombreText.setBackground(new java.awt.Color(0, 0, 0, 150));
        nombreText.setForeground(new java.awt.Color(255, 255, 255));
        nombreText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextActionPerformed(evt);
            }
        });
        nombreText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreTextKeyTyped(evt);
            }
        });
        getContentPane().add(nombreText, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 170, 30));

        stockText.setBackground(new java.awt.Color(0, 0, 0, 150));
        stockText.setForeground(new java.awt.Color(255, 255, 255));
        stockText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockTextActionPerformed(evt);
            }
        });
        stockText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                stockTextKeyTyped(evt);
            }
        });
        getContentPane().add(stockText, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 170, 30));

        precioText.setBackground(new java.awt.Color(0, 0, 0, 150));
        precioText.setForeground(new java.awt.Color(255, 255, 255));
        precioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTextActionPerformed(evt);
            }
        });
        precioText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioTextKeyTyped(evt);
            }
        });
        getContentPane().add(precioText, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 170, 30));

        btn.setBackground(new java.awt.Color(0, 0, 0));
        btn.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btn.setForeground(new java.awt.Color(255, 255, 255));
        btn.setText(nameBtn);
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        getContentPane().add(btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 200, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/InicioNormal.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stockTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stockTextActionPerformed

    private void nombreTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextActionPerformed

    private void precioTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precioTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precioTextActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
      if(comprobarCampos()){
            pulsado = true;
            temp = new Producto(nombreText.getText(), Long.parseLong(precioText.getText()), Integer.parseInt(stockText.getText()));
            System.out.println("Pulsado papá");
            dispose();
        }
    }//GEN-LAST:event_btnActionPerformed

    private void nombreTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTextKeyTyped
      char caracter=evt.getKeyChar();
      if((caracter<'A'||caracter>'Z') && (caracter<'a'||caracter>'z'))evt.consume();
    }//GEN-LAST:event_nombreTextKeyTyped

    private void stockTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stockTextKeyTyped
      char caracter=evt.getKeyChar();
      if(caracter<'0'||caracter>'9')evt.consume();
    }//GEN-LAST:event_stockTextKeyTyped

    private void precioTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioTextKeyTyped
       char caracter=evt.getKeyChar();
      if(caracter<'0'||caracter>'9')evt.consume();
    }//GEN-LAST:event_precioTextKeyTyped

    public boolean comprobarCampos(){
        Nombre = nombreText.getText().trim(); 
        Precio = precioText.getText().trim();
        Stock = stockText.getText().trim();
        if (Nombre.equals("")|| Precio.equals("")||Stock.equals("")){
            JOptionPane.showMessageDialog(this, "Algun campo vacio");
            return false;
        }
        // Validar que no esta vacio 
        return true;
    }
    
    public static void main(String[] args) {
        new VentanaProducto(null, true, "Agregar").setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelIcono;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelUsuario1;
    private javax.swing.JLabel jLabelUsuario2;
    private javax.swing.JTextField nombreText;
    private javax.swing.JTextField precioText;
    private javax.swing.JTextField stockText;
    // End of variables declaration//GEN-END:variables
}
