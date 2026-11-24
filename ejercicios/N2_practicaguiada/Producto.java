public class Producto {
    private String nombre;
    private int precio;
    private int stock;                     // Punto 1: oculto, solo cambia con reponer()

    public String getNombre() { return nombre; }
    public int getPrecio() { return precio; }
    public int getStock() { return stock; }

    public void setNombre(String nombre) {
        this.nombre = nombre;              // this distingue el atributo del parámetro
    }

    public void setPrecio(int precio) {
        if (precio < 0 || precio > 50000) {
            throw new IllegalArgumentException(
                "Precio fuera de rango: " + precio);
        }
        this.precio = precio;
    }

    // Punto 1: la regla va antes de tocar el atributo
    public void reponer(int unidades) {
        if (unidades <= 0) {
            throw new IllegalArgumentException(
                "Unidades inválidas: " + unidades);
        }
        stock += unidades;
    }

    // Punto 2: no hay setStock; con reponer cada cambio tiene una razón y una regla
}
