package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class GestionCeldas extends DefaultTableCellRenderer{
	
	private String tipo="";
	private JLabel label = new JLabel();
	private ImageIcon iconoAgregar = new ImageIcon(getClass().getResource("/Imagenes/boton-agregar.png"));
        private ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/Imagenes/eliminar.png"));
	

	
	public GestionCeldas(String tipo){
		this.tipo=tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            if( tipo.equals("icono")){
                if(String.valueOf(value).equals("Agregar")){
                    label.setIcon(iconoAgregar);
                } else{
                    label.setIcon(iconoEliminar);
                }
                return label;
            }



            return this;
		
		
	}
	
	
	
}
