package com.example.springjava.model;

import lombok.Data;

import java.util.List;

@Data
public class PaginationDTO<T> {
    private List<T> list;
    private int totalPage;
    private int currentPage;
    private int size;
    private long totalItem;
    private int totalItemPerPage;
    private boolean isPrevious;
    private boolean isNext;
}
