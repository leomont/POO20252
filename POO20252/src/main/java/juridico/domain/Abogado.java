package juridico.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Abogado como tipo especializado de usuario.
 * Los abogados pueden realizar revisiones humanas de consultas y documentos.
 */
public class Abogado extends Usuario {

    private String numeroTarjetaProfesional;
    private String especializacion;
    private List<String> areasExperticia;
    private boolean disponibleParaRevisiones;
    private int revisionesCompletadas;

    public Abogado(Long id, String nombres, String apellidos, String email, String telefono, 
                   String username, String password, String numeroTarjetaProfesional) {
        super(id, nombres, apellidos, email, telefono, username, password);
        this.numeroTarjetaProfesional = numeroTarjetaProfesional;
        this.areasExperticia = new ArrayList<>();
        this.disponibleParaRevisiones = true;
        this.revisionesCompletadas = 0;
    }

    public String getNumeroTarjetaProfesional() {
        return numeroTarjetaProfesional;
    }

    public void setNumeroTarjetaProfesional(String numeroTarjetaProfesional) {
        this.numeroTarjetaProfesional = numeroTarjetaProfesional;
    }

    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }

    public List<String> getAreasExperticia() {
        return areasExperticia;
    }

    public void setAreasExperticia(List<String> areasExperticia) {
        this.areasExperticia = areasExperticia;
    }

    public boolean isDisponibleParaRevisiones() {
        return disponibleParaRevisiones;
    }

    public void setDisponibleParaRevisiones(boolean disponibleParaRevisiones) {
        this.disponibleParaRevisiones = disponibleParaRevisiones;
    }

    public int getRevisionesCompletadas() {
        return revisionesCompletadas;
    }

    public void setRevisionesCompletadas(int revisionesCompletadas) {
        this.revisionesCompletadas = revisionesCompletadas;
    }

    /**
     * Agrega un área de experticia al abogado.
     * @param area Área de experticia a agregar
     */
    public void agregarAreaExperticia(String area) {
        if (!areasExperticia.contains(area)) {
            areasExperticia.add(area);
        }
    }

    /**
     * Incrementa el contador de revisiones completadas.
     */
    public void completarRevision() {
        revisionesCompletadas++;
    }

    /**
     * Verifica si el abogado tiene experticia en un área específica.
     * @param area Área a verificar
     * @return true si tiene experticia, false en caso contrario
     */
    public boolean tieneExperticia(String area) {
        return areasExperticia.contains(area);
    }
}
