package com.example.springjava.util.excel;

public class AddHeaderCell {
    private int indexRow;
    private int indexCol;
    private String value;

    public AddHeaderCell(int indexRow, int indexCol, String value) {
        this.indexRow = indexRow;
        this.indexCol = indexCol;
        this.value = value;
    }

    public int getIndexRow() {
        return this.indexRow;
    }

    public void setIndexRow(int indexRow) {
        this.indexRow = indexRow;
    }

    public int getIndexCol() {
        return this.indexCol;
    }

    public void setIndexCol(int indexCol) {
        this.indexCol = indexCol;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }


}
