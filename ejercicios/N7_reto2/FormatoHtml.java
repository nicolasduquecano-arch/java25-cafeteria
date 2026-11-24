// Extra: 1 archivo nuevo, 0 clases existentes modificadas (solo Main lo usa)
public class FormatoHtml implements Formato {
    @Override
    public String dar(int total, int ventas) {
        return "<p>" + ventas + " ventas, total $" + total + "</p>";
    }
}
