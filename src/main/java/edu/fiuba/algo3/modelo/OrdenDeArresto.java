package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class OrdenDeArresto {
    private String vehiculo;
    private String hobby;
    private String sexo;
    private String cabello;
    private String senia;
    private Ladron ladron;

    public OrdenDeArresto() {
        this.vehiculo = "???";
        this.hobby = "???";
        this.sexo = "???";
        this.cabello = "???";
        this.senia = "???";
        this.ladron = null;
    }

    public ArrayList<Ladron> actualizarVehiculo(String vehiculo, ArrayList<Ladron> ladrones) {
        this.vehiculo = vehiculo;
        return this.posiblesLadrones(ladrones);
    }

    public ArrayList<Ladron> actualizarHobby(String hobby, ArrayList<Ladron> ladrones) {
        this.hobby = hobby;
        return this.posiblesLadrones(ladrones);
    }

    public ArrayList<Ladron> actualizarSexo(String sexo, ArrayList<Ladron> ladrones) {
        this.sexo = sexo;
        return this.posiblesLadrones(ladrones);
    }

    public ArrayList<Ladron> actualizarCabello(String cabello, ArrayList<Ladron> ladrones) {
        this.cabello = cabello;
        return this.posiblesLadrones(ladrones);
    }

    public ArrayList<Ladron> actualizarSenia(String senia, ArrayList<Ladron> ladrones) {
        this.senia = senia;
        return this.posiblesLadrones(ladrones);
    }

    public ArrayList<Ladron> posiblesLadrones(ArrayList<Ladron> ladronesSospechosos) {
        Ladron modeloLadron = new Ladron("???", this.sexo, this.hobby, this.cabello, this.senia, this.vehiculo, new ArrayList<String>());
        ArrayList<Ladron> ladronesCoincidentes = new ArrayList<>();

        for (Ladron ladron : ladronesSospechosos) {
            if (ladron.coincideDesripcion(modeloLadron)) {
                ladronesCoincidentes.add(ladron);
            }

        }
        if (ladronesCoincidentes.size() == 1) {
            this.ladron = ladronesCoincidentes.get(0);
        } else {
            this.ladron = null;
        }

        return ladronesCoincidentes;
    }

    public void atraparLadron(Juego juego, Mision mision) {
        if (mision.compararLadron(this.ladron)) {
            juego.ladronAtrapado();
        }
        else {
            juego.ladronEscapa();
        }
    }

}
