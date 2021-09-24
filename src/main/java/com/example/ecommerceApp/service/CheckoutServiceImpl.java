package com.example.ecommerceApp.service;

import com.example.ecommerceApp.dao.CustomerRepository;
import com.example.ecommerceApp.dto.Purchase;
import com.example.ecommerceApp.dto.PurchaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        return null;
    }
}
