package com.hotel.model;

import java.time.LocalDate;

public class Quarto {
    private int numero;
    private String categoria;
    private double valorDiaria;
    private StatusQuarto status;

    // Atributos preenchidos no Check-in (RF #02)
    private Hospede hospede;
    private LocalDate dataEntrada;
    private int numeroDiarias;

    public Quarto(int numero, String categoria, double valorDiaria) {
        this.numero = numero;
        this.categoria = categoria;
        this.valorDiaria = valorDiaria;
        this.status = StatusQuarto.VAGO; // Todo quarto nasce vago
    }

    // Getters e Setters
    public int getNumero() { return numero; }
    public String getCategoria() { return categoria; }
    public double getValorDiaria() { return valorDiaria; }
    public StatusQuarto getStatus() { return status; }
    public void setStatus(StatusQuarto status) { this.status = status; }

    public Hospede getHospede() { return hospede; }
    public void setHospede(Hospede hospede) { this.hospede = hospede; }

    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

    public int getNumeroDiarias() { return numeroDiarias; }
    public void setNumeroDiarias(int numeroDiarias) { this.numeroDiarias = numeroDiarias; }
}