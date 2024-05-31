package com.example.EmployeeMS.entity;


import com.example.EmployeeMS.enums.Gender;
import com.example.EmployeeMS.enums.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//meken apita auto empCode eka genarate krgnna puluwn
    private int cusCode;
    private String cusName;
    private Gender cusGender;
    private String joinDate;
    private Level level;
    private int totalPoints;
    private String cusDOB;
    private String cusAddressLine1;
    private String cusAddressLine2;
    private String cusAddressLine3;
    private String cusAddressLine4;
    private String cusContact;
    private String cusEmail;



}
