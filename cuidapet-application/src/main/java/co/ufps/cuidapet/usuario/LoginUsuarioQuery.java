package co.ufps.cuidapet.usuario;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class LoginUsuarioQuery {

    private final IUsuarioRepository repository;

    protected LoginUsuarioQuery() { this.repository = null; }

    @Inject
    public LoginUsuarioQuery(IUsuarioRepository repository) {
        this.repository = repository;
    }

    public UsuarioDTO execute(String correo, String contrasena) {
        return repository.buscarPorCorreo(correo)
                .filter(u -> u.getContrasena().equals(contrasena))
                .map(UsuarioDTO::form)
                .orElseThrow(() -> new RuntimeException("Correo o contraseña incorrectos."));
    }
}
