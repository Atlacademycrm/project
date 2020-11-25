package com.atlacademy.crm.controller;

import com.atlacademy.crm.entity.Customer;
import com.atlacademy.crm.response.BaseResponse;
import com.atlacademy.crm.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping(value = "/api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public BaseResponse customers() {
        return new BaseResponse(customerService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponse newCustomer(@RequestBody Customer customer) {
        log.info(customer.toString());
        return new BaseResponse(customerService.save(customer));
    }

    @GetMapping("/{id}")
    public BaseResponse singleCustomer(@PathVariable Long id) {
        return new BaseResponse(customerService.getById(id));
    }

    @PutMapping("/{id}")
    public BaseResponse updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return new BaseResponse(customerService.updateById(id, customer));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteById(id);
    }

    @GetMapping("/check")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse checkCustomer(@RequestParam String phoneNumber) {
        log.info(phoneNumber);
        Customer customer;
        try {
            customer = customerService.searchByPhoneNumber(phoneNumber);
            return new BaseResponse(customer);
        } catch (Exception exception) {
            return new BaseResponse(203, "Phone number not found!");
        }
    }

    @GetMapping("/size")
    BaseResponse customerSize() {
        return new BaseResponse(customerService.getCustomersCount());
    }
}
