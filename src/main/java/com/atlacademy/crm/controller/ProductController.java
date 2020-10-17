package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Product;
import com.atlacademy.crm.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    List<Product> products() {
        return productService.findAll();
    }
    @PostMapping("/api/products")
    Product newProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/api/product/{id}")
    Product singleProduct(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PutMapping("/api/product/{id}")
    Product updateProduct(@PathVariable Long id) {
        Product product = productService.getById(id);
        return productService.save(product);
    }

    @DeleteMapping("/api/product/{id}")
    void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
