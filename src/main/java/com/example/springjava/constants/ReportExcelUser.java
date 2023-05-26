package com.example.springjava.constants;

public enum ReportExcelUser {
    STT("0", "Số thứ tự"),
    NAME("1", "Tên"),
    AGE("2", "Tuổi"),
    ADDRESS("3", "Địa chỉ"),
    RELATION("4", "Mối quan hệ"),
    JOB("5", "Công việc"),
    TITLE_POSITION("6", "Chức vụ"),
    PHONE_NUMBER("7", "Số điện thoại"),
    EMAIL("8", "Email"),
    ID_CARD("9", "Số CMND"),
    DAT_OF_BIRTH("10", "Ngày sinh"),
    EXPERIED_DATE("11", "Ngày hết hạn");


    private final String columnIndex;
    private final String columnName;

    ReportExcelUser(String index, String name) {
        this.columnIndex = index;
        this.columnName = name;
    }

    public String toString() {
        return columnIndex + "/" + columnName;
    }
}
