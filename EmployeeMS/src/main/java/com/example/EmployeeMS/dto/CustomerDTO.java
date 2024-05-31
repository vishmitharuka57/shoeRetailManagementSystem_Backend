package com.example.EmployeeMS.dto;

import com.example.EmployeeMS.enums.Gender;
import com.example.EmployeeMS.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
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
