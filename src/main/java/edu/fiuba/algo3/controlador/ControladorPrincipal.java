package edu.fiuba.algo3.controlador;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.chrono.ThaiBuddhistEra;
import java.time.format.TextStyle;
import java.util.*;

import edu.fiuba.algo3.modelo.Ciudad;
import edu.fiuba.algo3.modelo.Juego;
import edu.fiuba.algo3.modelo.Ladron;
import edu.fiuba.algo3.modelo.edificios.Edificio;
import edu.fiuba.algo3.vista.Vista;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class ControladorPrincipal {

    Stage stage;
    /* TextBox */
    @FXML
    TextArea txtPistas;
    @FXML
    TextArea txtInfoCiudad;
    @FXML
    TextArea txtPosiblesSospechosos;
    @FXML
    TextField txtNombrePolicia;
    /* Labels */
    @FXML
    Label txtFechaYHora;
    @FXML
    Label txtCiudadActual;
    /* Button */
    @FXML
    Button btnIniciar;
    @FXML
    Button btnViajar;
    @FXML
    Button btnEdificios;
    @FXML
    Button btnSalirEdificio;
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
    @FXML
    Button btnMenuPrincipal;
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
    @FXML
    VBox vboxLadronEscapa;
    @FXML
    VBox vboxLadronAtrapado;
    @FXML
    VBox vboxInicio;
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

    public ControladorPrincipal(){
    }

    public void handleIniciar() throws Exception {
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        this.juego = new Juego(this.txtNombrePolicia.getText(), true);
        this.juego.establecerInterfazGrafica(this);
        this.juego.iniciarNuevaMision();
        this.cerrarVBox(vboxInicio);

    }

    public void handleIntroduccionNombre() {
        if (this.txtNombrePolicia.getText().equals("")) {
            this.btnIniciar.setDisable(true);
        }
        else {
            this.btnIniciar.setDisable(false);
        }
    }

    public void handleViajar() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
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
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        Ciudad ciudadDestino = (Ciudad) cmbViajar.getValue();
        if (ciudadDestino != null) {
            juego.viajarA(ciudadDestino);
            this.cerrarVBox(this.vboxViajar);
        }
    }

    public void handleCancelarViajar() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        this.cerrarVBox(this.vboxViajar);
    }

    private void cerrarVBox(VBox vbox){
        vbox.setVisible(false);
        this.habilitarBotonesPrincipales();
    }

    public void handleEdificios() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
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
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        Edificio edificioDestino = (Edificio) cmbEdificios.getValue();
        if (edificioDestino != null) {
            juego.policiaEntrarA(edificioDestino);
            this.btnEdificios.setVisible(false);
            this.btnViajar.setVisible(false);
            this.btnOrden.setVisible(false);
            this.btnSalirEdificio.setVisible(true);
            this.cerrarVBox(this.vboxEdificios);
        }
    }

    public void handleMenuPrincipal() throws Exception {
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        Vista vistaRegistro = new Vista("/escenas/vistaInicio.fxml");
        var scene = new Scene(vistaRegistro.escena());
        this.stage = (Stage) this.btnMenuPrincipal.getScene().getWindow();
        this.stage.setScene(scene);
    }

    public void handleSalirEdificio() {
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        this.btnEdificios.setVisible(true);
        this.btnViajar.setVisible(true);
        this.btnOrden.setVisible(true);
        this.btnSalirEdificio.setVisible(false);
        this.txtPistas.setText("");
    }

    public void handleCancelarEdificios() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        this.cerrarVBox(this.vboxEdificios);
    }

    public void handleOrden() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
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
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        String sexo = (String) cmbSexo.getValue();
        String hobby = (String) cmbHobby.getValue();
        String cabello = (String) cmbCabello.getValue();
        String senia = (String) cmbCaracteristica.getValue();
        String vehiculo = (String) cmbVehiculo.getValue();
        if (sexo != null) {
            juego.OrdenActualizarSexo(sexo);
        }
        if (hobby != null) {
            juego.OrdenActualizarHobby(hobby);
        }
        if (cabello != null) {
            juego.OrdenActualizarCabello(cabello);
        }
        if (senia != null) {
            juego.OrdenActualizarSenia(senia);
        }
        if (vehiculo != null) {
            juego.OrdenActualizarVehiculo(vehiculo);
        }
        ArrayList<Ladron> sospechosos = this.juego.generarOrdenDeArresto();
        String salidaSospechosos = "";
        for (Ladron ladron: sospechosos) {
            salidaSospechosos = salidaSospechosos + ladron.toString() + "\n";
        }
        this.txtPosiblesSospechosos.setText(salidaSospechosos);
    }

    public void handleCancelarOrden() throws Exception{
        this.reproducir_sonido("src/main/resources/Sonidos/Cick.wav");
        this.cerrarVBox(this.vboxOrden);
    }

    public void deshabilitarBotonesPrincipales(){
        this.btnViajar.setDisable(true);
        this.btnEdificios.setDisable(true);
        this.btnOrden.setDisable(true);
    }

    public void habilitarBotonesPrincipales() {
        this.btnViajar.setDisable(false);
        this.btnEdificios.setDisable(false);
        this.btnOrden.setDisable(false);
    }

    public void recibirPunialada() {
        this.vboxPunialada.setVisible(true);
        this.btnSalirEdificio.setDisable(true);
        this.reproducir_sonido("src/main/resources/Sonidos/Puñalada.wav");
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(5),
                        event -> {

                            this.btnSalirEdificio.setDisable(false);
                            this.cerrarVBox(this.vboxPunialada);
                        }
                )
        );
        timeline.play();
    }

    public void recibirDisparo() {
        this.vboxDisparo.setVisible(true);
        this.btnSalirEdificio.setDisable(true);
        this.reproducir_sonido("src/main/resources/Sonidos/Disparo.wav");
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(5),
                        event -> {

                            this.btnSalirEdificio.setDisable(false);
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

    public void mostrarPista(String pista) {
        this.txtPistas.setText(pista);
    }

    public void mostrarInfo(String info) {
        this.txtInfoCiudad.setText(info);
    }

    public void ladronEscapa() {
        this.reproducir_sonido("src/main/resources/Sonidos/Perder.wav");
        this.vboxLadronEscapa.setVisible(true);
        this.btnSalirEdificio.setDisable(true);
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(5),
                        event -> {
                            this.mostrarPista("");
                            this.mostrarInfo("");
                            this.txtPosiblesSospechosos.setText("");
                            this.cerrarVBox(this.vboxLadronEscapa);
                            this.btnSalirEdificio.setDisable(false);
                            this.btnSalirEdificio.setVisible(false);
                            this.btnEdificios.setVisible(true);
                            this.btnViajar.setVisible(true);
                            this.btnOrden.setVisible(true);
                            juego.iniciarNuevaMision();
                        }
                )
        );
        timeline.play();
    }

    public void ladronAtrapado() {
        this.reproducir_sonido("src/main/resources/Sonidos/Ganar.wav");
        this.vboxLadronAtrapado.setVisible(true);
        this.btnSalirEdificio.setDisable(true);
        this.deshabilitarBotonesPrincipales();
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.seconds(5),
                        event -> {
                            this.mostrarPista("");
                            this.mostrarInfo("");
                            this.txtPosiblesSospechosos.setText("");
                            this.btnSalirEdificio.setDisable(false);
                            this.btnSalirEdificio.setVisible(false);
                            this.btnEdificios.setVisible(true);
                            this.btnViajar.setVisible(true);
                            this.btnOrden.setVisible(true);
                            this.cerrarVBox(this.vboxLadronAtrapado);
                            juego.iniciarNuevaMision();
                        }
                )
        );
        timeline.play();
    }

    public void cerrarVentanas() {
        this.cerrarVBox(vboxEdificios);
        this.cerrarVBox(vboxViajar);
        this.cerrarVBox(vboxOrden);
    }

    public void reproducir_sonido(String ruta) {
        String uriString = new File(ruta).toURI().toString();
        MediaPlayer player = new MediaPlayer( new Media(uriString));
        player.play();
    }

}
