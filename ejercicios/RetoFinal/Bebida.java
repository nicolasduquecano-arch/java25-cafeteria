// N04 · Bebida «es un» Producto
public class Bebida extends Producto {
    private final Tamano tamano;

    public Bebida(int id, String nombre, int precioBase, Categoria categoria, Tamano tamano) {
        if (nombre.isBlank()) {            // N03 · prólogo de Java 25: antes de super(…)
            throw new IllegalArgumentException("Bebida sin nombre");
        }
        super(id, nombre, precioBase, categoria);
        this.tamano = tamano;
    }

    // N03 · sobrecarga: la bebida corta es mediana
    public Bebida(int id, String nombre, int precioBase, Categoria categoria) {
        this(id, nombre, precioBase, categoria, Tamano.MEDIANO);
    }

    @Override
    public int precio() {
        return getPrecioBase() + tamano.recargo();
    }

    @Override
    public String detalle() {
        return tamano + " " + tamano.ml() + " ml";
    }
}
