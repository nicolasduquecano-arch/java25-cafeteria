# N04 · S06 · Temporada y Combo

- espacio 1 → `extends`: Temporada «es un» Producto.
- espacio 2 → `super`: el constructor del padre asigna nombre y precio, que son `private`.
- espacio 3 → `@Override`: confirma que se sobrescribe `descripcion()` del padre.
- espacio 4 → `super`: reutiliza la descripción del padre; con `this` se llamaría a sí misma sin fin.
- espacio 5 → `Producto`: el combo «tiene un» producto de cualquier tipo.
- espacio 6 → `getPrecio`: `precio` es `private`, se lee con el getter.
- espacio 7 → `Temporada`: es la clase que recibe nombre, precio y mes.

**Sobran:** `Object`, `getNombre`, `Bebida`, `this`, `implements`.
