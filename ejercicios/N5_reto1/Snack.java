public abstract class Snack implements   // espacios 3 y 4: abstract, implements
        Descontable {
    private final int precio;

    protected Snack(int precio) {
        this.precio = precio;
    }

    @Override
    public int precioBase() {
        return precio;
    }

    public abstract String nombre();       // espacio 5: abstract, cada hija lo escribe
}
