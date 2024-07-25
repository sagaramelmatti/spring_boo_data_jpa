package com.demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.dto.EmployeeDTO;
import com.demo.example.dto.ProjectDTO;
import com.demo.example.entity.Employee;
import com.demo.example.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public List<EmployeeDTO> getEmployees() {
		return employeeService.findAll();
	}

	// Save operation
	@PostMapping("/")
	public Employee saveEmployee(@RequestBody EmployeeDTO employeeDto) {
		return employeeService.saveEmployee(employeeDto);
	}

	@GetMapping("/{id}")
	public EmployeeDTO getEmployeeById(@PathVariable Integer id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
	}

	@PostMapping("/assignProject/{abc}")
	public Employee addProjectToEmployee(@PathVariable(value = "abc") Integer abc,
			@RequestBody ProjectDTO projectDTO) {
		return employeeService.assignProjectToEmployee(abc, projectDTO);
	}
}
