package com.example.springjava.constants;

public enum ReportExcelHeaderOrder {
    ORDER_ID("0", "Mã đơn hàng"),
    ORDER_NAME("2", "Tên đơn hàng"),
    ORDER_TYPE("3", "Loại đơn hàng"),
    ORDER_STATUS("4", "Trạng thái đơn hàng"),
    CREATED_DATE("5", "Ngày tạo đơn hàng"),
    MODIFIED_DATE("6", "Ngày sửa đổi"),
    AMOUNT("7", "Số tiền"),
    TOTAL_AMOUNT("8", "Tổng tiền"),
    PAYMENT_STATUS("9", "Trạng thái thanh toán");

    private final String columnIndex;
    private final String columnName;

    ReportExcelHeaderOrder(String index, String name) {
        this.columnIndex = index;
        this.columnName = name;
    }

    public String toString() {
        return columnIndex + "/" + columnName;
    }
}
