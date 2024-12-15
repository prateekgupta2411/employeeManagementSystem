package com.xyz.employeeManagementSystem.controller;

import com.xyz.employeeManagementSystem.entities.Employee;
import com.xyz.employeeManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private EmployeeService employeeService;

    // Get all employees
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.getEmployees();
    }

    // Get employee by ID
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable String employeeId) {
        try {
            return this.employeeService.getEmployee(Long.parseLong(employeeId));
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    // Add new Employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }

    // update the Employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }

    // delete the Employee By EmpId
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId){
        try {
            this.employeeService.getEmployee(Long.parseLong(employeeId));
            return "Course with ID " + employeeId + " has been deleted.";
        } catch (RuntimeException e){
            return "Error: " +e.getMessage();
        }
    }
}
