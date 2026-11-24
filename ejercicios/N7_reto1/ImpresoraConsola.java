public class ImpresoraConsola implements Impresora {   // espacio 2: implements
    @Override
    public void imprimir(String texto) {
        IO.println("[impresora] " + texto);
    }
}
