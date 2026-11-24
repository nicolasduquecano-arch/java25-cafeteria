void main() {
    BotePropinas bote = new BotePropinas();
    bote.aportar(2000);
    bote.aportar(5000);
    bote.aportar(3500);

    try {
        bote.aportar(-100);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    try {
        bote.aportar(0);                   // caso límite del <=
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    try {
        bote.repartir(0);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    try {
        bote.sobrante(0);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }

    IO.println("Total: $" + bote.getTotal());
    IO.println("Aportes: " + bote.getAportes());
    IO.println("A cada uno: $" + bote.repartir(3));
    IO.println("Sobrante entre 3: $" + bote.sobrante(3));

    // Extra: con 4 personas sale exacto; con 9 sobra, pero la cuenta sigue cuadrando
    IO.println("Entre 4: $" + bote.repartir(4) + " y sobran $" + bote.sobrante(4));
    IO.println("Entre 9: $" + bote.repartir(9) + " y sobran $" + bote.sobrante(9));
    int cuenta = bote.repartir(9) * 9 + bote.sobrante(9);
    IO.println("¿Cuadra? " + (cuenta == bote.getTotal()));
}
