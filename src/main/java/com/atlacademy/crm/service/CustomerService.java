package com.atlacademy.crm.service;

import com.atlacademy.crm.entity.Customer;
import com.atlacademy.crm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer getById(Long id) {
        return customerRepository.getOne(id);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.delete(getById(id));
    }
}
