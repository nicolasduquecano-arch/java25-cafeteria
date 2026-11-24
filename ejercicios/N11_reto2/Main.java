int leerNumero(String texto) {
    return Integer.parseInt(IO.readln(texto + " › "));
}

void mostrar(List<Reserva> lista) {
    if (lista.isEmpty()) {
        IO.println("Sin reservas");
    }
    for (Reserva r : lista) IO.println(r);
}

// Si el archivo está dañado se avisa y se empieza vacío, sin cerrar el programa
List<Reserva> abrir(ArchivoReservas archivo) {
    try {
        return archivo.cargar();
    } catch (InvalidClassException e) {    // primero: es hija de IOException
        IO.println("El archivo trae una clase no permitida: " + e.getMessage());
    } catch (IOException e) {
        IO.println("No se pudo leer el archivo: " + e.getMessage());
    } catch (ClassNotFoundException e) {
        IO.println("El archivo trae una clase desconocida: " + e.getMessage());
    }
    return List.of();
}

void main() {
    var archivo = new ArchivoReservas(Path.of("reservas.ser"));
    Agenda agenda = new Agenda(abrir(archivo));
    IO.println("Reservas cargadas: " + agenda.listar().size());

    while (true) {
        IO.println("[1] Crear [2] Listar [3] Buscar [4] Cambiar hora [5] Cancelar "
            + "[6] De una hora [7] Exportar CSV [0] Salir");
        String op = IO.readln("Opción › ");
        try {
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
                case "7" -> {
                    archivo.exportarCsv(agenda.listar(), Path.of("reservas.csv"));
                    IO.println("Exportado reservas.csv");
                }
                case "0" -> {
                    archivo.guardar(agenda.listar());   // si falla, el catch avisa y el menú sigue
                    IO.println("Guardado. ¡Hasta mañana!");
                    return;
                }
                default -> IO.println("Opción inválida");
            }
        } catch (NumberFormatException e) {
            IO.println("Escribe un número entero");
        } catch (IllegalArgumentException e) {
            IO.println("Reserva inválida: " + e.getMessage());
        } catch (IOException e) {
            IO.println("Error con el archivo: " + e.getMessage());
        }
    }
}
