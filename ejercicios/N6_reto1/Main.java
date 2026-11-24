void main() {
    for (Leche l : Leche.values()) {       // espacio 6: values
        if (l.vegetal()) {
            IO.println(l + " +$" + l.recargo());   // espacio 7: recargo
        }
    }
}
