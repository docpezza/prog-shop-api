package com.product.dto;

import com.product.entity.Prodotto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProdottoRequest {
    @NotBlank(message = "Il nome del prodotto è obbligatorio")
    private String nome;
    @Positive(message = "Il prezzo deve essere un numero positivo")
    private double prezzo;
    @NotBlank(message = "La categoria del prodotto è obbligatoria")
    private String categoria;

    public ProdottoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Prodotto toProdotto() {
    return new Prodotto(
        0,
        this.nome,
        this.prezzo,
        this.categoria
    );
    }
}
