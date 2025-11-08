package com.sistema.gestao_empresarial.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.gestao_empresarial.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByBarcode(String barcode);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByActiveTrue();

    List<Product> findByStockLessThenEqual(Integer quantity);
}
