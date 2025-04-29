module com.example.ohtuprojekti {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ohtuprojekti to javafx.fxml;
    exports com.example.ohtuprojekti;
}