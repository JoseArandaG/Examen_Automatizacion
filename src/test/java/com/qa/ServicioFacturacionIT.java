package com.qa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioFacturacionIT {
    @Test void testCalcularTotalConIva() {
        ServicioFacturacion servicio = new ServicioFacturacion(new Calculadora());
        assertEquals(2380.0, servicio.calcularTotalConIva(1000, 2), 0.001);
    }
    @Test void testTotalCantidadUno() {
        ServicioFacturacion servicio = new ServicioFacturacion(new Calculadora());
        assertEquals(1190.0, servicio.calcularTotalConIva(1000, 1), 0.001);
    }
}