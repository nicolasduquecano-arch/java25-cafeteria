// Punto 2: copia de Reserva con la validación movida al prólogo del constructor corto
public class ReservaPrologo {
    private final String cliente;
    private final int personas;
    private final String hora;

    public ReservaPrologo(String cliente, int personas,
                          String hora) {
        this.cliente = cliente;            // aquí ya no valida: quedó desprotegido
        this.personas = personas;
        this.hora = hora;
    }

    public ReservaPrologo(String cliente, int personas) {
        if (personas < 1 || personas > 8) {   // prólogo: antes de this(…), Java 25
            throw new IllegalArgumentException(
                "Mesas de 1 a 8 personas");
        }
        this(cliente, personas, "19:00");
    }

    public String aviso() {
        return cliente + " · " + personas + " pers. · " + hora;
    }
}
