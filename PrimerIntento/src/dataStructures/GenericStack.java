/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataStructures;

import principal.Producto;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GenericStack {
    private int N;
    private int top;
    private Producto[] sarray;
    private boolean sorted;

    public int getTop() {
        return top;
    }
    public void setTop(int top) {
        this.top = top;
    }
    // constructors
    
    public GenericStack(int n) {
        this.N = n;
        this.top = 0;
        this.sarray = new Producto[N];
    }
    // value returning methods
    public boolean empty() {
        return top <= 0;
    }
    private boolean full() {
        return top >= sarray.length;
    }
    public Producto pop() {
        if(empty())
            throw new RuntimeException("Stack is empty");
        top--;
        return sarray[top];
    }
    // void method
    public void push(Producto item) {
        if(full())
            throw new RuntimeException("Stack is full");
        if(!empty() && item.compareTo(peek())<0) sorted = false;
        sarray[top]=item;
        top++;
    }
    
    public void print(int n){
        if(!sorted)
            if(n==1) sortV1();
            else if(n==2) sortV2();
        for(int i=0; i<top; i++){
            System.out.print(sarray[i].toString()+" | ");
        }
        System.out.println("");
    }
    
    public Producto peek(){
        if(empty()) throw new RuntimeException("Stack is empty");
        return sarray[top-1];
    }
    
    public void sortV1(){
        long timeStack = System.nanoTime();
        GenericStack aux = new GenericStack(N);
        while(!this.empty()){
            Producto temp = this.pop();
            while(!aux.empty() && aux.peek().compareTo(temp)>0)
                this.push(aux.pop());
            aux.push(temp);
        }
        this.top = aux.top;
        this.sarray = aux.sarray;
        sorted = true;
        System.out.println("Sort1 Stack: "+(System.nanoTime()-timeStack));
    }
    
    public void sortV2(){
        long timeStack = System.nanoTime();
        GenericStack aux1 = new GenericStack(N);
        GenericStack aux2 = new GenericStack(N);
        int max = top-1;
        if(!this.empty()) aux1.push(this.pop());
        for(int i=0; i<max; i++){
            int j = aux1.top;
            Producto item = this.pop();
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
        sorted = true;
        System.out.println("Sort2 Stack: "+(System.nanoTime()-timeStack));
    }
    
    public Producto giveMe(int n){
        if(top>n) return sarray[n];
        return null;
    }
    
    
}
