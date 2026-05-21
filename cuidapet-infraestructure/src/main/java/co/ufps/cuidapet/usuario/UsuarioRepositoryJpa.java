package co.ufps.cuidapet.usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.Optional;

public class UsuarioRepositoryJpa implements IUsuarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioJpa jpa = toEntity(usuario);
        entityManager.persist(jpa);
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarPorCorreo(String correoElectronico) {
        return entityManager.createQuery(
                        "SELECT u FROM UsuarioJpa u WHERE u.correoElectronico = :correo",
                        UsuarioJpa.class)
                .setParameter("correo", correoElectronico)
                .getResultStream()
                .findFirst()
                .map(this::toDomain);
    }

    @Override
    public boolean existeCorreo(String correoElectronico) {
        Long count = entityManager.createQuery(
                        "SELECT COUNT(u) FROM UsuarioJpa u WHERE u.correoElectronico = :correo",
                        Long.class)
                .setParameter("correo", correoElectronico)
                .getSingleResult();
        return count > 0;
    }

    // Convierte entidad de dominio a entidad JPA
    private UsuarioJpa toEntity(Usuario usuario) {
        UsuarioJpa jpa = new UsuarioJpa();
        jpa.setUsuarioId(usuario.getUsuarioId().value());
        jpa.setCorreoElectronico(usuario.getCorreoElectronico());
        jpa.setNombre(usuario.getNombre());
        jpa.setContrasena(usuario.getContrasena());
        return jpa;
    }

    // Convierte entidad JPA a entidad de dominio
    private Usuario toDomain(UsuarioJpa jpa) {
        return Usuario.of(
                UsuarioId.of(jpa.getUsuarioId()),
                jpa.getCorreoElectronico(),
                jpa.getNombre(),
                jpa.getContrasena()
        );
    }
}