# N11 · S06 · Turno

- espacio 1 → `Serializable`: marca el record como guardable.
- espacio 2 → `Path`: `Path.of` crea la ruta del archivo.
- espacio 3 → `try`: try con recursos, cierra el flujo aunque haya error.
- espacio 4 → `ObjectOutputStream`: convierte objetos en bytes para escribir.
- espacio 5 → `writeObject`: guarda el objeto.
- espacio 6 → `readObject`: lee el objeto; devuelve `Object`, por eso el cast.
- espacio 7 → `size`: `Files.size` da el tamaño del archivo en bytes.

**Sobran:** `Cloneable`, `length`, `read`, `File`, `write`.
