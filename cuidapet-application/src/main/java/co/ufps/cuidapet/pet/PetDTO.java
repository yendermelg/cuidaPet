package co.ufps.cuidapet.pet;

public record PetDTO (String petId,
        String name,
        String size,
        String race,
        int edad,
        String animal,
        String food,
        String hygiene,
        String behavior
){

    public static PetDTO form(Pet p){
        return new PetDTO(p.getPetId().value(),
                p.getName(),
                p.getSize(),
                p.getRace().name(),
                p.getEdad(),
                p.getAnimal().name(),
                p.getFood().toString(),
                p.getHygiene().toString(),
                p.getBehavior().name());
    }
}
