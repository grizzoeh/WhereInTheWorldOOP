module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;
    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.controlador to javafx.fxml;
    opens edu.fiuba.algo3.controlador to javafx.fxml;
}