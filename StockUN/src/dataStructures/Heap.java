package dataStructures;

import principal.Producto;

public class Heap {

    private final int n;
    private Producto[] array;
    private int size, position;

    public Heap(int n) {
        this.n = n;
        array = new Producto[n];
        size = 0;
    }

    public void insertItem(Producto item) {
        array[size] = item;
        moveUp();
        size++;
    }

    private void moveUp() {
        int child = size;
        int parent = (child-1)/2;
        Producto temp = array[child];
        while(child > 0 && temp.compareTo(array[parent])<0) {
            array[child] = array[parent];
            child = parent;
            parent = (child-1)/2;
        }
        array[child] = temp;
    }

    public Producto removeMin() {
        Producto min = array[0];
        array[0] = array[--size];
        moveDown();
        return min;
    }

    private void moveDown() {
        boolean flag = false;
        Producto smallest = null;
        int parent = 0;
        int child = 2*parent+1;
        Producto temp = array[parent];
        while(child < size && !flag) {
            smallest = array[child];
            if(child+1 < size && array[child+1].compareTo(array[child])<0)
                smallest = array[++child];
            if(smallest.compareTo(temp)<0) {
                array[parent] = smallest;
                parent = child;
            }
            else flag = true;

            child = 2*parent+1;
        }

        array[parent] = temp;
    }

    public void sort(){
        SortClass.heapSort(array, size);
    }
    
    public boolean search(Producto item){
        int i=0;
        while(i<size-1 && array[i].compareTo(item)!=0) i++;
        if(i>array.length) return false;
        if(array[i].compareTo(item)==0){
            position = i;
            return true;
        }
        return false;
    }
    
    /*
    private void removeMin(){
        
        int min = array[0];
        array[0] = array[--size];
        moveDown();
        //return min;
        
    }
    */
    
    public boolean delete(Producto item){
        int i=0;
        if(!search(item)) return false;
        for(int k = position; k<size-1; k++){
            array[k]=array[k+1];
        }
        array[--size] = null;
        return true;
    }
    
    public Producto giveMe(int n){
        if(n>size) return null;
        return array[n];
    }
    
    public boolean empty(){
        return size<=0;
    }
    
    public Object[] getArray(){
        return array;
    }
    
    public int getSize(){
        return size;
    }
    
    public void print(){
        for(int i=0; i<size; i++)
            System.out.print(array[i]+" | ");
        System.out.println("");
    }
    
    public static void main(String[] args) {
        
        Heap heap = new Heap(50);
        
        heap.insertItem(new Producto("A", 1, 1));
        heap.insertItem(new Producto("D", 1, 1));
        heap.insertItem(new Producto("J", 1, 1));
        heap.insertItem(new Producto("K", 1, 1));
        heap.insertItem(new Producto("f", 1, 1));
        heap.insertItem(new Producto("R", 1, 1));
        heap.insertItem(new Producto("P", 1, 1));
        heap.insertItem(new Producto("Q", 1, 1));
        heap.insertItem(new Producto("B", 1, 1));
        heap.insertItem(new Producto("L", 1, 1));
        heap.insertItem(new Producto("E", 1, 1));
        heap.insertItem(new Producto("S", 1, 1));
        heap.insertItem(new Producto("W", 17, 17));
        heap.insertItem(new Producto("G", 1, 1));
        heap.insertItem(new Producto("F", 1, 1));
        heap.insertItem(new Producto("f", 1, 1));
        heap.insertItem(new Producto("O", 1, 1));
        heap.insertItem(new Producto("H", 1, 1));
        heap.insertItem(new Producto("N", 1, 1));
        heap.insertItem(new Producto("I", 10, 10));
        
        heap.sort();
        
        heap.delete(new Producto("Q", 0, 0));
        System.out.println("Esta?: "+heap.search(new Producto("Zasd", 0, 0)));
        System.out.println("Aqui esta: "+heap.giveMe(heap.position));
        //heap.delete(8);
        
        for(int i=0; i<heap.array.length; i++)
            System.out.println(heap.array[i]);
        
        
        
    }

}