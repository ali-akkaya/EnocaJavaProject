package com.example.enocajavaproject.controller;

import com.example.enocajavaproject.dto.EmployeeDto;
import com.example.enocajavaproject.model.Employee;
import com.example.enocajavaproject.manager.impl.EmployeeManager;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    private final EmployeeManager employeeManager;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get specific employee information by id.")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(employeeManager.getEmployeeById(id), OK);
    }

    @GetMapping()
    @Operation(summary = "Get all employee list recorded in database.")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeManager.getAllEmployee(), OK);
    }

    @PostMapping()
    @Operation(summary = "Add a new employee to database. You need employee information and company name to create.")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employee){
        return new ResponseEntity<>(employeeManager.createEmployee(employee), OK);
    }

    @PutMapping
    @Operation(summary = "Update an employee.")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeManager.updateEmployee(employee), OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an employee with its id.")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Integer id){
        employeeManager.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee with following id deleted successfully: "+id, OK);
    }

}
