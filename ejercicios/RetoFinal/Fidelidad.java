public class Fidelidad implements Descuento {
    @Override
    public String nombre() { return "Fidelidad ($2000 menos)"; }

    @Override
    public int aplicar(int total) {
        return Math.max(0, total - 2000);  // cumple el contrato aunque la compra sea pequeña
    }
}
