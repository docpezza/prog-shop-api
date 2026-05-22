package com.product.dto;

public class ProdottoResponse {
    private Long id;
    private String nome;
    private double prezzo;
    private String categoriaNome;

    public ProdottoResponse(Long id, String nome, double prezzo, String categoriaNome) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoriaNome = categoriaNome;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public String getCategoriaNome() {
        return categoriaNome;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

}
