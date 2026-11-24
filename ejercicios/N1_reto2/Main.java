void main() {
    Barista martin = new Barista();
    martin.nombre = "Martín";
    martin.turno = "mañana";

    Barista ana = new Barista();
    ana.nombre = "Ana";
    ana.turno = "tarde";

    for (int i = 0; i < 3; i++) {
        martin.preparar("Latte");
    }
    for (int i = 0; i < 21; i++) {
        ana.preparar("Tinto");
    }

    IO.println(martin.resumen());
    IO.println("¿Merece pausa? " + martin.merecePausa());
    IO.println(ana.resumen());
    IO.println("¿Merece pausa? " + ana.merecePausa());

    // Caso límite: 19 todavía no, exactamente 20 sí
    for (int i = 0; i < 16; i++) {
        martin.preparar("Capuchino");
    }
    IO.println("Con " + martin.bebidas + ": " + martin.merecePausa());
    martin.preparar("Capuchino");
    IO.println("Con " + martin.bebidas + ": " + martin.merecePausa());

    // Extra: la segunda propina es negativa y no debe cambiar el total
    martin.recibirPropina(2000);
    martin.recibirPropina(-500);
    IO.println("Propinas: $" + martin.propinas);
}
