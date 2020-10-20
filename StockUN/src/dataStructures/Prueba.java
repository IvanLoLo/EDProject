
package dataStructures;

import principal.Producto;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Prueba {
    
    public static void main(String[] args){
        
        LinkedList lista = new LinkedList();
        lista.insert(new Producto("aaaaa", 50000, 2));
        lista.insert(new Producto("aa", 5000, 20));
        lista.insert(new Producto("abaaa", 500, 200));
        lista.insert(new Producto("zzzzz", 5, 20000));
        lista.insert(new Producto("accccc", 50, 2000));
        lista.insert(new Producto("ddddd", 1, 200000));
        lista.delete(new Producto("abaaa", 0, 0));
        lista.printR(lista.getHead());
        
        
    }

}
