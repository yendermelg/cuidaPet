package co.ufps.cuidapet.usuario;

import java.util.Optional;

public interface IUsuarioRepository {

    // Guardar nuevo usuario
    Usuario guardar(Usuario usuario);

    // Buscar por correo para verificar si ya existe
    Optional<Usuario> buscarPorCorreo(String correoElectronico);

    // Verificar si el correo ya está registrado
    boolean existeCorreo(String correoElectronico);
}