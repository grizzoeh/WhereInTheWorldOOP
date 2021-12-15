package edu.fiuba.algo3.modelo.lectoresDeArchivos;

import edu.fiuba.algo3.modelo.Ladron;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorLadrones {

    public ArrayList<Ladron> cargarLadrones(String ruta) {
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray JSONLadrones = (JSONArray) parser.parse(new FileReader(ruta));
            for (Object o : JSONLadrones) {
                JSONObject ladron = (JSONObject) o;
                String nombre = (String) ladron.get("Nombre");
                String sexo = (String) ladron.get("Sexo");
                String hobby = (String) ladron.get("Hobby");
                String cabello = (String) ladron.get("Cabello");
                String caracteristica = (String) ladron.get("Característica");
                String vehiculo = (String) ladron.get("Vehículo");
                ArrayList<String> descripciones = (ArrayList<String>) ladron.get("Descripciones");
                Ladron objLadron = new Ladron(nombre, sexo, hobby, cabello, caracteristica, vehiculo, descripciones);
                ladrones.add(objLadron);

            }
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
        return ladrones;
    }


}