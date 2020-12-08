package ventanas;

import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import principal.Producto;
import static ventanas.GeneralPrueba.structure;
import ventanas.RecursosTabla.*;

public class Clientes extends JFrame implements MouseListener{
    
    JLabel Agregar,xd;
    JPanel panelBtn, panelTabla,panelE;
    static JTable tabla,TCarrito;
    JScrollPane scrollPaneTabla,scrollCarrito;
    JTextField txtBuscar;
    ModeloTabla modelo;
    Object lista;
    ArrayList<Object> carrito;
    boolean found;
    static int structure;
    static long totalCompra;
    private int filasTabla;
    private int columnasTabla;
    
    
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
        new Clientes();
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
    
    public Clientes(){
        initComponents();
        structure = 2;
        lista = asignarEstructura(10005);
        construirCarrito();
        construirTabla();
       // this.updateUI();
        
        
        
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(600,600));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        //this.pack();
    }
    
    public void initComponents(){     
        panelBtn = new JPanel();
        panelBtn.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelE = new JPanel();
        panelE.setLayout(new FlowLayout(FlowLayout.LEFT));
       // panelE.setMaximumSize(new Dimension(30,60));
        
        panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        JLabel Agregar = new JLabel ();
        Agregar.setText("Carrito de compras            ");
        Agregar.setFont(new Font("Tahoma", 1, 47));
        Agregar.setBackground(new Color(255,255, 255));
        panelE.add(Agregar);
        JLabel xd = new JLabel ();
        xd.setText("Productos disponibles");
        xd.setFont(new Font("Tahoma", 1, 47));
        xd.setBackground(new Color(255,255, 255));
        panelE.add(xd);
        
        
        JButton btnSalir = crearBtn("Salir", "/Imagenes/Volver2.png");
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int exit;
                exit = JOptionPane.showConfirmDialog(getContentPane(), "¿Seguro que desea salir?");
                if(exit == JOptionPane.OK_OPTION){
                    dispose();
                    new InterfazPrincipal().setVisible(true);
                }
            }
        });
        JButton btnComprar = crearBtn("Finalizar Compra", "/Imagenes/Venta.png");
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Finalizar Compra");
                int opc = JOptionPane.showConfirmDialog(null, "¿Desea realizar la compra de sus productos"
                        + " por un total de: "+totalCompra+"?");
                if(opc == JOptionPane.OK_OPTION){
                    String dir = JOptionPane.showInputDialog(null, "Por favor ingrese la direccion a la "
                            + "que desea se entregue el pedido");
                    if(dir!=null){
                        JOptionPane.showMessageDialog(null, "Se agendó la entrega de su pedido a la direccion: "+dir+
                                "\nQue tenga un buen dia.");
                        construirCarrito();
                        totalCompra=0;
                    }
                }
                
            }
        });
        JButton btnRastrear = crearBtn("nose", "/Imagenes/Eliminar.png");
        btnRastrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
            System.out.println("Venta");
            
                
               
                
            }
        });
         JButton btnVenta = crearBtn("Ver Resumen", "/Imagenes/Editar.png");
        btnVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Venta");
            }
        });
         
        txtBuscar = new JTextField();
        txtBuscar.setBackground(new Color(255,255, 255));
        txtBuscar.setForeground(new Color(0,0,0));        
        txtBuscar.setPreferredSize(new Dimension(800,40));
        txtBuscar.setFont(new Font("Tahoma", 0, 26));
        txtBuscar.setText("Buscar");        
        panelBtn.add(txtBuscar);
        
       JButton btnCarrito = crearBtnE("Buscar", "/Imagenes/Search.png");       
        btnCarrito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Producto producto = buscarEstructura(txtBuscar.getText());
                if(!found) JOptionPane.showMessageDialog(null, "No encontramos el producto en el inventario :(");
                else if(producto!=null)
                    JOptionPane.showMessageDialog(null, "Producto: "+producto.getNombre()+"\nPrecio: "+producto.getPrecio()+
                        "\nStock: "+producto.getStock());
            }
        });
        
        scrollCarrito = new JScrollPane();
        TCarrito = new JTable();
        scrollCarrito.setViewportView(TCarrito);
        
        scrollPaneTabla = new JScrollPane();       
        tabla = new JTable();       
        scrollPaneTabla.setViewportView(tabla);
        
        panelTabla.add(scrollCarrito,BorderLayout.LINE_START);
        panelTabla.add(scrollPaneTabla,BorderLayout.CENTER);
        
        this.add(panelBtn);
        this.add(panelE);
        this.add(panelTabla);
        
    }
    private void construirCarrito( ){
        String[] titulos = {"Nombre", "Precio","Cant", " "};
        String informacion[][] = new String[0][titulos.length];
        Object[][] data = informacion;        
        modelo=new ModeloTabla(data, titulos);	
        TCarrito.setName("TCarrito");
	TCarrito.setModel(modelo);
        TCarrito.getColumnModel().getColumn(3).setMaxWidth(33);
        TCarrito.setFont(new Font("Tahoma", 0, 24));
        TCarrito.setRowHeight(33);
        TCarrito.addMouseListener(this);
        TCarrito.getTableHeader().setFont(new Font("Tahoma", 1, 26));		
	filasTabla=TCarrito.getRowCount();
	columnasTabla=TCarrito.getColumnCount();
	TCarrito.getColumnModel().getColumn(3).setCellRenderer(new GestionCeldas("icono"));
	TCarrito.getColumnModel().getColumn(0).setMaxWidth(300);
        TCarrito.getColumnModel().getColumn(1).setMaxWidth(300);
        //TCarrito.getColumnModel().getColumn(2).setMinWidth(0);
        TCarrito.getColumnModel().getColumn(2).setMaxWidth(50);
        
	//scrollPaneTabla.setViewportView(TCarrito);

        
	
    }
    private void construirTabla(){
        
     Object[] productos = consultarProductos();
        String[] titulos = {"Nombre", "Precio"," "};
        String informacion[][] = new String[productos.length][titulos.length];
        
        for(int i=0; i<informacion.length; i++){
            informacion[i][0] = ((Producto)productos[i]).getNombre();
            informacion[i][1] = String.valueOf(((Producto)productos[i]).getPrecio());            
            informacion[i][2] ="Agregar";
        }
        Object[][] data = informacion;        
        modelo=new ModeloTabla(data, titulos);
        tabla.setName("tabla");
	tabla.setModel(modelo);
        tabla.getColumnModel().getColumn(2).setMaxWidth(33);
        tabla.setFont(new Font("Tahoma", 0, 24));
        tabla.setRowHeight(33);
        tabla.addMouseListener(this);
        tabla.getTableHeader().setFont(new Font("Tahoma", 1, 26));		
	filasTabla=tabla.getRowCount();
	columnasTabla=tabla.getColumnCount();
	tabla.getColumnModel().getColumn(2).setCellRenderer(new GestionCeldas("icono"));
	//tabla.getColumnModel().getColumn(0).setMaxWidth(300);
       // tabla.getColumnModel().getColumn(1).setMaxWidth(300);
        
	//scrollPaneTabla.setViewportView(tabla);
	
        //tabla.getTableHeader().setBackground(new Color(0,0,0,150));
        //tabla.getTableHeader().setForeground(new Color(255, 255, 255));
        //tabla.setBackground(new Color(0, 0, 0,150));
        //tabla.setForeground(new Color(255, 255, 255));
    }
    private Object[] consultarProductos(){
        
        if(estructuraVacia()) new principal.newReader(lista, structure);
        
        return Arrays.copyOfRange(arrayEstructura(), 0, countEstructura());
    }
     private JButton crearBtnE(String msg, String path){
        
        JButton temp = new JButton();
        temp.setIcon(new ImageIcon(getClass().getResource(path)));
        temp.setAlignmentX(0.5F);
        crearPanelBtn(temp, msg);
        
        return temp;
    }
    
    private JButton crearBtn(String msg, String path){
        
        JButton temp = new JButton();
        temp.setIcon(new ImageIcon(getClass().getResource(path)));
        temp.setAlignmentX(0.5F);
        crearPanelBtn(temp, msg);
        
        return temp;
    }
    private void crearPanelBtnE(JButton btn, String msg){
        
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        JLabel lblTemp = new JLabel(msg);
        lblTemp.setAlignmentX(0.5F);        
        temp.add(btn);
        temp.add(lblTemp);
        
        panelBtn.add(temp);
        
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
    
    public Producto buscarEstructura(String item){
        
        //String item = txtBuscar.getText();
        
        if(item.equals("")){
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre de un producto para buscar");
            return null;
        }
        
        Producto producto = new Producto(item, 0, 0);
        found=false;
        
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
        
        return producto;
        
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

    @Override
    public void mouseClicked(MouseEvent e) {
        //capturo fila o columna dependiendo de mi necesidad
        
        int fila = tabla.rowAtPoint(e.getPoint());
        int columna = tabla.columnAtPoint(e.getPoint());
        boolean exit = false;
        
        if(e.getComponent().equals(TCarrito)){
            
            totalCompra -= Long.parseLong(TCarrito.getValueAt(fila, 1).toString())*Long.parseLong(TCarrito.getValueAt(fila, 2).toString());
            ((ModeloTabla)TCarrito.getModel()).removeRow(fila);
            
        }else if (columna==2) {
            System.out.println("Pulsado");
            String nombreProducto = tabla.getValueAt(fila, 0).toString();
            String precio = tabla.getValueAt(fila, 1).toString();
            String cantidad = JOptionPane.showInputDialog("Ingrese la cantidad de producto que desea:");
            if(cantidad==null) return;
            while(!isNumber(cantidad)){
                cantidad = JOptionPane.showInputDialog("Entrada no valida.\nIngrese la cantidad de producto que desea:");
                if(cantidad==null) return;
            }
            
            Producto producto = buscarEstructura(nombreProducto);
            int stock = producto.getStock();
            if(Integer.parseInt(cantidad)>stock){
                JOptionPane.showMessageDialog(null, "La cantidad de stock no satisface tus necesidades. Pondremos"
                +" todo nuestro stock en tu venta, que son "+stock+" articulos del producto");
                cantidad = String.valueOf(stock);
            }
            totalCompra += Long.parseLong(precio)*Long.parseLong(cantidad);
            //if(exit) return;
            ((ModeloTabla)TCarrito.getModel()).addRow(new Object[] {nombreProducto, precio, cantidad, ""});
        }
        
        //System.out.println("Total: "+totalCompra);

            //ProductosCarrito+=
          //  modelo=new ModeloTabla(data, titulos);		
           // TCarrito.setModel(modelo);
            //this.paintAll(this);
            //construirCarrito();
		
    }
   /* private void validarSeleccionMouse(int fila) {
		Utilidades.filaSeleccionada=fila;
		
		
		//teniendo la fila entonces se obtiene el objeto correspondiente para enviarse como parammetro o imprimir la información
		PersonaVo miPersona=new PersonaVo();
		miPersona.setDocumento(tablaPersonas.getValueAt(fila, Utilidades.DOCUMENTO).toString());
		miPersona.setNombre(tablaPersonas.getValueAt(fila, Utilidades.NOMBRE).toString());
		
		String info="INFO PERSONA\n";
		info+="Documento: "+miPersona.getDocumento()+"\n";
		info+="Nombre: "+miPersona.getNombre()+"\n";
		
		JOptionPane.showMessageDialog(null, info);
	}*/

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Released");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("Exited");
    }

    

}
