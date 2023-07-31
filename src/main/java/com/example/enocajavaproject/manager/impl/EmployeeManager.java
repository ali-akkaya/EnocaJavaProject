package com.example.enocajavaproject.manager.impl;

import com.example.enocajavaproject.converter.EmployeeConverter;
import com.example.enocajavaproject.dto.EmployeeDto;
import com.example.enocajavaproject.model.Company;
import com.example.enocajavaproject.model.Employee;
import com.example.enocajavaproject.manager.IEmployeeManager;
import com.example.enocajavaproject.ras.ICompanyRepository;
import com.example.enocajavaproject.ras.IEmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class EmployeeManager implements IEmployeeManager {

    private final IEmployeeRepository employeeRepository;
    private final ICompanyRepository companyRepository;
    private final EmployeeConverter employeeConverter;

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto){
        Company company = companyRepository.findByCompanyName(employeeDto.getCompanyName())
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id: " + employeeDto.getCompanyName()));

        Employee employee = employeeConverter.covertDtoToModel(employeeDto);
        employee.setCompany(company);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> employeeToUpdate = employeeRepository.findById(employee.getId());
        if(employeeToUpdate.isEmpty()){
            throw new EntityNotFoundException();
        }
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Integer id) {
        employeeRepository.deleteById(id);
    }
}
