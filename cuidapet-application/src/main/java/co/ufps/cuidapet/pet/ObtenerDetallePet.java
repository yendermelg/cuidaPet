package co.ufps.cuidapet.pet;

import co.ufps.cuidapet.DomainException;
import java.util.Optional;

public class ObtenerDetallePet {

    private final IPetRepository repository;

    public ObtenerDetallePet(IPetRepository repository) {
        this.repository = repository;
    }

    public PetDTO ejecutar(String id) {
        if (id == null || id.isBlank()) {
            throw new DomainException("El ID no puede estar vacío.");
        }

        PetId petId = PetId.of(id);

        Optional<Pet> resultado = repository.obtenerPorId(petId);

        // Si no existe lanza error de dominio
        Pet pet = resultado.orElseThrow(() ->
                new DomainException("No se encontró una mascota con el ID: " + id)
        );

        // Convierte la entidad a DTO con todos los campos incluyendo
        // food (alimentación), hygiene y behavior (comportamiento)
        return PetDTO.form(pet);
    }
}