package com.example.springjava.util.pdf;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Service
public class GenerateTemplatePDF {
    public byte[] generatePdf() throws JRException, IOException {
        Map<String, Object> parameters = new HashMap<>();
        String jasperTemplateFile = "jasper/order.jasper";
        parameters.put("logo", ClassLoader.getSystemResource("coffee.jpg"));
        parameters.put("coffee_stain", ClassLoader.getSystemResource("coffee_stain.png"));
        parameters.put("order_name", "Employee Report");
        parameters.put("address", "15000.0");
        parameters.put("quantity", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
        parameters.put("amount", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
        parameters.put("user_name", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
        parameters.put("order_status", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
        parameters.put("total_amount", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
        parameters.put("payment_status", " LAST_NAME ='Smith' ORDER BY FIRST_NAME");
        InputStream jasperStream = getClass().getClassLoader().getResourceAsStream(jasperTemplateFile);
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}

