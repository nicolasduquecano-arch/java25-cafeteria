// N02 y N07 · saldo privado; el canal de aviso se recibe por constructor
public class Caja {
    private final Notificador notificador;
    private int saldo;
    private int ventas;

    public Caja(Notificador notificador) {
        this.notificador = notificador;
    }

    public int getSaldo() { return saldo; }
    public int getVentas() { return ventas; }

    // No hay if por promoción: cada Descuento sabe calcularse
    public Recibo cobrar(Pedido pedido, Descuento descuento, String telefono) {
        if (pedido.vacio()) {
            throw new IllegalArgumentException("El pedido no tiene productos");
        }
        int total = descuento.aplicar(pedido.total());
        Recibo r = new Recibo(1001 + ventas, pedido.getMesa(), pedido.lineasDeRecibo(), total);
        saldo += total;
        ventas++;
        notificador.enviar(telefono, "gracias, tu total fue $" + total);
        return r;
    }
}
