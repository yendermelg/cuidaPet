package co.ufps.cuidapet.usuario;

import co.ufps.cuidapet.DomainException;
import co.ufps.cuidapet.pet.PetId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
    private final UsuarioId usuarioId;
    private final String correoElectronico;
    private final String nombre;
    private final String contrasena;
    private final List<PetId> mascotasRegistradas;

    private Usuario(UsuarioId usuarioId,
                    String correoElectronico,
                    String nombre,
                    String contrasena) {
        this.usuarioId = Objects.requireNonNull(usuarioId, "El ID es obligatorio.");
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.mascotasRegistradas = new ArrayList<>();
    }

    public static Usuario crearCuenta(String correoElectronico,
                                      String nombre,
                                      String contrasena) {
        validarCorreo(correoElectronico);
        validarNombre(nombre);
        validarContrasena(contrasena);
        return new Usuario(UsuarioId.generate(), correoElectronico, nombre, contrasena);
    }

    // Reconstruir desde persistencia
    public static Usuario of(UsuarioId usuarioId,
                             String correoElectronico,
                             String nombre,
                             String contrasena) {
        return new Usuario(usuarioId, correoElectronico, nombre, contrasena);
    }

    private static void validarCorreo(String correo) {
        if (correo == null || correo.isBlank()) {
            throw new DomainException("El correo no puede estar vacío.");
        }
        if (!correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new DomainException("El formato del correo es inválido: " + correo);
        }
    }

    private static void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new DomainException("El nombre no puede estar vacío.");
        }
    }

    private static void validarContrasena(String contrasena) {
        if (contrasena == null || contrasena.length() < 6) {
            throw new DomainException("La contraseña debe tener al menos 6 caracteres.");
        }
    }

    public void agregarMascota(PetId petId) {
        this.mascotasRegistradas.add(petId);
    }

    public UsuarioId getUsuarioId() { return usuarioId; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getNombre() { return nombre; }
    public String getContrasena() { return contrasena; }
    public List<PetId> getMascotasRegistradas() { return mascotasRegistradas; }
}