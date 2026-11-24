void main() {
    var latte = new ItemMenu("Latte", Categoria.CALIENTE, 9500);
    var tinto = new ItemMenu("Tinto", Categoria.CALIENTE, 3500);
    var brownie = new ItemMenu("Brownie", Categoria.POSTRE, 7000);

    var menu = new MenuDelDia("2026-11-23", List.of(latte, tinto, brownie));
    IO.println("Menú " + menu.fecha() + " · promedio $" + menu.promedioPrecio());

    // Paso 4: 10 % más crea otro item; el original queda igual
    ItemMenu subido = latte.conPrecio(latte.precio() * 110 / 100);
    IO.println(subido);
    IO.println("¿Original intacto? "
        + latte.equals(new ItemMenu("Latte", Categoria.CALIENTE, 9500)));
    IO.println("¿Original igual al nuevo? " + latte.equals(subido));

    // Cambiar un precio = publicar una versión nueva del menú
    var version2 = new MenuDelDia("2026-11-23", List.of(subido, tinto, brownie));
    IO.println("Versión 2 · promedio $" + version2.promedioPrecio());

    // Paso 5: el patrón desarma el record en n, c y p
    for (ItemMenu i : menu.items()) {
        if (i instanceof ItemMenu(var n, var c, var p) && c == Categoria.CALIENTE) {
            IO.println(c.etiqueta() + ": " + n + " $" + p);
        }
    }

    // Extra: List.copyOf entrega una lista inmutable; add no está permitido
    try {
        menu.items().add(subido);
    } catch (UnsupportedOperationException e) {
        IO.println("No se puede agregar: la lista del menú es inmutable");
    }

    // Validaciones del constructor compacto
    try {
        new ItemMenu(" ", Categoria.FRIA, 5000);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
    try {
        latte.conPrecio(0);
    } catch (IllegalArgumentException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
}
