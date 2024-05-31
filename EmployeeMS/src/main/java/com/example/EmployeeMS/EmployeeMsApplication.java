package com.example.EmployeeMS;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMsApplication.class, args);
	}

	@Bean
	//modelmapper eka spring bean ekk widiyata project ekata inject karagnnawa
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
