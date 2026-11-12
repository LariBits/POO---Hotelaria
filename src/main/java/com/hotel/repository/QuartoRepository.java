package com.hotel.repository;

import com.hotel.model.Hospede;
import com.hotel.model.Quarto;
import com.hotel.model.StatusQuarto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QuartoRepository {
    // Lista estática: funciona como nosso "banco de dados" na memória
    private static List<Quarto> quartos = new ArrayList<>();

    // Bloco estático para já iniciar o sistema com alguns quartos de teste (Mock)
    static {
        quartos.add(new Quarto(101, "Standard", 150.0));
        quartos.add(new Quarto(102, "Luxo", 280.0));
        quartos.add(new Quarto(201, "Suíte", 450.0));
    }

    // RF #01: Adiciona um novo quarto na lista
    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    // RF #06: Retorna todos os quartos para o Dashboard desenhar
    public List<Quarto> listarQuartos() {
        return quartos;
    }

    // RF #02: Busca o quarto pelo número e vincula o hóspede
    public void realizarCheckIn(int numeroQuarto, Hospede hospede, int dias) {
        for (Quarto q : quartos) {
            if (q.getNumero() == numeroQuarto) {
                q.setHospede(hospede);
                q.setDataEntrada(LocalDate.now());
                q.setNumeroDiarias(dias);
                q.setStatus(StatusQuarto.OCUPADO);
                break;
            }
        }
    }
}