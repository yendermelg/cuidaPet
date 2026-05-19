package co.ufps.cuidapet.pet;

public enum Behavior {
    TRANQUILO,
    JUGUETON,
    NORMAL,
    AGRESIVO;

    public static Behavior fromString(String dato){
        if(dato == null || dato.isBlank()) return null;
        try {
            return Behavior.valueOf(dato.toUpperCase().replace("-","_"));
        }catch (IllegalArgumentException e) {
            throw new DomainException("Comportamiento no aceptable: " + dato);
        }
    }
}
