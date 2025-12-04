package juridico.domain;

import java.time.LocalDateTime;

/**
 * Clase que representa un usuario del sistema jurídico.
 * Extiende de Persona y agrega atributos específicos de autenticación y membresía.
 */
public class Usuario extends Persona {

    private String username;
    private String password;
    private Membresia membresia;
    private boolean activo;
    private LocalDateTime fechaRegistro;
    private LocalDateTime ultimoAcceso;

    public Usuario(Long id, String nombres, String apellidos, String email, String telefono, String username, String password) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.username = username;
        this.password = password;
        this.activo = true;
        this.fechaRegistro = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalDateTime getUltimoAcceso() {
        return ultimoAcceso;
    }

    public void setUltimoAcceso(LocalDateTime ultimoAcceso) {
        this.ultimoAcceso = ultimoAcceso;
    }

    /**
     * Verifica si el usuario tiene una membresía activa y válida.
     * @return true si la membresía está activa, false en caso contrario
     */
    public boolean tieneMembresiaActiva() {
        return membresia != null && membresia.isActiva();
    }

    /**
     * Actualiza el timestamp del último acceso del usuario.
     */
    public void registrarAcceso() {
        this.ultimoAcceso = LocalDateTime.now();
    }
}
