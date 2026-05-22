package com.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prodotti")
public class Prodotto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double prezzo;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public Prodotto() {
    }

    public Prodotto( String nome, double prezzo, Categoria categoria) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
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

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}