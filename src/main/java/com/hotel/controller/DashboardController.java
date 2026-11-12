package com.hotel.controller;

import com.hotel.model.Quarto;
import com.hotel.model.StatusQuarto;
import com.hotel.repository.QuartoRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML private FlowPane painelQuartos;
    private QuartoRepository repository = new QuartoRepository();

    // O JavaFX chama esse método automaticamente assim que a tela abre
    @FXML
    public void initialize() {
        atualizarDashboard();
    }

    public void atualizarDashboard() {
        painelQuartos.getChildren().clear(); // Limpa os cards antigos para redesenhar

        for (Quarto quarto : repository.listarQuartos()) {
            VBox card = criarCardQuarto(quarto);
            painelQuartos.getChildren().add(card);
        }
    }

    private VBox criarCardQuarto(Quarto quarto) {
        VBox card = new VBox(8); // Espaçamento vertical de 8px entre os textos
        card.getStyleClass().add("card-quarto");

        Label lblNumero = new Label("Quarto " + quarto.getNumero());
        lblNumero.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");

        Label lblCategoria = new Label(quarto.getCategoria() + " - R$ " + quarto.getValorDiaria());
        Label lblStatus = new Label(quarto.getStatus().toString());

        // Define a cor pelo CSS baseado no Enum
        if (quarto.getStatus() == StatusQuarto.VAGO) {
            card.getStyleClass().add("card-vago");
        } else {
            card.getStyleClass().add("card-ocupado");
            // Mostra o nome do hóspede se estiver ocupado
            lblStatus.setText("OCUPADO (" + quarto.getHospede().getNome() + ")");
        }

        card.getChildren().addAll(lblNumero, lblCategoria, lblStatus);

        // Evento de clique no card para abrir o Check-in (RF #02)
        // Obs: A Maria Clara vai adicionar aqui o bloqueio (RF #03) se estiver ocupado
        card.setOnMouseClicked(event -> {
            if (quarto.getStatus() == StatusQuarto.VAGO) {
                abrirModalCheckIn(quarto);
            }
        });

        return card;
    }

    @FXML
    public void abrirTelaCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hotel/views/CadastroQuartoView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Cadastrar Quarto");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL); // Trava a tela de trás até fechar
            stage.showAndWait(); // Espera fechar...

            atualizarDashboard(); // ...e atualiza os cards na hora!
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void abrirModalCheckIn(Quarto quarto) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/hotel/views/CheckInModal.fxml"));
            Parent root = loader.load();

            // Passa o quarto clicado para o Controller do modal
            CheckInController controller = loader.getController();
            controller.setQuarto(quarto);

            Stage stage = new Stage();
            stage.setTitle("Realizar Check-in");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            atualizarDashboard(); // Atualiza a cor do card de verde para vermelho
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}