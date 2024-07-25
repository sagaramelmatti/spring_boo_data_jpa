package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.EmployeeDTO;
import com.demo.example.dto.ProjectDTO;
import com.demo.example.entity.Employee;

public interface EmployeeService {

	public List<EmployeeDTO> findAll();

	public Employee saveEmployee(EmployeeDTO productDto);

	public EmployeeDTO getEmployeeById(Integer id);

	public Employee updateEmployee(Integer id, Employee product);

	public void deleteEmployee(Integer id);

	public Employee assignProjectToEmployee(Integer employeeId, ProjectDTO projectDTO);
}