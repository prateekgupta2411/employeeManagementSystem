package com.xyz.employeeManagementSystem.services;

import com.xyz.employeeManagementSystem.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getEmployees();

    public Employee getEmployee(Long employeeID);

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);

    public void deleteEmployee(long courseId);

}
