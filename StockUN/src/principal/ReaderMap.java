
package principal;

import dataStructures.Map;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderMap<K, V> {
    
    public Map<K, V> mapa = null;

    public ReaderMap() {
        read();
    }

    public void read(){
        
        try {
            mapa = new Map(10);
            Producto temp;
            File file = new File("src\\recursos\\Mapa.txt");
            Scanner sc = new Scanner(file);
            String[] linea;
            int i = 0;
            long time = System.nanoTime();
            while(sc.hasNextLine()) {
                linea=sc.nextLine().split(" ");
                mapa.add((K) linea[0], (V) linea[1], 0);
                i++;
            }
            System.out.println("Tiempo registrando "+i+" usuarios: "+(System.nanoTime()-time));
            sc.close();
        }catch(FileNotFoundException e) {
            System.out.println("Error en la lectura del archivo\n"+e.getMessage());
        }
        
    }

}
