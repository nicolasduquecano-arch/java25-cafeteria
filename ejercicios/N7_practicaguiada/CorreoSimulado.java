// Punto 1: archivo nuevo; Caja no cambió (abierto/cerrado e inversión de dependencias)
public class CorreoSimulado implements Notificador {
    public void enviar(String destino, String mensaje) {
        IO.println("Correo a " + destino + ": " + mensaje);
    }
}
