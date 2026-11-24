public class BotePropinas {
    private int total;
    private int aportes;

    public void aportar(int valor) {
        if (valor <= 0) {                  // valida antes de sumar: si falla, nada cambia
            throw new IllegalArgumentException(
                "Aporte inválido: " + valor);
        }
        total += valor;
        aportes++;
    }

    public int repartir(int personas) {
        if (personas < 1) {                // sin esta regla, 0 sería dividir por cero
            throw new IllegalArgumentException(
                "Personas inválidas: " + personas);
        }
        return total / personas;           // división entera: lo que sobra lo da sobrante()
    }

    // Extra: repartir * personas + sobrante == total, por eso no se pierde dinero
    public int sobrante(int personas) {
        if (personas < 1) {
            throw new IllegalArgumentException(
                "Personas inválidas: " + personas);
        }
        return total % personas;
    }

    // Sin setters: el total solo cambia con aportar()
    public int getTotal() { return total; }
    public int getAportes() { return aportes; }
}
