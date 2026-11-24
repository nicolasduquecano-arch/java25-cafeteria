<T> int contar(List<T> lista, T buscado) {
    int veces = 0;
    for (T x : lista) {
        if (x.equals(buscado)) {           // equals compara contenido; == compararía referencias
            veces++;
        }
    }
    return veces;
}

// El comodín acepta List<Integer>, List<Double>…, solo para leer números
int sumar(List<? extends Number> l) {
    int s = 0;
    for (Number n : l) {
        s += n.intValue();
    }
    return s;
}

void main() {
    var pedidos = new Historial<String>(3);
    pedidos.agregar("latte");
    pedidos.agregar("tinto");
    pedidos.agregar("moka");
    IO.println(pedidos.todos());
    pedidos.agregar("tinto");              // caso límite: el 4.º saca a «latte»
    IO.println(pedidos.todos());
    IO.println("Más reciente: " + pedidos.masReciente());
    IO.println("Tintos: " + contar(pedidos.todos(), "tinto"));

    var cobros = new Historial<Integer>(3);
    cobros.agregar(9500);
    cobros.agregar(3500);
    cobros.agregar(10500);
    IO.println("Suma: $" + sumar(cobros.todos()));
    IO.println("Más reciente: $" + cobros.masReciente());

    // Extra
    IO.println("Cobro mayor: $" + cobros.mayor());
    IO.println("Pedido mayor: " + pedidos.mayor());   // en textos, el último alfabéticamente
}
