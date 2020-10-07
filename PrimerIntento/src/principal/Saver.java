
package principal;

import dataStructures.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Saver<T extends Comparable<T>>{
    private GenericList<T> list;

    public Saver(GenericList<T> list) {
        this.list = list;
        save();
    }
    
    public void save(){
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Ivan L\\Desktop\\nuevosDatos.txt");
            for(int i=0; i<list.getCount(); i++) {
                T item = list.giveMe(i);
                String[] datos = item.toString().split(" ");
                fw.write(datos[0]);
                fw.write(" "+datos[1]);
                fw.write(" "+datos[2]);
                fw.write("\r\n");
            }
            fw.close();
        }catch(IOException e) {
                System.out.println("No fue posible guardar los contactos. Disculpe las molestias");
        }
    }

}
