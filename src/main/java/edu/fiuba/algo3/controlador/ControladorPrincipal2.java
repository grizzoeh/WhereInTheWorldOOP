package edu.fiuba.algo3.controlador;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.vista.Vista;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ControladorPrincipal2{

    Stage stage;

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
    VBox vboxViajar;
    @FXML
    VBox vboxEdificios;
    @FXML
    VBox vboxPrincipal;
    @FXML
    ChoiceBox cmbEdificios;
    @FXML
    ChoiceBox cmbViajar;
    Parent vista;
    private Juego juego;

    public ControladorPrincipal2(){
        this.juego = new Juego("asd", false);
        this.juego.iniciarNuevaMision();

    }
    
    public void handleViajar() throws Exception{
        this.vboxViajar.setVisible(true);
        this.btnViajar.setDisable(true);
        this.btnEdificios.setDisable(true);
        this.btnOrden.setDisable(true);
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
        this.btnViajar.setDisable(true);
        this.btnEdificios.setDisable(true);
        this.btnOrden.setDisable(true);
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
