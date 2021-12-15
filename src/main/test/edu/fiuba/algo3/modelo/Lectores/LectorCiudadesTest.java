package edu.fiuba.algo3.modelo.Lectores;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorCiudades;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class LectorCiudadesTest {
    @Test
    public void test01secargaunaciudad() {
        ArrayList<String> nombresCiudades = new ArrayList<String>();
        nombresCiudades.add("Atenas");
        String ruta = "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelociudades.json";
        LectorCiudades lector = new LectorCiudades();

        ArrayList<Ciudad> ciudades = lector.cargarCiudades(ruta, nombresCiudades, false);

        assertEquals("Atenas", ciudades.get(0).obtenerNombre());
    }
}
