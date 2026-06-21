package cuidapet.usuario;

import co.ufps.cuidapet.usuario.LoginUsuarioQuery;
import co.ufps.cuidapet.usuario.UsuarioDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuarios")
@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    @Inject
    private LoginUsuarioQuery loginUsuarioQuery;

    @POST
    @Path("/login")
    public Response login(LoginUsuarioRequest request) {
        UsuarioDTO dto = loginUsuarioQuery.execute(request.correo(), request.contrasena());
        return Response.ok(dto).build();
    }
}
