package com.product.repository;

import com.product.entity.Prodotto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdottoRepository extends JpaRepository<Prodotto, Long> {

        List<Prodotto> findByCategoriaId(Long categoriaId);
}