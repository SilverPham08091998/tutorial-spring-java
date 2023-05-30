package com.example.springjava.util.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

public class ExcelGenerator<T> {
    private final Class<?> classData;
    private final Class<?> headerColumn;
    private final List<?> list;
    private final XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List<?> list, Class<?> data, Class<?> headerColumn) {
        this.list = list;
        this.classData = data;
        this.headerColumn = headerColumn;
        workbook = new XSSFWorkbook();
    }

    public ExcelGenerator(Class<?> classData, Class<?> headerColumn, List<?> list, XSSFWorkbook workbook) {
        this.classData = classData;
        this.headerColumn = headerColumn;
        this.list = list;
        this.workbook = workbook;
    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        NumberFormat formatCurrency = NumberFormat.getInstance(Locale.US);
        sheet.autoSizeColumn(columnCount);
        if (valueOfCell == null) {
            cell.setCellValue("--");
            cell.setCellStyle(style);
            return;
        }
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
            cell.setCellStyle(style);
            return;
        }
        if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
            cell.setCellStyle(style);
            return;
        }
        if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
            cell.setCellStyle(style);
            return;
        }
        if (valueOfCell instanceof Date) {
            cell.setCellValue(valueOfCell.toString());
            cell.setCellStyle(style);
            return;
        }
        if (valueOfCell instanceof Double) {
            cell.setCellValue((Double) valueOfCell);
            cell.setCellStyle(style);
        }
        if (valueOfCell instanceof BigDecimal) {
            cell.setCellValue(formatCurrency
                    .format(valueOfCell));
            cell.setCellStyle(style);
        }
    }

    public void writeExcel(int startRow) throws IllegalAccessException {
        Field[] headerFields = classData.getDeclaredFields();
        List<ItemColsExcelDto> columns = new ArrayList<>();
        setListColumnExcel(headerColumn, columns);
        Row rowHeader = sheet.createRow(startRow - 1);

        CellStyle style = workbook.createCellStyle();
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setWrapText(true);
        style.setAlignment(HorizontalAlignment.CENTER);
        columns.forEach(item -> {
            CellStyle headerStyle = workbook.createCellStyle();
            XSSFFont font = workbook.createFont();
            font.setFontName("Arial");
            font.setFontHeightInPoints((short) 10);
            font.setBold(true);
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setFont(font);
            sheet.autoSizeColumn(item.getColIndex());
            sheet.setColumnWidth(item.getColIndex(), 10000);
            createCell(rowHeader, item.getColIndex(), item.getColName().toUpperCase(), headerStyle);
        });
        Field[] fields;
        int stt = 1;
        for (Object excelDto : list) {
            XSSFRow row = sheet.createRow(startRow);
            Map<String, Object> mapValueFields = new HashMap<>();
            fields = headerFields;
            Field field;
            for (int i = 0; i < headerFields.length; ++i) {
                field = fields[i];
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                mapValueFields.put(field.getName().toUpperCase(), field.get(excelDto));
            }
            for (ItemColsExcelDto column : columns) {
                if (column.getColIndex() == 0) {
                    createCell(row, column.getColIndex(), stt, style);

                } else {
                    String value = String.valueOf(mapValueFields.get(column.getColField().toUpperCase()));
                    createCell(row, column.getColIndex(), value, style);
                }
            }
            ++startRow;
            ++stt;

        }
    }

    public ByteArrayInputStream generateExcelFile(String sheetName, int startRow) throws IOException, IllegalAccessException {
        sheet = workbook.createSheet(sheetName);
        writeExcel(startRow);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        workbook.write(byteArrayOutputStream);
        byteArrayOutputStream.close();
        workbook.close();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public void generateExcelSheet(int startRow, XSSFSheet sheet) throws IOException, IllegalAccessException {
        this.sheet = sheet;
        writeExcel(startRow);
    }

    public <E extends Enum<E>> void setListColumnExcel(Class<?> enumType, List<ItemColsExcelDto> cols) {
        Enum<?>[] enumConstants = (Enum<?>[]) enumType.getEnumConstants();
        Field[] headerFields = classData.getDeclaredFields();
        for (int i = 0; i < enumConstants.length; i++) {
            E enumConstant = (E) enumConstants[i];
            ItemColsExcelDto itemCol = new ItemColsExcelDto();
            String[] strings = enumConstant.toString().split("/");
            itemCol.setColName(strings.length > 1 ? strings[1] : enumConstant.name());
            itemCol.setColIndex(Integer.parseInt(strings[0]));
            // So sánh field của header và enum có stt chưa
            if (i > 0 && headerFields.length < enumConstants.length) {
                itemCol.setColField(headerFields[i - 1].getName().toUpperCase());
            } else {
                itemCol.setColField(headerFields[i].getName().toUpperCase());
            }
            cols.add(itemCol);
        }
    }


}

