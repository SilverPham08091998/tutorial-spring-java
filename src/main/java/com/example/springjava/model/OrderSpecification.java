package com.example.springjava.model;

import com.example.springjava.entity.AuthenciationEntity;
import com.example.springjava.entity.OrderEntity;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderSpecification implements Specification<OrderEntity> {

    private final OrderFilter orderFilter;

    public OrderSpecification(OrderFilter orderFilter) {
        this.orderFilter = orderFilter;
    }

    @Override
    public Specification<OrderEntity> and(Specification<OrderEntity> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<OrderEntity> or(Specification<OrderEntity> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<OrderEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Join<OrderEntity, AuthenciationEntity> join = root.join("authenciationEntity");
        if (!orderFilter.getUserId().isEmpty()) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(join.get("userId"), orderFilter.getUserId())));
        }
        if (!orderFilter.getOrderName().isEmpty()) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("orderName"), "%" + orderFilter.getOrderName() + "%")));
        }
        if (!orderFilter.getOrderStatus().isEmpty()) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("orderStatus"), orderFilter.getOrderStatus())));
        }
        if (!orderFilter.getOrderType().isEmpty()) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("orderType"), orderFilter.getOrderType())));
        }
        if (orderFilter.getAmount() != null && orderFilter.getAmount() != 0) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get("amount"), 0, orderFilter.getAmount())));
        }
        if (orderFilter.getTotalAmount() != null && orderFilter.getTotalAmount() != 0) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.between(root.get("totalAmount"), 0, orderFilter.getTotalAmount())));
        }

        if (!orderFilter.getPaymentStatus().isEmpty()) {
            predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("paymentStatus"), orderFilter.getPaymentStatus())));
        }

        if (orderFilter.getCreateDate() != null) {
            try {
                java.util.Date createdDate = dateFormat.parse(orderFilter.getCreateDate());
                java.sql.Date sqlDate = new Date(createdDate.getTime());
                Expression<Date> expressionCreateDateTrunc = criteriaBuilder.function("DATE", Date.class, root.get("createDate"));
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(expressionCreateDateTrunc, sqlDate)));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        if (orderFilter.getModifiedDate() != null) {
            try {
                java.util.Date modifiedDate = dateFormat.parse(orderFilter.getCreateDate());
                java.sql.Date sqlDate = new Date(modifiedDate.getTime());
                Expression<Date> expressionModifiedDateTrunc = criteriaBuilder.function("TRUNC", java.sql.Date.class, root.<java.util.Date>get("modifiedDate"));
                predicates.add(criteriaBuilder.and(criteriaBuilder.equal(expressionModifiedDateTrunc, sqlDate)));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
