package co.ufps.cuidapet.usuario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class RegistrarUsuarioComand {

    private final IUsuarioRepository repository;

    protected RegistrarUsuarioComand() { this.repository = null; }

    @Inject
    public RegistrarUsuarioComand(IUsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioDTO execute(String correo, String nombre, String contrasena) {
        if (repository.existeCorreo(correo)) {
            throw new CorreoYaExisteException(correo);  // en vez del RuntimeException genérico
        }
        Usuario usuario = Usuario.crearCuenta(correo, nombre, contrasena);
        repository.guardar(usuario);
        return UsuarioDTO.form(usuario);
    }
}
