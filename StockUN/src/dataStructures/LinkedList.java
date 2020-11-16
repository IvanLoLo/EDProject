
package dataStructures;

import principal.Producto;

public class LinkedList {
    
    private GenericNode<Producto> head;
    private GenericNode<Producto> position, cola;
    private int cant;

    public GenericNode<Producto> getHead() {
        return head;
    }
    public void setHead(GenericNode<Producto> head) {
        this.head = head;
    }
    public GenericNode<Producto> getPosition() {
        return position;
    }
    public void setPosition(GenericNode<Producto> position) {
        this.position = position;
    }
    public int getCant() {
        return cant;
    }
    public void setCant(int cant) {
        this.cant = cant;
    }
    public Object[] toArray(){
        
        Producto[] temp = new Producto[10006];
        GenericNode<Producto> curr = head;
        int i = 0;
        while(curr!=null){
            temp[i++] = curr.getData();
        }
        
        return temp;
    }
    
    
    public LinkedList(){
        head = position = cola = null;
        cant = 0;
    }

    public boolean empty(){
        return head == null;
    }

    public boolean insert(Producto item) {

        boolean inserted = false;
        GenericNode<Producto> ptr;

        if(search(item,0)) return false;//Ya esta en la lista

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
        
        if(inserted) cant++;

        return inserted;
    }

    public boolean update(Producto item){
        /*if(!search(item,0)) return false; //No esta en la lista
        position.setData(item);*/
        
        search(item,0);
        if(position!=null && ((Producto)position.getNext().getData()).compareTo(item)!=0) return false;
        GenericNode<Producto> ptr = head;
        while(((Producto)ptr.getNext().getData()).compareTo(item)<0)
            ptr = ptr.getNext();
        if(ptr.getData().compareTo(item)==0) head.setData(item);
        else ptr.getNext().setData(item);
        
        return true;
    }

    public boolean delete(Producto item){
        if(empty()) return false; //No esta en la lista
        //Hay que buscar si el siguiente al actual es el que buscamos
        //porque no hay forma de mirar el anterior nodo
        search(item,0);
        if(position!=null && ((Producto)position.getNext().getData()).compareTo(item)!=0) return false;
        GenericNode<Producto> ptr = head;
        while(((Producto)ptr.getNext().getData()).compareTo(item)<0)
            ptr = ptr.getNext();
        if(ptr.getData().compareTo(item)==0) head = head.getNext();
        else ptr.setNext(ptr.getNext().getNext());
        return true;
    }

    public boolean search(Producto item, int n){//Metodo search
        if(head==null) return false;
        long timeSearch = System.nanoTime();
        GenericNode<Producto> ptr = head;
        GenericNode<Producto> prev = null;
        while(ptr != null && ptr.getData().compareTo(item)<0) {
            prev = ptr;
            ptr = ptr.getNext();
        }

        position = prev;
        if(n==1) System.out.println("Searching LinkedList: "+(System.nanoTime()-timeSearch));

        if(position == null) return false;
        if(position.getData().compareTo(item)==0) return true;
        return false;
    }

    public void printR(GenericNode<Producto> p) {
        while(p!=null){
            System.out.print(p.getData()+" | ");
            p = p.getNext();
        }
        System.out.println("");
    }
    
    public Producto giveMe(GenericNode<Producto> p){
        if(p!=null) return p.getData();
        return null;
    }

}
