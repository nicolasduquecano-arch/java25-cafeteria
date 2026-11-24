import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agenda {
    private final ArrayList<Reserva> reservas = new ArrayList<>();
    private int siguienteId = 1;

    public Reserva crear(String cliente, int personas, String hora) {
        Reserva r = new Reserva(siguienteId, cliente, personas, hora);
        siguienteId++;                     // después de crear: una reserva inválida no gasta id
        reservas.add(r);
        return r;
    }

    // Extra: se ordena una copia modificable; compareTo en «HH:mm» ordena por hora
    public List<Reserva> listar() {
        List<Reserva> copia = new ArrayList<>(reservas);
        copia.sort((a, b) -> a.getHora().compareTo(b.getHora()));
        return copia;
    }

    public Optional<Reserva> buscar(int id) {
        for (Reserva r : reservas) {
            if (r.getId() == id) {
                return Optional.of(r);
            }
        }
        return Optional.empty();           // caja vacía en lugar de null
    }

    public boolean cambiarHora(int id, String hora) {
        Optional<Reserva> o = buscar(id);
        if (o.isEmpty()) {
            return false;
        }
        o.get().setHora(hora);
        return true;
    }

    public boolean cancelar(int id) {
        return reservas.removeIf(r -> r.getId() == id);
    }

    public List<Reserva> deLaHora(String hora) {
        List<Reserva> r = new ArrayList<>();
        for (Reserva x : reservas) {
            if (x.getHora().equals(hora)) {
                r.add(x);
            }
        }
        return r;
    }
}
