module jtheb.matrixrain {
    requires javafx.controls;
    requires javafx.fxml;


    opens jtheb.matrixrain to javafx.fxml;
    exports jtheb.matrixrain;
}