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
public class Stack {
    private int N, top, position;
    private Producto[] sarray;
    private boolean sorted;

    public int getTop() {
        return top;
    }
    public void setTop(int top) {
        this.top = top;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    
    
    public Stack(int n) {
        this.N = n;
        this.top = 0;
        this.sarray = new Producto[N];
    }
    
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
    
    public void push(Producto item) {
        if(full())
            throw new RuntimeException("Stack is full");
        if(!empty() && item.compareTo(peek())<0) sorted = false;
        sarray[top]=item;
        top++;
    }
    
    public Producto peek(){
        if(empty()) throw new RuntimeException("Stack is empty");
        return sarray[top-1];
    }
    
    //Decidir que Sort dejar (el mas rapido)
    public void sortV1(){
        long timeStack = System.nanoTime();
        Stack aux = new Stack(N);
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
        Stack aux1 = new Stack(N);
        Stack aux2 = new Stack(N);
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
    
    public boolean search(Producto item) {//Posicion por posicion O(n)
        //long timeSearch = System.nanoTime();
        boolean found, stop;
        found = false;
        stop = false;
        position = 0;
        while(position != (top-1) && !found){
            if(sarray[position].compareTo(item) == 0)
                    found = true;
            else position++;
        }
        //System.out.println("Searching List: "+(System.nanoTime()-timeSearch));
        return found;
    }
    
    public boolean smartSearch(Producto item){
        position = 0;
        if(empty()) return false;
        boolean found = false;
        long timeSearch = System.nanoTime();
        int i = 0;
        int j = top-1;
        int k;
        do{
            k = (i+j)/2;
            if(sarray[k].compareTo(item)<=0) i=k+1;
            if(sarray[k].compareTo(item)>=0) j=k-1;
        }while(i<=j);
        position = k;
        if(item.compareTo(sarray[position])== 0) found = true;
        //System.out.println("Searching List: "+(System.nanoTime()-timeSearch));
        System.out.println(sarray[position]+" at: "+k+" found: "+found);
        return found;
    }
    
    public boolean doSearch(Producto item){
        if(sorted) return smartSearch(item);
        System.out.println("Voy por la normal");
        return search(item);
    }
    
    public boolean update(Producto item){
        if(!doSearch(item)) return false;
        sarray[position] = item;
        return true;
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
    
    public Producto giveMe(int n){//No se si se esta usando :v
        if(top>n) return sarray[n];
        return null;
    }
    
    
}
