module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    requires javafx.media;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.controlador to javafx.fxml;
    opens edu.fiuba.algo3.controlador to javafx.fxml;
}