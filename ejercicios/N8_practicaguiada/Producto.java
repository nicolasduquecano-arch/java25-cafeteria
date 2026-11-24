// Punto 2: la línea que faltaba es «implements Comparable<Producto>» (y su método)
public class Producto implements Comparable<Producto> {
    private final int id;
    private final String nombre;
    private final int precio;

    public Producto(int id, String nombre, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int id() { return id; }
    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }

    @Override
    public int compareTo(Producto otro) {
        return Integer.compare(precio, otro.precio);   // «mayor» significa más caro
    }
}
