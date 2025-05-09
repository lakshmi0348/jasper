package com.example.jasperreports.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Employee" , indexes = {
        @Index(name = "idx_emp_id", columnList = "email")})
public class Employee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private  String empName;
    private String empAddress;
    private double salary;
    private String email;
    private Long phoneNumber;
}
