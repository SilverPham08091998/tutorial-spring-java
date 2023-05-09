package com.example.springjava.service;

import com.example.springjava.model.OrderDTO;

import java.util.List;

public interface OrderService {

    void createOrder(OrderDTO orderDTO);

    List<OrderDTO> getListOrder(String search);

    void updateOrder();

    void deleteOrder(String orderId);

    void paymentOrder(String orderId);

    void updatePaymentStatus();

    void updateProgressOrder();

    void updateProductForOrder();

    void updateTypeForOrder();


}
