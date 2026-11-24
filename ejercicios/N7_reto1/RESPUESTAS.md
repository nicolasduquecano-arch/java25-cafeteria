# N07 · S06 · Cocina

- espacio 1 → `interface`: es el contrato; su método no tiene cuerpo.
- espacio 2 → `implements`: ImpresoraConsola firma el contrato.
- espacio 3 → `final`: la dependencia se asigna una vez en el constructor.
- espacio 4 → `Impresora`: Cocina depende de la interfaz, no de la consola.
- espacio 5 → `impresora`: se guarda el parámetro recibido.
- espacio 6 → `imprimir`: es el único método del contrato.
- espacio 7 → `ImpresoraConsola`: `new` necesita una clase concreta; una interfaz no se instancia.

**Sobran:** `extends`, `Cocina`, `print`, `class`, `String`.
