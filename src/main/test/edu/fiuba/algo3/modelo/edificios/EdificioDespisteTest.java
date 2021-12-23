package edu.fiuba.algo3.modelo.edificios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EdificioDespisteTest {
    EdificioDespiste aeropuerto = new EdificioDespiste("Aeropuerto");
    
    @Test
    public void test01ObtengoUnaPistaFacilYLosIngresosAumentan() {

        assertEquals(aeropuerto.obtenerPistaFacil(null), "!!!");
        assertEquals(aeropuerto.calcularTiempo(), 1);
    }

    @Test
    public void test02ObtengoUnaPistaMediaYLosIngresosAumentan() {

        assertEquals(aeropuerto.obtenerPistaMedia(null), "!!!");
        assertEquals(aeropuerto.calcularTiempo(), 1);

        assertEquals(aeropuerto.obtenerPistaMedia(null), "!!!");
        assertEquals(aeropuerto.calcularTiempo(), 2);
    }

    @Test
    public void test03ObtengoUnaPistaDificilYLosIngresosAumentan() {

        assertEquals(aeropuerto.obtenerPistaDificil(null), "!!!");
        assertEquals(aeropuerto.calcularTiempo(), 1);

        assertEquals(aeropuerto.obtenerPistaDificil(null), "!!!");
        assertEquals(aeropuerto.calcularTiempo(), 2);
    }

}
