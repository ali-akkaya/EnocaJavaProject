package com.example.enocajavaproject.manager;

import com.example.enocajavaproject.model.Company;
import com.example.enocajavaproject.model.Employee;

import java.util.List;

public interface ICompanyManager {
    Company getCompanyDetailsById(Integer id);
    List<Company> getAllCompanyList();
    Company createCompany(Company company);
    Company updateCompany(Company company);
    void deleteCompanyById(Integer id);
    List<Employee> findCompanyEmployees(Integer id);
}
