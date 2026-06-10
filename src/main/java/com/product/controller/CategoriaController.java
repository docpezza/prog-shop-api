package com.product.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.product.service.CategoriaService;
import com.product.entity.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.product.dto.CategoriaRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import com.product.dto.CategoriaResponse;

@RestController
@RequestMapping("/categorie")
public class CategoriaController {

    private CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> getTutteCategorie() {
        return ResponseEntity.ok(service.getTutteCategorie().stream()
                .map(this::convertToResponse)
                .collect(java.util.stream.Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> getCategoriaPerId(@PathVariable Long id) {
        Categoria categoria = service.getCategoriaPerId(id);
        return ResponseEntity.ok(convertToResponse(categoria));
    }

    @PostMapping
    public ResponseEntity<String> creaCategoria(@Valid @RequestBody CategoriaRequest request) {
        service.creaCategoria(request.getNome());
        return ResponseEntity.status(201).body("Categoria creata correttamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> updateCategoria(@PathVariable Long id, @Valid @RequestBody CategoriaRequest request) {
        Categoria categoriaAggiornata = service.updateCategoria(id, request);
        return ResponseEntity.ok(convertToResponse(categoriaAggiornata));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        service.eliminaCategoria(id);
        return ResponseEntity.noContent().build();
    }

    private CategoriaResponse convertToResponse(Categoria categoria) {
        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }
}
