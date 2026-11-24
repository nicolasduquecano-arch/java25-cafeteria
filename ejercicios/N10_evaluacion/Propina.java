public record Propina(String barista, int valor) {
    public Propina {
        if (valor < 0) {                   // < y no <=: solo se rechazan los negativos
            throw new IllegalArgumentException(
                "Propina negativa: " + valor);
        }
    }
}
