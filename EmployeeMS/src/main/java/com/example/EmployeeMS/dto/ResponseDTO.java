package com.example.EmployeeMS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {  // meka haduwe responses manage krnna
    private String code;
    private String message;
    private Object content;

}
