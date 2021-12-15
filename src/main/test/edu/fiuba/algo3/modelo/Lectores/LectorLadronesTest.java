package edu.fiuba.algo3.modelo.Lectores;

import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorLadrones;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class LectorLadronesTest {

    @Test
    public void test01Pruebas() {
        LectorLadrones lector = new LectorLadrones();
        ArrayList<Ladron> ladrones = lector.cargarLadrones("src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelosladronespruebas.json");
        Ladron ladron = ladrones.get(0);
        assertTrue(ladron.coincideNombre("Nick Brunch"));
    }

}