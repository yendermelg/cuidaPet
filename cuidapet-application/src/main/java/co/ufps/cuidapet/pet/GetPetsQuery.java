package co.ufps.cuidapet.pet;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;

@ApplicationScoped
public class GetPetsQuery {

    private final IPetRepository repository;

    protected GetPetsQuery() {
        this.repository = null;
    }

    @Inject
    public GetPetsQuery(IPetRepository repository) {
        this.repository = repository;
    }

    public List<PetDTO> execute() {
        return repository
                .buscarTodas()
                .stream()
                .map(PetDTO::form)
                .toList();
    }
}

