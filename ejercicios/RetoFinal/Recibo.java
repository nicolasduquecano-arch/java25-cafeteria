import java.util.List;

// N10 · una vez emitido no se altera
public record Recibo(int numero, int mesa, List<LineaRecibo> lineas, int total) {
    public Recibo {
        if (total < 0) {
            throw new IllegalArgumentException("Total negativo");
        }
        lineas = List.copyOf(lineas);      // copia inmutable
    }

    public int subtotal() {
        int t = 0;
        for (LineaRecibo l : lineas) t += l.subtotal();
        return t;
    }

    public String texto() {
        String s = "RECIBO " + numero + " · mesa " + mesa;
        for (LineaRecibo l : lineas) {
            s += "\n" + l.cantidad() + " × " + l.producto() + " = $" + l.subtotal();
        }
        return s + "\nSubtotal: $" + subtotal()
            + "\nDescuento: $" + (subtotal() - total)
            + "\nTotal: $" + total;
    }
}
