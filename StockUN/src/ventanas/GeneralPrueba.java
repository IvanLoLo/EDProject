
package ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import principal.Producto;
import ventanas.RecursosTabla.*;
import javax.swing.table.DefaultTableModel;
import static ventanas.Clientes.TCarrito;
import static ventanas.Clientes.totalArticulos;
import static ventanas.Clientes.totalCompra;

public class GeneralPrueba extends JFrame{
    
    JButton btnSalir, btnAgregar, btnEditar, btnEliminar, btnVenta;
    JLabel fondo;
    JPanel panelBtn, panelTabla;
    static JTable tabla;
    JTextField txtBuscar;
    JScrollPane scrollPaneTabla;
    ModeloTabla modelo;
    Object lista;
    static int structure;
    
    
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
    
    private Object asignarEstructura(int size){
        
        switch(structure){
            case 1: return new dataStructures.Stack(size);
            case 2: return new dataStructures.List(size);
            case 3: return new dataStructures.LinkedList();
            case 4: return new dataStructures.Heap(size);
            default: System.out.println("Estructura no encontrada asignarEstructura");
        }
        
        return null;
    }
    
    public GeneralPrueba(){
        initComponents();
        structure = 2;
        lista = asignarEstructura(10005);
        construirTabla();
        
        
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(600,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
       // this.pack();
    }
    
    public void initComponents(){
        //fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/InicioNormal.jpg")));
        
        
        panelBtn = new JPanel();
        panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER));
        
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
                    insertarEstructura(nuevo.getTemp());
                    ordenarEstructura();
                    //lista.sortedInsert(nuevo.getTemp());
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
                        actualizarProducto(getInformation()[0], nuevo.getTemp());
                        //lista.update(nuevo.cambioNombre, getInformation()[0],nuevo.getTemp());
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
                    eliminarProducto();
                    //lista.delete(new Producto(getInformation()[0], 0, 0));
                    DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
                    dtm.removeRow(tabla.getSelectedRow());
                    imprimirEstructura();
                    //lista.output();
                }
            }
        });
        
        btnVenta = crearBtn("Venta", "/Imagenes/Venta.png");
        btnVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Venta");
                if(tabla.getSelectedRow()==-1){
                    JOptionPane.showMessageDialog(null, "Por favor seleccione la fila que desea vender");
                }else{
                    
                }
            }
                
                
            
        });
       
        JButton btnBuscar = crearBtn("Buscar", "/Imagenes/Search.png");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                buscarEstructura();
            }
        });
        txtBuscar = new JTextField();
        txtBuscar.setBackground(new Color(255,255, 255));
        txtBuscar.setForeground(new Color(0,0,0));        
        txtBuscar.setPreferredSize(new Dimension(200,40));
        txtBuscar.setFont(new Font("Tahoma", 0, 26));
        txtBuscar.setText("Buscar");        
        panelBtn.add(txtBuscar);
        
        
        scrollPaneTabla = new JScrollPane();
        
        tabla = new JTable();
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
        tabla.setFont(new Font("Tahoma", 0, 24));
        tabla.setRowHeight(30);
        tabla.getTableHeader().setFont(new Font("Tahoma", 1, 26));
        //tabla.getTableHeader().setBackground(new Color(0,0,0,150));
        //tabla.getTableHeader().setForeground(new Color(255, 255, 255));
        //tabla.setBackground(new Color(0, 0, 0,150));
        //tabla.setForeground(new Color(255, 255, 255));
        
            
        
        
        
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
        
        if(estructuraVacia()) new principal.newReader(lista, structure);
        
        return Arrays.copyOfRange(arrayEstructura(), 0, countEstructura());
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
    
    public void buscarEstructura(){
        
        String item = txtBuscar.getText();
        
        if(item.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre de un producto para buscar");
            return;
        }
        
        Producto producto = new Producto(item, 0, 0);
        boolean found=false;
        
        switch(structure){
            case 1: if (((dataStructures.Stack) lista).doSearch(producto, 0)){
                        producto = ((dataStructures.Stack) lista).giveMe(((dataStructures.Stack) lista).getPosition());
                        found = true;
                    }else producto = null;
            break;
            case 2: if (((dataStructures.List) lista).smartSearch(producto, 0)){
                        producto = ((dataStructures.List) lista).giveMe(((dataStructures.List) lista).getPosition());
                        found = true;
                    }else producto = null;
            break;
            case 3: if (((dataStructures.LinkedList) lista).search(producto, 0)){
                        producto = ((dataStructures.LinkedList) lista).giveMe(((dataStructures.LinkedList) lista).getPosition());
                        found = true;
                    }else producto = null;
            break;
            case 4: if (((dataStructures.Heap) lista).doSearch(producto)){
                        producto = ((dataStructures.Heap) lista).giveMe(((dataStructures.Heap) lista).position);
                        found = true;
                    }else producto = null;
            break;
            default: System.out.println("Estructura no encontrada insertarEstructura");
        }
        
        if(!found) JOptionPane.showMessageDialog(null, "No encontramos el producto en el inventario :(");
        else {
            JOptionPane.showMessageDialog(null, "Producto: "+producto.getNombre()+
                    "\nPrecio: "+producto.getPrecio()+"\nStock: "+producto.getStock());
        }
            
        
    }
    
    private void insertarEstructura(Producto producto){
        
        switch(structure){
            case 1: ((dataStructures.Stack) lista).push(producto);
            break;
            case 2: ((dataStructures.List) lista).sortedInsert(producto);
            break;
            case 3: ((dataStructures.LinkedList) lista).insert(producto);
            break;
            case 4: ((dataStructures.Heap) lista).insertItem(producto);
            break;
            default: System.out.println("Estructura no encontrada insertarEstructura");
        }
        
    }
    
    private void actualizarProducto(String oldName, Producto newProduct){
        
        switch(structure){
            //case 1: return new dataStructures.Stack(size);
            case 2: ((dataStructures.List) lista).update(oldName, newProduct);
            break;
            //case 3: return new dataStructures.LinkedList();
            //case 4: return new dataStructures.Arbol();
            default: System.out.println("Estructura no encontrada actualizarProducto");
        }
        
    }
    
    private void ordenarEstructura(){
        
        switch(structure){
            case 1: ((dataStructures.Stack) lista).sort();
            break;
            case 2: //((dataStructures.List) lista).sort();
            break;
            case 3: //((dataStructures.LinkedList) lista); No tenemos un ordenamiento para LinkedList
            case 4: ((dataStructures.Heap) lista).sort();
            break;
            default: System.out.println("Estructura no encontrada ordenarEstructura");
        }
        
    }
    
    private void eliminarProducto(){
        
        Producto item = new Producto(getInformation()[0], 0, 0);
        
        switch(structure){
            case 1: ((dataStructures.Stack) lista).delete(item);
            break;
            case 2: ((dataStructures.List) lista).delete(item);
            break;
            case 3: ((dataStructures.LinkedList) lista).delete(item);
            break;
            case 4: ((dataStructures.Heap) lista).delete(item);
            break;
            default: System.out.println("Estructura no encontrada eliminarProducto");
        }
        
    }
    
    private boolean estructuraVacia(){
        
        switch(structure){
            case 1: return ((dataStructures.Stack) lista).empty();
            case 2: return ((dataStructures.List) lista).empty();
            case 3: return ((dataStructures.LinkedList) lista).empty();
            case 4: return ((dataStructures.Heap) lista).empty();
            default: System.out.println("Estructura no encontrada estructuraVacia");
        }
        
        return true;
    }
    
    private void imprimirEstructura(){
        
        switch(structure){
            case 1: ((dataStructures.Stack) lista).print();
            break;
            case 2: ((dataStructures.List) lista).output();
            break;
            case 3: ((dataStructures.LinkedList) lista).printR(((dataStructures.LinkedList) lista).getHead());
            break;
            case 4: ((dataStructures.Heap) lista).print();
            break;
            default: System.out.println("Estructura no encontrada imprimirEstructura");
        }
        
    }
    
    private Object[] arrayEstructura(){
        
        switch(structure){
            case 1: return ((dataStructures.Stack) lista).getSarray();
            case 2: return ((dataStructures.List) lista).getArray();
            case 3: return ((dataStructures.LinkedList) lista).toArray();
            case 4: return ((dataStructures.Heap) lista).getArray();
            default: System.out.println("Estructura no encontrada arrayEstructura");
        }
        
        return null;
    }
    
    private int countEstructura(){
        
        switch(structure){
            case 1: return ((dataStructures.Stack) lista).getTop();
            case 2: return ((dataStructures.List) lista).getCount();
            case 3: return ((dataStructures.LinkedList) lista).getCant();
            case 4: return ((dataStructures.Heap) lista).getSize();
            default: System.out.println("Estructura no encontrada countEstructura");
        }
        
        return -1;
        
    }
    private static boolean isNumber(String n) {
        try {
                if(Integer.parseInt(n)>0) return true;
                return false;
        } catch (NumberFormatException nfe) {
                return false;
        }
    }

}
