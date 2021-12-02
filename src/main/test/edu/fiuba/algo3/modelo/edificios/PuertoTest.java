package edu.fiuba.algo3.modelo.edificios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Ciudad;

public class PuertoTest {
    Puerto Puerto = new Puerto();
    
    @Test
    public void test01ObtengoUnaPistaFacilYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaFacilAeropuerto()).thenReturn("La bandera es de color azul");

        assertEquals(Puerto.obtenerPistaFacil(ciudad), "La bandera es de color azul");
        assertEquals(Puerto.calcularTiempo(), 1);
    }

    @Test
    public void test02ObtengoUnaPistaMediaYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaMediaAeropuerto()).thenReturn("El lenguaje del pais es español");

        assertEquals(Puerto.obtenerPistaMedia(ciudad), "El lenguaje del pais es español");
        assertEquals(Puerto.calcularTiempo(), 1);

        assertEquals(Puerto.obtenerPistaMedia(ciudad), "El lenguaje del pais es español");
        assertEquals(Puerto.calcularTiempo(), 2);
    }

    @Test
    public void test03ObtengoUnaPistaDificilYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaDificilAeropuerto()).thenReturn("Los landmarks son Great Sandy Desert, Opera House, Outback");

        assertEquals(Puerto.obtenerPistaDificil(ciudad), "Los landmarks son Great Sandy Desert, Opera House, Outback");
        assertEquals(Puerto.calcularTiempo(), 1);

        assertEquals(Puerto.obtenerPistaDificil(ciudad), "Los landmarks son Great Sandy Desert, Opera House, Outback");
        assertEquals(Puerto.calcularTiempo(), 2);
    }

}