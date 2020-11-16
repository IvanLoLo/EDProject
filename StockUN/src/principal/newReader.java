
package principal;

import dataStructures.LinkedList;
import dataStructures.List;
import dataStructures.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class newReader {
    
    private Object listado;
    private int structure;

    public newReader(Object listado, int estructura) {
        this.listado = listado;
        this.structure = estructura;
        read();
    }
    
    public void read(){
        
        try {
            Producto temp;
            File file = new File("src\\recursos\\Prueba10k.txt");
            Scanner sc = new Scanner(file);
            String[] linea;
            long timeList = System.nanoTime();
            
            while(sc.hasNextLine()) {
                linea=sc.nextLine().split(" ");
                temp = new Producto(linea[0], Long.parseLong(linea[1]), Integer.parseInt(linea[2]));
                insertEstructura(temp);
            }
            System.out.println("Inserting "+countEstructura()+" elements at "+listado.getClass()+": "+(System.nanoTime()-timeList));
            
            if(structure==1) ((dataStructures.Stack) listado).sort();
            else if(structure==4) ((dataStructures.Heap) listado).sort();
            
            sc.close();
        }catch(FileNotFoundException e) {
            System.out.println("Error en la lectura del archivo\n"+e.getMessage());
        }
    }
    
    public void insertEstructura(Producto item){
        
        switch(structure){
            case 1: ((dataStructures.Stack) listado).push(item);
            break;
            case 2: ((dataStructures.List) listado).sortedInsert(item);
            break;
            case 3: ((dataStructures.LinkedList) listado).insert(item);
            break;
            case 4: ((dataStructures.Heap) listado).insertItem(item);
            break;
            default: System.out.println("Estructura no encontrada");
        }
        
    }
    
    private int countEstructura(){
        
        switch(structure){
            case 1: return ((dataStructures.Stack) listado).getTop();
            case 2: return ((dataStructures.List) listado).getCount();
            case 3: return ((dataStructures.LinkedList) listado).getCant();
            case 4: return ((dataStructures.Heap) listado).getSize();
            default: System.out.println("Estructura no encontrada");
        }
        
        return -1;
        
    }


}
