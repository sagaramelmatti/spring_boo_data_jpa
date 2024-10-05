package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.EmployeeSalaryDTO;
import com.demo.example.entity.EmployeeSalaryDetail;

public interface EmployeeSalaryService {

	public List<EmployeeSalaryDTO> findAll();

	public EmployeeSalaryDetail saveEmployeeSalary(EmployeeSalaryDTO studentDto);


}