package com.atlacademy.crm.service;

import com.atlacademy.crm.entity.Product;
import com.atlacademy.crm.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.getOne(id);
    }

    public Product saveProduct(Product Product) {
        return productRepository.save(Product);
    }

    public void deleteProductById(Long id) {
        productRepository.delete(getById(id));
    }
}
