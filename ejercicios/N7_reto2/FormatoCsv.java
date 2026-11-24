public class FormatoCsv implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "ventas;total\n" + ventas + ";" + total;
    }
}
