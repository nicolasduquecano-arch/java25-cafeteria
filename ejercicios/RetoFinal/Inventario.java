import java.util.List;
import java.util.Optional;

// N09 · reglas de la bodega; el guardado en lista lo delega en Repositorio
public class Inventario {
    private final Repositorio<Insumo> insumos = new Repositorio<>();
    private int siguienteId = 1;

    public Inventario(List<Insumo> cargados) {
        for (Insumo i : cargados) {
            insumos.guardar(i);
            if (i.id() >= siguienteId) {   // sigue después del id más alto
                siguienteId = i.id() + 1;
            }
        }
    }

    public Insumo crear(String nombre, int cantidad) {
        Insumo i = new Insumo(siguienteId, nombre, cantidad);
        siguienteId++;                     // después: un insumo inválido no gasta id
        insumos.guardar(i);
        return i;
    }

    public List<Insumo> listar() {
        return insumos.listar();
    }

    public Optional<Insumo> buscar(int id) {
        return insumos.porId(id);
    }

    public boolean actualizar(int id, int cantidad) {
        Optional<Insumo> o = buscar(id);
        if (o.isEmpty()) {
            return false;
        }
        return insumos.actualizar(o.get().conCantidad(cantidad));
    }

    public boolean eliminar(int id) {
        return insumos.eliminar(id);
    }
}
