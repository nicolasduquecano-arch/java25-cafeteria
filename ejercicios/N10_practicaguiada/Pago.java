// Punto 1: Bono entra a la lista cerrada
public sealed interface Pago
    permits Efectivo, Tarjeta, Billetera, Bono { }
