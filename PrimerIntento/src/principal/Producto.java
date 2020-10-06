
package principal;

public class Producto {
    
    String nombre, precio;
    int stock;

    public Producto(String nombre, String precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", cantidad=" + stock + '}';
    }

    

}
