import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// N08 y N09 · un solo CRUD para productos e insumos
public class Repositorio<T extends Identificable> {
    private final List<T> items = new ArrayList<>();

    // C
    public void guardar(T item) {
        if (porId(item.id()).isPresent()) {
            throw new IllegalArgumentException("Ya existe el id " + item.id());
        }
        items.add(item);
    }

    // R
    public List<T> listar() {
        return List.copyOf(items);
    }

    public Optional<T> porId(int id) {
        for (T item : items) {
            if (item.id() == id) {
                return Optional.of(item);
            }
        }
        return Optional.empty();
    }

    // U · reemplaza: sirve también para records, que no se modifican
    public boolean actualizar(T nuevo) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id() == nuevo.id()) {
                items.set(i, nuevo);
                return true;
            }
        }
        return false;
    }

    // D
    public boolean eliminar(int id) {
        return items.removeIf(x -> x.id() == id);
    }
}
