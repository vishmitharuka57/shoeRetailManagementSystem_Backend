package com.example.EmployeeMS.repo;

import com.example.EmployeeMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
