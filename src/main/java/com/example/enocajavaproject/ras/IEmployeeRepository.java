package com.example.enocajavaproject.ras;

import com.example.enocajavaproject.dto.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
