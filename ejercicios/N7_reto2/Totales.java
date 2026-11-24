import java.util.List;

// S: cambia solo si cambia la forma de sumar
public class Totales {
    private final List<Integer> ventas;

    public Totales(List<Integer> ventas) {
        this.ventas = ventas;
    }

    public int total() {
        int t = 0;
        for (int v : ventas) t += v;
        return t;
    }

    public int cantidad() {
        return ventas.size();
    }
}
