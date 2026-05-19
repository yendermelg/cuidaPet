package co.ufps.cuidapet.pet;

import co.ufps.cuidapet.DomainException;

public enum TipoComida {
    SECA,
    HUMEDA,
    NATURAL;

    public static TipoComida fromString(String dato){
        if(dato == null || dato.isBlank()) return null;
        try {
            return TipoComida.valueOf(dato.toUpperCase().replace("-","_"));
        }catch (IllegalArgumentException e) {
            throw new DomainException("Tipo de Comida no valida: " + dato);
        }
    }
}
