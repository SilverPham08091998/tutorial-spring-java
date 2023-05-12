package com.example.springjava.service.Impl;


import com.example.springjava.entity.AuthenciationEntity;
import com.example.springjava.entity.CategoryOrderEntity;
import com.example.springjava.entity.OrderDetailEntity;
import com.example.springjava.entity.OrderEntity;
import com.example.springjava.model.OrderDTO;
import com.example.springjava.model.OrderDetailDTO;
import com.example.springjava.model.ProductDTO;
import com.example.springjava.payload.request.OrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.respository.AuthenciationRepository;
import com.example.springjava.respository.CategoryOrderRepository;
import com.example.springjava.respository.OrderDetailRepository;
import com.example.springjava.respository.OrderRepository;
import com.example.springjava.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CategoryOrderRepository categoryOrderRepository;

    @Autowired
    AuthenciationRepository authenciationRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ApiResponse<String> createOrder(OrderPayload.CreateOrderPayload payload) {
        CategoryOrderEntity categoryOrderEntity = categoryOrderRepository.findCategoryOrderEntityByCategoryOrderId(payload.getCategoryOrderId());
        AuthenciationEntity authenciationEntity = authenciationRepository.findAuthenciationEntityByUserId(payload.getUserId());
        long sum = 0;
        OrderEntity order = new OrderEntity();
        order.setOrderName(payload.getOrderName());
        order.setOrderStatus(payload.getOrderStatus());
        order.setDiscount(payload.getDiscount());
        order.setPaymentStatus(payload.getPaymentStatus());
        order.setCategoryOrderEntity(categoryOrderEntity);
        order.setAuthenciationEntity(authenciationEntity);
        OrderEntity orderEntity = orderRepository.save(order);
        for (ProductDTO productDTO : payload.getProductDTOList()) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setAmount(productDTO.getAmount());
            orderDetailEntity.setQuantity(productDTO.getQuantity());
            orderDetailEntity.setProductId(productDTO.getProductId());
            orderDetailEntity.setProductStatus(productDTO.getProductStatus());
            orderDetailEntity.setProductName(productDTO.getProductName());
            orderDetailEntity.setProductType(productDTO.getProductType());
            orderDetailEntity.setOrderEntity(orderEntity);
            sum = sum + productDTO.getAmount();
            orderDetailRepository.save(orderDetailEntity);
        }
        orderEntity.setAmount(sum);
        orderEntity.setTotalAmount(sum - payload.getDiscount());
        orderEntity.setDiscount(payload.getDiscount());
        orderRepository.save(orderEntity);

        return new ApiResponse<>(true, 200, "success", "Order is created");

    }

    @Override
    public ApiResponse<List<OrderDTO>> getListOrder(String search, String userId) {
        List<OrderEntity> orderEntityList = orderRepository.findOrderEntitiesByAuthenciationEntity_UserId(userId);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityList) {
            OrderDTO orderDTO = modelMapper.map(orderEntity, OrderDTO.class);
            orderDTO.setOrderType(orderEntity.getCategoryOrderEntity().getCategoryOrderName());
            List<OrderDetailDTO> orderDetailDTOList = Arrays.asList(modelMapper.map(orderEntity.getOrderDetailEntities(), OrderDetailDTO[].class));
            orderDTO.setOrderDetailDTOList(orderDetailDTOList);
            orderDTOList.add(orderDTO);
        }
        return new ApiResponse<>(true, 200, "success", orderDTOList);
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
