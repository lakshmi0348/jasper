package com.example.jasperreports.service;

import com.example.jasperreports.model.Employee;
import com.example.jasperreports.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractAuditable_.createdBy;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee()
    {
        return employeeRepository.findAll();
    }
    public Optional<Employee> findById(Integer empId)
    {
        return employeeRepository.findById(empId);
    }
    public Employee saveEmp(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    public void deleteEmpById(Integer empId)
    {
        employeeRepository.deleteById(empId);
    }


    public Optional<Employee> findByEmail(String email)
    {
        return employeeRepository.findByEmail(email);
    }
    public byte[] generateEmployeeReport(String createdBy) throws JRException {
        List<Employee> employees = employeeRepository.findAll();
        InputStream inputStream =getClass().getResourceAsStream("/reports/employee_report.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String ,Object> paramters = new HashMap<>();
        paramters.put("createdBy",createdBy);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramters,dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);

    }
}
