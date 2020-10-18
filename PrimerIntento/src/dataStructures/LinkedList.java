
package dataStructures;

import principal.Producto;

public class LinkedList {
    
    private GenericNode<Producto> head;
    private GenericNode<Producto> position, cola;

    public GenericNode<Producto> getHead() {
        return head;
    }
    public void setHead(GenericNode<Producto> head) {
        this.head = head;
    }
    
    public LinkedList(){
        head = position = cola = null;
    }

    public boolean empty(){
        return head == null;
    }
    
    /*public boolean insert(Producto item){
        boolean inserted = false;
        if(search(item)) return false;
        GenericNode<Producto> temp = new GenericNode<>(item);
        if(cola==null){
            cola = temp;
            if(head==null) head = cola;
        }
        else{
            cola.setNext(temp);
            cola = cola.getNext();
        }
        inserted = true;
        
        return inserted;
    }*/

    public boolean sortedInsert(Producto item) {

        boolean inserted = false;
        GenericNode<Producto> ptr;

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
        System.out.println(search(item));
        if(!search(item) || empty()) return false; //No esta en la lista
        //Hay que buscar si el siguiente al actual es el que buscamos
        //porque no hay forma de mirar el anterior nodo
        GenericNode<Producto> ptr = head;
        while(((Producto)ptr.getNext().getData()).compareTo(item)<0)
            ptr = ptr.getNext();
        if(ptr.getData()==item) head = head.getNext();
        else ptr.setNext(ptr.getNext().getNext());
        return true;
    }

    public boolean search(Producto item){

        GenericNode<Producto> ptr = head;
        GenericNode<Producto> prev = null;
        System.out.println("Punteros:");
        while(ptr != null && ptr.getData().compareTo(item)<0) {
            System.out.println(ptr.getData());
            prev = ptr;
            ptr = ptr.getNext();
        }

        position = prev;

        if(position == null) return false;
        if(position.getData().compareTo(item)==0) return true;
        return false;
    }

    public void printR(GenericNode<Producto> p) {
            if(p != null) {
                    System.out.print(p.getData()+" ");
                    printR(p.getNext());
            }
    }

}
