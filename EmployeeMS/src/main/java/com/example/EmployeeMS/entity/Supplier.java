package com.example.EmployeeMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
