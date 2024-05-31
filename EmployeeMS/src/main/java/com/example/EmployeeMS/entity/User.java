package com.example.EmployeeMS.entity;


import com.example.EmployeeMS.enums.AccessRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "User")
public class User {
    @Id
    private String username;
    private String password;
    private AccessRole role;
}
