public enum MedioPago {
    EFECTIVO(0), BILLETERA(1), TARJETA(2);

    private final int comisionPct;

    MedioPago(int comisionPct) {
        this.comisionPct = comisionPct;
    }

    public int neto(int valor) {
        return valor - valor * comisionPct / 100;   // multiplica antes de dividir: no pierde con enteros
    }
}
