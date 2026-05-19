package co.ufps.cuidapet.pet;

import co.ufps.cuidapet.DomainException;

import java.util.UUID;

public class PetId {
    private final String value;

    private PetId(String value) {
        if(value == null || value.isBlank())
            throw new DomainException("El contentID no puede estar vacio");
        this.value = value.strip();
        //Strip elimina espacios en blanco de un String
    }
    public static PetId generate() {
        return new PetId(UUID.randomUUID().toString());
        //Generador de randomUUID utilizando la clase UUID incluida en java
    }
    public static PetId of (String value) {
        return new PetId((value));
    }
    public String value() {
        return value;
    }
}
