public class Combo {
    private final String bebida;
    private final String postre;
    private final int precio;

    public Combo(String bebida, String postre, int precio) {
        if (precio <= 0) {                 // único lugar con la regla del precio
            throw new IllegalArgumentException(
                "Precio inválido: " + precio);
        }
        this.bebida = bebida;
        this.postre = postre;
        this.precio = precio;
    }

    public Combo(String bebida, int precio) {
        // Extra: leer this.precio aquí no compila (ver ERROR_COMPILADOR.txt):
        // el objeto todavía no está construido; el prólogo solo usa los parámetros
        if (bebida.isBlank()) {            // prólogo: se valida antes de delegar
            throw new IllegalArgumentException(
                "Falta la bebida");
        }
        this(bebida, "sin postre", precio);
    }

    public int precioFinal() {
        return precio;
    }

    public int precioFinal(int propinaPct) {
        return precioFinal() + precioFinal() * propinaPct / 100;   // reutiliza la otra
    }

    public String descripcion() {
        return bebida + " + " + postre + " $" + precio;
    }
}
