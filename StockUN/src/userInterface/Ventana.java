
package userInterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Ventana extends JFrame{
    
    private JButton btnLogin, btnRegistro;
    private JPanel nombre, campos, botones;
    private JLabel userlbl, passlbl;
    private JTextField user;
    private JPasswordField pass;
    
    public Ventana(){
        this.setTitle("StockUN");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 0));
        
        initComponents();
        
    }
    
    private void initComponents(){
        
        nombre = new JPanel(new BorderLayout());
        JLabel nombrelabel = new JLabel("StockUN");
        nombrelabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombre.add(nombrelabel, BorderLayout.CENTER);
        
        campos = new JPanel();
        campos.setLayout(new BoxLayout(campos, BoxLayout.Y_AXIS));
        
        userlbl = new JLabel("Usuario");
        userlbl.setAlignmentX(0.5F);
        passlbl = new JLabel("Contraseña");
        passlbl.setAlignmentX(0.5F);
        
        user = new JTextField();
        user.setMinimumSize(new Dimension(300,20));
        user.setMaximumSize(new Dimension(300,20));
        
        pass = new JPasswordField();
        pass.setMinimumSize(new Dimension(300,20));
        pass.setMaximumSize(new Dimension(300,20));
        
        campos.add(Box.createRigidArea(new Dimension(1,10)));
        campos.add(userlbl);
        campos.add(user);
        campos.add(Box.createRigidArea(new Dimension(1,30)));
        campos.add(passlbl);
        campos.add(pass);
        
        botones = new JPanel();
        botones.setLayout(new BoxLayout(botones, BoxLayout.Y_AXIS));
        btnLogin = createButton("Ingresar");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Hola");
            }
        });
        
        btnRegistro = createButton("Registrarse");
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Hola2");
            }
        });
        
        botones.add(Box.createRigidArea(new Dimension(1,50)));
        botones.add(btnLogin);
        botones.add(Box.createRigidArea(new Dimension(1,20)));
        botones.add(btnRegistro);
        
        getContentPane().add(nombre);
        getContentPane().add(campos);
        getContentPane().add(botones);
    }
    
    private JButton createButton(String msg){
        JButton temp = new JButton(msg);
        temp.setAlignmentX(0.5F);
        temp.setBackground(new java.awt.Color(0, 0, 0));
        temp.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        temp.setForeground(new java.awt.Color(255, 255, 255));
        
        return temp;
    }
    
}
