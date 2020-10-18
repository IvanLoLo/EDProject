
package principal;

import dataStructures.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Saver{
    private List list;
    private Stack stack;

    public Saver(List list, Stack stack) {
        this.list = list;
        this.stack = stack;
        save();
    }
    
    public void save(){
        try {
            FileWriter fw = new FileWriter("src\\recursos\\nuevosDatos.txt");
            for(int i=0; i<list.getCount(); i++) {
                Producto item = list.giveMe(i);
                System.out.println(item);
                String[] datos = item.toString().split(" ");
                fw.write(datos[0]);
                fw.write(" "+datos[1]);
                fw.write(" "+datos[2]);
                fw.write("\r\n");
            }
            fw.close();
            FileWriter fw2 = new FileWriter("src\\recursos\\nuevosDatos2.txt");
            for(int i=0; i<stack.getTop(); i++) {
                Producto item = stack.giveMe(i);
                String[] datos = item.toString().split(" ");
                fw2.write(datos[0]);
                fw2.write(" "+datos[1]);
                fw2.write(" "+datos[2]);
                fw2.write("\r\n");
            }
            fw2.close();
        }catch(IOException e) {
                System.out.println("No fue posible guardar. Disculpe las molestias");
        }
    }

}
