Turno leer(Path f) throws Exception {
    try (var in = new ObjectInputStream(
            Files.newInputStream(f))) {
        in.setObjectInputFilter(           // va antes de readObject
            ObjectInputFilter.Config.createFilter("Turno;!*"));
        return (Turno) in.readObject();
    }
}

void guardar(Path f, Object o) throws Exception {
    try (var out = new ObjectOutputStream(
            Files.newOutputStream(f))) {
        out.writeObject(o);
    }
}

void main() throws Exception {
    Path f = Path.of("turno.ser");
    guardar(f, new Turno("Martín", 42));
    IO.println(leer(f));

    // Un archivo con otra clase se rechaza antes de crear el objeto
    Path otro = Path.of("otro.ser");
    guardar(otro, new ArrayList<>(List.of("no es un turno")));
    try {
        leer(otro);
    } catch (InvalidClassException e) {
        IO.println("Rechazado: " + e.getMessage());
    }
}
