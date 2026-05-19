package co.ufps.cuidapet.pet;

public enum Animal {
    GATO,
    PERRO,
    AVE,
    REPTIL,
    ROEDOR;

    public static Animal fromString(String dato){
        if(dato == null || dato.isBlank()) return null;
        try {
            return Animal.valueOf(dato.toUpperCase().replace("-","_"));
        }catch (IllegalArgumentException e) {
            throw new DomainException("Animal no existe: " + dato);
        }
    }
}
