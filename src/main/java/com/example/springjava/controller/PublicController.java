package com.example.springjava.controller;


import com.example.springjava.model.DistrictDTO;
import com.example.springjava.model.ProvinceDTO;
import com.example.springjava.model.WardDTO;
import com.example.springjava.payload.response.ApiResponse;
import com.example.springjava.service.PublicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/public")
@Api(tags = {"Public"})
@SwaggerDefinition(tags = {
        @Tag(name = "Public", description = "This are public APIs, client can call with none authenticate")
})
public class PublicController {


    @Autowired
    private PublicService publicService;

    @PostMapping(value = "import/province", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ApiResponse<String>> importProvince(@RequestParam("file") MultipartFile excel) throws IOException {
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", publicService.importProvince(excel)));
    }

    @PostMapping(value = "import/district", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ApiResponse<String>> importDistrict(@RequestParam("file") MultipartFile excel) throws IOException {
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", publicService.importDistrict(excel)));
    }

    @PostMapping(value = "import/ward", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ApiResponse<String>> importWard(@RequestParam("file") MultipartFile excel) throws IOException {
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", publicService.importWard(excel)));
    }

    @GetMapping(value = "list/province")
    private ResponseEntity<ApiResponse<List<ProvinceDTO>>> getListProvince() {
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", publicService.getProvince()));
    }

    @GetMapping(value = "list/district")
    private ResponseEntity<ApiResponse<List<DistrictDTO>>> getListDistrict(@RequestParam(name = "provinceId", required = false) String provinceId) {
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", publicService.getDistrict(provinceId)));
    }

    @GetMapping(value = "list/ward")
    private ResponseEntity<ApiResponse<List<WardDTO>>> getListWard(@RequestParam(name = "provinceId", required = false) String provinceId,
                                                                   @RequestParam(name = "districtId", required = false) String districtId) {
        return ResponseEntity.ok(new ApiResponse<>(true, 200, "success", publicService.getWard(provinceId, districtId)));
    }
}
