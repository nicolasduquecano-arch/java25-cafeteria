public class Insumo {
    private final int id;
    private final String nombre;
    private int cantidad;

    public Insumo(int id, String nombre, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        setCantidad(cantidad);             // reutiliza la validación
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(
                "Cantidad negativa");
        }
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "#" + id + " " + nombre + " (" + cantidad + ")";
    }
}
