
package ventanas;

import java.awt.*;
import javax.swing.*;

public class GeneralPrueba extends JFrame{
    
    JPanel btnSalir, btnAgregar, btnEditar, btnEliminar, btnVenta;
    JLabel fondo;
    JPanel panelBtn, panelTabla;
    
    public static void main(String[] args) {
        new GeneralPrueba();
    }

    public GeneralPrueba(){
        
        this.setVisible(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(500,500));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        
        initComponents();
    }
    
    public void initComponents(){
        
        btnSalir = crearPanelBtn(/*Poner URL Imagen*/);
        btnAgregar = crearPanelBtn(/*Poner URL Imagen*/);
        btnEditar = crearPanelBtn(/*Poner URL Imagen*/);
        btnEliminar = crearPanelBtn(/*Poner URL Imagen*/);
        btnVenta = crearPanelBtn(/*Poner URL Imagen*/);
        
        panelBtn = new JPanel();
        panelBtn.setLayout(new FlowLayout());
        panelTabla = new JPanel();
        
        panelBtn.add(btnSalir);
        panelBtn.add(btnEditar);
        panelBtn.add(btnAgregar);
        panelBtn.add(btnVenta);
        
        this.add(panelBtn);
        this.add(panelTabla);
    }
    
    public JPanel crearPanelBtn(){
        
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        JButton btnTemp = new JButton();
        btnTemp.setAlignmentX(0.5F);
        btnTemp.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Volver.png")));
        JLabel lblTemp = new JLabel("Hola");
        lblTemp.setAlignmentX(0.5F);
        temp.add(btnTemp);
        temp.add(lblTemp);
        
        return temp;
    }

    
    
}
