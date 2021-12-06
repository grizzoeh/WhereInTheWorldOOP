package edu.fiuba.algo3.modelo.edificios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BibliotecaDespisteTest {
    BibliotecaDespiste biblioteca = new BibliotecaDespiste();
    
    @Test
    public void test01ObtengoUnaPistaFacilYLosIngresosAumentan() {

        assertEquals(biblioteca.obtenerPistaFacil(null), "No paso el sospechoso por aca");
        assertEquals(biblioteca.calcularTiempo(), 1);
    }

    @Test
    public void test02ObtengoUnaPistaMediaYLosIngresosAumentan() {

        assertEquals(biblioteca.obtenerPistaMedia(null), "No paso el sospechoso por aca");
        assertEquals(biblioteca.calcularTiempo(), 1);

        assertEquals(biblioteca.obtenerPistaMedia(null), "No paso el sospechoso por aca");
        assertEquals(biblioteca.calcularTiempo(), 2);
    }

    @Test
    public void test03ObtengoUnaPistaDificilYLosIngresosAumentan() {

        assertEquals(biblioteca.obtenerPistaDificil(null), "No paso el sospechoso por aca");
        assertEquals(biblioteca.calcularTiempo(), 1);

        assertEquals(biblioteca.obtenerPistaDificil(null), "No paso el sospechoso por aca");
        assertEquals(biblioteca.calcularTiempo(), 2);
    }

}
