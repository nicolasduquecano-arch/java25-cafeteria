public class Cocina {
    private final Impresora impresora;     // espacio 3: final, no se cambia después

    public Cocina(Impresora impresora) {   // espacio 4: Impresora, pide el contrato
        this.impresora = impresora;        // espacio 5: impresora, el parámetro
    }

    public void enviarComanda(String plato, int mesa) {
        impresora.imprimir("Mesa " + mesa + ": " + plato);   // espacio 6: imprimir
    }
}
