package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Vista;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class ControladorPantallaSimple{

    Stage stage;
    @FXML
    Button btnVolver;

    Parent vista;

    public ControladorPantallaSimple(){
    }

    public void reproducir_sonido(String ruta) {
        String uriString = new File(ruta).toURI().toString();
        MediaPlayer player = new MediaPlayer( new Media(uriString));
        player.play();
    }

    public void handleVolver() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.aiff");
        Vista vistaInicio = new Vista("/escenas/vistaInicio.fxml");
        var scene = new Scene(vistaInicio.escena());
        this.stage = (Stage) btnVolver.getScene().getWindow();
        this.stage.setScene(scene);
    }
}
