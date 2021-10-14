package com.example.ecommerceApp.controller;


import com.example.ecommerceApp.apiEntity.Quote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/quote")

public class QuoteController {


    @GetMapping
    public ResponseEntity getQuote(RestTemplate restTemplate) {
        Quote quote = restTemplate.getForObject(
                "https://quoters.apps.pcfone.io/api/random", Quote.class);

        return ResponseEntity.ok(quote.getValue());
    }
}
