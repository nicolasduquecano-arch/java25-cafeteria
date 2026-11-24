import java.util.ArrayList;
import java.util.List;

// Extra: el límite Comparable permite llamar compareTo en mayor()
public class Historial<T extends Comparable<T>> {
    private final List<T> items = new ArrayList<>();
    private final int capacidad;

    public Historial(int capacidad) {
        this.capacidad = capacidad;
    }

    public void agregar(T item) {
        if (items.size() == capacidad) {
            items.removeFirst();           // el más viejo está al inicio
        }
        items.add(item);
    }

    public T masReciente() {
        return items.getLast();
    }

    public List<T> todos() {
        return List.copyOf(items);         // copia: nadie cambia el historial desde afuera
    }

    public T mayor() {
        T mejor = items.getFirst();
        for (T x : items) {
            if (x.compareTo(mejor) > 0) {
                mejor = x;
            }
        }
        return mejor;
    }
}
