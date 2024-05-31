package com.example.EmployeeMS.dto;

import com.example.EmployeeMS.enums.AccessRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private String username;
    private String password;
    private AccessRole role;
}

