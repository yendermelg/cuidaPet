package co.ufps.cuidapet.pet;

import co.ufps.cuidapet.DomainException;

public enum Frecuencia {
    CADA_8_HORAS,
    DIARIO,
    SEMANAL,
    MENSUAL;

    public static Frecuencia fromString(String dato){
        if(dato == null || dato.isBlank()) {
            return null;
        }
        try {
            return Frecuencia.valueOf(dato.toUpperCase().replace("-","_"));
        }catch (IllegalArgumentException e) {
            throw new DomainException("Frecuencia no valida: " + dato);
        }
    }


}
