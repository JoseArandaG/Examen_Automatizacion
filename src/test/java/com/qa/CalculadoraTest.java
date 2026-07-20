package com.qa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    private final Calculadora calculadora = new Calculadora();

    @Test
    void testSumar() {
        assertEquals(5, calculadora.sumar(2, 3));
    }

    @Test
    void testRestar() {
        assertEquals(1, calculadora.restar(3, 2));
    }

    @Test
    void testMultiplicar() {
        assertEquals(6, calculadora.multiplicar(2, 3));
    }

    @Test
    void testDividir() {
        assertEquals(2.5, calculadora.dividir(5, 2));
    }

    @Test
    void testDividirPorCero() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.dividir(5, 0));
    }
}
