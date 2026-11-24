import java.util.ArrayList;
import java.util.List;

public class DestinoMemoria implements Destino {
    private final List<String> recibidos = new ArrayList<>();

    @Override
    public void enviar(String texto) {
        recibidos.add(texto);
    }

    public List<String> recibidos() {
        return recibidos;
    }
}
