package com.example.springjava.controller;

import com.example.springjava.exception.BadRequestException;
import com.example.springjava.model.Person;
import com.example.springjava.payload.ApiResponse;
import com.example.springjava.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class DemoController {
    @Autowired
    private DemoService demoService;

    @GetMapping("/home")
    public ResponseEntity<ApiResponse<List<Person>>> home() {
        List<Person> list = demoService.getAllPerson();
        return ResponseEntity.ok(new ApiResponse<List<Person>>(true, 200, "success", list));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<ApiResponse<NullValue>> addPerson(
            @RequestBody(required = true) Person person
    ) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", 200);
//        map.put("message","SUCCESS");
//        Person person = new Person();
//        person.setId(13);
//        person.setFullName("Silver Pham");
//        person.setAge(25);
        try {
            demoService.addPerson(person);

        } catch (Exception e) {
            throw new BadRequestException(e.toString());
        }
        return ResponseEntity.ok(new ApiResponse<NullValue>(true, 200, "SUCCESS", null));
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<ApiResponse<String>> deletePerson(@RequestBody(required = true)Map<String , Integer> payload){
        try {
            demoService.deletePerson( payload.get("id"));
        }
        catch (Exception e)
        {
            throw  new BadRequestException(e.toString());
        }
        return ResponseEntity.ok(new ApiResponse<String>(true,200,"success","You was deleted "));
    }
}
