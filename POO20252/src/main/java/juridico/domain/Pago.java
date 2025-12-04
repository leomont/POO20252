package juridico.domain;

import java.time.LocalDateTime;

/**
 * Clase que representa un pago realizado por una membresía.
 * Incluye información del monto, método de pago y estado de la transacción.
 */
public class Pago {

    private Long id;
    private Membresia membresia;
    private double monto;
    private LocalDateTime fechaPago;
    private MetodoPago metodoPago;
    private EstadoPago estado;
    private String numeroTransaccion;
    private String descripcion;

    public Pago() {
        this.fechaPago = LocalDateTime.now();
        this.estado = EstadoPago.PENDIENTE;
    }

    public Pago(Long id, Membresia membresia, double monto, MetodoPago metodoPago, String numeroTransaccion) {
        this.id = id;
        this.membresia = membresia;
        this.monto = monto;
        this.fechaPago = LocalDateTime.now();
        this.metodoPago = metodoPago;
        this.estado = EstadoPago.PENDIENTE;
        this.numeroTransaccion = numeroTransaccion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public EstadoPago getEstado() {
        return estado;
    }

    public void setEstado(EstadoPago estado) {
        this.estado = estado;
    }

    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Marca el pago como completado.
     */
    public void confirmar() {
        this.estado = EstadoPago.COMPLETADO;
    }

    /**
     * Marca el pago como rechazado.
     * @param motivo Motivo del rechazo
     */
    public void rechazar(String motivo) {
        this.estado = EstadoPago.RECHAZADO;
        this.descripcion = motivo;
    }

    /**
     * Enumeración de métodos de pago disponibles
     */
    public enum MetodoPago {
        TARJETA_CREDITO,
        TARJETA_DEBITO,
        TRANSFERENCIA_BANCARIA,
        EFECTIVO,
        PAYPAL,
        OTRO
    }

    /**
     * Enumeración de estados de pago
     */
    public enum EstadoPago {
        PENDIENTE,
        COMPLETADO,
        RECHAZADO,
        CANCELADO,
        REEMBOLSADO
    }
}
