public class Barista {
    String nombre;
    String turno;
    int bebidas;                           // empieza en 0 porque es int
    int propinas;                          // Extra

    void preparar(String bebida) {
        IO.println(nombre + " prepara un " + bebida);
        bebidas = bebidas + 1;             // cada preparación cuenta una bebida
    }

    String resumen() {
        return nombre + " (" + turno + "): " + bebidas + " bebidas";
    }

    boolean merecePausa() {
        return bebidas >= 20;              // >= y no >: con 20 exactas ya merece
    }

    // Extra: solo suma si es positivo; un negativo se ignora sin avisar
    void recibirPropina(int valor) {
        if (valor > 0) {
            propinas = propinas + valor;
        }
    }
}
