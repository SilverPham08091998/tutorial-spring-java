package com.example.springjava.service.Impl;


import com.example.springjava.entity.AuthenciationEntity;
import com.example.springjava.entity.CategoryEntity;
import com.example.springjava.entity.OrderDetailEntity;
import com.example.springjava.entity.OrderEntity;
import com.example.springjava.model.*;
import com.example.springjava.payload.request.OrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.respository.AuthenciationRepository;
import com.example.springjava.respository.CategoryRepository;
import com.example.springjava.respository.OrderDetailRepository;
import com.example.springjava.respository.OrderRepository;
import com.example.springjava.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CategoryRepository categoryOrderRepository;

    @Autowired
    AuthenciationRepository authenciationRepository;

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ApiResponse<String> createOrder(OrderPayload.CreateOrderPayload payload) {
        CategoryEntity categoryEntity = categoryOrderRepository.findCategoryEntitiesByCategoryId(Long.parseLong(payload.getCategoryOrderId()));
        AuthenciationEntity authenciationEntity = authenciationRepository.findAuthenciationEntityByUserId(payload.getUserId());
        long sum = 0;
        OrderEntity order = new OrderEntity();
        order.setOrderName(payload.getOrderName());
        order.setOrderStatus(payload.getOrderStatus());
        order.setDiscount(payload.getDiscount());
        order.setPaymentStatus(payload.getPaymentStatus());
        OrderEntity orderEntity = orderRepository.save(order);
        for (ProductDTO productDTO : payload.getProductDTOList()) {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setAmount(productDTO.getAmount());
            orderDetailEntity.setQuantity(productDTO.getQuantity());
            orderDetailEntity.setProductId(productDTO.getProductId());
            orderDetailEntity.setProductStatus(productDTO.getProductStatus());
            orderDetailEntity.setProductName(productDTO.getProductName());
            orderDetailEntity.setProductType(productDTO.getProductType());
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
    public List<OrderDTO> getListOrder(String search, String userId) {
        List<OrderEntity> orderEntityList = orderRepository.findOrderEntitiesByOrderId(userId);
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityList) {
            OrderDTO orderDTO = modelMapper.map(orderEntity, OrderDTO.class);
            orderDTO.setOrderType("");
            orderDTOList.add(orderDTO);
        }
        return orderDTOList;
    }

    @Override
    public PaginationDTO<OrderDTO> getListOrder(OrderFilter orderFilter, Pageable pageable) {

        Specification<OrderEntity> specification = new OrderSpecification(orderFilter);

        Page<OrderEntity> orderEntityPage = orderRepository.findAll(specification, pageable);

        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (OrderEntity orderEntity : orderEntityPage.getContent()) {
            OrderDTO orderDTO = modelMapper.map(orderEntity, OrderDTO.class);
//            orderDTO.setOrderType(orderEntity.getCategoryEntity().getCategoryOrderName());
//            List<OrderDetailDTO> orderDetailDTOList = Arrays.asList(modelMapper.map(orderEntity.getOrderDetailEntities(), OrderDetailDTO[].class));
//            orderDTO.setOrderDetailDTOList(orderDetailDTOList);
            orderDTOList.add(orderDTO);
        }
        PaginationDTO<OrderDTO> orderDTOPaginationDTO = new PaginationDTO<>();
        orderDTOPaginationDTO.setSize(orderEntityPage.getSize());
        orderDTOPaginationDTO.setList(orderDTOList);
        orderDTOPaginationDTO.setTotalPage(orderEntityPage.getTotalPages());
        orderDTOPaginationDTO.setCurrentPage(pageable.getPageNumber() + 1);
        orderDTOPaginationDTO.setNext(orderEntityPage.hasNext());
        orderDTOPaginationDTO.setPrevious(orderEntityPage.hasPrevious());
        orderDTOPaginationDTO.setTotalItem(orderEntityPage.getTotalElements());
        orderDTOPaginationDTO.setTotalItemPerPage(orderEntityPage.getNumberOfElements());
        return orderDTOPaginationDTO;
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
