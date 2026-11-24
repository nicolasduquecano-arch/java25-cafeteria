// Punto 1: medio nuevo = clase nueva; cobrar no se tocó
public class Tarjeta implements MedioDePago {
    private int cupo;

    public Tarjeta(int cupo) { this.cupo = cupo; }

    public String nombre() { return "Tarjeta"; }

    public boolean pagar(int valor) {
        int conComision = valor + valor * 2 / 100;   // el 2 % también gasta cupo
        if (conComision > cupo) {
            return false;
        }
        cupo -= conComision;
        return true;
    }
}
