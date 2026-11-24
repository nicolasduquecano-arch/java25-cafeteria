public class DestinoConsola implements Destino {
    @Override
    public void enviar(String texto) {
        IO.println(texto);
    }
}
