package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Vista;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ControladorRegistro{

    Stage stage;
    @FXML
    Button btnVolver;
    @FXML
    Button btnComenzar;
    @FXML
    TextArea txtNombre;
    Parent vista;

    public ControladorRegistro(){
    }

    public void handleVolver() throws Exception{
        Vista vistaInicio = new Vista("escenas/vistaInicio.fxml");
        var scene = new Scene(vistaInicio.escena());
        this.stage = (Stage) btnVolver.getScene().getWindow();
        this.stage.setScene(scene);
    }

    public void handleComenzar() throws Exception{
        Vista vistaPrincipal = new Vista("escenas/vistaPrincipal.fxml");
        var scene = new Scene(vistaPrincipal.escena());
        this.stage = (Stage) btnComenzar.getScene().getWindow();
        this.stage.setScene(scene);
    }
}
