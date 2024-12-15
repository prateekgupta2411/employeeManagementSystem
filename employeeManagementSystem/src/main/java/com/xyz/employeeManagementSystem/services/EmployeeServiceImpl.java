package com.xyz.employeeManagementSystem.services;

import com.xyz.employeeManagementSystem.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> list;

    public EmployeeServiceImpl() {
        list = new ArrayList<>();
        list.add(new Employee(123, "Prateek Gupta", "prateekparauliya@gmail.com", "7906795383", "Agra", "SDE1", 50000));
        list.add(new Employee(234, "Ritik Gupta", "ritikparauliya@gmail.com", "7906795583", "Agra", "SDE2", 500000));
    }

    @Override
    public List<Employee> getEmployees() {
        return list;
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        for (Employee employee : list) {
            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }
        throw new RuntimeException("Employee not found with ID: " + employeeId);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        list.add(employee);
        return employee;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        for (Employee e : list) {
            if (e.getEmployeeId() == employee.getEmployeeId()) {
                e.setName(employee.getName());
                e.setAddress(employee.getAddress());
                e.setDesignation(employee.getDesignation());
                e.setEmail(employee.getEmail());
                e.setPhoneNumber(employee.getPhoneNumber());
                e.setSalary(employee.getSalary());
                e.setEmployeeId(employee.getEmployeeId());
                return e;
            }
        }
        return null;
    }

    @Override
    public void deleteEmployee(long courseId) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEmployeeId() == courseId) {
                list.remove(i);
                return;
            }
        }
        throw new RuntimeException("you enter the Incorrect Id Please Check !" + courseId);
    }
}
