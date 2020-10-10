
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

    public Reader(Stack stack, List list) {
        this.stack = stack;
        this.list = list;
        read();
    }
    
    public void read(){
        
        try {
            File file = new File("C:\\Users\\Ivan L\\Desktop\\final.txt");
            Producto temp;
            Scanner sc = new Scanner(file);
            String[] linea;
            long timeStack = System.nanoTime();
            while(sc.hasNextLine()) {
                linea=sc.nextLine().split(" ");
                temp = new Producto(linea[0], linea[1], Integer.parseInt(linea[2]));
                stack.push(temp);
            }
            System.out.println("Inserting "+stack.getTop()+" elements Stack: "+(System.nanoTime()-timeStack));
            sc = new Scanner(file);
            long timeList = System.nanoTime();
            while(sc.hasNextLine()) {
                linea=sc.nextLine().split(" ");
                temp = new Producto(linea[0], linea[1], Integer.parseInt(linea[2]));
                list.insert(temp);
            }
            System.out.println("Inserting "+list.getCount()+" elements List: "+(System.nanoTime()-timeList));
            sc.close();
        }catch(FileNotFoundException e) {
            System.out.println("Error en la lectura del archivo\n"+e.getMessage());
        }
    }

}
