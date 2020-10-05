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
public class GenericList<T extends Comparable<T>>{
    private int N;
    private int position, count;
    private T[] lArray;
    private T reference;
    
    public GenericList(int n) {
        this.N = n;
        count=0;
        lArray = (T[]) new Comparable[N];
    }
    private boolean empty() {
        return count <= 0;
    }
    private boolean full() {
        return count >= N;
    }
    public boolean insert(T item) {
        boolean inserted=false;
        
        if(!full())
            if (!search(item)){
                for(int j=count; j>position; j--)
                    lArray[j] = lArray[j-1];
                lArray[position] = item;
                count++;
                inserted = true;
            }else
                System.out.println("List is Full");
        
        return inserted;
    }
    public boolean delete(T item) {
        
        boolean deleted=false;
        if(!empty())
            if(search(item)){
                for(int j=position; j<count-1; j++)
                    lArray[j] = lArray[j+1];
                count--;
                deleted = true;
            }else
                System.out.println("List is Empty");
        
        return deleted;
    }
    
    public boolean search(T item) {
        boolean found, stop;
        found = false;
        stop = false;
        position = 0;
        while(position != count && !stop)
            if(lArray[position].compareTo(item) >= 0){
                stop = true;
                if(lArray[position].compareTo(item) == 0)
                    found = true;
            }
            else position++;
        return found;
    }
    public void output() {
        System.out.print("List: ");
        int j = 0;
        while(j != count) {
            System.out.print(lArray[j]+" ");
            j++;
        }
        System.out.println();
    }
    public int compareTo(T item) {
        int result;
        if(reference.compareTo(item) > 0)
            result = 1;
        else if(reference.compareTo(item) < 0)
            result = -1;
        else
            result = 0;
        
        return result;
    }

}