package edu.fiuba.algo3.modelo.edificios;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Ciudad;

public class BancoTest {
    Banco banco = new Banco();
    
    @Test
    public void test01ObtengoUnaPistaFacilYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaFacilBanco()).thenReturn("La moneda es el dolar");

        assertEquals(banco.obtenerPistaFacil(ciudad), "La moneda es el dolar");
        assertEquals(banco.calcularTiempo(), 1);
    }

    @Test
    public void test02ObtengoUnaPistaMediaYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaMediaBanco()).thenReturn("Las industrias son textiles");

        assertEquals(banco.obtenerPistaMedia(ciudad), "Las industrias son textiles");
        assertEquals(banco.calcularTiempo(), 1);

        assertEquals(banco.obtenerPistaMedia(ciudad), "Las industrias son textiles");
        assertEquals(banco.calcularTiempo(), 2);
    }

    @Test
    public void test03ObtengoUnaPistaDificilYLosIngresosAumentan() {
        Ciudad ciudad = mock(Ciudad.class);
        when(ciudad.pistaDificilBanco()).thenReturn("Los animales son pumas");

        assertEquals(banco.obtenerPistaDificil(ciudad), "Los animales son pumas");
        assertEquals(banco.calcularTiempo(), 1);

        assertEquals(banco.obtenerPistaDificil(ciudad), "Los animales son pumas");
        assertEquals(banco.calcularTiempo(), 2);
    }

}
