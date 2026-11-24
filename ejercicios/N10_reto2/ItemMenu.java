public record ItemMenu(String nombre, Categoria categoria, int precio) {
    public ItemMenu {                      // valida antes de que Java asigne los componentes
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre vacío");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("Precio inválido: " + precio);
        }
    }

    // Un record no se modifica: se crea otro, que vuelve a pasar por la validación
    public ItemMenu conPrecio(int nuevo) {
        return new ItemMenu(nombre, categoria, nuevo);
    }
}
