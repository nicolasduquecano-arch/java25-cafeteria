void main() {
    for (MedioPago m : MedioPago.values()) {
        IO.println(m + ": $" + m.neto(10000));
    }
}
