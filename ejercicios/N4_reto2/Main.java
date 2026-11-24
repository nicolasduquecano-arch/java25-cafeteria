void main() {
    Barista martin = new Barista("Martín", 60000, 25);
    Mesero sara = new Mesero("Sara", 50000, 18000);

    Turno turno = new Turno();
    turno.agregar(martin);
    turno.agregar(sara);

    IO.println(martin.getNombre() + " recibe $" + martin.pago());
    IO.println(sara.getNombre() + " recibe $" + sara.pago());
    IO.println("Nómina: $" + turno.totalNomina());

    // Caso límite: con 0 bebidas y 0 propinas queda solo el salario base
    Turno vacio = new Turno();
    vacio.agregar(new Barista("Ana", 60000, 0));
    vacio.agregar(new Mesero("Julián", 50000, 0));
    IO.println("Nómina sin extras: $" + vacio.totalNomina());

    // Extra: se imprime el objeto directamente
    IO.println(martin);
    IO.println(sara);
}
