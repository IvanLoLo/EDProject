package dataStructures;

import principal.Producto;

public class List{
    private final int N;
    private int count;
    private int position;
    private Producto[] array;

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
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
    
    public Producto giveMe(int n){
        if(count>=n) return array[n];
        return null;
    }
    
    /*public boolean insert(Producto item){//Realiza una busqueda dependiendo si esta ordenado o no
                                         //De estar ordenada, hace la insercion ordenada para mantenerlo 
        boolean inserted = false;
        if(!full()){
            if(!search(item)){
                //if(sorted) return sortedInsert(item);
                array[count++] = item;
                inserted = true;
                sorted = false;
            }else System.out.println("Product is already in the list");
        }else System.out.println("List is full2");
        
        return inserted;
    }*/
    
    public boolean sortedInsert(Producto item) {
        boolean inserted=false;
        if(!full()){
            if (!smartSearch(item,0)){
                if(array[position]!=null && array[position].compareTo(item)<0)
                    position++;
                for(int j=count; j>position; j--)
                    array[j] = array[j-1];
                array[position] = item;
                count++;
                inserted = true;
            }else System.out.println("Product is already in the list");
        }else System.out.println("List is Full1");
        
        return inserted;
    }
    
    public boolean delete(Producto item) {
        if(!smartSearch(item, 0)) return false;
        for(int j=position; j<count-1; j++)
            array[j] = array[j+1];
        count--;
        return true;
    }
    
    /*public void sort(){
        long timeList = System.nanoTime();
        List temp = new List(N);
        for(int i=0; i<count; i++)
           temp.sortedInsert(array[i]);
        array = temp.array;
        sorted = true;
        System.out.println("Sort List: "+(System.nanoTime()-timeList));
    }*/
    
    public boolean search(Producto item) {//Busqueda posicion por posicion O(n) ->Nombre
        if(empty()){
            return false;
        }
        boolean found, stop;
        found = false;
        stop = false;
        position = 0;
        long timeSearch = System.nanoTime();
        while(position < count && !stop)
            if(array[position].compareTo(item) >= 0){
                stop = true;
                if(array[position].compareTo(item) == 0)
                    found = true;
            }
            else position++;
        //System.out.println("DumpSearching List: "+(System.nanoTime()-timeSearch));
        //System.out.println(array[position]+" at: "+k+" found: "+found);
        return found;
    }
    
    public boolean smartSearch(Producto item, int n){//Busqueda binaria
        position = 0;
        if(empty()) return false;
        boolean found = false;
        int i = 0;
        int j = count-1;
        int k;
        long timeSearch=System.nanoTime();
        do{
            k = (i+j)/2;
            //System.out.println("Buscado en "+k+": "+array[k]);
            if(array[k].compareTo(item)<=0) i=k+1;
            if(array[k].compareTo(item)>=0) j=k-1;
        }while(i<=j);
        position = k;
        if(item.compareTo(array[position])== 0) found = true;
        if(n==1) System.out.println("SmartSearching List: "+(System.nanoTime()-timeSearch));
        //System.out.println(array[position]+" at: "+k+" found: "+found);
        return found;
    }
    
    /*public boolean doSearch(Producto item){
        return sorted ? smartSearch(item) : search(item);
    }*/
    
    public boolean update(Producto item){
        if(!smartSearch(item,0)) return false;
        array[position] = item;
        return true;
    }
    
    public void output() {
        for(int i=0;i<count;i++){
            System.out.print(array[i].toString()+" | ");
        }
        System.out.println("");
    }

}
