int leerNumero(String texto) {
    return Integer.parseInt(IO.readln(texto + " › "));
}

void mostrar(List<Reserva> lista) {
    if (lista.isEmpty()) {
        IO.println("Sin reservas");
    }
    for (Reserva r : lista) IO.println(r);
}

void main() {
    Agenda agenda = new Agenda();

    while (true) {
        IO.println("[1] Crear [2] Listar [3] Buscar [4] Cambiar hora "
            + "[5] Cancelar [6] De una hora [0] Salir");
        String op = IO.readln("Opción › ");
        try {                              // dentro del while: el error no cierra el programa
            switch (op) {
                case "1" -> {
                    String cliente = IO.readln("Cliente › ");
                    int personas = leerNumero("Personas");
                    String hora = IO.readln("Hora › ");
                    IO.println("Creada " + agenda.crear(cliente, personas, hora));
                }
                case "2" -> mostrar(agenda.listar());
                case "3" -> {
                    Optional<Reserva> o = agenda.buscar(leerNumero("Id"));
                    if (o.isPresent()) {
                        IO.println(o.get());
                    } else {
                        IO.println("No existe");
                    }
                }
                case "4" -> {
                    int id = leerNumero("Id");
                    String hora = IO.readln("Nueva hora › ");
                    IO.println(agenda.cambiarHora(id, hora) ? "Hora cambiada" : "No existe");
                }
                case "5" -> {
                    int id = leerNumero("Id");
                    IO.println(agenda.cancelar(id) ? "Cancelada" : "No existe");
                }
                case "6" -> mostrar(agenda.deLaHora(IO.readln("Hora › ")));
                case "0" -> {
                    IO.println("¡Hasta mañana!");
                    return;
                }
                default -> IO.println("Opción inválida");
            }
        } catch (NumberFormatException e) {   // primero: es hija de IllegalArgumentException
            IO.println("Escribe un número entero");
        } catch (IllegalArgumentException e) {
            IO.println("Reserva inválida: " + e.getMessage());
        }
    }
}
