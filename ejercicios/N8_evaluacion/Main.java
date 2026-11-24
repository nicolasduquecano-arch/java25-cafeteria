<T> List<T> primeros(List<T> l, int n) {
    List<T> r = new ArrayList<>();
    for (int i = 0; i < n && i < l.size(); i++) {   // la segunda condición evita salirse de la lista
        r.add(l.get(i));
    }
    return r;
}

void main() {
    List<String> bebidas = List.of("latte", "moka", "tinto", "capuchino");
    IO.println(primeros(bebidas, 2));
    IO.println(primeros(bebidas, 10));     // caso límite: pide más de las que hay
}
