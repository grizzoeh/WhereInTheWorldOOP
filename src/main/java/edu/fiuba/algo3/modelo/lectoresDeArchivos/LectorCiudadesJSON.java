package edu.fiuba.algo3.modelo.lectoresDeArchivos;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Coordenadas;
import edu.fiuba.algo3.modelo.edificios.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorCiudadesJSON implements LectorCiudades{
    private String ruta = "src/main/java/edu/fiuba/algo3/modelo/archivosJson/modelociudades.json";

    public ArrayList<Ciudad> cargarCiudades(ArrayList<String> nombresCiudades, Boolean esDespiste){
        ArrayList<Ciudad> resultado = new ArrayList<Ciudad>();

        JSONParser parser = new JSONParser();
        try {
            Object o = (JSONObject) parser.parse(new FileReader(this.ruta));
            JSONObject JSONCiudades = (JSONObject) o;
            for (String nombreCiudad: nombresCiudades){
                JSONArray JSONCiudadAr = (JSONArray) JSONCiudades.get(nombreCiudad);
                JSONObject JSONCiudad = (JSONObject) JSONCiudadAr.get(0);

                Double latitud = (Double) JSONCiudad.get("Latitud");
                Double longitud = (Double) JSONCiudad.get("Longitud");
                String bandera = (String) JSONCiudad.get("Bandera");
                String moneda = (String) JSONCiudad.get("Moneda");
                String geografia = (String) JSONCiudad.get("Geografía");
                String landmarks = (String) JSONCiudad.get("Landmarks");
                String industrias = (String) JSONCiudad.get("Industrias");
                String animales = (String) JSONCiudad.get("Animales");
                String gente = (String) JSONCiudad.get("Gente");
                String lenguaje = (String) JSONCiudad.get("Lenguaje");
                String arte = (String) JSONCiudad.get("Arte");
                String religion = (String) JSONCiudad.get("Religion");
                String lider = (String) JSONCiudad.get("Lider");
                String extra = (String) JSONCiudad.get("Extra");
                String descripcion = (String) JSONCiudad.get("Descripcion");
                String ruta = (String) JSONCiudad.get("Ruta");
                Coordenadas coordenadas = new Coordenadas(latitud, longitud);
                ArrayList<Edificio> edificios = new ArrayList<Edificio>();
                if (esDespiste){
                    edificios.add(new EdificioDespiste("Aeropuerto"));
                    edificios.add(new EdificioDespiste("Biblioteca"));
                    edificios.add(new EdificioDespiste("Banco"));
                } else{
                    edificios.add(new Aeropuerto());
                    edificios.add(new Biblioteca());
                    edificios.add(new Banco());
                }

                Ciudad ciudad = new Ciudad(nombreCiudad, coordenadas, bandera, moneda, geografia, landmarks, industrias, animales, gente, lenguaje, arte, religion, lider, extra, edificios, descripcion, ruta);
                resultado.add(ciudad);
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

        return resultado;
    }
}
