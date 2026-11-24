void main() {
    List<Integer> ventas = List.of(9500, 7000, 3500);

    // Paso 1: la salida original, guardada en salida_paso1.txt
    new ReporteDiarioViejo().generar(ventas);

    // Pasos 2 a 4: Main es el único que conoce los detalles
    Totales totales = new Totales(ventas);
    new ReporteDiario(new FormatoTexto(), new DestinoConsola()).generar(totales);
    new ReporteDiario(new FormatoCsv(), new DestinoConsola()).generar(totales);

    // Paso 5: el destino en memoria permite comparar el texto sin mirar la pantalla
    var memoria = new DestinoMemoria();
    new ReporteDiario(new FormatoTexto(), memoria).generar(totales);
    String original = "CIERRE · 3 ventas · total $20000";
    IO.println("¿Idéntica a la original? " + memoria.recibidos().getLast().equals(original));

    // Extra
    new ReporteDiario(new FormatoHtml(), new DestinoConsola()).generar(totales);

    // Caso límite: un día sin ventas
    new ReporteDiario(new FormatoTexto(), new DestinoConsola())
        .generar(new Totales(List.of()));
}
