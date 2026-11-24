import java.util.ArrayList;
import java.util.List;

// Doble de prueba: permite probar la caja sin enviar mensajes
public class NotificadorMemoria implements Notificador {
    private final List<String> enviados = new ArrayList<>();

    @Override
    public void enviar(String destino, String mensaje) {
        enviados.add(destino + " → " + mensaje);
    }

    public List<String> enviados() {
        return List.copyOf(enviados);
    }
}
