package edu.fiuba.algo3.modelo.obtenedoresDePistas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Aeropuerto;

public class ObtenedorDePistasMediasTest {

    ObtenedorDePistasMedias obtenedor = new ObtenedorDePistasMedias();

    @Test
    public void test01ObtengoUnaPista() {

        Aeropuerto aeropuerto = new Aeropuerto();
        Mision mision = mock(Mision.class);
        Ciudad ciudad = mock(Ciudad.class);

        when (mision.obtenerProximaCiudad()).thenReturn(ciudad);
        when (mision.obtenerDescripcionSospechoso()).thenReturn("pelo rojo");
        when(ciudad.pistaMediaAeropuerto()).thenReturn("El lenguaje del pais es inglés");

        assertEquals(obtenedor.pedirPista(aeropuerto, mision), "El lenguaje del pais es inglés, pelo rojo");
    }
}
