package com.demo.example.service;

import java.util.List;
import java.util.Optional;

import com.demo.example.dto.EmployeeDTO;

public interface EmployeeService {
	
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);

	public List<EmployeeDTO> getAllEmployees();

	public Optional<EmployeeDTO> getEmployeeById(Long id);

	public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

	public void deleteEmployee(Long id);
}
