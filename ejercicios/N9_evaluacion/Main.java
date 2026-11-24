void main() {
    Inventario inv = new Inventario();
    IO.println("Lista vacía: " + inv.existe("Avena (L)"));
    inv.crear("Leche entera (L)", 12);
    inv.crear("Avena (L)", 3);
    IO.println("¿Avena? " + inv.existe("Avena (L)"));
    IO.println("¿Canela? " + inv.existe("Canela (g)"));
}
