public class Postre {
    private final String nombre;
    private final int precio;
    private final boolean sinAzucar;

    public Postre(String nombre, int precio,   // espacio 1: Postre, sin tipo de retorno
                  boolean sinAzucar) {
        this.nombre = nombre;              // espacio 2: this
        this.precio = precio;
        this.sinAzucar = sinAzucar;
    }

    public Postre(String nombre, int precio) {
        this(nombre, precio, false);       // espacios 3 y 4: this delega, false por defecto
    }

    public String etiqueta() {
        return nombre + " $" + precio;
    }

    public String etiqueta(boolean detallada) {   // espacio 5: boolean
        if (detallada && sinAzucar) {
            return etiqueta() + " · sin azúcar";
        }
        return etiqueta();                 // espacio 6: etiqueta, reutiliza la versión corta
    }
}
