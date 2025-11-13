package com.sistema.gestao_empresarial.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.sistema.gestao_empresarial.entity.Product;

public interface ProductService {

    Optional<Product> findById(Long id);

    Product save(Product product);

    List<Product> findAll();

    void delete(Product product);

    void deleteById(Long id);

    Product calculateSellingPrice(Product product, BigDecimal profit);

    Optional<Product> findByBarcode(String barcode);

    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByActiveTrue();

    List<Product> findByStockLessThenEqual(Integer quantity);
}
