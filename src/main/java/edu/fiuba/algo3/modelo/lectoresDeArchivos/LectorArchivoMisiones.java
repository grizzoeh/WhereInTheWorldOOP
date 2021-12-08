/*
package edu.fiuba.algo3.modelo.lectoresDeArchivos;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;


import com.opencsv.CSVReader;
import edu.fiuba.algo3.modelo.Juego;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class LectorArchivoMisiones {

    public void leerYParsear(String rutaArchivo, Juego juego) throws FileNotFoundException {
        FileReader fileReader = new FileReader(rutaArchivo);
        CSVReader csvReader = new CSVReader(fileReader);

        try {


            fileReader = new FileReader(rutaArchivo);
            csvReader = new CSVReader(fileReader);
            String[] linea;
            csvReader.readNext();
            int lineasArchivo = 0;

            //contador de lineas (misiones)
            while (csvReader.readNext() != null) {
                lineasArchivo++;
            }

            int randomNum = ThreadLocalRandom.current().nextInt(0, lineasArchivo);

            fileReader = new FileReader(rutaArchivo);
            csvReader = new CSVReader(fileReader);
            String[] lineaEspecifica = csvReader.readAll().get(randomNum);

            String objetoRobado = lineaEspecifica[0];



        }
        catch (Exception e) {
            e.printStackTrace();
        }



    }


}
*/
