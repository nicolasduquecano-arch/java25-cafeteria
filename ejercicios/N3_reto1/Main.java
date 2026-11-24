void main() {
    Postre a = new Postre("Brownie", 7000);   // espacio 7: new
    Postre b = new Postre("Cheesecake", 9000, true);
    IO.println(a.etiqueta(true));
    IO.println(b.etiqueta(true));
}
