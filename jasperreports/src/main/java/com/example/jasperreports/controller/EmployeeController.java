package com.example.jasperreports.controller;

import com.example.jasperreports.model.Employee;
import com.example.jasperreports.model.EmployeeReportRequest;
import com.example.jasperreports.service.EmployeeService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAllEmp")
    public List<Employee> getAllMethod()
    {
        return employeeService.getAllEmployee();
    }
    @GetMapping("/findById/{empId}")
    public Optional<Employee> findById(@PathVariable Integer empId)
    {
        return employeeService.findById(empId);
    }
    @PostMapping("/saveEmp")
    public Employee saveUser(@RequestBody Employee employee)
    {
        return employeeService.saveEmp(employee);
    }
    @DeleteMapping("/deleteEmp/{empId}")
    public void deleteEmp(@PathVariable Integer empId)
    {
         employeeService.deleteEmpById(empId);
    }
    @GetMapping("/email/{email}")
    public Optional<Employee> findByEmail(@PathVariable String email)
    {
       return employeeService.findByEmail(email);
    }
    @GetMapping("/employeePdf")
    public ResponseEntity<byte[]> getEmployeeReport() throws JRException
    {
        byte[] pdf = employeeService.generateEmployeeReport("Admin");
        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.inline().filename("employee_report.pdf").build());
        return new ResponseEntity<>(pdf,headers, HttpStatus.OK);
    }

}
