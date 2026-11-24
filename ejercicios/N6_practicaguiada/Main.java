void registrar(Map<Categoria, Integer> v,
               Categoria c, int valor) {
    v.put(c, v.getOrDefault(c, 0) + valor);
}

void main() {
    Map<Categoria, Integer> ventas =
        new EnumMap<>(Categoria.class);
    registrar(ventas, Categoria.FRIA, 12000);
    registrar(ventas, Categoria.CALIENTE, 9500);
    registrar(ventas, Categoria.CALIENTE, 3500);
    registrar(ventas, Categoria.POSTRE, 7000);
    for (Categoria c : ventas.keySet()) {
        IO.println(c.etiqueta() + ": $" + ventas.get(c));
    }
    // Punto 1: values() ya trae BOTELLAS, por eso aparece sin cambiar este bloque
    for (Categoria c : Categoria.values()) {
        if (!ventas.containsKey(c)) {
            IO.println("Sin ventas: " + c.etiqueta());
        }
    }

    // Punto 2: mismo registro con HashMap; su orden no está garantizado
    Map<Categoria, Integer> conHash = new HashMap<>();
    registrar(conHash, Categoria.FRIA, 12000);
    registrar(conHash, Categoria.CALIENTE, 9500);
    registrar(conHash, Categoria.CALIENTE, 3500);
    registrar(conHash, Categoria.POSTRE, 7000);
    IO.println("EnumMap: " + ventas);
    IO.println("HashMap: " + conHash);
}
