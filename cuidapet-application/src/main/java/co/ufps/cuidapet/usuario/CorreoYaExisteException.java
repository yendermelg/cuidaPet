package co.ufps.cuidapet.usuario;

public class CorreoYaExisteException extends RuntimeException {

    private final String correo;

    public CorreoYaExisteException(String correo) {
        super("Ya existe una cuenta con ese correo: " + correo);
        this.correo = correo;
    }

    public String getCorreo() { return correo; }
}
