package com.product.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank(message = "Il nome della categoria è obbligatorio")
    private String nome;

    public CategoriaRequest() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
