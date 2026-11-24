public abstract class Entrega {
    private final int pedidoId;

    protected Entrega(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public abstract int costo();           // cada forma de entrega cobra distinto

    public String resumen() {              // concreto: confía en el costo() de la hija
        return "Pedido " + pedidoId + " · entrega $" + costo();
    }
}
