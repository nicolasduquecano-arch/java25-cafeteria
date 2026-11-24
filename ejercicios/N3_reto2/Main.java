void main() {
    Combo completo = new Combo("Latte", "Brownie", 15000);
    Combo corto = new Combo("Tinto", 3500);
    IO.println(completo.descripcion());
    IO.println(corto.descripcion());
    IO.println("Final: $" + completo.precioFinal());
    IO.println("Con propina 10 %: $" + completo.precioFinal(10));

    // Los dos errores: precio (en ambos constructores) y bebida vacía
    try {
        new Combo("Latte", "Brownie", 0);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    try {
        new Combo("Tinto", -100);          // el corto también valida, porque delega
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    try {
        new Combo(" ", 3500);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
}
