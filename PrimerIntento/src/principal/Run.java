
package principal;

import dataStructures.*;
import java.util.Scanner;

public class Run {
    
    static int opcion;
    static GenericList<Producto> inventLista;
    static GenericStack<Producto> inventStack;
    static  Scanner sc;
    
    public static void main(String[] args){
        
        sc = new Scanner(System.in);
        
        inventLista = new GenericList<Producto>(100);
        inventStack = new GenericStack<Producto>(100);
        
        while(true){
            System.out.println("Escoja una opcion:");
            opcion = Integer.valueOf(sc.nextLine());
            switch(opcion){
                case 1: agregar();
                break;
                case 2: mostrar();
                break;
                default: System.out.println("Que paso");
            }
        }
    }      
    
    private static void agregar() {
        System.out.println("Informacion:");
        String[] info = sc.nextLine().split(" ");
        Producto producto = new Producto(info[0], info[1], Integer.valueOf(info[2]));
        inventStack.push(producto);
        
    }
    
    private static void mostrar() {
        inventStack.print("Hola");
    }
        
}
