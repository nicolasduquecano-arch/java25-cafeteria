void main() {
    Snack s = new Galleta();
    IO.println(s.nombre() + ": $" + s.precioBase());
    Descontable d = s;                     // espacio 7: Descontable, mira solo el contrato
    IO.println("Con 20 %: $" + d.conDescuento(20));
}
