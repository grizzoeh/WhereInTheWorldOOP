package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Vista;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class ControladorInicio{

    Stage stage;
    @FXML
    Button btnJugar;
    @FXML
    Button btnTutorial;
    @FXML
    Button btnAcercaDe;

    Parent vista;



    public ControladorInicio(){

    }

    public void reproducir_sonido(String ruta) {
        String uriString = new File(ruta).toURI().toString();
        MediaPlayer player = new MediaPlayer( new Media(uriString));
        player.play();
    }

    public void handleJugar() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        Vista vistaRegistro = new Vista("/escenas/vistaPrincipal.fxml");
        var scene = new Scene(vistaRegistro.escena());
        this.stage = (Stage) btnJugar.getScene().getWindow();
        this.stage.setScene(scene);
    }

    public void handleTutorial() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        Vista vistaTutorial = new Vista("/escenas/vistaTutorial.fxml");
        var scene = new Scene(vistaTutorial.escena());
        this.stage = (Stage) btnTutorial.getScene().getWindow();
        this.stage.setScene(scene);
    }

    public void handleAcercaDe() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        Vista vistaAcercaDe = new Vista("/escenas/vistaAcercaDe.fxml");
        var scene = new Scene(vistaAcercaDe.escena());
        this.stage = (Stage) btnAcercaDe.getScene().getWindow();
        this.stage.setScene(scene);
    }
}

