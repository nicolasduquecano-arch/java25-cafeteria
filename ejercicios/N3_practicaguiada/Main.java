void main() {
    Reserva r1 = new Reserva("Familia Rojas", 6,
        "18:30");
    Reserva r2 = new Reserva("Andrés", 2);
    IO.println(r1.aviso());
    IO.println(r2.aviso(15));
    try {
        new Reserva("Fiesta", 12);
    } catch (IllegalArgumentException e) {
        IO.println("No se pudo: " + e.getMessage());
    }

    // Punto 1
    Reserva r3 = new Reserva("Sofía");
    IO.println(r3.aviso());

    // Punto 2: el corto sigue protegido…
    try {
        new ReservaPrologo("Fiesta", 12);
    } catch (IllegalArgumentException e) {
        IO.println("Corto: " + e.getMessage());
    }
    // …pero el completo deja pasar 12 personas: por eso la regla va en el completo
    ReservaPrologo mala = new ReservaPrologo("Fiesta", 12, "20:00");
    IO.println("Completo sin regla: " + mala.aviso());
}
