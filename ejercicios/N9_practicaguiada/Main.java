int leerNumero(String texto) {
    return Integer.parseInt(IO.readln(texto + " › "));
}

void main() {
    Inventario inv = new Inventario();
    inv.crear("Leche entera (L)", 12);

    while (true) {
        IO.println("[1] Crear [2] Listar [3] Cantidad [4] Eliminar [0] Salir");
        String op = IO.readln("Opción › ");
        // Punto 2: el try va dentro del while, así el error no termina el menú
        try {
            switch (op) {
                case "1" -> {
                    String n = IO.readln("Nombre › ");
                    int c = leerNumero("Cantidad");
                    IO.println("Creado " + inv.crear(n, c));
                }
                case "2" -> {
                    for (Insumo i : inv.listar()) IO.println(i);
                }
                case "3" -> {
                    int id = leerNumero("Id");
                    int c = leerNumero("Cantidad");
                    boolean ok = inv.actualizar(id, c);
                    IO.println(ok ? "Actualizado" : "No existe");
                }
                // Punto 1: eliminar devuelve false si removeIf no borró nada
                case "4" -> {
                    int id = leerNumero("Id");
                    IO.println(inv.eliminar(id) ? "Eliminado" : "No existe");
                }
                case "0" -> {
                    IO.println("¡Hasta mañana!");
                    return;
                }
                default -> IO.println("Opción inválida");
            }
        } catch (NumberFormatException e) {
            IO.println("Escribe un número entero");
        }
    }
}
