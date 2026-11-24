String describir(Pago p, int total) {
    return switch (p) {
        case Efectivo(int recibido) ->
            "Efectivo · vuelto $" + (recibido - total);
        case Tarjeta(String f, int cuotas) when cuotas > 1 ->
            f + " a " + cuotas + " cuotas";
        case Tarjeta(String f, int cuotas) -> f + " de contado";
        case Billetera(String tel) -> "Billetera " + tel;
        // Punto 1: sin esta línea no compila, porque Pago es sealed (ver ERROR_COMPILADOR.txt)
        case Bono(int valor) -> "Bono de $" + valor;
    };
}

// Punto 2: sin el caso con when, toda tarjeta cae en «de contado»
String describirSinWhen(Pago p, int total) {
    return switch (p) {
        case Efectivo(int recibido) ->
            "Efectivo · vuelto $" + (recibido - total);
        case Tarjeta(String f, int cuotas) -> f + " de contado";
        case Billetera(String tel) -> "Billetera " + tel;
        case Bono(int valor) -> "Bono de $" + valor;
    };
}

void main() {
    int total = 26000;
    List<Pago> pagos = List.of(new Efectivo(30000),
        new Tarjeta("Débito", 1), new Tarjeta("Crédito", 3),
        new Billetera("300 555 0110"));
    for (Pago p : pagos) {
        IO.println(describir(p, total));
    }

    // Punto 1
    IO.println(describir(new Bono(26000), total));

    // Punto 2: compila, pero el resultado es incorrecto para 3 cuotas
    IO.println("Sin when: " + describirSinWhen(new Tarjeta("Crédito", 3), total));
}
