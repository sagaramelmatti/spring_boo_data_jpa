package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.EmployeeDTO;
import com.demo.example.entity.EmployeeDetail;

public interface EmployeeService {

	public List<EmployeeDTO> findAll();

	public EmployeeDetail saveEmployee(EmployeeDTO studentDto);

	public EmployeeDTO getEmployeeById(Integer id);

	public EmployeeDTO updateEmployee(Integer id, EmployeeDTO studentDto);

	public void deleteEmployee(Integer id);

}