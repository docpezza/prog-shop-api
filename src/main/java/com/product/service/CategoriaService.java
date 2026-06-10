package com.product.service;

import com.product.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import com.product.dto.CategoriaRequest;
import com.product.entity.Categoria;
import com.product.exception.CategoriaNonTrovataException;

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
                .orElseThrow(() -> new CategoriaNonTrovataException("Categoria non trovata con id: " + id));
    }

    public Categoria updateCategoria(Long id, CategoriaRequest request){
        Categoria categoria = getCategoriaPerId(id);
        categoria.setNome(request.getNome());
        return repository.save(categoria);
    }

    public void eliminaCategoria(Long id) {
        Categoria categoria = getCategoriaPerId(id);
        repository.delete(categoria);
    }
}
