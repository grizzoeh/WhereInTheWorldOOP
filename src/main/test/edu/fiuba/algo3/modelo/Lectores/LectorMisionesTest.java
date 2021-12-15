package edu.fiuba.algo3.modelo.Lectores;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.RegistroLadrones;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorCiudades;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorLadrones;
import edu.fiuba.algo3.modelo.lectoresDeArchivos.LectorMisiones;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorMisionesTest {

    @Test
    public void test01secargaunamision() {
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        Ladron ladron = new Ladron("Nick Brunch", "Masculino", "Escalada De Montaña", "Negro", "Anillo", "Motocicleta", new ArrayList<String>(Arrays.asList("Lo vi bajarse de una moto")));
        ladrones.add(ladron);
        RegistroLadrones registro = new RegistroLadrones(ladrones);

        String rutaMisiones = "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelomisionesComunespruebas.json";
        String rutaCiudades = "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelociudades.json";

        LectorMisiones lector = new LectorMisiones();

        Mision mision = lector.cargarMisiones(rutaMisiones, rutaCiudades, registro);

        assertEquals(mision.obtenerProximaCiudad(),mision.ciudadesDisponibles().get(0));
    }
}

