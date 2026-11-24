public class FormatoTexto implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "CIERRE · " + ventas + " ventas · total $" + total;
    }
}
