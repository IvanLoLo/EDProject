
package principal;

import dataStructures.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Saver{
    private dataStructures.List list;
    private dataStructures.Stack stack;
    private dataStructures.LinkedList listRef;

    public Saver(dataStructures.List list, dataStructures.Stack stack, dataStructures.LinkedList listRef) {
        this.list = list;
        this.stack = stack;
        this.listRef = listRef;
        save();
    }
    
    public void save(){
        try {
            FileWriter fw = new FileWriter("src\\recursos\\nuevosDatosLista.txt");
            for(int i=0; i<list.getCount(); i++) {
                Producto item = list.giveMe(i);
                String[] datos = item.toString().split(" ");
                fw.write(datos[0]);
                fw.write(" "+datos[1]);
                fw.write(" "+datos[2]);
                fw.write("\r\n");
            }
            fw.close();
            
            FileWriter fw2 = new FileWriter("src\\recursos\\nuevosDatosStack.txt");
            for(int i=0; i<stack.getTop(); i++) {
                Producto item = stack.giveMe(i);
                String[] datos = item.toString().split(" ");
                fw2.write(datos[0]);
                fw2.write(" "+datos[1]);
                fw2.write(" "+datos[2]);
                fw2.write("\r\n");
            }
            fw2.close();
            
            FileWriter fw3 = new FileWriter("src\\recursos\\nuevosDatosListaRef.txt");
            GenericNode<Producto> current = listRef.getHead();
            while(current!=null) {
                Producto item = listRef.giveMe(current);
                String[] datos = item.toString().split(" ");
                fw3.write(datos[0]);
                fw3.write(" "+datos[1]);
                fw3.write(" "+datos[2]);
                fw3.write("\r\n");
                current = current.getNext();
            }
            fw3.close();
        }catch(IOException e) {
                System.out.println("No fue posible guardar. Disculpe las molestias");
        }
    }

}
