package juridico.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una institución educativa registrada en el sistema.
 * Permite asociar usuarios y gestionar la información institucional.
 */
public class InstitucionEducativa {

    private Long id;
    private String nombre;
    private String nit;
    private String direccion;
    private String telefono;
    private String email;
    private String ciudad;
    private String pais;
    private TipoInstitucion tipoInstitucion;
    private boolean activa;
    private List<Usuario> usuariosAsociados;

    public InstitucionEducativa() {
        this.usuariosAsociados = new ArrayList<>();
        this.activa = true;
    }

    public InstitucionEducativa(Long id, String nombre, String nit, String direccion, 
                               String telefono, String email, String ciudad, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ciudad = ciudad;
        this.pais = pais;
        this.usuariosAsociados = new ArrayList<>();
        this.activa = true;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public TipoInstitucion getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(TipoInstitucion tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public List<Usuario> getUsuariosAsociados() {
        return usuariosAsociados;
    }

    public void setUsuariosAsociados(List<Usuario> usuariosAsociados) {
        this.usuariosAsociados = usuariosAsociados;
    }

    /**
     * Agrega un usuario a la institución educativa.
     * @param usuario Usuario a asociar
     */
    public void agregarUsuario(Usuario usuario) {
        if (!usuariosAsociados.contains(usuario)) {
            usuariosAsociados.add(usuario);
        }
    }

    /**
     * Remueve un usuario de la institución educativa.
     * @param usuario Usuario a remover
     */
    public void removerUsuario(Usuario usuario) {
        usuariosAsociados.remove(usuario);
    }

    /**
     * Tipo de institución educativa
     */
    public enum TipoInstitucion {
        UNIVERSIDAD,
        COLEGIO,
        INSTITUTO_TECNICO,
        ESCUELA,
        OTRO
    }
}
