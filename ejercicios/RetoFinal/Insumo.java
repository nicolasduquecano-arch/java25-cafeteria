import java.io.Serializable;

// N10 y N11 · record guardable; el constructor compacto también corre al leer
public record Insumo(int id, String nombre, int cantidad)
        implements Identificable, Serializable {
    public Insumo {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Insumo sin nombre");
        }
        if (cantidad < 0) {
            throw new IllegalArgumentException("Cantidad negativa");
        }
    }

    public Insumo conCantidad(int nueva) {
        return new Insumo(id, nombre, nueva);
    }

    @Override
    public String toString() {
        return "#" + id + " " + nombre + " (" + cantidad + ")";
    }
}
