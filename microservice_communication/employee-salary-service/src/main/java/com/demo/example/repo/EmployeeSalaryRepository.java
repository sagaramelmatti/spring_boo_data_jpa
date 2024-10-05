package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.EmployeeSalaryDetail;

public interface EmployeeSalaryRepository extends JpaRepository<EmployeeSalaryDetail, Integer> {


}
