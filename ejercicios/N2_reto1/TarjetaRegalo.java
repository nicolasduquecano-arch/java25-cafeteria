public class TarjetaRegalo {
    private int saldo;                     // espacio 1: private

    public int getSaldo() {                // espacio 2: getSaldo
        return saldo;
    }

    public void recargar(int valor) {
        if (valor <= 0) {                  // espacio 3: <=, también rechaza el 0
            throw new IllegalArgumentException(   // espacio 4
                "Recarga inválida");
        }
        saldo += valor;
    }

    public boolean pagar(int valor) {      // espacio 5: boolean, responde si pudo pagar
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;                       // espacio 6: return
    }
}
