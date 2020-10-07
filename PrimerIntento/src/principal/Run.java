
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
        
        inventLista = new GenericList<Producto>(101);
        inventStack = new GenericStack<Producto>(101);
        
        Reader read = new Reader(inventStack, inventLista);
        
        while(true){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Agregar");
            System.out.println("2. Mostrar Todos");
            System.out.println("9. Salir");
            opcion = Integer.valueOf(sc.nextLine());
            switch(opcion){
                case 1: agregar();
                break;
                case 2: mostrar();
                break;
                case 9: guardar();
                return;
                default: System.out.println("Que paso");
            }
            System.out.println("Presione cualquier tecla para continuar...");
            sc.nextLine();
        }
        
    }
    
    private static void guardar(){
        Saver save = null;
        if(!inventLista.empty())
            save = new Saver(inventLista);
    }
    
    private static void agregar() {
        System.out.println("Informacion:");
        String[] info = sc.nextLine().split(" ");
        Producto producto = new Producto(info[0], info[1], 1);
        inventStack.push(producto);
        inventLista.insert(producto);
        
    }
    
    private static void mostrar() {
        inventStack.print("Hola", 1);
        inventLista.output(1);
    }
        
}
