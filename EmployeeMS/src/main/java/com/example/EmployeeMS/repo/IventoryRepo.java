package com.example.EmployeeMS.repo;

import com.example.EmployeeMS.entity.Iventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IventoryRepo extends JpaRepository<Iventory,Integer> {
}
