package com.product.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProdottoNonTrovatoException.class)
    public ResponseEntity<ErrorResponse> handleProdottoNonTrovato(ProdottoNonTrovatoException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), 404);
        return ResponseEntity.status(404).body(errorResponse);
    }

    @ExceptionHandler(CategoriaNonTrovataException.class)
    public ResponseEntity<ErrorResponse> handleCategoriaNonTrovata(CategoriaNonTrovataException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), 404);
        return ResponseEntity.status(404).body(errorResponse);
    }
}
