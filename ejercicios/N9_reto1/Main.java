void main() {
    List<String> espera = new ArrayList<>();   // espacio 1: ArrayList
    // C
    espera.add("Rojas (4)");               // espacio 2: add
    espera.add("Gómez (2)");
    espera.add("Pérez (3)");
    IO.println("En espera: " + espera.size());   // R · espacio 3: size
    IO.println("Sigue: " + espera.getFirst());   // espacio 4: getFirst
    espera.set(1, "Gómez (5)");            // U · espacio 5: set
    espera.removeIf(n -> n.startsWith("Rojas"));   // D · espacio 6: removeIf
    IO.println(espera);
    IO.println("¿Pérez? " + espera.contains("Pérez (3)"));   // espacio 7: contains
}
