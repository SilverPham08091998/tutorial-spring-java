package com.example.springjava.service;

import com.example.springjava.model.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    void insertProductsToOrderDetail();

    List<OrderDetailDTO> getProductsFromOrderDetail();
}
