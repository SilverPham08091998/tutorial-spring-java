package com.example.springjava.util.excel;

public class ItemRowExcelDto {
    private String rowName;
    private int rowIndex;
    private String rowField;

    public String getRowName() {
        return rowName;
    }

    public void setRowName(String rowName) {
        this.rowName = rowName;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }

    public String getRowField() {
        return rowField;
    }

    public void setRowField(String rowField) {
        this.rowField = rowField;
    }
}
