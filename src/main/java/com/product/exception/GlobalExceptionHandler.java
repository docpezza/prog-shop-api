package com.product.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<String> handleProdottoNonTrovato(ProdottoNonTrovatoException ex) {
        return ResponseEntity.status(404).body(ex.getMessage());
    }
}
