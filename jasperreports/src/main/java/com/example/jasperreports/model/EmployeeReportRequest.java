package com.example.jasperreports.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReportRequest {

    private List<Employee> employees;
    private String createdBy;

}
