package co.ufps.cuidapet.buscador;
import co.ufps.cuidapet.pet.Pet;

import java.util.List;

// Servicio encargado de realizar búsquedas de mascotas usando el repositorio.
public class Buscador {
    private final AnimalRepositorio repository;

    public Buscador(AnimalRepositorio repository) {
        this.repository = repository;
    }

    public List<Pet> buscar(String nombre, String especie) {
        return repository.buscar(nombre, especie);
    }
}
