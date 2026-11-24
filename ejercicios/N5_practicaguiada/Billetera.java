public class Billetera implements MedioDePago {
    private int saldo;

    public Billetera(int saldo) { this.saldo = saldo; }

    public String nombre() { return "Billetera digital"; }

    public boolean pagar(int valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }
}
