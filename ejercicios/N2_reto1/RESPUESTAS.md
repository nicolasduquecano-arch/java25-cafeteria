# N02 · S06 · TarjetaRegalo

- espacio 1 → `private`: el saldo solo debe cambiar por los métodos de la clase.
- espacio 2 → `getSaldo`: es el getter, devuelve `saldo` sin cambiarlo.
- espacio 3 → `<=`: una recarga de 0 o negativa es inválida.
- espacio 4 → `IllegalArgumentException`: es la excepción para un argumento que no cumple la regla.
- espacio 5 → `boolean`: el método devuelve `true` o `false`.
- espacio 6 → `return`: entrega el resultado del pago exitoso.
- espacio 7 → `getSaldo`: desde Main no se puede leer `t.saldo` porque es `private`.

**Sobran:** `int`, `void`, `>=`, `setSaldo`, `public`.
