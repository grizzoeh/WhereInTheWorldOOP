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
import java.util.concurrent.ThreadLocalRandom;


public class LectorMisiones {

    public Mision cargarMisiones(String rutaMisiones, String rutaCiudades, RegistroLadrones registroLadrones) {
        JSONParser parser = new JSONParser();
        Mision mision = null;
        try {
            JSONArray JSONMisiones = (JSONArray) parser.parse(new FileReader(rutaMisiones));
            int largo = JSONMisiones.size();
            int randomNum = ThreadLocalRandom.current().nextInt(0, largo-1);
            JSONObject JSONMision = (JSONObject) JSONMisiones.get(randomNum);

            String nombreLadron = (String) JSONMision.get("Ladron");
            ArrayList<String> nombresRecorridoLadron = (ArrayList<String>) JSONMision.get("Recorrido_Ladron");
            ArrayList<String> nombresCiudadesDespiste = (ArrayList<String>) JSONMision.get("Ciudades_Despiste");
            String objetoRobado = (String) JSONMision.get("Objeto_Robado");

            Ladron ladron = registroLadrones.encontrarLadronConNombre(nombreLadron);
            LectorCiudades lectorCiudades = new LectorCiudades();
            ArrayList<Ciudad> recorridoLadron = lectorCiudades.cargarCiudades(rutaCiudades,nombresRecorridoLadron,false);
            ArrayList<Ciudad> ciudadesDespiste = lectorCiudades.cargarCiudades(rutaCiudades,nombresCiudadesDespiste,true);

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