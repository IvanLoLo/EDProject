
package dataStructures;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GenericLinkedList<T> {
    
    GenericNode head, cola;
    int size;
    
    public int getSize(){
        return size;
    }

    public GenericLinkedList() {
        this.head = null;
        this.cola = null;
        this.size = 0;
    }
    
    public void add(T value){
        
        if(head==null){
            head = new GenericNode(value);
            cola = head;
        }else{
            GenericNode nuevo = new GenericNode(value);
            cola.setNext(nuevo);
            cola = cola.getNext();
        }
        
        size++;
    }
    
    public void remove(T value){
        
        GenericNode temp = head;
        GenericNode prev = null;
        while(temp!=null){
            if(temp.getData().equals(value)){
                if(prev==null) head = head.getNext();
                else prev.setNext(temp.getNext());
                break;
            }
            prev = temp;
            temp = temp.getNext();
        }
        
        size--;
        
    }
    
    public T[] toArray(){
        GenericNode curr = head;
        T[] temp = (T[]) new Object[size];
        int i = 0;
        while(curr!=null){
            temp[i] = (T) curr.getData();
            curr = curr.getNext();
            i++;
        }
        return temp;
    }
    
    
    
    

}
