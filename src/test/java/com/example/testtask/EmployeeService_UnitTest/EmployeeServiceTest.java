package com.example.testtask.EmployeeService_UnitTest;
import com.example.testtask.interfaces.EmployeeRepository;
import com.example.testtask.model.Employee;
import com.example.testtask.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetEmployeeById() {
        // arrange
        int id = 1;
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setAge(34);

        // Cтворюємо макет employeeRepository та вказуємо, що метод findById має повернути створений об'єкт employee
        when(employeeRepository.findById(id)).thenReturn(employee);

        // act
        Map<String, Object> response = employeeService.getEmployeeById(id);

        // assert
        assertEquals(response.get("id"), id);
        assertEquals(response.get("firstName"), "John");
        assertEquals(response.get("lastName"), "Doe");
        assertEquals(response.get("age"), 34);
    }
}