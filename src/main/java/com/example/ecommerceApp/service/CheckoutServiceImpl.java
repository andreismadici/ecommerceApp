package com.example.ecommerceApp.service;

import com.example.ecommerceApp.dao.CustomerRepository;
import com.example.ecommerceApp.dto.Purchase;
import com.example.ecommerceApp.dto.PurchaseResponse;
import com.example.ecommerceApp.entity.Customer;
import com.example.ecommerceApp.entity.Order;
import com.example.ecommerceApp.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }


    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrive the order info from dto
        Order order = purchase.getOrder();
        //generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        //populate order with billingAddress and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        //populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);
        //save to database
        customerRepository.save(customer);
        //return response

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        //generate a random UUID number (UUID version -4)
        return UUID.randomUUID().toString();

    }
}
