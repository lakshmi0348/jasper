package com.example.jasperreports.repository;

import com.example.jasperreports.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository  extends JpaRepository<Employee ,Integer> {

    Optional<Employee> findByEmail(String email);
}
