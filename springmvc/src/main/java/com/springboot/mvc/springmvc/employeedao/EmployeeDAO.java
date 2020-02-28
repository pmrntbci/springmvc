package com.springboot.mvc.springmvc.employeedao;

import com.springboot.mvc.springmvc.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeDAO {
    public Employee addEmployee(Employee employee);
    public Employee updateEmployee();
    public List<Employee> fetchAllEmployee();
    public void deleteEmployee();

    public Employee fetchEmployeeById(int id);

    List<Employee> fetchEmployeeByName(int name);
}
