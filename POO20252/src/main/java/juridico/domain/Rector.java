package juridico.domain;

/**
 * Clase que representa un Rector como tipo especializado de usuario.
 * Los rectores tienen autorización para representar instituciones educativas.
 */
public class Rector extends Usuario {

    private InstitucionEducativa institucion;
    private String cargoOficial;
    private String numeroResolucion;

    public Rector(Long id, String nombres, String apellidos, String email, String telefono, 
                  String username, String password, InstitucionEducativa institucion) {
        super(id, nombres, apellidos, email, telefono, username, password);
        this.institucion = institucion;
        this.cargoOficial = "Rector";
    }

    public InstitucionEducativa getInstitucion() {
        return institucion;
    }

    public void setInstitucion(InstitucionEducativa institucion) {
        this.institucion = institucion;
    }

    public String getCargoOficial() {
        return cargoOficial;
    }

    public void setCargoOficial(String cargoOficial) {
        this.cargoOficial = cargoOficial;
    }

    public String getNumeroResolucion() {
        return numeroResolucion;
    }

    public void setNumeroResolucion(String numeroResolucion) {
        this.numeroResolucion = numeroResolucion;
    }

    /**
     * Verifica si el rector tiene una institución asignada.
     * @return true si tiene institución, false en caso contrario
     */
    public boolean tieneInstitucionAsignada() {
        return institucion != null && institucion.isActiva();
    }
}
