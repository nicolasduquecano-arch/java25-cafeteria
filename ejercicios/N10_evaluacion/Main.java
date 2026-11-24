void main() {
    IO.println(new Propina("Martín", 2000));
    IO.println(new Propina("Martín", 0));  // caso límite: 0 no es negativo
    try {
        new Propina("Martín", -1);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazada: " + e.getMessage());
    }
}
