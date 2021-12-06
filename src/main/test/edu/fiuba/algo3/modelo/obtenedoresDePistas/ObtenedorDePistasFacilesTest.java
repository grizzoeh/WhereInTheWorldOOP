package edu.fiuba.algo3.modelo.obtenedoresDePistas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Aeropuerto;

public class ObtenedorDePistasFacilesTest {

    ObtenedorDePistasFaciles obtenedor = new ObtenedorDePistasFaciles();

    @Test
    public void test01ObtengoUnaPista() {

        Aeropuerto aeropuerto = new Aeropuerto();
        Mision mision = mock(Mision.class);
        Ciudad ciudad = mock(Ciudad.class);

        when (mision.obtenerProximaCiudad()).thenReturn(ciudad);
        when (mision.obtenerDescripcionSospechoso()).thenReturn("pelo rojo");
        when(ciudad.pistaFacilAeropuerto()).thenReturn("La bandera es de color azul");

        assertEquals(obtenedor.pedirPista(aeropuerto, mision), "La bandera es de color azul, pelo rojo");
    }
}
