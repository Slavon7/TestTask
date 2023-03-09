package com.example.testtask.service;

import com.example.testtask.interfaces.EmployeeRepository;
import com.example.testtask.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Метод, який отримує дані працівника за його id
     * @param id id працівника, якого потрібно отримати
     * @return Map з інформацією про працівника, який має наступні ключі:
     *  - id - id працівника
     *  - firstName - ім'я працівника
     *  - lastName - прізвище працівника
     *  - age - вік працівника
     */
    public Map<String, Object> getEmployeeById(int id) {
        // отримуємо працівника з БД за його id
        Employee employee = employeeRepository.findById(id);
        // визначаємо вік працівника
        int age = employee.getAge();

        // формуємо Map з інформацією про працівника
        Map<String, Object> response = new HashMap<>();
        response.put("id", employee.getId());
        response.put("firstName", employee.getFirstName());
        response.put("lastName", employee.getLastName());
        response.put("age", age);

        return response;
    }
}