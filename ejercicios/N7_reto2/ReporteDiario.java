// D: recibe interfaces por constructor; aquí no hay ni un new de detalles
public class ReporteDiario {
    private final Formato formato;
    private final Destino destino;

    public ReporteDiario(Formato formato, Destino destino) {
        this.formato = formato;
        this.destino = destino;
    }

    public void generar(Totales totales) {
        destino.enviar(formato.dar(totales.total(), totales.cantidad()));
    }
}
