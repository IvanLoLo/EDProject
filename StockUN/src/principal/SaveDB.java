
package principal;

import dataStructures.GenericNode;
import dataStructures.Map;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SaveDB <K, V>{
    
    Map<K, V> mapa;

    public SaveDB(Map<K, V> mapa) {
        this.mapa = mapa;
    }
    
    public void save(){
        
        try {
            
            Object[] keys = mapa.getKeys();
            FileWriter fw = new FileWriter("src\\recursos\\Mapa.txt");
            
            for(int i=0; i<keys.length; i++) {
                fw.write(keys[i].toString());
                fw.write(" "+mapa.get((K) keys[i]).toString());
                fw.write("\r\n");
            }
            fw.close();
        }catch(IOException e) {
                System.out.println("No fue posible guardar. Disculpe las molestias");
        }
        
    }

}
