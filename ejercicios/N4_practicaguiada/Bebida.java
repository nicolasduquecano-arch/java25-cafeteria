public class Bebida extends Producto {
    private final int ml;

    public Bebida(String nombre, int precio, int ml) {
        super(nombre, precio);             // nombre y precio son private del padre
        this.ml = ml;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " · " + ml + " ml";
    }
}
