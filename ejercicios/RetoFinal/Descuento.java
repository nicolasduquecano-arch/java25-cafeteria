// N07 · O: una promoción nueva es una clase nueva
public interface Descuento {
    String nombre();
    int aplicar(int total);                // nunca negativo
}
