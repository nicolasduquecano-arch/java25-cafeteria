void main() throws Exception {
    Path f = Path.of("turno.ser");         // espacio 2: Path

    try (var out = new ObjectOutputStream( // espacios 3 y 4: try cierra el flujo solo
            Files.newOutputStream(f))) {
        out.writeObject(new Turno("Martín", 42));   // espacio 5: writeObject
    }

    try (var in = new ObjectInputStream(
            Files.newInputStream(f))) {
        in.setObjectInputFilter(
            ObjectInputFilter.Config.createFilter("Turno;!*"));
        Turno t = (Turno) in.readObject(); // espacio 6: readObject
        IO.println(t + " · " + Files.size(f) + " bytes");   // espacio 7: size
    }
}
