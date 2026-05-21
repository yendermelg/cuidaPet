package co.ufps.cuidapet.usuario;

public record UsuarioDTO(
        String usuarioId,
        String correoElectronico,
        String nombre
) {
    public static UsuarioDTO form(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getUsuarioId().value(),
                usuario.getCorreoElectronico(),
                usuario.getNombre()
        );
    }
}