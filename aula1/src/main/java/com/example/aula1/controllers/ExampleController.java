package com.example.aula1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula1.modules.addDTO;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ExampleController {

    @GetMapping("/hello")
    public String getHelloMessage(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "lastName") String lastName) {
        return "Hello " + name + " " + lastName;
    }

    @GetMapping("/getById/{id}")
    public String getById(@PathVariable(value = "id") int id) {
        return "ID: " + id;
    }

    @PostMapping("/add")
    public Integer addString(@RequestBody addDTO data) {
        
        return data.getNum1() + data.getNum2();
    }
     
}
