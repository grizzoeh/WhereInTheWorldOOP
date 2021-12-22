package edu.fiuba.algo3;
import java.io.IOException;
import edu.fiuba.algo3.vista.Vista;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        
        Vista vistaInicio = new Vista("/escenas/vistaInicio.fxml");
        var scene = new Scene(vistaInicio.escena());
        stage.setScene(scene);
        stage.show();
    }

   public static void main(String[] args) {
        launch();
    }

}