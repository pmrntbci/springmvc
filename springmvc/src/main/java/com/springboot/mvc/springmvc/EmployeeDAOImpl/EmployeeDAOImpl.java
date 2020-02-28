package com.springboot.mvc.springmvc.EmployeeDAOImpl;

import com.springboot.mvc.springmvc.employeedao.EmployeeDAO;
import com.springboot.mvc.springmvc.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Employee addEmployee(Employee employee) {
        //get the current hibernate session
        Session currentSession= entityManager.unwrap(Session.class);

        //add the employee object
        currentSession.save(employee);

        return null;
    }

    @Override
    public Employee updateEmployee() {
        return null;
    }


    @Override
    public List<Employee> fetchAllEmployee() {

        //get the current hibernate session
        Session currentSession= entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> theQuery= currentSession.createQuery("from Employee", Employee.class);

        //execute a query and get a result list
        List<Employee> allEmployees= theQuery.getResultList();

        //return the result
        return allEmployees;
    }

    @Override
    public void deleteEmployee() {



    }

    @Override
    public Employee fetchEmployeeById(int id) {
        //get the current session
        Session currentSession= entityManager.unwrap(Session.class);

        //create a query
        Query theQuery= currentSession.createQuery("from Employee e where e.employeeId="+id, Employee.class);

        //execute the query
        Employee employee= (Employee) theQuery.getResultList();

        //return the employee object
        return employee;
    }

    @Override
    public List<Employee> fetchEmployeeByName(int name) {
        //get the current Session
        Session currentSession= entityManager.unwrap(Session.class);

        //create the query
        Query theQuery= currentSession.createQuery("from Employee e where e.employeeName="+name, Employee.class);

        //execute the query
        List<Employee> employeeList= (List<Employee>) theQuery.getResultList();

        //return the employeeList
        return employeeList;

    }
}
