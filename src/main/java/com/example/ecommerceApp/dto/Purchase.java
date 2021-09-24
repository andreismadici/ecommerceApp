package com.example.ecommerceApp.dto;

import com.example.ecommerceApp.entity.Address;
import com.example.ecommerceApp.entity.Customer;
import com.example.ecommerceApp.entity.Order;
import com.example.ecommerceApp.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems; //Works with JSON Array



}
