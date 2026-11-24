public class Reserva {
    private final String cliente;
    private final int personas;
    private final String hora;

    public Reserva(String cliente, int personas,
                   String hora) {
        if (personas < 1 || personas > 8) {   // la regla vive solo aquí
            throw new IllegalArgumentException(
                "Mesas de 1 a 8 personas");
        }
        this.cliente = cliente;
        this.personas = personas;
        this.hora = hora;
    }

    public Reserva(String cliente, int personas) {
        this(cliente, personas, "19:00");
    }

    // Punto 1: con this(…) basta una línea y hereda la validación
    public Reserva(String cliente) {
        this(cliente, 2, "19:00");
    }

    public String aviso() {
        return cliente + " · " + personas + " pers. · " + hora;
    }

    public String aviso(int minutosAntes) {
        return "En " + minutosAntes + " min: " + aviso();
    }
}
