package edu.fiuba.algo3.controlador;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.ThaiBuddhistEra;
import java.time.format.TextStyle;
import java.util.*;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControladorPrincipal2{

    Stage stage;
    /* Labels */
    @FXML
    Label txtFechaYHora;
    @FXML
    Label txtCiudadActual;
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
    @FXML
    VBox vboxDisparo;
    @FXML
    VBox vboxPunialada;
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
    ChoiceBox cmbCaracteristica;
    @FXML
    ChoiceBox cmbVehiculo;

    Parent vista;
    private Juego juego;

    public ControladorPrincipal2(){
        this.juego = new Juego("asd", true);
        this.juego.establecerInterfazGrafica(this);
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
        Ciudad ciudadDestino = (Ciudad) cmbViajar.getValue();
        if (ciudadDestino != null) {
            juego.viajarA(ciudadDestino);
            this.cerrarVBox(this.vboxViajar);
        }
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
        HashMap<String, ArrayList<String>> caracteristicas = this.juego.obtenerCaracteristicas();

        ArrayList<String> sexos = caracteristicas.get("Sexo");
        ObservableList<String> lista = FXCollections.observableArrayList();
        for (String sexo: sexos){
            lista.add(sexo);
        }
        cmbSexo.setItems(lista);

        ArrayList<String> hobbys = caracteristicas.get("Hobby");
        ObservableList<String> lista2 = FXCollections.observableArrayList();
        for (String hobby: hobbys){
            lista2.add(hobby);
        }
        cmbHobby.setItems(lista2);

        ArrayList<String> cabellos = caracteristicas.get("Cabello");
        ObservableList<String> lista3 = FXCollections.observableArrayList();
        for (String cabello: cabellos){
            lista3.add(cabello);
        }
        cmbCabello.setItems(lista3);

        ArrayList<String> senias = caracteristicas.get("Senia");
        ObservableList<String> lista4 = FXCollections.observableArrayList();
        for (String senia: senias){
            lista4.add(senia);
        }
        cmbCaracteristica.setItems(lista4);

        ArrayList<String> vehiculos = caracteristicas.get("Vehiculo");
        ObservableList<String> lista5 = FXCollections.observableArrayList();
        for (String vehiculo: vehiculos){
            lista5.add(vehiculo);
        }
        cmbVehiculo.setItems(lista5);
    }

    public void handleEmitirOrden() throws Exception{

    }

    public void handleCancelarOrden() throws Exception{
        this.cerrarVBox(this.vboxOrden);
    }

    public void deshabilitarBotonesPrincipales(){
        this.btnViajar.setDisable(true);
        this.btnEdificios.setDisable(true);
        this.btnOrden.setDisable(true);
    }

    public void recibirPunialada() {
        this.vboxPunialada.setVisible(true);
        this.deshabilitarBotonesPrincipales();
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(5),
                        event -> {
                            this.cerrarVBox(this.vboxPunialada);
                        }
                )
        );
        timeline.play();
    }

    public void recibirDisparo() {
        this.vboxDisparo.setVisible(true);
        this.deshabilitarBotonesPrincipales();
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(5),
                        event -> {
                            this.cerrarVBox(this.vboxDisparo);
                        }
                )
        );
        timeline.play();
    }

    public void actualizarFechaYHora(LocalDateTime fecha) {
        String dia = fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es","ES")); // Dia de la semana segun fecha
        dia = dia.substring(0, 1).toUpperCase() + dia.substring(1);
        int hora = fecha.getHour();
        String str = dia + ", " + hora + ":00hs";
        this.txtFechaYHora.setText(str);
    }

    public void actualizarCiudadActual(String nombreCiudad) {
        this.txtCiudadActual.setText(nombreCiudad);
    }



}
