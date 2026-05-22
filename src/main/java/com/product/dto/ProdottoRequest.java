package com.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdottoRequest {
    @NotBlank(message = "Il nome del prodotto è obbligatorio")
    private String nome;
    @Positive(message = "Il prezzo deve essere un numero positivo")
    private double prezzo;
    @NotNull(message = "La categoria del prodotto è obbligatoria")
    private Long categoriaId;

    public ProdottoRequest() {
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
