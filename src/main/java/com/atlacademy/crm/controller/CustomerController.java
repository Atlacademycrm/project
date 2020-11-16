package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Customer;
import com.atlacademy.crm.response.BaseResponse;
import com.atlacademy.crm.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    BaseResponse customers() {
        return new BaseResponse(customerService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BaseResponse newCustomer(@RequestBody Customer customer) {
        log.info(customer.toString());
        return new BaseResponse(customerService.save(customer));
    }

    @GetMapping("/{id}")
    BaseResponse singleCustomer(@PathVariable Long id) {
        return new BaseResponse(customerService.getById(id));
    }

    @PutMapping("/{id}")
    BaseResponse updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return new BaseResponse(customerService.updateById(id, customer));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/size")
    BaseResponse customerSize() {
        return new BaseResponse(customerService.getCustomersCount());
    }
}
