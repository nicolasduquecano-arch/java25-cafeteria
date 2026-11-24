public class Porcentaje implements Descuento {
    private final int pct;

    public Porcentaje(int pct) { this.pct = pct; }

    public int aplicar(int total) {
        return total * (100 - pct) / 100;
    }
}
