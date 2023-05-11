package com.example.springjava.controller;

import com.example.springjava.payload.request.OrderPayload;
import com.example.springjava.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "/create-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderPayload.CreateOrderPayload payload) {
        try {
            return ResponseEntity.ok(orderService.createOrder(payload));

        } catch (Exception e) {
            throw e;
        }

    }

}
