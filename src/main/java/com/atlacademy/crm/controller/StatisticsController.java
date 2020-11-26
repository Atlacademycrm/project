package com.atlacademy.crm.controller;

import com.atlacademy.crm.response.BaseResponse;
import com.atlacademy.crm.service.CustomerService;
import com.atlacademy.crm.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {
    private CustomerService customerService;
    private ProductService productService;

    public StatisticsController(CustomerService customerService, ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    @GetMapping(name = "customer_count")
    public BaseResponse customerCount() {
        HashMap<String, Long> count = new HashMap<>();
        count.put("count", customerService.getCustomersCount());
        return new BaseResponse(count);
    }

    @GetMapping(name = "product_count")
    public BaseResponse productCount() {
        HashMap<String, Long> count = new HashMap<>();
        count.put("count", productService.getProductsCount());
        return new BaseResponse(count);
    }
}
