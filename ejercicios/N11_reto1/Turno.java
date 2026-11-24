import java.io.Serializable;

public record Turno(String barista, int bebidas)
    implements Serializable {}             // espacio 1: Serializable, permiso para guardarlo
