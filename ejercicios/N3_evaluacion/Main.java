void main() {
    Domicilio lejos = new Domicilio("Calle 10 # 5-20", 7000);
    Domicilio cerca = new Domicilio("Carrera 3 # 8-15");
    IO.println(lejos.descripcion());
    IO.println(cerca.descripcion());       // muestra el valor por defecto
}
