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

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteById(Long id) {
        customerRepository.delete(getById(id));
    }

    public Customer updateById(Long id, Customer customer) {
        customerRepository.getOne(id);
        customer.setId(id);
        return customerRepository.save(customer);
    }

    public long getCustomersCount() {
        return customerRepository.count();
    }
}
