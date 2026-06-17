package co.ufps.cuidapet.buscador;

import co.ufps.cuidapet.pet.PetDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class BuscadorAnimal {

    private final Buscador buscador;

    protected BuscadorAnimal() {
        this.buscador = null;
    }

    @Inject
    public BuscadorAnimal(Buscador buscador) {
        this.buscador = buscador;
    }

    public List<PetDTO> ejecutar(String nombre, String especie) {
        return buscador.buscar(nombre, especie)
                .stream()
                .map(PetDTO::form)
                .toList();
    }
}
