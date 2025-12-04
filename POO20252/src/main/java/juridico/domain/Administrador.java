package juridico.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un Administrador del sistema jurídico.
 * Los administradores tienen permisos especiales para gestión del sistema.
 */
public class Administrador extends Usuario {

    private NivelAcceso nivelAcceso;
    private List<String> permisosEspeciales;
    private boolean puedeGestionarUsuarios;
    private boolean puedeGestionarContenido;
    private boolean puedeGestionarMembresias;

    public Administrador(Long id, String nombres, String apellidos, String email, String telefono, 
                         String username, String password, NivelAcceso nivelAcceso) {
        super(id, nombres, apellidos, email, telefono, username, password);
        this.nivelAcceso = nivelAcceso;
        this.permisosEspeciales = new ArrayList<>();
        configurarPermisosPorNivel();
    }

    public NivelAcceso getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(NivelAcceso nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
        configurarPermisosPorNivel();
    }

    public List<String> getPermisosEspeciales() {
        return permisosEspeciales;
    }

    public void setPermisosEspeciales(List<String> permisosEspeciales) {
        this.permisosEspeciales = permisosEspeciales;
    }

    public boolean isPuedeGestionarUsuarios() {
        return puedeGestionarUsuarios;
    }

    public void setPuedeGestionarUsuarios(boolean puedeGestionarUsuarios) {
        this.puedeGestionarUsuarios = puedeGestionarUsuarios;
    }

    public boolean isPuedeGestionarContenido() {
        return puedeGestionarContenido;
    }

    public void setPuedeGestionarContenido(boolean puedeGestionarContenido) {
        this.puedeGestionarContenido = puedeGestionarContenido;
    }

    public boolean isPuedeGestionarMembresias() {
        return puedeGestionarMembresias;
    }

    public void setPuedeGestionarMembresias(boolean puedeGestionarMembresias) {
        this.puedeGestionarMembresias = puedeGestionarMembresias;
    }

    /**
     * Configura los permisos según el nivel de acceso del administrador.
     */
    private void configurarPermisosPorNivel() {
        switch (nivelAcceso) {
            case SUPER_ADMIN:
                puedeGestionarUsuarios = true;
                puedeGestionarContenido = true;
                puedeGestionarMembresias = true;
                break;
            case ADMIN:
                puedeGestionarUsuarios = true;
                puedeGestionarContenido = true;
                puedeGestionarMembresias = false;
                break;
            case MODERADOR:
                puedeGestionarUsuarios = false;
                puedeGestionarContenido = true;
                puedeGestionarMembresias = false;
                break;
        }
    }

    /**
     * Agrega un permiso especial al administrador.
     * @param permiso Permiso a agregar
     */
    public void agregarPermiso(String permiso) {
        if (!permisosEspeciales.contains(permiso)) {
            permisosEspeciales.add(permiso);
        }
    }

    /**
     * Verifica si el administrador tiene un permiso específico.
     * @param permiso Permiso a verificar
     * @return true si tiene el permiso, false en caso contrario
     */
    public boolean tienePermiso(String permiso) {
        return permisosEspeciales.contains(permiso);
    }

    /**
     * Enumeración de niveles de acceso para administradores
     */
    public enum NivelAcceso {
        SUPER_ADMIN,
        ADMIN,
        MODERADOR
    }
}
