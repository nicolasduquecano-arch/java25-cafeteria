import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

// N11 · memoria de la bodega
public class Almacen {
    private final Path archivo;
    private static final String PERMITIDOS =
        "Insumo;java.util.ArrayList;java.lang.Object;!*";

    public Almacen(Path archivo) { this.archivo = archivo; }

    public void guardar(List<Insumo> insumos) throws IOException {
        try (var out = new ObjectOutputStream(
                Files.newOutputStream(archivo))) {
            out.writeObject(new ArrayList<>(insumos));
        }
    }

    @SuppressWarnings("unchecked")
    public List<Insumo> cargar() throws IOException,
            ClassNotFoundException {
        if (Files.notExists(archivo)) {    // primer día
            return List.of();
        }
        try (var in = new ObjectInputStream(
                Files.newInputStream(archivo))) {
            in.setObjectInputFilter(       // antes de leer: solo nuestras clases
                ObjectInputFilter.Config.createFilter(PERMITIDOS));
            return (List<Insumo>) in.readObject();
        }
    }

    public void exportarCsv(List<Insumo> insumos, Path csv) throws IOException {
        List<String> lineas = new ArrayList<>();
        lineas.add("id;nombre;cantidad");
        for (Insumo i : insumos) {
            lineas.add(i.id() + ";" + i.nombre() + ";" + i.cantidad());
        }
        Files.write(csv, lineas);
    }
}
