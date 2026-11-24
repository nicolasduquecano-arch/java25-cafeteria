import java.util.ArrayList;
import java.util.List;

public class NotificadorMemoria implements Notificador {
    private final List<String> enviados = new ArrayList<>();

    public void enviar(String destino, String mensaje) {
        enviados.add(destino + " → " + mensaje);
    }

    public List<String> enviados() {
        return enviados;
    }
}
