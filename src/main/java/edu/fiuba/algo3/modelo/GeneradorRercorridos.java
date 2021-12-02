package edu.fiuba.algo3.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;

public class GeneradorRercorridos {

    public ArrayList<Ciudad> generarRecorridoAleatorio(int numeroCiudades, String nombreCiudadinicial) throws IOException {
        RandomAccessFile lector = new RandomAccessFile(new File("E:\\Algoritmos 3\\AlgothiefMyBranch\\src\\txt\\locacion_ciudades.txt"), "r");
        ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>();

        //Aniadimos la primer ciudad
        String ciudad = lector.readLine();
        String[] parametros = ciudad.split(",");
        while(!Objects.equals(nombreCiudadinicial, parametros[0])) {
            ciudad = lector.readLine();
            parametros = ciudad.split(",");
        }
        float coordenadaX = Float.parseFloat(parametros[1]);
        float coordenadaY = Float.parseFloat(parametros[2]);
        ciudades.add(new Ciudad(parametros[0], new Coordenada(coordenadaX, coordenadaY)));

        //Anidimos el resto de las ciudades random
        lector.seek(0);
        HashSet setDeNumerosRandom = new HashSet();
        int numeroAleatorio;
        Random random = new Random();
        while(setDeNumerosRandom.size() < numeroCiudades){
            numeroAleatorio = random.nextInt(30);
            setDeNumerosRandom.add(numeroAleatorio);
        }
        int contador = 0;
        int numeroDeLinea = 0;
        while (contador < numeroCiudades){
            if (setDeNumerosRandom.contains(numeroDeLinea)) {
                ciudad = lector.readLine();
                parametros = ciudad.split(",");
                coordenadaX = Float.parseFloat(parametros[1]);
                coordenadaY = Float.parseFloat(parametros[2]);
                ciudades.add(new Ciudad(parametros[0], new Coordenada(coordenadaX, coordenadaY)));
                contador++;
            }else
            {
                lector.readLine();
            }
            numeroDeLinea++;
        }
        lector.close();
        return ciudades;
    }


}
