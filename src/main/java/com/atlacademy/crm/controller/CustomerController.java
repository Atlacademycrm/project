package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Customer;
import com.atlacademy.crm.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    List<Customer> customers() {
        return customerService.findAll();
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        return customerService.save(customer);
    }

    @GetMapping("/customer/{id}")
    Customer singleCustomer(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PutMapping("/customer/{id}")
    Customer updateCustomer(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        return customerService.save(customer);
    }

    @DeleteMapping("/customer/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }
}
