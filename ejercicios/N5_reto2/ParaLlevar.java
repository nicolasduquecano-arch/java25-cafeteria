public class ParaLlevar extends Entrega {
    public ParaLlevar(int pedidoId) {
        super(pedidoId);
    }

    @Override
    public int costo() {
        return 500;                        // empaque
    }
}
