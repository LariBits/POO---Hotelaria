package com.hotel.controller;

import com.hotel.model.Quarto;
import com.hotel.repository.QuartoRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastroQuartoController {

    @FXML private TextField txtNumero;
    @FXML private TextField txtCategoria;
    @FXML private TextField txtValor;

    private QuartoRepository repository = new QuartoRepository();

    @FXML
    public void salvarQuarto() {
        try {
            // Converte os textos digitados para número
            int numero = Integer.parseInt(txtNumero.getText());
            String categoria = txtCategoria.getText();
            double valor = Double.parseDouble(txtValor.getText());

            // Cria o objeto e salva no repositório
            Quarto novoQuarto = new Quarto(numero, categoria, valor);
            repository.adicionarQuarto(novoQuarto);

            // Fecha a janela de cadastro após salvar
            Stage stage = (Stage) txtNumero.getScene().getWindow();
            stage.close();

        } catch (NumberFormatException e) {
            // Validação exigida no RF #01 caso digitem letras no número ou valor
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro de Validação");
            alerta.setHeaderText("Valores inválidos");
            alerta.setContentText("Digite apenas números válidos para o quarto e a diária.");
            alerta.showAndWait();
        }
    }
}