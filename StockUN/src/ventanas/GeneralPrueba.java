
package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import principal.Producto;
import ventanas.RecursosTabla.*;
import javax.swing.table.DefaultTableModel;

public class GeneralPrueba extends JFrame{
    
    JButton btnSalir, btnAgregar, btnEditar, btnEliminar, btnVenta;
    JLabel fondo;
    JPanel panelBtn, panelTabla;
    static JTable tabla;
    JScrollPane scrollPaneTabla;
    ModeloTabla modelo;
    dataStructures.List lista;
    
    
    public static String[] getInformation(){
        int fila = tabla.getSelectedRow();
        String[] tempArray = {" ", " ", " "};
        if(fila==-1) return tempArray;
        tempArray[0] = String.valueOf(tabla.getValueAt(fila, 0));
        tempArray[1] = String.valueOf(tabla.getValueAt(fila, 1));
        tempArray[2] = String.valueOf(tabla.getValueAt(fila, 2));
        return tempArray;
    }
    
    public static void main(String[] args){
        new GeneralPrueba();
    }
    
    public GeneralPrueba(){
        initComponents();
        this.setResizable(false);  
        this.setLocationRelativeTo(null);
        lista = new dataStructures.List(10005);
        construirTabla();
        
        
        this.setVisible(true);       
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(1000,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.pack();
    }
    
    public void initComponents(){
        
        panelBtn = new JPanel();
        panelBtn.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        
        btnSalir = crearBtn("Salir", "/Imagenes/Volver2.png");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int exit = JOptionPane.showConfirmDialog(getContentPane(), "¿Seguro que desea salir?");
                if(exit == JOptionPane.OK_OPTION){
                    dispose();
                    new InterfazPrincipal().setVisible(true);
                }
            }
        });
        
        btnAgregar = crearBtn("Agregar", "/Imagenes/Agregar.png");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                VentanaProducto nuevo = new VentanaProducto(null, true, "Agregar Producto");
                nuevo.setVisible(true);
                if(nuevo.pulsado){
                    lista.sortedInsert(nuevo.getTemp());
                    construirTabla();
                }
            }
        });
        
        btnEditar = crearBtn("Editar", "/Imagenes/Editar.png");
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(tabla.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "Por favor seleccione el producto que dese editar");
                }else{
                    VentanaProducto nuevo = new VentanaProducto(null, true, "Guardar Cambios");
                    nuevo.setVisible(true);
                    if(nuevo.pulsado){
                        lista.update(nuevo.cambioNombre, getInformation()[0],nuevo.getTemp());
                        if(nuevo.cambioNombre) lista.sort();
                        construirTabla();
                    }
                }
            }
        });
        
        btnEliminar = crearBtn("Eliminar", "/Imagenes/Borrar.png");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(tabla.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "Por favor seleccione la fila que desea eliminar");
                }else{
                    lista.delete(new Producto(getInformation()[0], 0, 0));
                    DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
                    dtm.removeRow(tabla.getSelectedRow());
                    lista.output();
                }
            }
        });
        
        btnVenta = crearBtn("Venta", "/Imagenes/Venta.png");
        btnVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Venta");
            }
        });
        
        scrollPaneTabla = new JScrollPane();
        
        tabla = new JTable();
        tabla.setFont(new java.awt.Font("Tahoma", 0, 22));
        tabla.setRowHeight(22);
        scrollPaneTabla.setViewportView(tabla);
        
        panelTabla.add(scrollPaneTabla);
        this.add(panelBtn);
        this.add(panelTabla);
    }
    
    private void construirTabla(){
        
        Object[] productos = consultarProductos();
        String[] titulos = {"Nombre", "Precio", "Stock"};
        
        Object[][] data = obtenerDatos(titulos.length, productos);
        construirTabla(titulos, data);
    }
    
    private void construirTabla(String[] titulos, Object[][] datos){
        modelo = new ModeloTabla(datos, titulos);
        tabla.setModel(modelo);
    }
    
    private Object[][] obtenerDatos(int titulosTam, Object[] productos){
        
        String informacion[][] = new String[productos.length][titulosTam];
        
        for(int i=0; i<informacion.length; i++){
            informacion[i][0] = ((Producto)productos[i]).getNombre();
            informacion[i][1] = String.valueOf(((Producto)productos[i]).getPrecio());
            informacion[i][2] = String.valueOf(((Producto)productos[i]).getStock());
        }
        
        return informacion;
    }
    
    private Object[] consultarProductos(){
        
        if(lista.empty()) new principal.Reader(null, lista, null);
        
        return Arrays.copyOfRange(lista.getArray(), 0, lista.getCount());
    }
    
    private JButton crearBtn(String msg, String path){
        
        JButton temp = new JButton();
        temp.setIcon(new ImageIcon(getClass().getResource(path)));
        temp.setAlignmentX(0.5F);
        crearPanelBtn(temp, msg);
        
        return temp;
    }
    
    private void crearPanelBtn(JButton btn, String msg){
        
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        JLabel lblTemp = new JLabel(msg);
        lblTemp.setAlignmentX(0.5F);
        temp.add(btn);
        temp.add(lblTemp);
        
        panelBtn.add(temp);
        
    }
    
    public static void espera(){
        try {
            Thread.sleep(50);
        } catch (InterruptedException ex) {
            System.out.println("Algo malo paso");
        }
    }

}
