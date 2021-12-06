package edu.fiuba.algo3.modelo.edificios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Ciudad;

public class BibliotecaTest {
    Biblioteca biblioteca = new Biblioteca();
    
    @Test
    public void test01ObtengoUnaPistaFacilYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaFacilBiblioteca()).thenReturn("La gente es inca");

        assertEquals(biblioteca.obtenerPistaFacil(ciudad), "La gente es inca");
        assertEquals(biblioteca.calcularTiempo(), 1);
    }

    @Test
    public void test02ObtengoUnaPistaMediaYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaMediaBiblioteca()).thenReturn("La religion principal es budismo");

        assertEquals(biblioteca.obtenerPistaMedia(ciudad), "La religion principal es budismo");
        assertEquals(biblioteca.calcularTiempo(), 1);

        assertEquals(biblioteca.obtenerPistaMedia(ciudad), "La religion principal es budismo");
        assertEquals(biblioteca.calcularTiempo(), 2);
    }

    @Test
    public void test03ObtengoUnaPistaDificilYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaDificilBiblioteca()).thenReturn("El lider es el zar");

        assertEquals(biblioteca.obtenerPistaDificil(ciudad), "El lider es el zar");
        assertEquals(biblioteca.calcularTiempo(), 1);

        assertEquals(biblioteca.obtenerPistaDificil(ciudad), "El lider es el zar");
        assertEquals(biblioteca.calcularTiempo(), 2);
    }

}
