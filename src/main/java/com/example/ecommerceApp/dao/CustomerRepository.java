package com.example.ecommerceApp.dao;

import com.example.ecommerceApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,  Long> {

}
