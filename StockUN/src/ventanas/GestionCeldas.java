package ventanas;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Diego
 */
public class GestionCeldas implements TableCellRenderer {

    private  String tipo;
    private JLabel jAgregar=new JLabel();
    

    public GestionCeldas(String tipo) {
        this.tipo=tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(tipo.equals("icono"))      { 
         jAgregar.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Agregar")));
         
        }
     
     return jAgregar;
    }
     
}
