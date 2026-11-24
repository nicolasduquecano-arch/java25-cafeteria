// Extra: se ejecuta aparte con «java DemoArchivoMalo.java»
void main() throws Exception {
    Path malo = Path.of("reservas_mala.ser");
    var archivo = new ArchivoReservas(malo);

    // El constructor no deja crear 12 personas, así que se guarda una válida con 7…
    archivo.guardar(List.of(new Reserva(1, "Fiesta", 7, "20:00")));

    // …y se alteran los bytes: en el archivo van seguidos id (0,0,0,1) y personas (0,0,0,7)
    byte[] b = Files.readAllBytes(malo);
    for (int i = 0; i + 7 < b.length; i++) {
        if (b[i] == 0 && b[i + 1] == 0 && b[i + 2] == 0 && b[i + 3] == 1
                && b[i + 4] == 0 && b[i + 5] == 0 && b[i + 6] == 0 && b[i + 7] == 7) {
            b[i + 7] = 12;
            IO.println("Archivo alterado: ahora dice 12 personas");
        }
    }
    Files.write(malo, b);

    try {
        IO.println(archivo.cargar());
    } catch (IOException e) {              // InvalidObjectException: la lanza la lectura del record
        IO.println("Rechazado al leer: " + e.getMessage());
    }
}
