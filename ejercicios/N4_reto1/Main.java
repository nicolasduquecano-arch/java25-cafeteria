void main() {
    Producto ponque = new Temporada("Ponqué de calabaza",   // espacio 7: Temporada
        8500, "octubre");
    Combo c = new Combo(new Bebida("Latte", 9500, 350), ponque);
    IO.println(ponque.descripcion());
    IO.println("Combo: $" + c.precio());
}
