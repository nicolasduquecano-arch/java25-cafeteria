import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Agenda {
    private final ArrayList<Reserva> reservas;
    private int siguienteId = 1;

    public Agenda(List<Reserva> cargadas) {
        reservas = new ArrayList<>(cargadas);
        for (Reserva r : reservas) {       // sigue después del id más alto, sin repetirlos
            if (r.id() >= siguienteId) {
                siguienteId = r.id() + 1;
            }
        }
    }

    public Reserva crear(String cliente, int personas, String hora) {
        Reserva r = new Reserva(siguienteId, cliente, personas, hora);
        siguienteId++;
        reservas.add(r);
        return r;
    }

    public List<Reserva> listar() {
        List<Reserva> copia = new ArrayList<>(reservas);
        copia.sort((a, b) -> a.hora().compareTo(b.hora()));
        return copia;
    }

    public Optional<Reserva> buscar(int id) {
        for (Reserva r : reservas) {
            if (r.id() == id) {
                return Optional.of(r);
            }
        }
        return Optional.empty();
    }

    public boolean cambiarHora(int id, String hora) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).id() == id) {
                reservas.set(i, reservas.get(i).conHora(hora));   // reemplaza en su posición
                return true;
            }
        }
        return false;
    }

    public boolean cancelar(int id) {
        return reservas.removeIf(r -> r.id() == id);
    }

    public List<Reserva> deLaHora(String hora) {
        List<Reserva> r = new ArrayList<>();
        for (Reserva x : reservas) {
            if (x.hora().equals(hora)) {
                r.add(x);
            }
        }
        return r;
    }
}
