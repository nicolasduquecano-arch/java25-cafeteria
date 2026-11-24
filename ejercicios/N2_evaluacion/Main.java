void main() {
    Termo t = new Termo();
    t.servir(250);
    IO.println("Quedan " + t.getLitros() + " litros");
    try {
        t.servir(5000);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    t.servir(1750);                        // caso límite: pedir exactamente lo que hay
    IO.println("Quedan " + t.getLitros() + " litros");
}
