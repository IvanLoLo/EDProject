
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
    
    private JButton btn1, btn2;
    private JPanel nombre, campos, botones;
    private JLabel userlbl, passlbl;
    private JTextField user;
    
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
        
        JPasswordField pass = new JPasswordField();
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
        btn1 = new JButton("Ingresar");
        btn1.setAlignmentX(0.5F);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Hola");
            }
        });
        
        btn2 = new JButton("Registrarse");
        btn2.setAlignmentX(0.5F);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Hola2");
            }
        });
        
        botones.add(Box.createRigidArea(new Dimension(1,50)));
        botones.add(btn1);
        botones.add(Box.createRigidArea(new Dimension(1,20)));
        botones.add(btn2);
        
        getContentPane().add(nombre);
        getContentPane().add(campos);
        getContentPane().add(botones);
    } 
    
}
