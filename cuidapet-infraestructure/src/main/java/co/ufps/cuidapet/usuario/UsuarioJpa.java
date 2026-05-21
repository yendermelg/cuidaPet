package co.ufps.cuidapet.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioJpa {

    @Id
    @Column(name = "usuario_id", length = 36, nullable = false)
    private String usuarioId;

    @Column(name = "correo_electronico", length = 100, nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "contrasena", length = 255, nullable = false)
    private String contrasena;

    public UsuarioJpa() {}

    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
}