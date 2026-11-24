Map<EstadoMesa, Integer> contar(EstadoMesa[] mesas) {
    Map<EstadoMesa, Integer> conteo = new EnumMap<>(EstadoMesa.class);
    for (EstadoMesa e : mesas) {
        conteo.put(e, conteo.getOrDefault(e, 0) + 1);
    }
    return conteo;
}

void mostrar(Map<EstadoMesa, Integer> conteo) {
    for (EstadoMesa e : EstadoMesa.values()) {   // values(): también muestra los que van en 0
        IO.println(e + " (" + e.aviso() + "): " + conteo.getOrDefault(e, 0));
    }
}

void main() {
    EstadoMesa[] mesas = {
        EstadoMesa.LIBRE, EstadoMesa.OCUPADA, EstadoMesa.OCUPADA,
        EstadoMesa.POR_LIMPIAR, EstadoMesa.RESERVADA, EstadoMesa.LIBRE,
        EstadoMesa.OCUPADA, EstadoMesa.FUERA_DE_SERVICIO
    };

    IO.println("Antes");
    mostrar(contar(mesas));

    int disponibles = 0;
    for (EstadoMesa e : mesas) {
        if (e.disponible()) {
            disponibles++;
        }
    }
    IO.println("Disponibles: " + disponibles);

    for (int i = 0; i < mesas.length; i++) {
        mesas[i] = mesas[i].siguiente();   // con índice: hay que reemplazar en el arreglo
    }

    IO.println("Después");
    mostrar(contar(mesas));
}
