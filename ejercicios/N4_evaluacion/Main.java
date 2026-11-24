void main() {
    Producto te = new Te("Té verde", 5000, 300, "Japón");   // Te «es una» Bebida y «es un» Producto
    IO.println(te.descripcion());
}
