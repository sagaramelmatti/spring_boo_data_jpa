package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.EmployeeDetail;

public interface EmployeeRepository extends JpaRepository<EmployeeDetail, Integer> {


}
