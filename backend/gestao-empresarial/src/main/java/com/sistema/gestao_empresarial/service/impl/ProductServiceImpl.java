package com.sistema.gestao_empresarial.service.impl;

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
        if (product.getId() == null){
            productRepository.findByBarcode(product.getBarcode()).ifPresent(p ->{ throw new RuntimeException("Já existe um produto com este código de barras")});

        }
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void delete(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteById(Long Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public Product calculateSellingPrice(Product product) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateSellingPrice'");
    }

    @Override
    public Optional<Product> findByBarcode(String barcode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByBarcode'");
    }

    @Override
    public List<Product> findByNameContainingIgnoreCase(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNameContainingIgnoreCase'");
    }

    @Override
    public List<Product> findByActiveTrue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByActiveTrue'");
    }

    @Override
    public List<Product> findByStockLessThenEqual(Integer quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByStockLessThenEqual'");
    }

}
