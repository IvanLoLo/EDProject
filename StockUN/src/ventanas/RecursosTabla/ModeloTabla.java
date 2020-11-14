
package ventanas.RecursosTabla;

import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ModeloTabla extends DefaultTableModel{

    String[] titulos;
    Object[][] datos;

    public ModeloTabla(Object[][] datos, String[] titulos) {
        this.titulos = titulos;
        this.datos = datos;
        setDataVector(datos, titulos);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    
    
    
}
