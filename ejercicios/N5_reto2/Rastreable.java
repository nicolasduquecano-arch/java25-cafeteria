public interface Rastreable {
    String estado();

    default boolean entregado() {          // una sola vez para todas las que firmen
        return estado().equals("entregado");
    }
}
