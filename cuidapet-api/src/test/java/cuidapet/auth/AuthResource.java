package cuidapet.auth;

import co.ufps.cuidapet.usuario.RegistrarUsuarioComand;
import co.ufps.cuidapet.usuario.UsuarioDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {

    @Inject
    private RegistrarUsuarioComand registerCommand;

    @POST
    @Path("/register")
    public Response register(RegisterUsuarioRequest request) {
        UsuarioDTO dto = registerCommand.execute(
                request.email(),
                request.password(),
                request.nombre()
        );
        return Response.status(Response.Status.CREATED).entity(dto).build();
    }
}
