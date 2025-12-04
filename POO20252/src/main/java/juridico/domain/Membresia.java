package juridico.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa la membresía de un usuario en el sistema.
 * Gestiona el tipo de membresía, estado de pago y validez.
 */
public class Membresia {

    private Long id;
    private TipoMembresia tipoMembresia;
    private Usuario usuario;
    private InstitucionEducativa institucion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private boolean activa;
    private List<Pago> pagos;
    private int consultasRealizadasMes;

    public Membresia() {
        this.pagos = new ArrayList<>();
        this.consultasRealizadasMes = 0;
    }

    public Membresia(Long id, TipoMembresia tipoMembresia, Usuario usuario, 
                     InstitucionEducativa institucion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.id = id;
        this.tipoMembresia = tipoMembresia;
        this.usuario = usuario;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.activa = true;
        this.pagos = new ArrayList<>();
        this.consultasRealizadasMes = 0;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMembresia getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(TipoMembresia tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public InstitucionEducativa getInstitucion() {
        return institucion;
    }

    public void setInstitucion(InstitucionEducativa institucion) {
        this.institucion = institucion;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public int getConsultasRealizadasMes() {
        return consultasRealizadasMes;
    }

    public void setConsultasRealizadasMes(int consultasRealizadasMes) {
        this.consultasRealizadasMes = consultasRealizadasMes;
    }

    /**
     * Valida si la membresía está vigente y activa.
     * @return true si la membresía es válida, false en caso contrario
     */
    public boolean esValida() {
        LocalDateTime ahora = LocalDateTime.now();
        return activa && 
               fechaInicio != null && 
               fechaFin != null &&
               !ahora.isBefore(fechaInicio) && 
               !ahora.isAfter(fechaFin);
    }

    /**
     * Verifica si el usuario puede realizar más consultas según su límite mensual.
     * @return true si puede realizar más consultas, false si alcanzó el límite
     */
    public boolean puedeRealizarConsulta() {
        if (!esValida()) {
            return false;
        }
        
        if (tipoMembresia.esIlimitada()) {
            return true;
        }
        
        return consultasRealizadasMes < tipoMembresia.getLimiteConsultasMensuales();
    }

    /**
     * Incrementa el contador de consultas realizadas en el mes.
     */
    public void incrementarConsultas() {
        consultasRealizadasMes++;
    }

    /**
     * Reinicia el contador de consultas mensuales.
     */
    public void reiniciarContadorMensual() {
        consultasRealizadasMes = 0;
    }

    /**
     * Agrega un pago a la membresía.
     * @param pago Pago realizado
     */
    public void agregarPago(Pago pago) {
        if (!pagos.contains(pago)) {
            pagos.add(pago);
        }
    }

    /**
     * Renueva la membresía extendiendo la fecha de fin.
     * @param meses Cantidad de meses a renovar
     */
    public void renovar(int meses) {
        if (fechaFin == null) {
            fechaFin = LocalDateTime.now().plusMonths(meses);
        } else {
            fechaFin = fechaFin.plusMonths(meses);
        }
        activa = true;
    }
}
