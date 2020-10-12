
package principal;

import dataStructures.*;
import java.util.Scanner;

public class Run {
    
    static int opcion;
    static List inventLista;
    static Stack inventStack;
    static  Scanner sc;
    
    public static void main(String[] args){
        
        sc = new Scanner(System.in);
        
        //inventLista = new List(102);
        //inventStack = new Stack(102);
        inventLista = new List(10001);
        inventStack = new Stack(10001);
        
        Reader read = new Reader(inventStack, inventLista);
        
        while(true){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Agregar");
            System.out.println("2. Mostrar Stack");
            System.out.println("3. Mostrar Lista");
            System.out.println("4. Buscar en Stack");
            System.out.println("5. Buscar en Lista");
            System.out.println("9. Salir");
            opcion = sc.nextInt();
            switch(opcion){
                case 1: agregar();
                break;
                case 2: mostrarStack();
                break;
                case 3: mostrarList();
                break;
                case 4: 
                case 5: System.out.println("Ingrese el nombre del producto");
                    buscar(sc.nextLine(), opcion);
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
        Producto producto = new Producto(info[0], Long.parseLong(info[1]), 1);
        inventStack.push(producto);
        inventLista.sortedInsert(producto);
        
    }
    
    private static void mostrarStack() {
        inventStack.print(1);
    }
    
    private static void mostrarList() {
        inventLista.output(1);
    }
    
    private static void buscar(String name, int opc){
        Producto item = new Producto(name, 0, 0);
        if(opc==4 && inventStack.doSearch(item))
            System.out.println(inventStack.giveMe(inventStack.getPosition()));
        else if(inventLista.doSearch(item))
            System.out.println(inventLista.giveMe(inventLista.getPosition()));
        else System.out.println("No se ha encontrado un producto con el nombre señalado");//No esta
            
    }
        
}
