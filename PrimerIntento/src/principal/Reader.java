
package principal;

import dataStructures.*;
import java.io.*;
import java.util.Scanner;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Reader {
    
    private GenericStack stack;
    private GenericList list;

    public Reader(GenericStack stack, GenericList list) {
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
            while(sc.hasNextLine()) {
                linea=sc.nextLine().split(" ");
                temp = new Producto(linea[0], linea[1], 1);
                stack.push(temp);
                list.insert(temp);
            }
            sc.close();
        }catch(FileNotFoundException e) {
            System.out.println("Error en la lectura del archivo\n"+e.getMessage());
        }
    }

}
