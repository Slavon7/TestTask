package com.example.testtask.interfaces;

import com.example.testtask.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findById(int id); // Метод findById повертає об'єкт Employee з бази даних за заданим id
}