// N05 · plantilla: nadie vende «un producto» a secas
public abstract class Producto implements Identificable {
    private final int id;                  // N02 · datos privados
    private final String nombre;
    private final int precioBase;
    private final Categoria categoria;

    protected Producto(int id, String nombre, int precioBase, Categoria categoria) {
        if (precioBase <= 0) {             // la regla del precio vive solo aquí
            throw new IllegalArgumentException("Precio inválido: " + precioBase);
        }
        this.id = id;
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.categoria = categoria;
    }

    @Override
    public int id() { return id; }
    public String getNombre() { return nombre; }
    public int getPrecioBase() { return precioBase; }
    public Categoria getCategoria() { return categoria; }

    public abstract int precio();          // cada hija calcula el suyo

    public abstract String detalle();

    public String descripcion() {          // usa los abstractos sin saber qué hija es
        return id + " · " + nombre + " $" + precio() + " · " + detalle();
    }
}
