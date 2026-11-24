public class Domicilio {
    private final String direccion;
    private final int valor;

    public Domicilio(String direccion, int valor) {
        this.direccion = direccion;
        this.valor = valor;
    }

    public Domicilio(String direccion) {
        this(direccion, 4000);             // delega: las asignaciones quedan en un solo lugar
    }

    public String descripcion() {
        return direccion + " $" + valor;
    }
}
