void main() {
    var memoria = new NotificadorMemoria();
    Caja caja = new Caja(memoria);
    caja.cobrar(List.of(9500), new Porcentaje(0), "300 555 0104");
    caja.cobrar(List.of(3500), new Porcentaje(50), "300 555 0105");
    IO.println("Mensajes enviados: " +
        memoria.enviados().size());
    IO.println("Último: " + memoria.enviados().getLast());

    // Punto 2: el primero que se anotó
    IO.println("Primero: " + memoria.enviados().getFirst());

    // Punto 1: solo cambia lo que Main inyecta
    Caja conCorreo = new Caja(new CorreoSimulado());
    conCorreo.cobrar(List.of(7000), new Porcentaje(10), "sofia@ejemplo.com");
}
