String aLinea(Insumo i) {
    return i.id() + ";" + i.nombre() + ";" + i.cantidad();
}

Insumo deLinea(String linea) {
    String[] p = linea.split(";");
    return new Insumo(Integer.parseInt(p[0]), p[1],
        Integer.parseInt(p[2]));
}

void main() throws Exception {
    List<Insumo> hoy = List.of(
        new Insumo(1, "Leche entera (L)", 20),
        new Insumo(2, "Café en grano (kg)", 5));
    Path csv = Path.of("bodega.csv");
    List<String> lineas = new ArrayList<>();
    for (Insumo i : hoy) lineas.add(aLinea(i));
    Files.write(csv, lineas);
    IO.print(Files.readString(csv));
    List<Insumo> leidos = new ArrayList<>();
    for (String l : Files.readAllLines(csv)) {
        leidos.add(deLinea(l));
    }
    IO.println(Files.size(csv) + " bytes · ¿iguales? "
        + hoy.equals(leidos));

    // Punto 1: equivale a abrir bodega.csv y cambiar 20 por -3 a mano
    Files.writeString(csv, Files.readString(csv).replace(";20", ";-3"));
    try {
        for (String l : Files.readAllLines(csv)) deLinea(l);
    } catch (IllegalArgumentException e) {
        IO.println("Punto 1: " + e.getMessage());   // lo detecta el constructor de Insumo
    }

    // Punto 2: con encabezado, la primera línea ya no es un insumo
    List<String> conEncabezado = new ArrayList<>();
    conEncabezado.add("id;nombre;cantidad");
    for (Insumo i : hoy) conEncabezado.add(aLinea(i));
    Files.write(csv, conEncabezado);
    try {
        for (String l : Files.readAllLines(csv)) deLinea(l);
    } catch (NumberFormatException e) {
        IO.println("Punto 2, sin cambiar la lectura: " + e.getMessage());
    }
    List<String> todas = Files.readAllLines(csv);
    List<Insumo> otraVez = new ArrayList<>();
    for (int i = 1; i < todas.size(); i++) {   // desde 1: se salta el encabezado
        otraVez.add(deLinea(todas.get(i)));
    }
    IO.println("Punto 2, saltando el encabezado: ¿iguales? " + hoy.equals(otraVez));
}
