package edu.fiuba.algo3.vista;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Vista{

    Parent root;

    public Vista(String ruta) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(ruta));
        this.root = loader.load();
    }

    public Parent escena(){
        return root;
    }
}

