package com.example.springjava.controller;

import com.example.springjava.constants.ReportExcelBodyOrder;
import com.example.springjava.constants.ReportExcelHeaderOrder;
import com.example.springjava.constants.ReportExcelUser;
import com.example.springjava.model.OrderDTO;
import com.example.springjava.model.OrderDetailDTO;
import com.example.springjava.model.UserDTO;
import com.example.springjava.service.OrderService;
import com.example.springjava.service.UserService;
import com.example.springjava.util.ExcelGenerator;
import com.example.springjava.util.ExcelMultipleGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping(value = "/file")
public class FileController {
    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/user/export-excel", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> exportExcelUser(
            @RequestParam(name = "fullName", required = false) String fullName,
            @RequestParam(name = "address", required = false) String address,
            @RequestParam(name = "job", required = false) String job
    ) throws IOException, IllegalAccessException {

        List<UserDTO> listUser = userService.getListUser(fullName, address, job);
        ExcelGenerator<UserDTO> generator = new ExcelGenerator<>(listUser, UserDTO.class, ReportExcelUser.class);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=user.xlsx";
        headers.add(headerKey, headerValue);
        InputStreamResource inputStreamResource = new InputStreamResource(generator.generateExcelFile("Users", 1));
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(inputStreamResource);
    }

    @GetMapping(value = "/order/export-excel/{userId}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> exportExcelOrder(
            @RequestParam(name = "search", required = false) String search,
            @PathVariable(value = "userId") String userId
    ) throws IOException, IllegalAccessException {

        List<OrderDTO> listOrder = orderService.getListOrder(search, userId);
        ExcelMultipleGenerator<OrderDTO> generator = new ExcelMultipleGenerator<>(OrderDTO.class, ReportExcelHeaderOrder.class, listOrder, OrderDetailDTO.class, ReportExcelBodyOrder.class);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_OCTET_STREAM));
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=order.xlsx";
        headers.add(headerKey, headerValue);
        InputStreamResource inputStreamResource = new InputStreamResource(generator.generateExcelFile(1));
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(inputStreamResource);
    }
}
