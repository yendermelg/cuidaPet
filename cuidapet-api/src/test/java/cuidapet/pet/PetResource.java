package cuidapet.pet;

import co.ufps.cuidapet.pet.GetPetsQuery;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/pets")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class PetResource {
    @Inject
    private GetPetsQuery getPetsQuery;

    @GET
    public Response listar() {
        return Response.ok(getPetsQuery.execute()).build();
    }
}
