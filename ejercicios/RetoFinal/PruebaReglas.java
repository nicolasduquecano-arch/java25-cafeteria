// Comprobaciones sin teclado: «java PruebaReglas.java»
void main() {
    // La caja se prueba sin enviar mensajes reales
    var memoria = new NotificadorMemoria();
    Caja caja = new Caja(memoria);
    Pedido p = new Pedido(4);
    p.agregar(new Bebida(1, "Latte", 8000, Categoria.CALIENTE), 2);
    p.agregar(new Postre(2, "Brownie", 7000, false), 1);
    Recibo r = caja.cobrar(p, new Porcentaje(10), "300 555 0101");
    IO.println("26000 con 10 %: $" + r.total());
    IO.println("Aviso: " + memoria.enviados().getLast());

    IO.println("Fidelidad en 1500: $" + new Fidelidad().aplicar(1500));   // nunca negativo

    try {
        r.lineas().add(new LineaRecibo("Tinto", 3500, 1));
    } catch (UnsupportedOperationException e) {
        IO.println("El recibo no se altera");
    }
    try {
        caja.cobrar(new Pedido(1), new SinDescuento(), "300 555 0102");
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    try {
        new Bebida(9, " ", 5000, Categoria.FRIA);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    try {
        new Insumo(1, "Leche", -3);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    IO.println("Saldo: $" + caja.getSaldo() + " en " + caja.getVentas() + " venta");
}
