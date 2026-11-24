public class Cartel implements Imprimible {
    private final String mensaje;

    public Cartel(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String texto() {
        return mensaje;
    }
}
