void main() {
    var a = new Calificacion("Sofía", 5);
    var b = new Calificacion("Sofía", 5);
    IO.println(a.cliente() + ": " + a.estrellas());   // espacio 4: cliente, sin get
    IO.println("¿Buena? " + a.esBuena());             // espacio 5: esBuena
    IO.println("¿Iguales? " + a.equals(b));           // espacio 6: equals
    IO.println(b);                                    // espacio 7: b, usa el toString automático
}
