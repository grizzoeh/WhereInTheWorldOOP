<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Investigador.java
package edu.fiuba.algo3.modelo;
=======
package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasMedias;
>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Investigador.java

public class Investigador implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Investigador.java
=======
    //private GeneradorDeMisiones generadorDeMisiones;

>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Investigador.java
    private int kmPorHora;

    public Investigador(){
        this.obtenedorDePistas = new ObtenedorDePistasMedias();
<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Investigador.java
=======
        //this.generadorDeMisiones = new GeneradorDeMisionValiosa();
>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Investigador.java
        this.kmPorHora = 1300;
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        return new Sargento();
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }
}
