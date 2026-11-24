public class Te extends Bebida {
    private final String origen;

    public Te(String nombre, int precio, int ml, String origen) {
        super(nombre, precio, ml);         // el padre directo es Bebida: pide 3 datos
        this.origen = origen;
    }

    @Override
    public String descripcion() {
        return super.descripcion() + " · " + origen;   // suma a lo que ya arma Bebida
    }
}
