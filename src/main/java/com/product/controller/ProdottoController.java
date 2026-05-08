package com.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.product.service.ProdottoService;
import com.product.entity.Prodotto;
import com.product.exception.ProdottoNonTrovatoException;
import com.product.repository.ProdottoRepository;
import com.product.dto.ProdottoRequest;
import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {
    private final ProdottoService service;
    private final ProdottoRepository repository;

    public ProdottoController(ProdottoService service, ProdottoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public List<Prodotto> getAllProdotti() {
        return service.getTuttiProdotti();
    }

    @GetMapping("/categoria/{categoria}")
    public List<Prodotto> getProdottoPerCategoria(@PathVariable String categoria) {
        return service.getProdottiPerCategoria(categoria);
    }

    @GetMapping("/{id}")
    public Prodotto getProdottoPerId(int id) {
    Prodotto prodotto = repository.trovaPerId(id);

    if (prodotto == null) {
        throw new ProdottoNonTrovatoException("Prodotto con id " + id + " non trovato");
    }

    return prodotto;
}

    @PostMapping
    public ResponseEntity<String> aggiungiProdotto(@Valid @RequestBody ProdottoRequest request) {
    service.aggiungiProdotto(request.toProdotto());
    return ResponseEntity.status(201).body("Prodotto aggiunto correttamente");
    }
}
