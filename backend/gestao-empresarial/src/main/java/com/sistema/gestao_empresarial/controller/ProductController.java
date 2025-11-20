package com.sistema.gestao_empresarial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import com.sistema.gestao_empresarial.entity.Product;
import com.sistema.gestao_empresarial.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll() {
        return productService.findAll();
    }
    
}
