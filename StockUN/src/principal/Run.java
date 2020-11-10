
package principal;

import dataStructures.*;
import java.util.Scanner;
import userInterface.*;

public class Run {
    
    static int opcion;
    static List inventLista;
    static Stack inventStack;
    static LinkedList inventListaRef;
    static  Scanner sc;
    
    public static void main(String[] args){
        
        Ventana prueba = new Ventana();
        prueba.setVisible(true);
        
        sc = new Scanner(System.in);
        
        //inventLista = new List(102);
        //inventStack = new Stack(102);
        inventLista = new List(100005);
        inventStack = new Stack(100005);
        inventListaRef = new LinkedList();
        
        Reader read = new Reader(inventStack, inventLista, inventListaRef);
        
        while(true){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Agregar");
            System.out.println("2. Mostrar Stack");
            System.out.println("3. Mostrar Lista");
            System.out.println("4. Mostrar Lista Referenciada");
            System.out.println("5. Buscar en Stack");
            System.out.println("6. Buscar en Lista");
            System.out.println("7. Buscar en Lista Referenciada");
            System.out.println("8. Guardar y salir");
            System.out.println("9. Salir sin guardar");
            opcion = comprobar(sc);
            while(opcion<1 || opcion>9){
                System.out.println("Ingrese una opción válida");
                opcion = comprobar(sc);
            }
            switch(opcion){
                //case 0: delete();
                //    break;
                case 1: agregar();
                    break;
                case 2: inventStack.print();
                    break;
                case 3: inventLista.output();
                    break;
                case 4: inventListaRef.printR(inventListaRef.getHead());
                    break;
                case 5:
                case 6:
                case 7: System.out.println("Ingrese el nombre del producto");
                        buscar(sc.nextLine(), opcion);
                    break;
                case 8: guardar();
                case 9: return;
                default: System.out.println("Que paso");
            }
            System.out.println("Presione cualquier tecla para continuar...");
            sc.nextLine();
        }
        
    }
    
    private static int comprobar(Scanner scan){
        try{
            String temp = scan.nextLine();
            return Integer.parseInt(temp);
        }catch(NumberFormatException e){
            return -1;
        }
    }
    
    private static void guardar(){
        Saver save = null;
        if(!inventLista.empty())
            save = new Saver(inventLista, inventStack, inventListaRef);
    }
    
    private static void agregar() {
        System.out.println("Informacion:");
        String[] info = sc.nextLine().split(" ");
        Producto producto = new Producto(info[0], Long.parseLong(info[1]), Integer.parseInt(info[2]));
        inventStack.push(producto);
        inventLista.sortedInsert(producto);
        inventListaRef.insert(producto);
    }
    
    private static void buscar(String name, int opc){
        Producto item = new Producto(name, 0, 0);
        if(opc==5 && inventStack.doSearch(item,1))
            System.out.println(inventStack.giveMe(inventStack.getPosition()));
        else if(opc==6 && inventLista.smartSearch(item,1))
            System.out.println(inventLista.giveMe(inventLista.getPosition()));
        else if(opc==7){
            buscarEnListaRef(item);
        }
        else System.out.println("No se ha encontrado un producto con el nombre señalado");
            
    }
    
    private static void buscarEnListaRef(Producto item){
        boolean esta = false;
            inventListaRef.search(item,1);
            if(inventListaRef.getPosition()!=null){
                inventListaRef.setPosition(inventListaRef.getPosition().getNext());
                if(inventListaRef.giveMe(inventListaRef.getPosition()).compareTo(item)==0) esta = true;
            }else if(inventListaRef.giveMe(inventListaRef.getHead()).compareTo(item)==0){
                inventListaRef.setPosition(inventListaRef.getHead());
                esta = true;
            }
            if(esta) System.out.println(inventListaRef.giveMe(inventListaRef.getPosition()));
            else System.out.println("No se ha encontrado un producto con el nombre señalado");
    }
    
    private static void delete(){
        String name = sc.nextLine().split(" ")[0];
        Producto temp = new Producto(name, 0, 0);
        if(!inventStack.delete(temp))
            System.out.println("No se ha encontrado un producto con el nombre señalado");
        if(!inventLista.delete(temp))
            System.out.println("No se ha encontrado un producto con el nombre señalado");
        if(!inventListaRef.delete(temp))
            System.out.println("No se ha encontrado un producto con el nombre señalado");
    }
        
}
