void main() {
    Producto latte = new Producto();
    latte.setNombre("Latte");
    latte.setPrecio(9500);
    IO.println(latte.getNombre() + " $" +
        latte.getPrecio());
    try {
        latte.setPrecio(-9500);
    } catch (IllegalArgumentException e) {
        IO.println(e.getMessage());
    }
    IO.println("Sigue en $" + latte.getPrecio());

    // Punto 1: primero un reponer válido, después el caso límite 0
    latte.reponer(10);
    IO.println("Stock: " + latte.getStock());
    try {
        latte.reponer(0);
    } catch (IllegalArgumentException e) {
        IO.println(e.getMessage());
    }
    IO.println("Stock: " + latte.getStock());   // sigue igual: la excepción cortó antes
}
