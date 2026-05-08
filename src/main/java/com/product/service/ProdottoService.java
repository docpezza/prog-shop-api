package com.product.service;

import org.springframework.stereotype.Service;
import com.product.repository.ProdottoRepository;
import com.product.entity.Prodotto;
import java.util.List;

@Service
public class ProdottoService {
    private final ProdottoRepository repository;

    public ProdottoService(ProdottoRepository repository) {
        this.repository = repository;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        repository.salva(prodotto);
    }

    public List<Prodotto> getTuttiProdotti() {
        return repository.trovaTutti();
    }

    public List<Prodotto> getProdottiPerCategoria(String categoria) {
        return repository.trovaPerCategoria(categoria);
    }

    public Prodotto getProdottoPerId (int id) {
        return repository.trovaPerId(id);
    }
}
