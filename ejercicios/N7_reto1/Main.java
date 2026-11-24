void main() {
    Cocina c = new Cocina(new ImpresoraConsola());   // espacio 7: Main elige el detalle
    c.enviarComanda("Sándwich de pollo", 4);
}
