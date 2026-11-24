// N04 · la línea «tiene un» producto
public class LineaPedido {
    private final Producto producto;
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad mínima: 1");
        }
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public int subtotal() {
        return producto.precio() * cantidad;
    }

    // N10 · deja el dato fijo: si mañana cambia el menú, el recibo no cambia
    public LineaRecibo aRecibo() {
        return new LineaRecibo(producto.getNombre(), producto.precio(), cantidad);
    }
}
