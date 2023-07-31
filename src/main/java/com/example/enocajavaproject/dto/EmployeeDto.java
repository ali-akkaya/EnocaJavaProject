package com.example.enocajavaproject.dto;

import com.example.enocajavaproject.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private String name;
    private String surname;
    private String email;
    private String companyName;
}
