package com.example.springjava.controller;

import com.example.springjava.model.OrderFilter;
import com.example.springjava.payload.request.OrderPayload;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    private final Logger logger = LogManager.getLogger(OrderController.class);


    @Autowired
    OrderService orderService;

    @PostMapping(value = "/create-order")
    public ResponseEntity<?> createOrder(@RequestBody OrderPayload.CreateOrderPayload payload) {
        try {
            return ResponseEntity.ok(orderService.createOrder(payload));

        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }

    @GetMapping(value = "/list-order/{userId}")
    public ResponseEntity<ApiResponse<?>> getListOrder(
            @PathVariable(value = "userId") String userId,
            @RequestParam(name = "sort", defaultValue = "desc", required = false) String sort,
            @RequestParam(name = "field", defaultValue = "createDate", required = false) String field,
            @RequestParam(name = "orderName", defaultValue = "", required = false) String orderName,
            @RequestParam(name = "orderType", defaultValue = "", required = false) String orderType,
            @RequestParam(name = "amount", required = false) Integer amount,
            @RequestParam(name = "totalAmount", required = false) Integer totalAmount,
            @RequestParam(name = "orderId", defaultValue = "", required = false) String orderId,
            @RequestParam(name = "modifiedDate", required = false) String modifiedDate,
            @RequestParam(name = "createDate", required = false) String createDate,
            @RequestParam(name = "paymentStatus", defaultValue = "", required = false) String paymentStatus,
            @RequestParam(name = "orderStatus", defaultValue = "", required = false) String orderStatus,
            @RequestParam(name = "size", defaultValue = "10", required = false) Integer size,
            @RequestParam(name = "page", defaultValue = "1", required = false) Integer page
    ) {
        try {
            OrderFilter orderFilter = OrderFilter
                    .builder()
                    .userId(userId)
                    .orderId(orderId)
                    .orderName(orderName)
                    .orderType(orderType)
                    .orderStatus(orderStatus)
                    .modifiedDate(modifiedDate)
                    .createDate(createDate)
                    .amount(amount)
                    .totalAmount(totalAmount)
                    .paymentStatus(paymentStatus)
                    .build();
            Sort sortable;
            if ("asc".equals(sort)) {
                sortable = Sort.by(Sort.Order.asc(field));
            } else {
                sortable = Sort.by(Sort.Order.desc(field));
            }
            Pageable pageable = PageRequest.of(page - 1, size, sortable);
            return ResponseEntity.ok(new ApiResponse<>(
                    true,
                    200,
                    "success",
                    orderService.getListOrder(orderFilter, pageable)));
        } catch (Exception e) {
            logger.error(e);
            throw e;
        }
    }

}
