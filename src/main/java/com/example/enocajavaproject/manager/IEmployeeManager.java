package com.example.enocajavaproject.manager;

import com.example.enocajavaproject.dto.EmployeeDto;
import com.example.enocajavaproject.model.Employee;

import java.util.List;

public interface IEmployeeManager {

    Employee getEmployeeById(Integer id);
    Employee createEmployee(EmployeeDto employeeDto);
    List<Employee> getAllEmployee();

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(Integer id);

}
