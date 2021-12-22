package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Vista;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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

    public void handleJugar() throws Exception{
        Vista vistaRegistro = new Vista("escenas/vistaRegistro.fxml");
        var scene = new Scene(vistaRegistro.escena());
        this.stage = (Stage) btnJugar.getScene().getWindow();
        this.stage.setScene(scene);
    }

    public void handleTutorial() throws Exception{
        Vista vistaTutorial = new Vista("escenas/vistaTutorial.fxml");
        var scene = new Scene(vistaTutorial.escena());
        this.stage = (Stage) btnTutorial.getScene().getWindow();
        this.stage.setScene(scene);
    }

    public void handleAcercaDe() throws Exception{
        Vista vistaAcercaDe = new Vista("escenas/vistaAcercaDe.fxml");
        var scene = new Scene(vistaAcercaDe.escena());
        this.stage = (Stage) btnAcercaDe.getScene().getWindow();
        this.stage.setScene(scene);
    }
}

