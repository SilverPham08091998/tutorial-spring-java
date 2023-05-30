package com.example.springjava.util.excel;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ExcelMultipleGenerator<T> {
    private final Class<?> classRow;
    private final Class<?> headerRowExcel;
    private final List<T> list;
    private final XSSFWorkbook workbook;
    private final Class<?> classColumn;
    private final Class<?> headerColumnExcel;


    public ExcelMultipleGenerator(Class<?> classRow, Class<?> headerRowExcel, List<T> list, Class<?> classColumn, Class<?> headerColumnExcel) {
        this.classRow = classRow;
        this.headerRowExcel = headerRowExcel;
        this.list = list;
        this.workbook = new XSSFWorkbook();
        this.classColumn = classColumn;
        this.headerColumnExcel = headerColumnExcel;
    }

    public ByteArrayInputStream generateExcelFile(int start) throws IOException, IllegalAccessException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int stt = 1;
        for (T excelDTO : list.stream().limit(30).collect(Collectors.toList())) {
            List<ItemRowExcelDto> rows = new ArrayList<>();
            List<?> listColumn = new ArrayList<>();
            Field[] headerFields = classRow.getDeclaredFields();
            getHeaderExcel(headerRowExcel, rows);
            Field[] fields;
            Map<String, Object> mapValueFields = new HashMap<>();
            fields = headerFields;
            Field field;
            for (int i = 0; i < headerFields.length; ++i) {
                field = fields[i];
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                if (headerFields[i].getType().getTypeName().equals(List.class.getTypeName())) {
                    listColumn = (List<?>) field.get(excelDTO);
                    continue;
                }
                mapValueFields.put(field.getName().toUpperCase(), field.get(excelDTO));
            }

            int startRow = start;
            ExcelGenerator<?> generator = new ExcelGenerator<>(classColumn, headerColumnExcel, listColumn, workbook);
            XSSFSheet xssfSheet = workbook.createSheet("Sheet" + stt);
            startRow = startRow + addHeaderExcel(startRow, xssfSheet, mapValueFields, rows);
            generator.generateExcelSheet(startRow + 2, xssfSheet);
            ++stt;
        }
        workbook.write(byteArrayOutputStream);
        byteArrayOutputStream.close();
        workbook.close();
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        Cell cell = row.createCell(columnCount);
        NumberFormat formatCurrency = NumberFormat.getInstance(Locale.US);
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


    public int addHeaderExcel(int startRow, XSSFSheet sheet, Map<String, Object> mapValueFields, List<ItemRowExcelDto> rows) {
        for (ItemRowExcelDto item : rows) {
            Row row = sheet.createRow(startRow);
            CellStyle style = createStyle();
            sheet.autoSizeColumn(1);
            XSSFFont fontRow = workbook.createFont();
            fontRow.setFontName("Arial");
            fontRow.setFontHeightInPoints((short) 12);
            fontRow.setBold(true);
            style.setAlignment(HorizontalAlignment.RIGHT);
            style.setFont(fontRow);
            createCell(row, 1, item.getRowName().toUpperCase(), style);


            XSSFFont fontField = workbook.createFont();
            fontField.setFontName("Arial");
            fontField.setFontHeightInPoints((short) 10);
            style.setAlignment(HorizontalAlignment.LEFT);
            style.setFont(fontField);
            sheet.autoSizeColumn(2);
            createCell(row, 2, String.valueOf(mapValueFields.get(item.getRowField().toUpperCase())), style);
            ++startRow;
        }
        return startRow;
    }

    public <E extends Enum<E>> void getHeaderExcel(Class<?> enumType, List<ItemRowExcelDto> rows) {
        Enum<?>[] enumConstants = (Enum<?>[]) enumType.getEnumConstants();
        Field[] headerFields = classRow.getDeclaredFields();
        for (int i = 0; i < enumConstants.length; i++) {
            E enumConstant = (E) enumConstants[i];
            ItemRowExcelDto itemRow = new ItemRowExcelDto();
            String[] strings = enumConstant.toString().split("/");
            itemRow.setRowName(strings.length > 1 ? strings[1] : enumConstant.name());
            itemRow.setRowIndex(Integer.parseInt(strings[0]));
            itemRow.setRowField(headerFields[i].getName().toUpperCase());
            if (headerFields[i].getType().getTypeName().equals(List.class.getTypeName())) {
                continue;
            }
            rows.add(itemRow);
        }
    }

    private CellStyle createStyle() {
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
        return style;
    }
}
