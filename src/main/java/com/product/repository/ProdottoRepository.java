package com.product.repository;

import org.springframework.stereotype.Repository;
import com.product.entity.Prodotto;
import java.util.List;
import java.util.ArrayList;

@Repository
public class ProdottoRepository {
    private final List<Prodotto> prodotti = new ArrayList<>();

    public void salva(Prodotto prodotto) {
        prodotti.add(prodotto);
    }

    public List<Prodotto> trovaTutti() {
        return new ArrayList<>(prodotti);
    }

    public List<Prodotto> trovaPerCategoria(String categoria) {
        return prodotti.stream()
                .filter(p -> p.getCategoria().equalsIgnoreCase(categoria))
                .toList();
    }

    public Prodotto trovaPerId (int id) {
        return prodotti.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
