public enum EstadoMesa {
    LIBRE("Disponible"),
    OCUPADA("En servicio"),
    POR_LIMPIAR("Falta limpiar"),
    RESERVADA("Con reserva"),
    FUERA_DE_SERVICIO("No usar");          // Extra

    private final String aviso;

    EstadoMesa(String aviso) {
        this.aviso = aviso;
    }

    public String aviso() { return aviso; }

    // Sin default: si falta un estado, el compilador lo señala (ver ERROR_COMPILADOR.txt)
    public EstadoMesa siguiente() {
        return switch (this) {
            case OCUPADA -> POR_LIMPIAR;
            case POR_LIMPIAR -> LIBRE;
            case RESERVADA, LIBRE -> OCUPADA;
            case FUERA_DE_SERVICIO -> FUERA_DE_SERVICIO;   // Extra: no avanza sola
        };
    }

    public boolean disponible() {
        return this == LIBRE;              // en un enum == es seguro: cada constante es única
    }
}
