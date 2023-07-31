package com.example.enocajavaproject.converter;

import com.example.enocajavaproject.dto.EmployeeDto;
import com.example.enocajavaproject.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

     public Employee covertDtoToModel(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setEmail(employeeDto.getEmail());

        return employee;
    }
}
