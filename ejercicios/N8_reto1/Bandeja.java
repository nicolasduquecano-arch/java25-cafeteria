import java.util.ArrayList;
import java.util.List;

public class Bandeja<T> {                  // espacio 1: <T>, declara el parámetro de tipo
    private final List<T> cosas = new ArrayList<>();   // espacios 2 y 3: T, <>
    private final int capacidad;

    public Bandeja(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean poner(T cosa) {         // espacio 4: T, solo entra el tipo elegido
        if (cosas.size() == capacidad) {
            return false;
        }
        return cosas.add(cosa);
    }

    public T primera() { return cosas.getFirst(); }   // espacio 5: T, sale sin cast
    public int cantidad() { return cosas.size(); }
}
