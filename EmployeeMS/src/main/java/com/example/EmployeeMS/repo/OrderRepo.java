package com.example.EmployeeMS.repo;

import com.example.EmployeeMS.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
