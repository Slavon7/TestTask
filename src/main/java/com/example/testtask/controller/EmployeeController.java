package com.example.testtask.controller;

import com.example.testtask.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    // REST метод getEmployeeById, який викликає сервісний метод getEmployeeById
    @GetMapping("/employee/{id}")
    public ResponseEntity<Map<String, Object>> getEmployeeById(@PathVariable int id) {
        Map<String, Object> response = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(response);
    }
}
