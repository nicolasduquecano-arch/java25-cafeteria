public interface MedioDePago {
    String nombre();
    boolean pagar(int valor);
}
