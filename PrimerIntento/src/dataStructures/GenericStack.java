/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataStructures;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GenericStack<T extends Comparable<T>> {
    private int N;
    private int top;
    private T[] sarray;
    // constructors
    
    public GenericStack(int n) {
        this.N = n;
        this.top = 0;
        this.sarray = (T[]) new Comparable[N];
    }
    // value returning methods
    public boolean empty() {
        return top <= 0;
    }
    private boolean full() {
        return top >= sarray.length;
    }
    public T pop() {
        if(empty())
            throw new RuntimeException("Stack is empty");
        top--;
        return sarray[top];
    }
    // void method
    public void push(T item) {
        if(full())
            throw new RuntimeException("Stack is full");
        sarray[top]=item;
        top++;
    }
    
    public void print(String name, int n){
        if(n==1) sortV1();
        for(int i=0; i<top; i++){
            System.out.print(sarray[i].toString()+" | ");
        }
        System.out.println("");
    }
    
    public T peek(){
        if(!this.empty()) return sarray[top-1];
        return null;
    }
    
    public void sortV1(){
        GenericStack<T> aux = new GenericStack<T>(N);
        while(!this.empty()){
            T temp = this.pop();
            while(!aux.empty() && aux.peek().compareTo(temp)>0)
                this.push(aux.pop());
            aux.push(temp);
        }
        this.top = aux.top;
        this.sarray = aux.sarray;
        
    }
    
    public void sortV2(){
        GenericStack<T> aux1 = new GenericStack<T>(N);
        GenericStack<T> aux2 = new GenericStack<T>(N);
        int max = top-1;
        if(!this.empty()) aux1.push(this.pop());
        for(int i=0; i<max; i++){
            int j = aux1.top;
            T item = this.pop();
            while(j>0 && !aux1.empty() && item.compareTo(aux1.sarray[j-1])<0){
                aux2.push(aux1.pop());
                j--;
            }
            aux1.push(item);
            while(!aux2.empty())
                aux1.push(aux2.pop());
        }
        
        this.top = aux1.top;
        this.sarray = aux1.sarray;
    }
    
    public T giveMe(int n){
        if(top>n) return sarray[n];
        return null;
    }
    
    
}
