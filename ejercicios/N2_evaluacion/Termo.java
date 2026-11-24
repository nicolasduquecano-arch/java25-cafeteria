public class Termo {
    private double litros = 2.0;           // double porque servir en ml deja fracciones de litro

    public double getLitros() {
        return litros;
    }

    public void servir(int ml) {
        if (ml > litros * 1000) {          // se comparan ml con ml
            throw new IllegalArgumentException(
                "No hay " + ml + " ml en el termo");
        }
        litros -= ml / 1000.0;             // 1000.0 evita la división entera
    }
}
