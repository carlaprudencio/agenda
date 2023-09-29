module estrutura.agenda {
    requires javafx.controls;
    requires javafx.fxml;


    opens estrutura.agenda to javafx.fxml;
    exports estrutura.agenda;
}