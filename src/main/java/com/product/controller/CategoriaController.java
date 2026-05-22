package com.product.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.product.service.CategoriaService;
import com.product.entity.Categoria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.product.dto.CategoriaRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorie")
public class CategoriaController {

    private CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Categoria> getTutteCategorie() {
        return service.getTutteCategorie();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaPerId(@PathVariable Long id) {
        Categoria categoria = service.getCategoriaPerId(id);
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<String> creaCategoria(@Valid @RequestBody CategoriaRequest request) {
        service.creaCategoria(request.getNome());
        return ResponseEntity.status(201).body("Categoria creata correttamente");
    }
}
