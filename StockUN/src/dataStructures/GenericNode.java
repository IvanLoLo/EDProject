
package dataStructures;

public class GenericNode<T>{
    
    private T data;
    private GenericNode<T> next;
    
    public GenericNode() {
        this(null);
    }
    
    public GenericNode(T data) {
        this.data = data;
        next = null;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public GenericNode getNext() {
        return next;
    }
    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

}
