package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.vista.Vista;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControladorPrincipal2{

    Stage stage;

    @FXML
    Button btnViajar;
    @FXML
    Button btnEdificios;
    @FXML
    Button btnOrden;

    Parent vista;
    private Juego juego;

    public ControladorPrincipal2(){
        Juego juego = new Juego("asd", false);
        juego.iniciarNuevaMision();
    }
    
    public void handleViajar() throws Exception{
        Vista vistaInicio = new Vista("/escenas/vistaInicio.fxml");
        var scene = new Scene(vistaInicio.escena());
        this.stage = (Stage) btnViajar.getScene().getWindow();
        this.stage.setScene(scene);
        this.juego.viajarA(null);
    }
    /*public void handleEvidencia() throws Exception{
        this.paneEvidencia.setDisable(false);
        this.paneEvidencia.setVisible(true);
        this.btnCerrarMenuEvidencia.setDisable(false);
    }
    public void handleCerrarMenuLadronModelo() throws Exception{
        this.paneEvidencia.setDisable(true);
        this.paneEvidencia.setVisible(false);
    }
    */
}
