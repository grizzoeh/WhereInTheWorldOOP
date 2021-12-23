package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Mision {
    private String objetoRobado;
    private Ladron ladron;
    private ArrayList<Ciudad> recorridoLadron;
    private ArrayList<Ciudad> ciudadesFalsas;
    private int index;


    public Mision(String objetoRobado, Ladron ladron, ArrayList<Ciudad> recorridoLadron, ArrayList<Ciudad> ciudadesFalsas) {
        this.objetoRobado = objetoRobado;
        this.ladron = ladron;
        this.recorridoLadron = recorridoLadron;
        this.ciudadesFalsas = ciudadesFalsas;
        this.index = 0;
    }

    public Ciudad obtenerProximaCiudad() {
        return (this.recorridoLadron.get(index+1));
    }

    public void viajarA(Ciudad unaCiudad) {
        if (this.recorridoLadron.contains(unaCiudad)) {
            this.index++;
        }
    }

    public String obtenerDescripcionSospechoso() {
        return this.ladron.obtenerDescripcion();
    }

    public boolean finalDelRecorrido(Ciudad ciudadActual) {
        return this.recorridoLadron.get(this.recorridoLadron.size()-1) == ciudadActual;
    }

    public boolean compararLadron(Ladron otroLadron) {
        return this.ladron.sosEsteLadron(otroLadron);
    }

    public ArrayList<Ciudad> ciudadesDisponibles(){
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

        if (this.index >= this.recorridoLadron.size()-1){
            return ciudades;
        }

        ciudades.add(this.recorridoLadron.get(this.index + 1));
        for(int i = 0; ciudades.size() < 3; i++){

            int randomNum = ThreadLocalRandom.current().nextInt(0, this.ciudadesFalsas.size());
            Ciudad ciudad = this.ciudadesFalsas.get(randomNum);
            if (ciudades.contains(ciudad)){
                continue;
            }

            ciudades.add(ciudad);
        }
        Collections.shuffle(ciudades);
        return ciudades;
    }

    public Ciudad inicioRecorrido() {
        return this.recorridoLadron.get(0);
    }
}

