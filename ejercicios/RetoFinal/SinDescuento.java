// Evita usar null o un if cuando no hay promoción
public class SinDescuento implements Descuento {
    @Override
    public String nombre() { return "Sin descuento"; }

    @Override
    public int aplicar(int total) {
        return total;
    }
}
