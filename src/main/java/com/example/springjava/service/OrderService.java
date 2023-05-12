package com.example.springjava.service;

import com.example.springjava.model.OrderDTO;
import com.example.springjava.payload.request.OrderPayload;
import com.example.springjava.payload.response.ApiResponse;

import java.util.List;

public interface OrderService {

    ApiResponse<String> createOrder(OrderPayload.CreateOrderPayload payload);

    ApiResponse<List<OrderDTO>> getListOrder(String search , String userId);

    void updateOrder();

    void deleteOrder(String orderId);

    void paymentOrder(String orderId);

    void updatePaymentStatus();

    void updateProgressOrder();

    void updateProductForOrder();

    void updateTypeForOrder();


}
