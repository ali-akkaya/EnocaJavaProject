package com.example.enocajavaproject.ras;

import com.example.enocajavaproject.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {

    Optional<Company> findByCompanyName(String companyName);
}
