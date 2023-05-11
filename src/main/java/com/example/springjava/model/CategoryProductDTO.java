package com.example.springjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryProductDTO {

    private String categoryProductId;

    private String categoryProductName;

    private String categoryProductStatus;

    private Date createDate;

    private Date modifiedDate;
}
