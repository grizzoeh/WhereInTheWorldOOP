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

public class ControladorPrincipal{

    Stage stage;
    @FXML
    Button btnEvidencia;
    @FXML
    Button btnSospechosos;
    @FXML
    Button btnPaises;
    @FXML
    Button btnOpciones;
    @FXML
    Button btnEnviar;
    @FXML
    Button btnCancelar;
    @FXML
    Button btnViajar;
    @FXML
    Button btnEmitirOrden;
    @FXML
    Button btnMas;
    @FXML
    Button btnCerrarMenuEvidencia;
    @FXML
    Pane paneEvidencia;
    @FXML
    TextArea txtNombre;
    @FXML
    ChoiceBox choiceboxSexo;
    @FXML
    ChoiceBox choiceboxCabello;
    @FXML
    ChoiceBox choiceboxHobby;
    @FXML
    ChoiceBox choiceboxSenia;
    @FXML
    ChoiceBox choiceboxVehiculo;


    Parent vista;
    private Juego juego;

    public ControladorPrincipal(){
        Juego juego = new Juego("asd", false);
        juego.iniciarNuevaMision();
        this.iniciarEvidencia();

    }
    private void iniciarEvidencia(){
        this.choiceboxSexo.getItems();
        this.choiceboxCabello.getItems().addAll(FXCollections.observableArrayList("Negro", "Rojo", "Rubio", "Castaño"));
        this.choiceboxHobby.getItems().addAll(FXCollections.observableArrayList("Escalada De Montaña", "Croquet", "Tenis"));
        this.choiceboxSenia.getItems().addAll(FXCollections.observableArrayList("Joyeria", "Tatuaje", "Anillo"));
        this.choiceboxVehiculo.getItems().addAll(FXCollections.observableArrayList("Motocicleta", "Convertible", "Limusina"));
    }
    public void handleViajar() throws Exception{
        Vista vistaInicio = new Vista("/escenas/vistaInicio.fxml");
        var scene = new Scene(vistaInicio.escena());
        this.stage = (Stage) btnViajar.getScene().getWindow();
        this.stage.setScene(scene);
        this.juego.viajarA(null);
    }
    public void handleEvidencia() throws Exception{
        this.paneEvidencia.setDisable(false);
        this.paneEvidencia.setVisible(true);
        this.btnCerrarMenuEvidencia.setDisable(false);
    }
    public void handleCerrarMenuLadronModelo() throws Exception{
        this.paneEvidencia.setDisable(true);
        this.paneEvidencia.setVisible(false);
    }
}
