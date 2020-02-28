package com.springboot.mvc.springmvc.serviceimpl;

import com.springboot.mvc.springmvc.employeedao.EmployeeDAO;
import com.springboot.mvc.springmvc.entity.Employee;
import com.springboot.mvc.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Transactional
    @Override
    public Employee addEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Transactional
    @Override
    public List<Employee> fetchAllEmployee() {
        return employeeDAO.fetchAllEmployee();
    }

    @Override
    public Employee updateEmployee() {
        return employeeDAO.updateEmployee();
    }

    @Override
    public void deleteEmployee() {
        employeeDAO.deleteEmployee();
    }

    @Override
    public Employee fetchEmployeeById(int id) {
        return employeeDAO.fetchEmployeeById(id);
    }

    @Override
    public List<Employee> fetchEmployeeByName(int name) {
        return employeeDAO.fetchEmployeeByName(name);
    }

}
