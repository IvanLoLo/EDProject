
package principal;

public class Producto implements Comparable<Producto>{
    
    String nombre, precio;
    int stock;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public Producto(String nombre, String precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", cantidad=" + stock + '}';
    }

    /*public int compareTo(Producto item) { // Comparar por precio
        if(precio.equals(item.getPrecio())) return 0;
        else if (Long.parseLong(precio)>(Long.parseLong(item.getPrecio()))) return 1;
        return -1;
    }*/
    
    public int compareTo(Producto item) { //Comparar por Nombre
        return nombre.compareToIgnoreCase(item.getNombre());
    }

}
