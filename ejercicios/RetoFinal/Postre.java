// N04
public class Postre extends Producto {
    private final boolean vegano;

    public Postre(int id, String nombre, int precioBase, boolean vegano) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Postre sin nombre");
        }
        super(id, nombre, precioBase, Categoria.POSTRE);
        this.vegano = vegano;
    }

    @Override
    public int precio() {
        return getPrecioBase();
    }

    @Override
    public String detalle() {
        return vegano ? "vegano" : "tradicional";
    }
}
