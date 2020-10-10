package dataStructures;

import principal.Producto;

public class List{
    private final int N;
    private int count;
    private int position;
    private Producto[] array;
    private Producto reference;
    private boolean sorted;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    
    public List(int n) {
        this.N = n;
        count=0;
        array = new Producto[N];
    }
    
    public boolean empty() {
        return count <= 0;
    }
    
    private boolean full() {
        return count >= N;
    }
    
    public boolean sortedInsert(Producto item) {
        boolean inserted=false;
        
        if(!full()){
            if (!smartSearch(item)){
                for(int j=count; j>position; j--)
                    array[j] = array[j-1];
                array[position] = item;
                count++;
                inserted = true;
                sorted = true;
            }else System.out.println("Product is already in the list");
        }else System.out.println("List is Full1");
        
        return inserted;
    }
    
    public void sort(){
        long timeList = System.nanoTime();
        List temp = new List(N);
        for(int i=0; i<count; i++)
           temp.sortedInsert(array[i]);
        array = temp.array;
        sorted = true;
        System.out.println("Sort List: "+(System.nanoTime()-timeList));
    }
    
    public boolean insert(Producto item){
        boolean inserted = false;
        
        if(!full()){
            if(!smartSearch(item)){
                array[count++] = item;
                inserted = true;
                sorted = false;
            }else System.out.println("Product is already in the list");
        }else System.out.println("List is full2");
        
        return inserted;
        
    }
    
    public boolean delete(Producto item) {
        
        boolean deleted=false;
        if(!empty())
            if(search(item)){
                for(int j=position; j<count-1; j++)
                    array[j] = array[j+1];
                count--;
                deleted = true;
            }
        else
            System.out.println("List is Empty");
        
        return deleted;
    }
    
    public boolean search(Producto item) {
        //long timeSearch = System.nanoTime();
        boolean found, stop;
        found = false;
        stop = false;
        position = 0;
        while(position != count && !stop)
            if(array[position].compareTo(item) >= 0){
                stop = true;
                if(array[position].compareTo(item) == 0)
                    found = true;
            }
            else position++;
        //System.out.println("Searching List: "+(System.nanoTime()-timeSearch));
        return found;
    }
    
    public boolean smartSearch(Producto item){
        position = 0;
        if(empty()) return false;
        boolean found = false;
        long timeSearch = System.nanoTime();
        int i = 0;
        int j = count-1;
        int k;
        do{
            k = (i+j)/2;
            if(array[k].compareTo(item)<=0) i=k+1;
            if(array[k].compareTo(item)>=0) j=k-1;
            System.out.println(i+" "+j+" "+k);
        }while(i<=j);
        position = k;
        if(item.compareTo(array[position])== 0) found = true;
        System.out.println("Searching List: "+(System.nanoTime()-timeSearch));
        System.out.println(array[position]+" at: "+k+" found: "+found);
        return found;
    }
    
    public void output(int n) {
        if(n == 1 && !sorted) sort();
        int j = 0;
        while(j != count) {
            System.out.print(array[j]+" | ");
            j++;
        }
        System.out.println();
    }
    
    /*public int compareTo(Producto item) {
        int result;
        if(reference.compareTo(item) > 0)
            result = 1;
        else if(reference.compareTo(item) < 0)
            result = -1;
        else
            result = 0;
        
        return result;
    }*/
    
    public Producto giveMe(int n){
        if(count>=n) return array[n];
        return null;
    }

}
