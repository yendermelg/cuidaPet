package cuidapet.auth;

public record RegisterUsuarioRequest(
        String email,
        String password,
        String nombre
) {}
