module com.example.generalpricelist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.generalpricelist to javafx.fxml;
    exports com.example.generalpricelist;
}