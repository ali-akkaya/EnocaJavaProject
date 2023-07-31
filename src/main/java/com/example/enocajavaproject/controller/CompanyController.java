package com.example.enocajavaproject.controller;

import com.example.enocajavaproject.manager.ICompanyManager;
import com.example.enocajavaproject.model.Company;
import com.example.enocajavaproject.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RequestMapping("/company")
@RestController
@AllArgsConstructor
public class CompanyController {

    private final ICompanyManager companyManager;

    @GetMapping
    @Operation(summary = "Get list of al companies recorded in database.")
    public ResponseEntity<List<Company>> getAllCompanyList(){
        return new ResponseEntity<>(companyManager.getAllCompanyList(), OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Getspecific  company details by its id.")
    public ResponseEntity<Company> getCompanyDetailsById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(companyManager.getCompanyDetailsById(id), OK);
    }

    @PostMapping
    @Operation(summary = "Add a new company to database.")
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return new ResponseEntity<>(companyManager.createCompany(company), OK);
    }

    @PutMapping
    @Operation(summary = "Update a company.")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company){
        return new ResponseEntity<>(companyManager.updateCompany(company), OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a company with its id.")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id){
        companyManager.deleteCompanyById(id);
        return new ResponseEntity<>("Company with following id deleted successfully: "+id, OK);
    }

    @GetMapping("/{id}/employees")
    @Operation(summary = "Get list of all employees in a company by company id .")
    public ResponseEntity<List<Employee>> findCompanyEmployees(@PathVariable("id") Integer id){
        return new ResponseEntity<>(companyManager.findCompanyEmployees(id), OK);
    }
}
