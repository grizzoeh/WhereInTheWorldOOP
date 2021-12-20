package edu.fiuba.algo3.modelo.lectoresDeArchivos;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.excepciones.LadronNoEncontradoException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class LectorMisionesJSON implements LectorMisiones {
    private ArrayList<String> rutas = new ArrayList<String>(Arrays.asList(
            "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelomisionesComunes.json",
            "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelomisionesValiosas.json",
            "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelomisionesMuyValiosas.json"
    ));
    private int index = 0;
    private int max_index = 2;

    public void ascender(){
        if (this.index < max_index) {
            this.index++;
        }
    }

    public Mision cargarMisiones(LectorCiudades lectorCiudades, RegistroLadrones registroLadrones) {
        JSONParser parser = new JSONParser();
        Mision mision = null;
        try {
            JSONArray JSONMisiones = (JSONArray) parser.parse(new FileReader(this.rutas.get(this.index)));
            int largo = JSONMisiones.size();
            int randomNum = ThreadLocalRandom.current().nextInt(0, largo);
            JSONObject JSONMision = (JSONObject) JSONMisiones.get(randomNum);

            String nombreLadron = (String) JSONMision.get("Ladron");
            ArrayList<String> nombresRecorridoLadron = (ArrayList<String>) JSONMision.get("Recorrido_Ladron");
            ArrayList<String> nombresCiudadesDespiste = (ArrayList<String>) JSONMision.get("Ciudades_Despiste");
            String objetoRobado = (String) JSONMision.get("Objeto_Robado");

            Ladron ladron = registroLadrones.encontrarLadronConNombre(nombreLadron);
            ArrayList<Ciudad> recorridoLadron = lectorCiudades.cargarCiudades(nombresRecorridoLadron,false);
            ArrayList<Ciudad> ciudadesDespiste = lectorCiudades.cargarCiudades(nombresCiudadesDespiste,true);

            mision = new Mision(objetoRobado, ladron, recorridoLadron, ciudadesDespiste);


        }
        catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo");
        }
        catch (IOException e) {
            System.out.println("Entrada y salida interrumpida");
        }
        catch (ParseException e) {
            System.out.println("Error de parseo en el archivo");
        }
        catch (LadronNoEncontradoException e) {
            System.out.println("El ladron de la mision no estaba en el archivo de ladrones");
        }
        catch (IllegalArgumentException e) {
            System.out.println("El archivo de misiones no puede tener solo 1 mision");
        }

        return mision;

    }


}