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
import java.util.Dictionary;
import java.util.HashMap;

public class LectorLadronesJSON implements LectorLadrones{
    private String ruta = "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelosladrones.json";

    public ArrayList<Ladron> cargarLadrones() {
        ArrayList<Ladron> ladrones = new ArrayList<Ladron>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray JSONLadrones = (JSONArray) parser.parse(new FileReader(this.ruta));
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

    public HashMap<String, ArrayList<String>> obtenerCaracteristicas() {
        HashMap<String, ArrayList<String>> diccionario = new HashMap();
        diccionario.put("Sexo", new ArrayList<String>());
        diccionario.put("Cabello", new ArrayList<String>());
        diccionario.put("Hobby", new ArrayList<String>());
        diccionario.put("Vehiculo", new ArrayList<String>());
        diccionario.put("Senia", new ArrayList<String>());
        JSONParser parser = new JSONParser();
        try {
            JSONArray JSONLadrones = (JSONArray) parser.parse(new FileReader(this.ruta));
            for (Object o : JSONLadrones) {
                JSONObject ladron = (JSONObject) o;
                String nombre = (String) ladron.get("Nombre");
                String sexo = (String) ladron.get("Sexo");
                ArrayList<String> sexos = diccionario.get("Sexo");
                if (!sexos.contains(sexo)) {
                    sexos.add(sexo);
                }
                String hobby = (String) ladron.get("Hobby");
                ArrayList<String> hobbys = diccionario.get("Hobby");
                if (!hobbys.contains(hobby)) {
                    hobbys.add(hobby);
                }
                String cabello = (String) ladron.get("Cabello");
                ArrayList<String> cabellos = diccionario.get("Cabello");
                if (!cabellos.contains(cabello)) {
                    cabellos.add(cabello);
                }
                String caracteristica = (String) ladron.get("Característica");
                ArrayList<String> senias = diccionario.get("Senia");
                if (!senias.contains(caracteristica)) {
                    senias.add(caracteristica);
                }
                String vehiculo = (String) ladron.get("Vehículo");
                ArrayList<String> vehiculos = diccionario.get("Vehiculo");
                if (!vehiculos.contains(vehiculo)) {
                    vehiculos.add(vehiculo);
                }
                ArrayList<String> descripciones = (ArrayList<String>) ladron.get("Descripciones");
                Ladron objLadron = new Ladron(nombre, sexo, hobby, cabello, caracteristica, vehiculo, descripciones);
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
        return diccionario;
    }


}