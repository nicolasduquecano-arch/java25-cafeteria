void main() {
    Mesa m4 = new Mesa();                  // espacio 5: new
    m4.numero = 4;
    m4.ocupar(3);                          // espacio 6: ocupar
    IO.println(m4.estado());
    m4.liberar();
    IO.println(m4.estado());               // espacio 7: estado
}
