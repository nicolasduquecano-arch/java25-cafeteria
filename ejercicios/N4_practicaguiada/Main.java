void main() {
    Pedido p = new Pedido(4);
    p.agregar(new Bebida("Latte", 9500, 350), 2);
    p.agregar(new Postre("Brownie", 7000, false), 1);
    p.imprimir();

    // Punto 1: 2 + 1
    IO.println("Ítems: " + p.cantidadDeItems());

    // Punto 2: Pedido no cambió, porque agregar recibe cualquier Producto
    p.agregar(new Postre("Torta de zanahoria", 8000, true), 1);
    p.imprimir();
    IO.println("Ítems: " + p.cantidadDeItems());
}
