package juridico.domain;

/**
 * Clase base abstracta que representa una persona en el sistema.
 * Contiene los atributos comunes a todos los tipos de personas.
 */
public abstract class Persona {

    protected Long id;
    protected String nombres;
    protected String apellidos;
    protected String email;
    protected String telefono;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el nombre completo de la persona.
     * @return Nombres y apellidos concatenados
     */
    public String getNombreCompleto() {
        return nombres + " " + apellidos;
    }
}
