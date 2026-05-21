package co.ufps.cuidapet.usuario;

import java.util.UUID;

public class UsuarioId {
    private final String value;

    private UsuarioId(String value) {
        this.value = value;
    }

    public static UsuarioId generate() {
        return new UsuarioId(UUID.randomUUID().toString());
    }

    public static UsuarioId of(String value) {
        if (value == null || value.isBlank()) {
            throw new RuntimeException("El ID de usuario no puede estar vacío.");
        }
        return new UsuarioId(value);
    }

    public String value() {
        return value;
    }
}