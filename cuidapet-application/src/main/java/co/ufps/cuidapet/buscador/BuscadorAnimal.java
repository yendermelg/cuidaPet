package co.ufps.cuidapet.buscador;
import co.ufps.cuidapet.pet.Pet;

import java.util.List;

public class BuscadorAnimal {
    private final Buscador buscador;

    public BuscadorAnimal(Buscador buscador) {
        this.buscador = buscador;
    }

    public List<Pet> ejecutar(String nombre, String especie){
        return buscador.buscar(nombre, especie);
    }
}
