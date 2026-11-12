package com.hotel.controller;

import com.hotel.model.Hospede;
import com.hotel.model.Quarto;
import com.hotel.repository.QuartoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CheckInController {

    @FXML private Label lblTituloQuarto;
    @FXML private TextField txtNomeHospede;
    @FXML private TextField txtCpfHospede;
    @FXML private TextField txtDias;

    private Quarto quartoSelecionado;
    private QuartoRepository repository = new QuartoRepository();

    // Método chamado pelo Dashboard para dizer qual quarto foi clicado
    public void setQuarto(Quarto quarto) {
        this.quartoSelecionado = quarto;
        lblTituloQuarto.setText("Check-in - Quarto " + quarto.getNumero());
    }

    @FXML
    public void confirmarCheckIn() {
        String nome = txtNomeHospede.getText();
        String cpf = txtCpfHospede.getText();
        int dias = Integer.parseInt(txtDias.getText());

        Hospede hospede = new Hospede(nome, cpf);
        repository.realizarCheckIn(quartoSelecionado.getNumero(), hospede, dias);

        // Fecha o modal
        Stage stage = (Stage) txtNomeHospede.getScene().getWindow();
        stage.close();
    }
}