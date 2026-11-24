void main() {
    Cliente sofia = new Cliente();
    sofia.nombre = "Sofía";
    sofia.puntos = 41;
    sofia.sumarPuntos(12500);
    IO.println(sofia.tarjeta());
    IO.println("¿Café gratis? " + sofia.puedeCanjear());

    // Punto 1: 53 - 50 = 3
    sofia.canjear();
    IO.println(sofia.tarjeta());
    sofia.canjear();                       // con 3 puntos no cumple: no cambia nada
    IO.println(sofia.tarjeta());

    // Punto 2: 9999 / 1000 = 9, la división entera bota los decimales
    Cliente andres = new Cliente();
    andres.nombre = "Andrés";
    andres.sumarPuntos(9999);              // puntos empieza en 0 sin asignarlo: es int
    IO.println(andres.tarjeta());
}
