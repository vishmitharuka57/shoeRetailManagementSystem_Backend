package com.example.EmployeeMS.repo;

import com.example.EmployeeMS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
