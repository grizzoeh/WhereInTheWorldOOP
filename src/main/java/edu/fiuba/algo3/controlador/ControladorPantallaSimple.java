package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Vista;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControladorPantallaSimple{

    Stage stage;
    @FXML
    Button btnVolver;

    Parent vista;

    public ControladorPantallaSimple(){
    }

    public void handleVolver() throws Exception{
        Vista vistaInicio = new Vista("escenas/vistaInicio.fxml");
        var scene = new Scene(vistaInicio.escena());
        this.stage = (Stage) btnVolver.getScene().getWindow();
        this.stage.setScene(scene);
    }
}
