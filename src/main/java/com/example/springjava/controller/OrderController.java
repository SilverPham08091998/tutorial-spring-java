package com.example.springjava.controller;

import com.example.springjava.model.OrderDTO;
import com.example.springjava.payload.request.OrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/list-order/{userId}")
    public ResponseEntity<ApiResponse<List<OrderDTO>>> getListOrder(
            @PathVariable(value = "userId") String userId,
            @RequestParam(name = "search", required = false) String search
    ) {
        try {
            return ResponseEntity.ok(orderService.getListOrder(search, userId));
        } catch (Exception e) {
            throw e;
        }
    }

}
