
package principal;

import dataStructures.*;
import java.util.Scanner;

public class Run {
    
    static int opcion;
    static dataStructures.List inventLista;
    static dataStructures.Stack inventStack;
    static dataStructures.LinkedList inventListaRef;
    static dataStructures.Heap inventHeap;
    static  Scanner sc;
    
    public static void main(String[] args){
        
        //new ventanas.InterfazPrincipal().setVisible(true);
        
        sc = new Scanner(System.in);
        //Todo listo
        //inventLista = new List(102);
        //inventStack = new Stack(102);
        inventLista = new dataStructures.List(100005);
        inventStack = new dataStructures.Stack(100005);
        inventListaRef = new dataStructures.LinkedList();
        inventHeap = new dataStructures.Heap(10005);
        
        Reader read = new Reader(inventStack, inventLista, inventListaRef, inventHeap);
        
        while(true){
            System.out.println("Escoja una opcion:");
            System.out.println("1. Agregar");
            System.out.println("2. Mostrar Stack");
            System.out.println("3. Mostrar Lista");
            System.out.println("4. Mostrar Lista Referenciada");
            System.out.println("5. Mostrar Heap");
            System.out.println("6. Buscar en Stack");
            System.out.println("7. Buscar en Lista");
            System.out.println("8. Buscar en Lista Referenciada");
            System.out.println("9. Buscar en Heap");
            System.out.println("10. Guardar y salir");
            System.out.println("11. Salir sin guardar");
            opcion = comprobar(sc);
            while(opcion<1 || opcion>11){
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
                case 5: inventHeap.print();
                    break;
                case 6:
                case 7:
                case 8:
                case 9: System.out.println("Ingrese el nombre del producto");
                        buscar(sc.nextLine(), opcion);
                        break;
                case 10: guardar();
                case 11: return;
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
        inventHeap.insertItem(producto);
    }
    
    private static void buscar(String name, int opc){
        Producto item = new Producto(name, 0, 0);
        if(opc==6 && inventStack.doSearch(item,1))
            System.out.println(inventStack.giveMe(inventStack.getPosition()));
        else if(opc==7 && inventLista.smartSearch(item,1))
            System.out.println(inventLista.giveMe(inventLista.getPosition()));
        else if(opc==8){
            buscarEnListaRef(item);
        }else if(opc==9 && inventHeap.doSearch(item)){
            System.out.println(inventHeap.giveMe(inventHeap.position));
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
