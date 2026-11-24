public class Barista extends Empleado {
    private final int bebidas;

    public Barista(String nombre, int salarioBase, int bebidas) {
        super(nombre, salarioBase);
        this.bebidas = bebidas;
    }

    @Override
    public int pago() {
        return super.pago() + bebidas * 200;   // super: salarioBase es private
    }
}
