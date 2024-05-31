package com.example.EmployeeMS.entity;

import com.example.EmployeeMS.enums.AccessRole;
import com.example.EmployeeMS.enums.Gender;
import com.example.EmployeeMS.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//meken apita auto empCode eka genarate krgnna puluwn
    private int empCode;
    private String empName;
    private String empPic;
    private Gender empGender;
    private Status empStatus;
    private String empDesignation;
    private AccessRole empAccessRole;
    private String empDOB;
    private String empJoinDate;
    private String empAttachedBranch;
    private String empAddressLine1;
    private String empAddressLine2;
    private String empAddressLine3;
    private String empAddressLine4;
    private String empContact;
    private String empEmail;
    private String empEmergencyInformPerson;
    private String empEmergencyInformContact;






}
