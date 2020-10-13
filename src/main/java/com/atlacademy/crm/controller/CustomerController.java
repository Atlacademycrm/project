package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Customer;
import com.atlacademy.crm.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/api/customers")
    List<Customer> customers() {
        return customerService.findAll();
    }

    @PostMapping("/api/customers")
    Customer newCustomer(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/api/customer/{id}")
    Customer singleCustomer(@PathVariable Long id) {
        return customerService.getById(id);
    }

    @PutMapping("/api/customer/{id}")
    Customer updateCustomer(@PathVariable Long id) {
        Customer customer = customerService.getById(id);
        return customerService.saveCustomer(customer);
    }

    @DeleteMapping("/api/customer/{id}")
    void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
    }
}
