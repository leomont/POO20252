package Concesionario;

public class carro {
    //modificador de acceso + tipo de dato + nombre de atributo en camel case
    public String color;
    public String marca;
    public String modelo;
    public String kilometraje;
    public String chasis;
    public String placa;
    public String año;

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getKilometraje() {
        return kilometraje;
    }

    public String getChasis() {
        return chasis;
    }

    public String getPlaca() {
        return placa;
    }

    public String getAño() {
        return año;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public carro(String color, String placa) {
        this.color = color;
        this.placa = placa;
    }

    public carro(String color, String marca, String modelo, String kilometraje, String chasis, String placa, String año) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.kilometraje = kilometraje;
        this.chasis = chasis;
        this.placa = placa;
        this.año = año;
    }





}
