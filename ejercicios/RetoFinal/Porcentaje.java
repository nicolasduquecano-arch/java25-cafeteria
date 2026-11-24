public class Porcentaje implements Descuento {
    private final int pct;

    public Porcentaje(int pct) {
        if (pct < 0 || pct > 100) {        // más de 100 daría un total negativo
            throw new IllegalArgumentException("Porcentaje inválido: " + pct);
        }
        this.pct = pct;
    }

    @Override
    public String nombre() { return pct + " % menos"; }

    @Override
    public int aplicar(int total) {
        return total * (100 - pct) / 100;
    }
}
