public class Domicilio {
    String direccion;
    boolean despachado;                    // empieza en false: aún no sale

    void despachar() {
        despachado = true;                 // el método cambia el estado del objeto
    }
}
