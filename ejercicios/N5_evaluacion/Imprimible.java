public interface Imprimible {
    String texto();

    default void imprimir() {              // quien firme solo escribe texto()
        IO.println(texto());
    }
}
