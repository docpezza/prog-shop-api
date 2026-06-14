package com.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.product.service.ProdottoService;
import com.product.entity.Prodotto;
import com.product.dto.ProdottoRequest;
import com.product.dto.ProdottoResponse;

import java.util.List;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/prodotti")
public class ProdottoController {
    private final ProdottoService service;

    public ProdottoController(ProdottoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProdottoResponse>> getAllProdotti() {
        return ResponseEntity.ok(service.getTuttiProdotti().stream()
                .map(this::convertToResponse)
                .toList());
    }

    @GetMapping("/{id}")
        public ResponseEntity<ProdottoResponse> getProdottoPerId(@PathVariable Long id) {
        Prodotto prodotto = service.getProdottoPerId(id);
        ProdottoResponse response = convertToResponse(prodotto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categoria/{categoriaId}")
    public ResponseEntity<List<ProdottoResponse>> getProdottiPerCategoria(@PathVariable Long categoriaId) {
        return ResponseEntity.ok(service.getProdottiPerCategoria(categoriaId).stream()
                .map(this::convertToResponse)
                .toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdottoResponse> updateProdotto(@PathVariable Long id, @Valid @RequestBody ProdottoRequest request) {
        Prodotto prodottoAggiornato = service.updateProdotto(id, request);
        return ResponseEntity.ok(convertToResponse(prodottoAggiornato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProdotto(@PathVariable Long id) {
        service.deleteProdotto(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping
    public ResponseEntity<ProdottoResponse> aggiungiProdotto(@Valid @RequestBody ProdottoRequest request) {
    Prodotto prodotto = service.aggiungiProdotto(request);
    return ResponseEntity.status(201).body(convertToResponse(prodotto));
    }

    private ProdottoResponse convertToResponse(Prodotto prodotto) {
        return new ProdottoResponse(
                prodotto.getId(),
                prodotto.getNome(),
                prodotto.getPrezzo(),
                prodotto.getCategoria().getNome()
        );
    }
}
