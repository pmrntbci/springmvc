package com.springboot.mvc.springmvc.controller;

import com.springboot.mvc.springmvc.entity.Employee;
import com.springboot.mvc.springmvc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/springmvc")

public class MainController {


    EmployeeService employeeService;

    @Autowired
    public MainController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(value = "/addemployee", produces = {"application/json"})
    public Employee addEmployee(Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping(value = "/fetchallemployee", produces = {"application/json"})
    public List<Employee> fetchAllEmployee(){
        return employeeService.fetchAllEmployee();
    }

    @RequestMapping(value = "/fetchsingleemployee/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public Employee fetchSingleEmployeeById(@PathVariable("id") int id){
        return employeeService.fetchEmployeeById(id);
    }

    @RequestMapping(value = "/fetchemployeebyname/{name}", method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<Employee>> fetchEmployeeByName(@PathVariable("name") int name){

        //calling the service method
        List<Employee> employeeList= (List<Employee>) employeeService.fetchEmployeeByName(name);

        //creating an ResponseEntity variable
        ResponseEntity<List<Employee>> employeeResponseEntity;

        //creating a custom header for the HttpResponse
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom Header", "Custom Header Value");

        employeeResponseEntity = new ResponseEntity<List<Employee>>((List<Employee>) employeeList, headers, HttpStatus.OK);

        return employeeResponseEntity;
    }

    @GetMapping(value = "/updateemployee", produces = {"application/json"}, consumes = {"application/json"})
    public Employee updateEmployee(){
        return employeeService.updateEmployee();
    }

    @GetMapping("/deleteemployee")
    public void deleteEmployee(){
        employeeService.deleteEmployee();
    }

}
