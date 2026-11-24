int leerNumero(String texto) {
    return Integer.parseInt(IO.readln(texto + " › "));
}

Repositorio<Producto> crearMenu() {
    var menu = new Repositorio<Producto>();
    menu.guardar(new Bebida(1, "Latte", 8000, Categoria.CALIENTE));
    menu.guardar(new Bebida(2, "Tinto", 3500, Categoria.CALIENTE, Tamano.PEQUENO));
    menu.guardar(new Bebida(3, "Limonada", 6000, Categoria.FRIA, Tamano.GRANDE));
    menu.guardar(new Postre(4, "Brownie", 7000, false));
    menu.guardar(new Postre(5, "Torta de zanahoria", 8000, true));
    return menu;
}

// Si el archivo está dañado se avisa y se empieza vacío
List<Insumo> abrir(Almacen almacen) {
    try {
        return almacen.cargar();
    } catch (InvalidClassException e) {
        IO.println("La bodega trae una clase no permitida: " + e.getMessage());
    } catch (IOException e) {
        IO.println("No se pudo leer la bodega: " + e.getMessage());
    } catch (ClassNotFoundException e) {
        IO.println("La bodega trae una clase desconocida: " + e.getMessage());
    }
    return List.of();
}

void mostrarMenu(Repositorio<Producto> menu) {
    for (Categoria c : Categoria.values()) {   // en el orden del enum
        IO.println("— " + c.etiqueta());
        for (Producto p : menu.listar()) {
            if (p.getCategoria() == c) {
                IO.println(p.descripcion());
            }
        }
    }
}

void venderPedido(Repositorio<Producto> menu, List<Descuento> descuentos, Caja caja) {
    Pedido pedido = new Pedido(leerNumero("Mesa"));
    int id = leerNumero("Producto (0 termina)");
    while (id != 0) {
        Optional<Producto> o = menu.porId(id);
        if (o.isPresent()) {
            pedido.agregar(o.get(), leerNumero("Cantidad"));
        } else {
            IO.println("No existe");
        }
        id = leerNumero("Producto (0 termina)");
    }
    for (int i = 0; i < descuentos.size(); i++) {
        IO.println("[" + i + "] " + descuentos.get(i).nombre());
    }
    int d = leerNumero("Descuento");
    if (d < 0 || d >= descuentos.size()) {
        throw new IllegalArgumentException("Descuento inexistente: " + d);
    }
    String telefono = IO.readln("Teléfono › ");
    Recibo r = caja.cobrar(pedido, descuentos.get(d), telefono);
    IO.println(r.texto());
}

void main() {
    // Main es el único que ensambla: aquí se eligen los detalles
    var menu = crearMenu();
    List<Descuento> descuentos = List.of(
        new SinDescuento(), new Porcentaje(10), new Fidelidad());
    Caja caja = new Caja(new SmsSimulado());
    var almacen = new Almacen(Path.of("bodega.ser"));
    Inventario bodega = new Inventario(abrir(almacen));

    IO.println("CAFÉ SINTAXIS 1.0 · insumos cargados: " + bodega.listar().size());

    while (true) {
        IO.println("[1] Menú [2] Vender [3] Caja [4] Bodega [5] Crear insumo "
            + "[6] Cantidad [7] Eliminar [8] Exportar CSV [0] Salir");
        String op = IO.readln("Opción › ");
        try {
            switch (op) {
                case "1" -> mostrarMenu(menu);
                case "2" -> venderPedido(menu, descuentos, caja);
                case "3" -> IO.println(caja.getVentas() + " ventas · saldo $" + caja.getSaldo());
                case "4" -> {
                    for (Insumo i : bodega.listar()) IO.println(i);
                }
                case "5" -> {
                    String n = IO.readln("Nombre › ");
                    IO.println("Creado " + bodega.crear(n, leerNumero("Cantidad")));
                }
                case "6" -> {
                    int id = leerNumero("Id");
                    boolean ok = bodega.actualizar(id, leerNumero("Cantidad"));
                    IO.println(ok ? "Actualizado" : "No existe");
                }
                case "7" -> IO.println(bodega.eliminar(leerNumero("Id")) ? "Eliminado" : "No existe");
                case "8" -> {
                    almacen.exportarCsv(bodega.listar(), Path.of("bodega.csv"));
                    IO.println("Exportado bodega.csv");
                }
                case "0" -> {
                    almacen.guardar(bodega.listar());   // guardar al cerrar
                    IO.println("Bodega guardada. ¡Hasta mañana!");
                    return;
                }
                default -> IO.println("Opción inválida");
            }
        } catch (NumberFormatException e) {    // hija de IllegalArgumentException: va primero
            IO.println("Escribe un número entero");
        } catch (IllegalArgumentException e) {
            IO.println("Rechazado: " + e.getMessage());
        } catch (IOException e) {
            IO.println("Error con el archivo: " + e.getMessage());
        }
    }
}
