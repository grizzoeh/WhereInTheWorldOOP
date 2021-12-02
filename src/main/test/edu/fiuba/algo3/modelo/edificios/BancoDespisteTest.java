package edu.fiuba.algo3.modelo.edificios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BancoDespisteTest {
    BancoDespiste banco = new BancoDespiste();
    
    @Test
    public void test01ObtengoUnaPistaFacilYLosIngresosAumentan() {

        assertEquals(banco.obtenerPistaFacil(null), "No paso el sospechoso por aca");
        assertEquals(banco.calcularTiempo(), 1);
    }

    @Test
    public void test02ObtengoUnaPistaMediaYLosIngresosAumentan() {

        assertEquals(banco.obtenerPistaMedia(null), "No paso el sospechoso por aca");
        assertEquals(banco.calcularTiempo(), 1);

        assertEquals(banco.obtenerPistaMedia(null), "No paso el sospechoso por aca");
        assertEquals(banco.calcularTiempo(), 2);
    }

    @Test
    public void test03ObtengoUnaPistaDificilYLosIngresosAumentan() {

        assertEquals(banco.obtenerPistaDificil(null), "No paso el sospechoso por aca");
        assertEquals(banco.calcularTiempo(), 1);

        assertEquals(banco.obtenerPistaDificil(null), "No paso el sospechoso por aca");
        assertEquals(banco.calcularTiempo(), 2);
    }

}
