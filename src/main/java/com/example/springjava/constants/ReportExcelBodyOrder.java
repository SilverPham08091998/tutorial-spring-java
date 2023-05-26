package com.example.springjava.constants;

public enum ReportExcelBodyOrder {
    STT("0", "Số thứ tự"),
    ORDER_DETAIL_ID("1", "Mã thông tin đơn"),
    PRODUCT_ID("2", "Mã sản phẩm"),
    PRODUCT_NAME("3", "Tên sản phẩm"),
    PRODUCT_TYPE("4", "Loại sản phẩm"),
    PRODUCT_STATUS("5", "Trạng thái"),
    AMOUNT("6", "Giá tiền"),
    QUANTITY("7", "Số lượng");

    private final String columnIndex;
    private final String columnName;

    ReportExcelBodyOrder(String index, String name) {
        this.columnIndex = index;
        this.columnName = name;
    }

    public String toString() {
        return columnIndex + "/" + columnName;
    }
}
