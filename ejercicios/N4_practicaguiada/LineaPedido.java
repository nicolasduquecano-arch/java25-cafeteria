public class LineaPedido {
    private final Producto producto;       // «tiene un» producto: composición
    private final int cantidad;

    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Punto 1: la línea expone su cantidad; el pedido la suma
    public int getCantidad() { return cantidad; }

    public int subtotal() {
        return producto.getPrecio() * cantidad;
    }

    public String texto() {
        return cantidad + " × " + producto.getNombre()
            + " = $" + subtotal();
    }
}
