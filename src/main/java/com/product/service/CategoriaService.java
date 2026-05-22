package com.product.service;

import com.product.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import com.product.entity.Categoria;
import java.util.List;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    public Categoria creaCategoria(String nome) {
        Categoria categoria = new Categoria(nome);
        return repository.save(categoria);
    }

    public List<Categoria> getTutteCategorie() {
        return repository.findAll();
    }

    public Categoria getCategoriaPerId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria non trovata con id: " + id));
    }
}
