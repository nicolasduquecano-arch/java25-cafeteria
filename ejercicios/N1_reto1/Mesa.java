public class Mesa {                        // espacio 1: class
    int numero;
    int personas;
    boolean ocupada;                       // espacio 2: boolean, porque solo guarda sí o no

    void ocupar(int cuantas) {
        personas = cuantas;
        ocupada = true;
    }

    void liberar() {                       // espacio 3: void, porque no entrega nada
        personas = 0;
        ocupada = false;
    }

    String estado() {
        if (ocupada) {
            return "Mesa " + numero + " ocupada por " + personas;   // espacio 4: return
        }
        return "Mesa " + numero + " libre";
    }
}
