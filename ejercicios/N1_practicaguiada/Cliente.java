public class Cliente {
    String nombre;
    int puntos;

    // 1 punto por cada $1000 de compra
    void sumarPuntos(int compra) {
        puntos = puntos + compra / 1000;   // división entera: 12500 / 1000 da 12
    }

    boolean puedeCanjear() {
        return puntos >= 50;
    }

    // Punto 1: canjear reutiliza puedeCanjear() para no repetir la regla de los 50
    void canjear() {
        if (puedeCanjear()) {
            puntos = puntos - 50;
        }
    }

    String tarjeta() {
        return nombre + ": " + puntos + " puntos";
    }
}
