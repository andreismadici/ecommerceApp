package com.example.ecommerceApp.dao;

import com.example.ecommerceApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
