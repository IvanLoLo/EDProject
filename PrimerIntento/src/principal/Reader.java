
package principal;

import dataStructures.*;
import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Reader {
    
    private Stack stack;
    private List list;
    private LinkedList listRef;

    public Reader(Stack stack, List list, LinkedList listRef) {
        this.stack = stack;
        this.list = list;
        this.listRef = listRef;
        read();
    }
    
    public void read(){
        
        try {
            //File file = new File("C:\\Users\\Ivan L\\Desktop\\final.txt"); //RUTA IVAN
            //File file = new File("C:\\Users\\dsrod\\Documents\\UN\\2020-2\\Estructuras de datos\\Proyecto\\final.txt"); //RUTA SANTIAGO
            
            Producto temp;
            //Scanner sc = new Scanner(file);
            File file = new File("src\\recursos\\Prueba100k.txt");
            Scanner sc = new Scanner(file);
            String[] linea;
            long timeStack = System.nanoTime();
            while(sc.hasNextLine()) {
                linea=sc.nextLine().split(" ");
                temp = new Producto(linea[0], Long.parseLong((linea[1])), Integer.parseInt(linea[2]));
                stack.push(temp);
            }
            System.out.println("Inserting "+stack.getTop()+" elements Stack: "+(System.nanoTime()-timeStack));
            
            sc = new Scanner(file);
            long timeList = System.nanoTime();
            while(sc.hasNextLine()) {
                linea=sc.nextLine().split(" ");
                temp = new Producto(linea[0], Long.parseLong(linea[1]), Integer.parseInt(linea[2]));
                list.sortedInsert(temp);
            }
            System.out.println("Inserting "+list.getCount()+" elements List: "+(System.nanoTime()-timeList));
            
            sc = new Scanner(file);
            long timeListRef = System.nanoTime();
            while(sc.hasNextLine()) {
                linea=sc.nextLine().split(" ");
                temp = new Producto(linea[0], Long.parseLong(linea[1]), Integer.parseInt(linea[2]));
                listRef.insert(temp);
            }
            System.out.println("Inserting "+listRef.getCant()+" elements LinkedList: "+(System.nanoTime()-timeListRef));
            sc.close();
        }catch(FileNotFoundException e) {
            System.out.println("Error en la lectura del archivo\n"+e.getMessage());
        }
    }

}
