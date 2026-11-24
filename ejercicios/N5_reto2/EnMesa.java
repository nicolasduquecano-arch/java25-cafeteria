public class EnMesa extends Entrega {
    public EnMesa(int pedidoId) {
        super(pedidoId);
    }

    @Override
    public int costo() {
        return 0;
    }
}
