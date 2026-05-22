package com.product.service;

import org.springframework.stereotype.Service;
import com.product.repository.ProdottoRepository;
import com.product.repository.CategoriaRepository;
import com.product.entity.Prodotto;
import com.product.entity.Categoria;
import com.product.exception.ProdottoNonTrovatoException;
import com.product.dto.ProdottoRequest;

import java.util.List;

@Service
public class ProdottoService {

    private final ProdottoRepository repository;
    private final CategoriaRepository categoriaRepository;

    public ProdottoService(ProdottoRepository repository, CategoriaRepository categoriaRepository) {
        this.repository = repository;
        this.categoriaRepository = categoriaRepository;
    }

    public Prodotto aggiungiProdotto(ProdottoRequest request) {
        Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria non trovata"));

        Prodotto prodotto = new Prodotto(
                request.getNome(),
                request.getPrezzo(),
                categoria
        );

        return repository.save(prodotto);
    }

    public List<Prodotto> getTuttiProdotti() {
        return repository.findAll();
    }

    public Prodotto getProdottoPerId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProdottoNonTrovatoException("Prodotto non trovato con id: " + id));
    }

    public Prodotto updateProdotto(Long id, ProdottoRequest request) {
        Prodotto prodottoEsistente = getProdottoPerId(id);

        Categoria categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria non trovata"));

        prodottoEsistente.setNome(request.getNome());
        prodottoEsistente.setPrezzo(request.getPrezzo());
        prodottoEsistente.setCategoria(categoria);

        return repository.save(prodottoEsistente);
    }

    public void deleteProdotto(Long id) {
        Prodotto prodotto = getProdottoPerId(id);
        repository.delete(prodotto);
    }

    public List<Prodotto> getProdottiPerCategoria(Long categoriaId) {
        return repository.findByCategoriaId(categoriaId);
    }
}