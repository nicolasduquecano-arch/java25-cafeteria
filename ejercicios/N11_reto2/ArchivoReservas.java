import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoReservas {
    private final Path archivo;
    // Lista blanca: solo lo que guardamos; !* rechaza todo lo demás
    private static final String PERMITIDOS =
        "Reserva;java.util.ArrayList;java.lang.Object;!*";

    public ArchivoReservas(Path archivo) { this.archivo = archivo; }

    public void guardar(List<Reserva> reservas) throws IOException {
        try (var out = new ObjectOutputStream(
                Files.newOutputStream(archivo))) {
            out.writeObject(new ArrayList<>(reservas));   // ArrayList: es la clase que permite el filtro
        }
    }

    @SuppressWarnings("unchecked")
    public List<Reserva> cargar() throws IOException,
            ClassNotFoundException {
        if (Files.notExists(archivo)) {    // primer día: no es un error
            return List.of();
        }
        try (var in = new ObjectInputStream(
                Files.newInputStream(archivo))) {
            in.setObjectInputFilter(       // antes de readObject: revisa cada clase al leer
                ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Reserva>) in.readObject();
        }
    }

    public void exportarCsv(List<Reserva> reservas, Path csv) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("id;cliente;personas;hora");
        for (Reserva r : reservas) {
            lineas.add(r.id() + ";" + r.cliente() + ";" + r.personas() + ";" + r.hora());
        }
        Files.write(csv, lineas);
    }
}
