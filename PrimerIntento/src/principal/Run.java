
package principal;

import dataStructures.*;
import java.util.Scanner;

public class Run {
    
    static int opcion;
    static GenericList inventLista;
    static GenericStack inventStack;
    static  Scanner sc;
    
    public static void main(String[] args){
        
        sc = new Scanner(System.in);
        
        inventLista = new GenericList(102);
        inventStack = new GenericStack(102);
        
        Reader read = new Reader(inventStack, inventLista);
        
        while(true){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Agregar");
            System.out.println("2. Mostrar Stack");
            System.out.println("3. Mostrar Lista");
            System.out.println("3. Buscar");
            System.out.println("9. Salir");
            opcion = Integer.valueOf(sc.nextLine());
            switch(opcion){
                case 1: agregar();
                break;
                case 2: mostrarStack();
                break;
                case 3: mostrarList();
                break;
                case 4: System.out.println("Ingrese el nombre del producto");
                    buscar(sc.nextLine());
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
    
    private static void mostrarStack() {
        inventStack.print(1);
    }
    
    private static void mostrarList() {
        inventLista.output(1);
    }
    
    private static void buscar(String name){
        Producto item = new Producto(name, "", 0);
        inventLista.smartSearch(item);
    }
        
}
