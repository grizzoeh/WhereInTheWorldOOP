<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Sargento.java
package edu.fiuba.algo3.modelo;
=======
package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasDificiles;
>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Sargento.java

public class Sargento implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Sargento.java
=======
    //private GeneradorDeMisiones generadorDeMisiones;
>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Sargento.java
    private int kmPorHora;

    public Sargento(){
        this.obtenedorDePistas = new ObtenedorDePistasDificiles();
<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Sargento.java
=======
        //this.generadorDeMisiones = new GeneradorDeMisionMuyValiosa();
>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Sargento.java
        this.kmPorHora = 1500;
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        return null;
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }
}
