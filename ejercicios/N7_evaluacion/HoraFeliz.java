public class HoraFeliz implements Descuento {
    public int aplicar(int total) {
        return Math.max(0, total * 70 / 100);   // max cumple el contrato «nunca negativo»
    }
}
