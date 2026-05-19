package co.ufps.cuidapet.pet;

import co.ufps.cuidapet.DomainException;

public enum Race {
    LABRADOR,
    PASTOR_ALEMAN,
    PITBULL,
    PERSA,
    SIAMES;

    public static Race fromString(String dato){
        if(dato == null || dato.isBlank()) return null;
        try {
            return Race.valueOf(dato.toUpperCase().replace("-","_"));
        }catch (IllegalArgumentException e) {
            throw new DomainException("Raza no existe: " + dato);
        }
    }
}
