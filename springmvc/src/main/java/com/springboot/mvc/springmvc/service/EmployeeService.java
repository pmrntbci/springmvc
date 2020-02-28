package com.springboot.mvc.springmvc.service;

import com.springboot.mvc.springmvc.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public List<Employee> fetchAllEmployee();
    public Employee updateEmployee();
    public void deleteEmployee();

    public Employee fetchEmployeeById(int id);

    List<Employee> fetchEmployeeByName(int name);
}
