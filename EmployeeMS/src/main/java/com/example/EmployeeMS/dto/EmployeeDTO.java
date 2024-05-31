package com.example.EmployeeMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private int empCode;
    private String empName;
    private String empPic;
    private String empGender;
    private String empStatus;
    private String empDesignation;
    private String empAccessRole;
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
