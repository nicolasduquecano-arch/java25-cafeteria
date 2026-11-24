void main() {
    Domicilio d = new Domicilio();
    d.direccion = "Calle 10 # 5-20";
    IO.println(d.direccion + " · despachado: " + d.despachado);
    d.despachar();
    IO.println(d.direccion + " · despachado: " + d.despachado);
}
