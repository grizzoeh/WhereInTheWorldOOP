package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrdenDeArresto {
    private String vehiculo;
    private String hobby;
    private String sexo;
    private String cabello;
    private String seña;
    private boolean emitida;


    public OrdenDeArresto(){
        this.vehiculo = "???";
        this.hobby = "???";
        this.sexo = "???";
        this.cabello = "???";
        this.seña = "???";

    }

    public ArrayList<Ladron> posiblesLadrones(ArrayList<Ladron> ladronesSospechosos){
        Ladron modeloLadron = new Ladron("???",this.sexo,this.hobby, this.cabello, this.seña,this.vehiculo, new ArrayList<String>() );
        ArrayList<Ladron> ladronesCoincidentes = new ArrayList<>();

        for(Ladron ladron: ladronesSospechosos){
            if (ladron.coincideDesripcion(modeloLadron)){
                ladronesCoincidentes.add(ladron);
            }

        }

        if (ladronesCoincidentes.size() == 1){
            this.emitida = true;
        }
        else {this.emitida = false;}

        return ladronesCoincidentes;
    }



}
