package com.example.springjava.service.Impl;


import com.example.springjava.model.OrderDTO;
import com.example.springjava.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Override
    public void createOrder(OrderDTO orderDTO) {

    }

    @Override
    public List<OrderDTO> getListOrder(String search) {
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
