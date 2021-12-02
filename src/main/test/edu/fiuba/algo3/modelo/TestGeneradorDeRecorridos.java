package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGeneradorDeRecorridos {

    private GeneradorRercorridos generadorRecorrido = new GeneradorRercorridos();

    @Test
    public void test01ElGeneradorDeRecorridosPuedeGenerarUnrecorridoDeCincoCiudades() throws IOException {
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = this.generadorRecorrido.generarRecorridoAleatorio(5);
        assertEquals(5,ciudades.size());

    }

    @Test
    public void test01ElGeneradorDeRecorridosPuedeGenerarUnrecorridoDeSeisCiudades() throws IOException {
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = this.generadorRecorrido.generarRecorridoAleatorio(6);
        assertEquals(6,ciudades.size());
    }

    @Test
    public void test01ElGeneradorDeRecorridosPuedeGenerarUnrecorridoDeSieteCiudades() throws IOException {
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = this.generadorRecorrido.generarRecorridoAleatorio(7);
        assertEquals(7,ciudades.size());
    }
}
