package com.example.enocajavaproject.ras;

import com.example.enocajavaproject.dto.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company, Integer> {
}
