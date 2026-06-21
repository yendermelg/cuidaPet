package cuidapet.usuario;

public record LoginUsuarioRequest(
        String correo,
        String contrasena
) {}