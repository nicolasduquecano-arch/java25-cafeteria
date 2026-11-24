public class Empleado {
    private final String nombre;
    private final int salarioBase;

    public Empleado(String nombre, int salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public String getNombre() { return nombre; }

    public int pago() {
        return salarioBase;
    }

    // Extra: println(objeto) llama a toString(); sin esto saldría algo como Barista@1b6d3586
    @Override
    public String toString() {
        return nombre + ": $" + pago();    // pago() usa la versión de la hija
    }
}
