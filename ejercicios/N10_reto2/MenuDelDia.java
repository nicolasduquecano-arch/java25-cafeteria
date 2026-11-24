import java.util.List;

public record MenuDelDia(String fecha, List<ItemMenu> items) {
    public MenuDelDia {
        items = List.copyOf(items);        // sin copia, quien pasó la lista podría cambiarla
    }

    public int promedioPrecio() {
        if (items.isEmpty()) {             // evita dividir por cero
            return 0;
        }
        int suma = 0;
        for (ItemMenu i : items) suma += i.precio();
        return suma / items.size();
    }
}
