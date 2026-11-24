public interface Descontable {             // espacio 1: interface
    int precioBase();

    default int conDescuento(int pct) {    // espacio 2: default, tiene cuerpo
        return precioBase() * (100 - pct) / 100;
    }
}
