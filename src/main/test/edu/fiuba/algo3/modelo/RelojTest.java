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
    public void test03Pasan154HorasYNoQuedaTiempo(){

        reloj.pasarHoras(154);
        assertFalse(reloj.quedaTiempo());
    }

    @Test
    public void test04Pasan2HorasyEsLunes9hs(){

        reloj.pasarHoras(2);
        assertTrue(reloj.aString().equals("Lunes 9 hs"));
        assertTrue(reloj.quedaTiempo());
    }
    
    @Test
    public void test05Pasan24HorasYEsMartes7hs(){

        assertTrue(reloj.aString().equals("Lunes 7 hs"));
        reloj.pasarHoras(24);
        assertTrue(reloj.aString().equals("Martes 7 hs"));
        assertTrue(reloj.quedaTiempo());
    }

    @Test
    public void test06Pasan48HorasYEsMiercoles7hs(){

        assertTrue(reloj.aString().equals("Lunes 7 hs"));
        reloj.pasarHoras(48);
        assertTrue(reloj.aString().equals("Miércoles 7 hs"));
        assertTrue(reloj.quedaTiempo());
    }
    
    @Test
    public void test07Pasan72HorasYEsJueves7hs(){

        assertTrue(reloj.aString().equals("Lunes 7 hs"));
        reloj.pasarHoras(72);
        assertTrue(reloj.aString().equals("Jueves 7 hs"));
        assertTrue(reloj.quedaTiempo());
    }
    
    @Test
    public void test08Pasan96HorasYEsViernes7hs(){

        assertTrue(reloj.aString().equals("Lunes 7 hs"));
        reloj.pasarHoras(96);
        assertTrue(reloj.aString().equals("Viernes 7 hs"));
        assertTrue(reloj.quedaTiempo());
    }
    
    @Test
    public void test09Pasan120HorasYEsSabado7hs(){

        assertTrue(reloj.aString().equals("Lunes 7 hs"));
        reloj.pasarHoras(120);
        assertTrue(reloj.aString().equals("Sábado 7 hs"));
        assertTrue(reloj.quedaTiempo());
    }

    @Test
    public void test10Pasan144HorasYEsDomingo7hs(){

        assertTrue(reloj.aString().equals("Lunes 7 hs"));
        reloj.pasarHoras(144);
        assertTrue(reloj.aString().equals("Domingo 7 hs"));
        assertTrue(reloj.quedaTiempo());
        
    }
}
