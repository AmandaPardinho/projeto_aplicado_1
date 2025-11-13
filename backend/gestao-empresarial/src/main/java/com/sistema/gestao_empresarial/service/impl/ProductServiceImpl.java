package com.sistema.gestao_empresarial.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import com.sistema.gestao_empresarial.entity.Product;
import com.sistema.gestao_empresarial.service.ProductService;
import com.sistema.gestao_empresarial.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        if (product.getId() == null) {
            productRepository.findByBarcode(product.getBarcode())
                    .ifPresent(p -> {
                        throw new RuntimeException("Já existe um produto com este código de barras");
                    });

        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product calculateSellingPrice(Product product, BigDecimal profit) {
        if (profit.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("A margem de lucro não pode ser negativa");
        }

        if (product.getPurchasePrice() == null) {
            throw new IllegalArgumentException("O preço de compra não pode ser nulo");
        }

        BigDecimal sellingPrice = product.getPurchasePrice()
                .multiply(BigDecimal.ONE.add(profit));
        product.setSellingPrice(sellingPrice);
        return product;
    }

    @Override
    public Optional<Product> findByBarcode(String barcode) {
        return productRepository.findByBarcode(barcode);
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Product> findByActiveTrue() {
        return productRepository.findByActiveTrue();
    }

    @Override
    public List<Product> findByStockLessThenEqual(Integer quantity) {
        return productRepository.findByStockLessThenEqual(quantity);
    }

}
