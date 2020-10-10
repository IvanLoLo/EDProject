
package dataStructures;

import principal.Producto;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class LinkedList {
    
    private GenericNode<Producto> head;
    private GenericNode<Producto> position;

    public LinkedList(){
        head = null;
    }

    public boolean empty(){
        return head == null;
    }

    public boolean insert(Producto item) {

        boolean inserted;
        GenericNode<Producto> ptr;
        inserted = false;

        if(search(item)) return false;//Ya esta en la lista

        ptr = position;
        if(position == null) ptr = head;
        else ptr = position.getNext();

        if (ptr == null || ptr.getData()!=item) {
            inserted = true;
            GenericNode<Producto> newp = new GenericNode<Producto>(item);
            newp.setNext(ptr);
            if(position == null)
                head = newp;
            else
                position.setNext(newp);
        }

        return inserted;
    }

    public boolean update(Producto item){
        if(!search(item)) return false; //No esta en la lista
        position.setData(item);
        return true;
    }

    public boolean delete(Producto item){
        if(!search(item) || empty()) return false; //No esta en la lista
        //Hay que buscar si el siguiente al actual es el que buscamos
        //porque no hay forma de mirar el anterior nodo
        return true;
    }

    public boolean search(Producto item){

        GenericNode<Producto> ptr = head;
        GenericNode<Producto> prev = null;

        while(ptr != null && ptr.getData().compareTo(item)<0) {
            prev = ptr;
            ptr = ptr.getNext();
        }

        position = prev;

        if(position == null) return false;
        if(position.getData().compareTo(item)==0) return true;
        return false;
    }

    private void printR(GenericNode<Producto> p) {
            if(p != null) {
                    System.out.print(p.getData()+" ");
                    printR(p.getNext());
            }
    }

}
