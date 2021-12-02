package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGeneradorDeRecorridos {

    private GeneradorRercorridos generadorRecorrido = new GeneradorRercorridos();

    @Test
    public void test01ElGeneradorDeRecorridosPuedeGenerarUnrecorridoDeCincoCiudadesEmpezandoEnMontreal() throws IOException {
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = this.generadorRecorrido.generarRecorridoAleatorio(4, "Montreal");
        assertEquals(5,ciudades.size());
    }

    @Test
    public void test01ElGeneradorDeRecorridosPuedeGenerarUnrecorridoDeSeisCiudadesEmpezandoEnBuenosAires() throws IOException {
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = this.generadorRecorrido.generarRecorridoAleatorio(5, "Buenos Aires");
        assertEquals(6,ciudades.size());
    }

    @Test
    public void test01ElGeneradorDeRecorridosPuedeGenerarUnrecorridoDeSieteCiudadesEmpezandoEnCiudadDeMexico() throws IOException {
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();
        ciudades = this.generadorRecorrido.generarRecorridoAleatorio(6, "Ciudad De Mexico");
        assertEquals(7,ciudades.size());
    }
}
