public enum Categoria {
    CALIENTE("Bebida caliente"),
    FRIA("Bebida fría"),
    POSTRE("Postre"),
    PANADERIA("Panadería"),
    BOTELLAS("Bebida embotellada");        // Punto 1: solo se agregó esta constante

    private final String etiqueta;

    Categoria(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String etiqueta() { return etiqueta; }
}
