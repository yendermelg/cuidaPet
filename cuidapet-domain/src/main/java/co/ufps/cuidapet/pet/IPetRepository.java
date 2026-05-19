package co.ufps.cuidapet.pet;

import java.util.List;
import java.util.Optional;

public interface IPetRepository {
    // Guardar mascota
    public Pet save(Pet pet);

    // Buscar todas las mascotas
    public List<Pet> buscarTodas();

    // Buscar por ID
    public Optional<Pet> buscarId(PetId petId);

    // Verificar si existe
    public boolean existeId(PetId petId);

    // Eliminar mascota
    public int borrar(PetId petId);
}
