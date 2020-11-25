package com.atlacademy.crm.repository;

import com.atlacademy.crm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findCustomerByPhoneNumber(String phoneNumber);
}
