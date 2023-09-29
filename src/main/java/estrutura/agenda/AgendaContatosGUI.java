package estrutura.agenda;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.HashMap;
import java.util.Map;

public class AgendaContatosGUI {
    private Map<String, Contato> contatos = new HashMap<>();
    private TextField nomeField, telefoneField, nascimentoField, emailField, celularField;
    private TextArea listaContatosTextArea;

    public void start(Stage primaryStage) {
        primaryStage.setTitle("Agenda de Contatos");

        BorderPane layout = new BorderPane();

        VBox entradaDados = new VBox(10);
        entradaDados.setPadding(new Insets(10, 10, 10, 10));

        Label nomeLabel = new Label("Nome:");
        nomeField = new TextField();
        Label telefoneLabel = new Label("Telefone:");
        telefoneField = new TextField();
        Label nascimentoLabel = new Label("Nascimento:");
        nascimentoField = new TextField();
        Label emailLabel = new Label("Email:");
        emailField = new TextField();
        Label celularLabel = new Label("Celular:");
        celularField = new TextField();

        Button adicionarButton = new Button("Adicionar Contato");
        adicionarButton.setOnAction(e -> adicionarContato());

        entradaDados.getChildren().addAll(
                nomeLabel, nomeField, telefoneLabel, telefoneField,
                nascimentoLabel, nascimentoField, emailLabel, emailField,
                celularLabel, celularField, adicionarButton);

        listaContatosTextArea = new TextArea();
        listaContatosTextArea.setEditable(false);
        listaContatosTextArea.setWrapText(true);
        listaContatosTextArea.setPrefHeight(300);

        Button listarContatosButton = new Button("Listar Contatos");
        listarContatosButton.setOnAction(e -> listarContatos());

        Button excluirContatoButton = new Button("Excluir Contato");
        excluirContatoButton.setOnAction(e -> excluirContato());

        VBox botoes = new VBox(10);
        botoes.setPadding(new Insets(10, 10, 10, 10));
        botoes.getChildren().addAll(listarContatosButton, excluirContatoButton);

        layout.setLeft(entradaDados);
        layout.setCenter(listaContatosTextArea);
        layout.setRight(botoes);

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void adicionarContato() {
        String nome = nomeField.getText().trim();
        String telefone = telefoneField.getText();
        String nascimento = nascimentoField.getText();
        String email = emailField.getText();
        String celular = celularField.getText();

        if (nome.isEmpty()) {
            showAlert("Nome não pode estar em branco.");
            return;
        }

        Contato novoContato = new Contato(nome, telefone, nascimento, email, celular);
        contatos.put(nome, novoContato);

        nomeField.clear();
        telefoneField.clear();
        nascimentoField.clear();
        emailField.clear();
        celularField.clear();
    }

    private void listarContatos() {
        StringBuilder lista = new StringBuilder();
        for (Contato contato : contatos.values()) {
            lista.append(contato.toString()).append("\n");
        }
        listaContatosTextArea.setText(lista.toString());
    }

    private void excluirContato() {
        String nome = nomeField.getText().trim();
        if (contatos.containsKey(nome)) {
            contatos.remove(nome);
            showAlert("Contato '" + nome + "' excluído com sucesso.");
        } else {
            showAlert("Contato '" + nome + "' não encontrado.");
        }
        nomeField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informação");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
