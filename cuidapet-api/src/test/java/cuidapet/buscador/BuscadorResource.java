package cuidapet.buscador;

import co.ufps.cuidapet.buscador.BuscadorAnimal;
import co.ufps.cuidapet.pet.PetDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/buscador")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class BuscadorResource {
    @Inject
    private BuscadorAnimal buscadorAnimal;

    @GET
    public Response buscar(@QueryParam("nombre") @DefaultValue("") String nombre,
                               @QueryParam("especie") @DefaultValue("") String especie) {
        List<PetDTO> resultados = buscadorAnimal.ejecutar(nombre, especie);
        return Response.ok(resultados).build();
    }
}

