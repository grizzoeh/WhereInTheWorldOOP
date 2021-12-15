package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.LadronNoEncontradoException;

import java.util.ArrayList;

public class RegistroLadrones {

    private ArrayList<Ladron> ladrones;

    public RegistroLadrones(ArrayList<Ladron> ladrones){
        this.ladrones = ladrones;

    }

    public Ladron encontrarLadronConNombre(String nombre){
        for (Ladron ladron: this.ladrones){
            if (ladron.coincideNombre(nombre)){
                return ladron;
            }
        }
        throw new LadronNoEncontradoException();
    }

    public ArrayList<Ladron> posiblesLadrones(LadronModelo modeloLadron){

        ArrayList<Ladron> ladronesCoincidentes = new ArrayList<>();

        for (Ladron ladron : this.ladrones) {
            if (ladron.coincideDesripcion(modeloLadron)) {
                ladronesCoincidentes.add(ladron);
            }

        }


        return ladronesCoincidentes;
    }

}
