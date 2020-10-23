package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Product;
import com.atlacademy.crm.response.BaseResponse;
import com.atlacademy.crm.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    BaseResponse products() {
        return new BaseResponse(productService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BaseResponse newProduct(@RequestBody Product product) {
        log.info(product.toString());
        return new BaseResponse(productService.save(product));
    }

    @GetMapping("/{id}")
    BaseResponse singleProduct(@PathVariable Long id) {
        return new BaseResponse(productService.getById(id));
    }

    @PutMapping("/{id}")
    BaseResponse updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return new BaseResponse(productService.updateById(id, product));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
