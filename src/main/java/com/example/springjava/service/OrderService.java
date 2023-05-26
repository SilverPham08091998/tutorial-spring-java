package com.example.springjava.service;

import com.example.springjava.model.OrderDTO;
import com.example.springjava.model.OrderFilter;
import com.example.springjava.model.PaginationDTO;
import com.example.springjava.payload.request.OrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface OrderService {

    ApiResponse<String> createOrder(OrderPayload.CreateOrderPayload payload);

    List<OrderDTO> getListOrder(String search, String userId);

    PaginationDTO<OrderDTO> getListOrder(OrderFilter filter, Pageable pageable);


    void updateOrder();

    void deleteOrder(String orderId);

    void paymentOrder(String orderId);

    void updatePaymentStatus();

    void updateProgressOrder();

    void updateProductForOrder();

    void updateTypeForOrder();


}
