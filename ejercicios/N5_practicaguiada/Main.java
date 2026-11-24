String cobrar(MedioDePago medio, int valor) {
    String r = medio.pagar(valor) ? "aprobado" : "rechazado";
    return medio.nombre() + " $" + valor + ": " + r;
}

// Punto 2: lo mismo con if; más líneas, pero se lee paso a paso
String cobrarConIf(MedioDePago medio, int valor) {
    String r;
    if (medio.pagar(valor)) {
        r = "aprobado";
    } else {
        r = "rechazado";
    }
    return medio.nombre() + " $" + valor + ": " + r;
}

void main() {
    List<MedioDePago> medios = List.of(
        new Efectivo(), new Billetera(12000));
    for (MedioDePago m : medios) {
        IO.println(cobrar(m, 9500));
        IO.println(cobrar(m, 9500));
    }

    // Punto 1: 9500 + 2 % = 9690. Con 9690 alcanza justo; con 9689 no
    IO.println(cobrar(new Tarjeta(9690), 9500));
    IO.println(cobrar(new Tarjeta(9689), 9500));

    // Punto 2: el resultado es el mismo que con el ternario
    IO.println(cobrarConIf(new Tarjeta(9690), 9500));
    IO.println(cobrarConIf(new Tarjeta(9689), 9500));
}
