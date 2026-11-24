public record Calificacion(String cliente, int estrellas) {   // espacio 1: record
    public Calificacion {                  // espacio 2: constructor compacto, sin paréntesis
        if (estrellas < 1 || estrellas > 5) {
            throw new IllegalArgumentException("De 1 a 5");
        }
    }

    public boolean esBuena() {
        return estrellas >= 4;             // espacio 3: estrellas
    }
}
