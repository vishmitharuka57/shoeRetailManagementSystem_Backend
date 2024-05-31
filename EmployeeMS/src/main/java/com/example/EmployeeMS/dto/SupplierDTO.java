package com.example.EmployeeMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SupplierDTO {
    private int supCode;
    private String supName;
    private String supCategory;
    private String supAddressLine1;
    private String supAddressLine2;
    private String supAddressLine3;
    private String supAddressLine4;
    private String supContact1;
    private String supContact2;
    private String supEmail;
}
