package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
