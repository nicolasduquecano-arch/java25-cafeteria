import java.util.List;

// Paso 1: todo en un solo método (suma, formato y salida mezclados)
public class ReporteDiarioViejo {
    public void generar(List<Integer> ventas) {
        int total = 0;
        for (int v : ventas) total += v;
        String texto = "CIERRE · " + ventas.size() + " ventas · total $" + total;
        IO.println(texto);
    }
}
