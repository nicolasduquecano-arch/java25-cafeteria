import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventario {
    private final List<Insumo> insumos = new ArrayList<>();
    private int siguienteId = 1;

    public Insumo crear(String nombre, int cantidad) {
        Insumo i = new Insumo(siguienteId++, nombre, cantidad);
        insumos.add(i);
        return i;
    }

    public List<Insumo> listar() {
        return List.copyOf(insumos);
    }

    public Optional<Insumo> buscar(int id) {
        for (Insumo i : insumos) {
            if (i.getId() == id) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }

    // P8: se detiene en el primero que coincide
    public boolean existe(String nombre) {
        for (Insumo i : insumos) {
            if (i.getNombre().equals(nombre)) {   // equals: los textos no se comparan con ==
                return true;
            }
        }
        return false;                      // solo después de revisar toda la lista
    }

    public boolean actualizar(int id, int cantidad) {
        Optional<Insumo> o = buscar(id);
        if (o.isEmpty()) {
            return false;
        }
        o.get().setCantidad(cantidad);
        return true;
    }

    public boolean eliminar(int id) {
        return insumos.removeIf(i -> i.getId() == id);
    }
}
