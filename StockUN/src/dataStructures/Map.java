
package dataStructures;

import java.util.ArrayList;

public class Map<K,V> {
    
    public class HashNode<N, M> {

        N key;
    	M value;
    	HashNode<N, M> next;

    	public HashNode()
    	{
            this.key=key;
            this.value=value;
    	}
        
    }
	
    //ArrayList<HashNode<K, V>> mapa=new ArrayList<>();
    HashNode<K, V>[] mapa;
    GenericLinkedList<K> keys;
    //GenericLinkedList<V> values;
    int largoMapa;
    int size;

    public K[] getKeys() {
        return keys.toArray();
    }
    
    public Map(int n){
        this.largoMapa = nextPrime(n);
        System.out.println("Largo: "+largoMapa);
        mapa = new HashNode[largoMapa];
        keys = new GenericLinkedList<>();
        //values = new GenericLinkedList<>();
        /*
        for(int i=0;i<largoMapa;i++){
            mapa.add(null);
        }
        */
    }
    
    private static int nextPrime( int n )
    {
        if (n % 2 == 0)
            n++;
        while(!isPrime(n))
            n+=2;
        
        return n;
    }
 
    private static boolean isPrime(int n)
    {
        if (n == 2 || n == 3)
            return true;
        if (n == 1 || n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;
        return true;
    }
    
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    private int getHashIndex(K key){
        int hashCod=hash((String) key);
        //System.out.println("Primo: "+nextPrime(((String)key).length()));
        //hashCod = 31*hashCod + ((String)key).length()
        if(hashCod<0) hashCod = -hashCod;
        return hashCod % largoMapa;
    }
    
    public int hash(String str) {
        
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = str.charAt(i) + ((hash << 5) - hash);
        }
        //System.out.println("Hash: "+hash);
        return hash;
        
        /*
        int hash = 7;
        for (int i = 0; i < str.length(); i++) {
            hash = hash*31 + str.charAt(i);
        }
        //System.out.println("Hash: "+hash);
        return hash
        */
    }

    public V get(K key){
        int index=getHashIndex(key);
        HashNode<K, V> head = mapa[index];

        while(head!=null){
            if(head.key.equals(key)){
                return head.value;
            }
            head=head.next;
        }
        return null;

    }

    public V remove(K key){
        int index=getHashIndex(key);
        HashNode<K, V> head = mapa[index];
        if(head==null){
            return null;
        }
        if(head.key.equals(key)){
            V val=head.value;
            head=head.next;
            mapa[index] = head;
            size--;
            keys.remove(key);
            return val;
        }
        else{
            HashNode<K, V> prev = null;
            while(head!=null){
                if(head.key.equals(key)){
                    prev.next=head.next;
                    size--;
                    keys.remove(key);
                    return head.value;
                }
                prev=head;
                head=head.next;
            }
            size--;
            return null;
        }
    }
    public void add(K key,V value, int n){

        int index=getHashIndex(key);
        System.out.println("Index of '"+key+"' : "+index+" tamaño: "+largoMapa);
        HashNode<K, V> head = mapa[index];
        HashNode<K, V> toAdd = new HashNode<>();
        toAdd.key=key;
        toAdd.value=value;

        if(head==null){
            mapa[index] = toAdd;
            size++;
        }
        else{
            while(head!=null){
                if(head.key.equals(key)){
                    head.value=value;
                    size++;
                    break;
                }
                head=head.next;
            }
            if(head==null){
                head=mapa[index];
                toAdd.next=head;
                mapa[index] = toAdd;
                size++;
            }
        }
        
        if(n!=1) keys.add(key);
        
        if((1.0*size)/largoMapa>0.7){
            //System.out.println("Agrandando, porque: "+((1.0*size)/largoMapa));
            //do something
            HashNode<K, V>[] tmp = mapa;
            largoMapa=2*largoMapa;
            mapa = new HashNode[largoMapa];
            size=0;
            
            for(HashNode<K, V> headNode: tmp){
                while(headNode!=null){
                    add(headNode.key, headNode.value, 1);
                    headNode=headNode.next;
                }
            }
        }//else keys.add(key);

    }
    public static void main(String[] args){
        Map<String, String> map = new Map<>(10);
        System.out.println("HashCode: "+"alombana".hashCode());
        map.add("pruebaA", "123",0);
        map.add("pruebaB", "456",0);
        map.add("otro", "otro",0);
        System.out.println(map.get("this"));
        System.out.println(map.get("pruebaB"));
        System.out.println(map.get("pruebaA"));
        System.out.println("Keys:");
        Object[] cosa = map.getKeys();
        for(Object ob: cosa){
            System.out.println(ob.toString());
        }
        System.out.println(map.remove("pruebaB"));
        System.out.println(map.remove("pruebaB"));
    }
    
    
}