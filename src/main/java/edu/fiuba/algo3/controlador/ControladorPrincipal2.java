package edu.fiuba.algo3.controlador;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorPrincipal2{

    Stage stage;
    /* Button */
    @FXML
    Button btnViajar;
    @FXML
    Button btnEdificios;
    @FXML
    Button btnOrden;
    @FXML
    Button btnConfirmarViajar;
    @FXML
    Button btnCancelarViajar;
    @FXML
    Button btnConfirmarEdificios;
    @FXML
    Button btnCancelarEdificios;
    @FXML
    Button btnEmitirOrden;
    @FXML
    Button btnCancelarOrden;
    /* VBox */
    @FXML
    VBox vboxViajar;
    @FXML
    VBox vboxEdificios;
    @FXML
    VBox vboxPrincipal;
    @FXML
    VBox vboxOrden;
    /* ChoiceBox */
    @FXML
    ChoiceBox cmbEdificios;
    @FXML
    ChoiceBox cmbViajar;
    @FXML
    ChoiceBox cmbSexo;
    @FXML
    ChoiceBox cmbCabello;
    @FXML
    ChoiceBox cmbHobby;
    @FXML
    ChoiceBox cmbSenia;
    @FXML
    ChoiceBox cmbVehiculo;

    Parent vista;
    private Juego juego;

    public ControladorPrincipal2(){
        this.juego = new Juego("asd", false);
        this.juego.iniciarNuevaMision();

    }
    
    public void handleViajar() throws Exception{
        this.vboxViajar.setVisible(true);
        this.deshabilitarBotonesPrincipales();
        ArrayList<Ciudad> ciudades = this.juego.viajesDisponibles();
        ObservableList<Ciudad> lista = FXCollections.observableArrayList();
        for (Ciudad ciudad: ciudades){
            lista.add(ciudad);
        }
        cmbViajar.setItems(lista);
    }
    public void handleConfirmarViajar() throws Exception{
        this.cerrarVBox(this.vboxViajar);
        
    }
    public void handleCancelarViajar() throws Exception{
        this.cerrarVBox(this.vboxViajar);
    }
    private void cerrarVBox(VBox vbox){
        vbox.setVisible(false);
        this.btnViajar.setDisable(false);
        this.btnEdificios.setDisable(false);
        this.btnOrden.setDisable(false);
    }

    public void handleEdificios() throws Exception{
        this.vboxEdificios.setVisible(true);
        this.deshabilitarBotonesPrincipales();
        ArrayList<Edificio> edificios = this.juego.edificiosDisponibles();
        ObservableList<Edificio> lista = FXCollections.observableArrayList();
        for (Edificio edificio: edificios){
            lista.add(edificio);
        }
        cmbEdificios.setItems(lista);
    }
    public void handleConfirmarEdificios() throws Exception{
        this.cerrarVBox(this.vboxEdificios);
        
    }
    public void handleCancelarEdificios() throws Exception{
        this.cerrarVBox(this.vboxEdificios);
    }
    public void handleOrden() throws Exception{
        this.vboxOrden.setVisible(true);
        this.deshabilitarBotonesPrincipales();
    }
    public void handleEmitirOrden() throws Exception{
        this.cerrarVBox(this.vboxOrden);
    }
    public void handleCancelarOrden() throws Exception{
        this.cerrarVBox(this.vboxOrden);
    }   
    public void deshabilitarBotonesPrincipales(){
        this.btnViajar.setDisable(true);
        this.btnEdificios.setDisable(true);
        this.btnOrden.setDisable(true);
    }
}
    /*
    public void handleConfirmarViajar() throws Exception{
        Vista vistaInicio = new Vista("/escenas/vistaInicio.fxml");
        var scene = new Scene(vistaInicio.escena());
        this.stage = (Stage) btnViajar.getScene().getWindow();
        this.stage.setScene(scene);
        this.juego.viajarA(null);
    }
}*/
