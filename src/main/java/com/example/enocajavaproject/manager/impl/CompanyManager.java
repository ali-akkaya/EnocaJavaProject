package com.example.enocajavaproject.manager.impl;

import com.example.enocajavaproject.manager.ICompanyManager;
import com.example.enocajavaproject.model.Company;
import com.example.enocajavaproject.model.Employee;
import com.example.enocajavaproject.ras.ICompanyRepository;
import com.example.enocajavaproject.ras.IEmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CompanyManager implements ICompanyManager {

    private final ICompanyRepository companyRepository;
    private final IEmployeeRepository employeeRepository;

    @Override
    public Company getCompanyDetailsById(Integer id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public List<Company> getAllCompanyList() {
        return companyRepository.findAll();
    }

    @Override
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(Company company) {
        Optional<Company> companyToUpdate = companyRepository.findById(company.getId());

        if(companyToUpdate.isEmpty()){
            throw new EntityNotFoundException();
        }
        return companyRepository.save(company);
    }

    @Override
    public void deleteCompanyById(Integer id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<Employee> findCompanyEmployees(Integer id){
        return employeeRepository.findAllByCompany_Id(id);
    }
}
