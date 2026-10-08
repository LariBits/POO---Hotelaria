package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        VBox vbox = new VBox(10.0); //espaço das entre as linhas
        vbox.setPadding(new Insets(30.0)); //tamanho da borda do vbox
        stage.setTitle("Boas Vindas");
        stage.setResizable(false); //desativa o maximizar da tela

        Label labelNome = new Label("Nome:");
        TextField tfNome = new TextField();
        Label mensagem = new Label();

        Button botaoOk = new Button("Ok");
        botaoOk.setOnAction(e -> {
            mensagem.setText(tfNome.getText());
        });

        vbox.getChildren()
                .addAll(labelNome, tfNome, botaoOk, mensagem);
        Scene cena = new Scene(vbox, 320, 240);
        stage.setScene(cena);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}