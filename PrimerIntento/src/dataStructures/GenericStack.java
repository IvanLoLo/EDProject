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
public class GenericStack<T> {
    private int N;
    private int top;
    private T[] sarray;
    // constructors
    
    public GenericStack(int n) {
        this.N = n;
        this.top = 0;
        this.sarray = (T[]) new Object[N];
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
    
    public void print(String name){
        //search(name);
        System.out.println(sarray[top-1].toString());
    }
}
