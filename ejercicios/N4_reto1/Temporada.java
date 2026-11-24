public class Temporada extends Producto {   // espacio 1: extends
    private final String mes;

    public Temporada(String nombre, int precio,
                     String mes) {
        super(nombre, precio);             // espacio 2: super, constructor del padre
        this.mes = mes;
    }

    @Override                              // espacio 3: @Override
    public String descripcion() {
        return super.descripcion() + " (solo " + mes + ")";   // espacio 4: super
    }
}
