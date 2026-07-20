package com.qa;

public class ServicioFacturacion {

    private final Calculadora calculadora;

    public ServicioFacturacion(Calculadora calculadora) {
        this.calculadora = calculadora;
    }

    public double calcularTotalConIva(int precioUnitario, int cantidad) {
        int neto = calculadora.multiplicar(precioUnitario, cantidad);
        double iva = neto * 0.19;
        return neto + iva;
    }
}