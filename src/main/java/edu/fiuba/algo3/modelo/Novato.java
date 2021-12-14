<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Novato.java
package edu.fiuba.algo3.modelo;
=======
package edu.fiuba.algo3.modelo.policia;

import edu.fiuba.algo3.modelo.Mision;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistas;
import edu.fiuba.algo3.modelo.obtenedoresDePistas.ObtenedorDePistasFaciles;
>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Novato.java

public class Novato implements Rango {

    private ObtenedorDePistas obtenedorDePistas;
<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Novato.java
=======
    //private GeneradorDeMisiones generadorDeMisiones;
>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Novato.java
    private int kmPorHora;

    public Novato(){
        this.obtenedorDePistas = new ObtenedorDePistasFaciles();
<<<<<<< Updated upstream:src/main/java/edu/fiuba/algo3/modelo/Novato.java
=======
        //this.generadorDeMisiones = new GeneradorDeMisionComun();
>>>>>>> Stashed changes:src/main/java/edu/fiuba/algo3/modelo/policia/Novato.java
        this.kmPorHora = 900;
    }

    @Override
    public String pedirPista(Edificio unEdificio, Mision unaMision) {
        return this.obtenedorDePistas.pedirPista(unEdificio,unaMision);
    }

    @Override
    public Rango proximoRango(){
        return new Detective();
    }

    @Override
    public double calcularTiempoViajeA(double distancia){
        return distancia/this.kmPorHora;
    }
}
