package co.ufps.cuidapet.pet;

public enum Marca {
    GATITOS,
    KITTEN,
    DOG_SHAW;

    public static Marca fromString(String dato){
        if(dato == null || dato.isBlank()) return null;
        try {
            return Marca.valueOf(dato.toUpperCase().replace("-","_"));
        }catch (IllegalArgumentException e) {
            throw new DomainException("Marca no existe: " + dato);
        }
    }
}
