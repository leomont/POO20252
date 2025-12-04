package juridico.domain;

/**
 * Enumeración que define los tipos de membresía disponibles en el sistema.
 * Cada tipo incluye precio y características específicas.
 */
public enum TipoMembresia {
    BASICA("Básica", 0.0, "Acceso limitado a consultas básicas", 10),
    ESTANDAR("Estándar", 50.0, "Acceso a consultas y documentos básicos", 50),
    PREMIUM("Premium", 150.0, "Acceso completo con IA y documentos avanzados", -1),
    INSTITUCIONAL("Institucional", 500.0, "Acceso completo para instituciones educativas", -1);

    private final String nombre;
    private final double precioMensual;
    private final String descripcion;
    private final int limiteConsultasMensuales; // -1 significa ilimitado

    TipoMembresia(String nombre, double precioMensual, String descripcion, int limiteConsultasMensuales) {
        this.nombre = nombre;
        this.precioMensual = precioMensual;
        this.descripcion = descripcion;
        this.limiteConsultasMensuales = limiteConsultasMensuales;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioMensual() {
        return precioMensual;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getLimiteConsultasMensuales() {
        return limiteConsultasMensuales;
    }

    public boolean esIlimitada() {
        return limiteConsultasMensuales == -1;
    }
}
