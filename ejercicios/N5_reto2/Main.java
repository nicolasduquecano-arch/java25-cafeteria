void main() {
    Domicilio domicilio = new Domicilio(3, 5);
    domicilio.avanzar();

    List<Entrega> entregas = List.of(
        new EnMesa(1), new ParaLlevar(2), domicilio);

    for (Entrega e : entregas) {
        IO.println(e.resumen());
        if (e instanceof Rastreable r) {   // patrón: pregunta y crea r en un paso
            IO.println("Estado: " + r.estado());
            IO.println("¿Entregado? " + r.entregado());
        }
    }

    domicilio.avanzar();
    IO.println("Estado: " + domicilio.estado());
    IO.println("¿Entregado? " + domicilio.entregado());
    domicilio.avanzar();                   // caso límite: no pasa de entregado
    IO.println("Estado: " + domicilio.estado());

    // Extra: el mismo objeto visto por su segundo contrato
    Avisable a = domicilio;
    IO.println(a.aviso());
}
