// java
package Nomina;

public class CommissionEmployee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;      // ventas brutas por semana
    private double commissionRate;  // porcentaje (0 < rate < 1)

    public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                              double grossSales, double commissionRate) {
        if (firstName == null || lastName == null || socialSecurityNumber == null) {
            throw new IllegalArgumentException("Nombre, apellido y SSN no pueden ser null");
        }
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) throw new IllegalArgumentException("firstName no puede ser null");
        this.firstName = firstName;
    }

    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) {
        if (lastName == null) throw new IllegalArgumentException("lastName no puede ser null");
        this.lastName = lastName;
    }

    public String getLastName() { return lastName; }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        if (socialSecurityNumber == null) throw new IllegalArgumentException("SSN no puede ser null");
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getSocialSecurityNumber() { return socialSecurityNumber; }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) throw new IllegalArgumentException("Gross sales must be >= 0.0");
        this.grossSales = grossSales;
    }

    public double getGrossSales() { return grossSales; }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() { return commissionRate; }

    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.4f",
                "commission employee", getFirstName(), getLastName(),
                "SSN", getSocialSecurityNumber(),
                "gross sales", getGrossSales(),
                "commission rate", getCommissionRate());
    }
}
