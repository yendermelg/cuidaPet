package cuidapet.auth;

import co.ufps.cuidapet.DomainException; // Importado desde tu módulo cuidapet-domain
import co.ufps.cuidapet.usuario.CorreoYaExisteException; // Esta excepción la debes crear en tu módulo domain o application
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception ex) {

        // 409 — email duplicado al registrarse
        if (ex instanceof CorreoYaExisteException e)
            return error(409, e.getMessage());

        // 422 — violación de regla de negocio del dominio en CuidaPet
        if (ex instanceof DomainException e)
            return error(422, e.getMessage());

        // 500 — error inesperado no manejado
        return error(500, "Error interno del servidor en CuidaPet");
    }

    private Response error(int statusCode, String message) {
        return Response
                .status(statusCode)
                .entity(new ErrorResponse(statusCode, message))
                .type(MediaType.APPLICATION_JSON)
                .build();
    }

    public record ErrorResponse(int code, String message) {}
}
