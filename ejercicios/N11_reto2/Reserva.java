import java.io.Serializable;

public record Reserva(int id, String cliente, int personas, String hora)
        implements Serializable {
    public Reserva {                       // también corre al leer el archivo
        if (personas < 1 || personas > 8) {
            throw new IllegalArgumentException(
                "Mesas de 1 a 8 personas");
        }
    }

    // El record no cambia: cambiar la hora es crear otra reserva
    public Reserva conHora(String nueva) {
        return new Reserva(id, cliente, personas, nueva);
    }

    @Override
    public String toString() {
        return "#" + id + " " + cliente + " · " + personas + " pers. · " + hora;
    }
}
