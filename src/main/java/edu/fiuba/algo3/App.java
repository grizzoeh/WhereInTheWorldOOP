package edu.fiuba.algo3;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("vista/vistaInicio.fxml"));
        Parent root = loader.load();
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

   public static void main(String[] args) {
        launch();
    }

}