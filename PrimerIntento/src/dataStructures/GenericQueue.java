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
public class GenericQueue<T>{
    
    private int N;
    private int front, rear, count;
    private T[] qarray;
    
    public GenericQueue(int n) {
        this.N = n;
        front = rear = count = 0;
        qarray = (T[]) new Object[N];
    }
    public T dequeue() {
        T item = null;
        if(empty())
            System.out.println("Queue is empty: item not dequeued");
        else {
            item = qarray[front];
            front = (front + 1) % N;
            count--;
        }
    return item;
    }
    public void enqueue(T item) {
        if(full())
            System.out.println("Queue is full: item not enqueued");
        else {
            qarray[rear] = item;
            rear = (rear + 1) % N;
            count++;
        }
    }
    public boolean empty() {
        return count <= 0;
    }
    public boolean full() {
        return count >= N;
    }
    public int getCount() {
        return count;
    } 

}
