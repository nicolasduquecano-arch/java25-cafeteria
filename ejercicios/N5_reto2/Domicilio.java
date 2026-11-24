// Extra: hereda de una sola clase, pero firma dos contratos a la vez
public class Domicilio extends Entrega implements Rastreable, Avisable {
    private final int kilometros;
    private String estado = "preparando";

    public Domicilio(int pedidoId, int kilometros) {
        super(pedidoId);
        this.kilometros = kilometros;
    }

    @Override
    public int costo() {
        return 2000 + 800 * kilometros;
    }

    @Override
    public String estado() {
        return estado;
    }

    public void avanzar() {
        if (estado.equals("preparando")) {
            estado = "en camino";
        } else {
            estado = "entregado";          // si ya estaba entregado, se queda ahí
        }
    }

    @Override
    public String aviso() {
        return "Tu domicilio está: " + estado;
    }
}
