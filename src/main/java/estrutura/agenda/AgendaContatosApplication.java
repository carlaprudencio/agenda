package estrutura.agenda;

import javafx.application.Application;
import javafx.stage.Stage;

public class AgendaContatosApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AgendaContatosGUI agendaGUI = new AgendaContatosGUI();
        agendaGUI.start(primaryStage);
    }
}
