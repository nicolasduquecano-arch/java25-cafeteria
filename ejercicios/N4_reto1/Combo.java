public class Combo {
    private final Producto principal;      // espacio 5: Producto, acepta cualquier hija
    private final Producto acompanante;

    public Combo(Producto principal, Producto acompanante) {
        this.principal = principal;
        this.acompanante = acompanante;
    }

    public int precio() {
        int suma = principal.getPrecio()
            + acompanante.getPrecio();     // espacio 6: getPrecio
        return suma * 90 / 100;            // 10 % menos
    }
}
