public enum Leche {                        // espacio 1: enum
    ENTERA(0), DESLACTOSADA(500), AVENA(1500), ALMENDRAS(1800);

    private final int recargo;             // espacio 2: final, el recargo no cambia

    Leche(int recargo) {                   // espacio 3: Leche, el constructor
        this.recargo = recargo;
    }

    public int recargo() { return recargo; }

    public boolean vegetal() {
        return switch (this) {             // espacio 4: switch
            case AVENA, ALMENDRAS -> true;
            default -> false;              // espacio 5: default, cubre las otras dos
        };
    }
}
