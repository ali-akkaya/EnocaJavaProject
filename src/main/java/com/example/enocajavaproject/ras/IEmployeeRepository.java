package com.example.enocajavaproject.ras;

import com.example.enocajavaproject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByCompany_Id(Integer companyId);
}
