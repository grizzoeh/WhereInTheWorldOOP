package edu.fiuba.algo3.modelo.Lectores;

import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorLadrones;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorLadronesJSON;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class LectorLadronesTest {

    @Test
    public void test01Pruebas() {
        LectorLadrones lector = new LectorLadronesJSON();
        ArrayList<Ladron> ladrones = lector.cargarLadrones();
        Ladron ladron = ladrones.get(0);
        assertTrue(ladron.coincideNombre("Nick Brunch"));
    }

}