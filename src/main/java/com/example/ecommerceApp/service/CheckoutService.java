package com.example.ecommerceApp.service;

import com.example.ecommerceApp.dto.Purchase;
import com.example.ecommerceApp.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
