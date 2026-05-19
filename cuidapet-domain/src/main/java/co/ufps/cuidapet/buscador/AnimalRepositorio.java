package co.ufps.cuidapet.buscador;
import co.ufps.cuidapet.pet.Pet;

import java.util.List;

// Define el contrato para buscar animales por nombre y especie.
public interface AnimalRepositorio {
    List<Pet> buscar(String nombre, String especie);
}
