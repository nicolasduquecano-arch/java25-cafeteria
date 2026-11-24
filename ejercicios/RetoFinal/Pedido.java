import java.util.ArrayList;
import java.util.List;

// N04 · el pedido se compone de líneas
public class Pedido {
    private final int mesa;
    private final List<LineaPedido> lineas = new ArrayList<>();

    public Pedido(int mesa) {
        if (mesa < 1) {
            throw new IllegalArgumentException("Mesa inválida: " + mesa);
        }
        this.mesa = mesa;
    }

    public int getMesa() { return mesa; }

    public void agregar(Producto p, int cantidad) {
        lineas.add(new LineaPedido(p, cantidad));
    }

    public boolean vacio() {
        return lineas.isEmpty();
    }

    public int total() {
        int t = 0;
        for (LineaPedido l : lineas) t += l.subtotal();
        return t;
    }

    public List<LineaRecibo> lineasDeRecibo() {
        List<LineaRecibo> r = new ArrayList<>();
        for (LineaPedido l : lineas) r.add(l.aRecibo());
        return r;
    }
}
