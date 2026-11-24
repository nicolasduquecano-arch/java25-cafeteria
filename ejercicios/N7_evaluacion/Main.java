void main() {
    Descuento d = new HoraFeliz();
    IO.println("10000 → $" + d.aplicar(10000));
    IO.println("0 → $" + d.aplicar(0));
    IO.println("-500 → $" + d.aplicar(-500));   // caso límite del contrato
}
