package edu.fiuba.algo3.modelo.edificios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PuertoDespisteTest {
    PuertoDespiste puerto = new PuertoDespiste();
    
    @Test
    public void test01ObtengoUnaPistaFacilYLosIngresosAumentan() {

        assertEquals(puerto.obtenerPistaFacil(null), "No paso el sospechoso por aca");
        assertEquals(puerto.calcularTiempo(), 1);
    }

    @Test
    public void test02ObtengoUnaPistaMediaYLosIngresosAumentan() {

        assertEquals(puerto.obtenerPistaMedia(null), "No paso el sospechoso por aca");
        assertEquals(puerto.calcularTiempo(), 1);

        assertEquals(puerto.obtenerPistaMedia(null), "No paso el sospechoso por aca");
        assertEquals(puerto.calcularTiempo(), 2);
    }

    @Test
    public void test03ObtengoUnaPistaDificilYLosIngresosAumentan() {

        assertEquals(puerto.obtenerPistaDificil(null), "No paso el sospechoso por aca");
        assertEquals(puerto.calcularTiempo(), 1);

        assertEquals(puerto.obtenerPistaDificil(null), "No paso el sospechoso por aca");
        assertEquals(puerto.calcularTiempo(), 2);
    }

}
