package com.example.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryOrderDTO {
    private String categoryOrderId;

    private String categoryOrderName;

    private String categoryOrderStatus;

    private Date createDate;

    private Date modifiedDate;
}
