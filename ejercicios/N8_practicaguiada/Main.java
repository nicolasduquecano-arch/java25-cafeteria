<T extends Comparable<T>> T maximo(List<T> lista) {
    T mejor = lista.getFirst();
    for (T x : lista) {
        if (x.compareTo(mejor) > 0) {
            mejor = x;
        }
    }
    return mejor;
}

// Punto 1: solo cambia > por < (además del nombre)
<T extends Comparable<T>> T minimo(List<T> lista) {
    T mejor = lista.getFirst();
    for (T x : lista) {
        if (x.compareTo(mejor) < 0) {
            mejor = x;
        }
    }
    return mejor;
}

void main() {
    List<Integer> precios = List.of(9500, 3500, 10500, 7000);
    List<String> nombres = List.of("latte", "moka", "tinto");
    IO.println("Precio más alto: " + maximo(precios));
    IO.println("Último en el menú: " + maximo(nombres));

    // Punto 1
    IO.println("Precio más bajo: " + minimo(precios));

    // Punto 2: sin Comparable no compila (ver ERROR_COMPILADOR.txt)
    List<Producto> menu = List.of(new Producto(1, "Latte", 9500),
        new Producto(2, "Moka", 10500), new Producto(3, "Té", 4000));
    IO.println("Más caro: " + maximo(menu).getNombre());
}
