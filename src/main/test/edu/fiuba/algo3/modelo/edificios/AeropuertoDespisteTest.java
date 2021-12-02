package edu.fiuba.algo3.modelo.edificios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AeropuertoDespisteTest {
    AeropuertoDespiste aeropuerto = new AeropuertoDespiste();
    
    @Test
    public void test01ObtengoUnaPistaFacilYLosIngresosAumentan() {

        assertEquals(aeropuerto.obtenerPistaFacil(null), "No paso el sospechoso por aca");
        assertEquals(aeropuerto.calcularTiempo(), 1);
    }

    @Test
    public void test02ObtengoUnaPistaMediaYLosIngresosAumentan() {

        assertEquals(aeropuerto.obtenerPistaMedia(null), "No paso el sospechoso por aca");
        assertEquals(aeropuerto.calcularTiempo(), 1);

        assertEquals(aeropuerto.obtenerPistaMedia(null), "No paso el sospechoso por aca");
        assertEquals(aeropuerto.calcularTiempo(), 2);
    }

    @Test
    public void test03ObtengoUnaPistaDificilYLosIngresosAumentan() {

        assertEquals(aeropuerto.obtenerPistaDificil(null), "No paso el sospechoso por aca");
        assertEquals(aeropuerto.calcularTiempo(), 1);

        assertEquals(aeropuerto.obtenerPistaDificil(null), "No paso el sospechoso por aca");
        assertEquals(aeropuerto.calcularTiempo(), 2);
    }

}
