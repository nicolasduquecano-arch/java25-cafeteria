public class Mesero extends Empleado {
    private final int propinas;

    public Mesero(String nombre, int salarioBase, int propinas) {
        super(nombre, salarioBase);
        this.propinas = propinas;
    }

    @Override
    public int pago() {
        return super.pago() + propinas;
    }
}
