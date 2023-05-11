package com.example.springjava.service.Impl;


import com.example.springjava.entity.OrderEntity;
import com.example.springjava.model.OrderDTO;
import com.example.springjava.payload.request.OrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.respository.OrderRepository;
import com.example.springjava.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ApiResponse<String> createOrder(OrderPayload.CreateOrderPayload payload) {
        OrderEntity order = new OrderEntity();
        
        return null;
    }

    @Override
    public ApiResponse<List<OrderDTO>> getListOrder(String search) {
        return null;
    }

    @Override
    public void updateOrder() {

    }

    @Override
    public void deleteOrder(String orderId) {

    }

    @Override
    public void paymentOrder(String orderId) {

    }

    @Override
    public void updatePaymentStatus() {

    }

    @Override
    public void updateProgressOrder() {

    }

    @Override
    public void updateProductForOrder() {

    }

    @Override
    public void updateTypeForOrder() {

    }
}
