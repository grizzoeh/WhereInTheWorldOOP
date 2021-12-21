package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.Vista;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControladorInicio implements EventHandler<MouseEvent> {

    Stage stage;
    Button btnJugar, btnTutorial, btnAcercaDe;

    Parent vista;

    public ControladorInicio(){

    }
    public void init(Stage stage) {
        this.stage = stage;
    }

    public void handleJugar() throws Exception{
        Vista vistaRegistro = new Vista("escenas/vistaRegistro.fxml");
        var scene = new Scene(vistaRegistro.escena());
        Stage stageNuevo = new Stage();
        stageNuevo.setScene(scene);
        stageNuevo.show();
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("asd");

    }
}

