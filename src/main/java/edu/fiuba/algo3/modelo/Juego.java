package edu.fiuba.algo3.modelo;

public class Juego {

    private int numeroArrestos;

    private Objeto objetoRobado;

    public Juego(){
        this.numeroArrestos = 0;
    }

    public Objeto generarObjeto(){
        if(this.numeroArrestos > 5) {
            if (this.numeroArrestos > 10) {
                return new ObjetoMuyValioso();
            }
            return new ObjetoValioso();
        }
        return new ObjetoPocoValioso();
    }
}
