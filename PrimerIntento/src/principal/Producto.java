
package principal;

public class Producto implements Comparable<Producto>{
    
    String nombre;
    long precio;
    int stock;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public long getPrecio() {
        return precio;
    }
    public void setPrecio(long precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public Producto(String nombre, long precio, int stock) { //CONSTRUCTOR DE PRUEBA PRECIO DOUBLE
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return nombre + " " + precio + " " + stock ;
    }

    /*public int compareTo(Producto item) {
        int rta=-1;
        if(Long.parseLong(precio)==Long.parseLong(item.getPrecio())) rta = 0;
        else if (Long.parseLong(precio)>Long.parseLong(item.getPrecio())) rta = 1;
        System.out.println(" Estado: "+rta);
        return rta;
    }*/
    
    public int compareTo(Producto item) { //Comparar por Nombre
        return nombre.compareToIgnoreCase(item.getNombre());
    }
    public byte compareToPrecio(Producto item){ //Comparar por precio
        byte compare;
        if(precio==item.getPrecio()){
            compare=0;
        }
        else if(precio<item.getPrecio()){
            compare=-1;
        }
        else {
            compare=1;
        }
        return compare;
    }
    public byte compareToStock(Producto item){ //Comparar por cantidad Stock
        byte compare;
        if(stock==item.getStock()){
            compare=0;
        }
        else if(stock<item.getStock()){
            compare=-1;
        }
        else {
            compare=1;
        }
        return compare;
    }
}
