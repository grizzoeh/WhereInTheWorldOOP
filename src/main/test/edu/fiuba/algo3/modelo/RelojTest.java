package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RelojTest {
    
    Reloj reloj = new Reloj();
    
    @Test
    public void test01AlInicializarUnRelojQuedaTiempo(){

        assertTrue(reloj.quedaTiempo());
    }

    @Test
    public void test02Pasan2HorasYSigueQuedandoTiempo(){

        reloj.pasarHoras(2);
        assertTrue(reloj.quedaTiempo());
    }

    @Test
    public void test03Pasan200HorasYNoQuedaTiempo(){

        reloj.pasarHoras(200);
        assertFalse(reloj.quedaTiempo());
    }

    @Test
    public void test04Pasan2HorasyEsLunes9hs(){

        reloj.pasarHoras(2);
        assertTrue(reloj.aString().equals("Lunes 9 hs00"));
        assertTrue(reloj.quedaTiempo());
    }
    
    @Test
    public void test05Pasan24HorasYEsMartes15hs(){

        assertTrue(reloj.aString().equals("Lunes 7 hs00"));
        reloj.pasarHoras(24);
        assertTrue(reloj.aString().equals("Martes 15 hs00"));
        assertTrue(reloj.quedaTiempo());
    }
}
