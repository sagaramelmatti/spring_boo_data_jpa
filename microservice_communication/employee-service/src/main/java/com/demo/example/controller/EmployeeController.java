package com.demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.dto.EmployeeDTO;
import com.demo.example.entity.EmployeeDetail;
import com.demo.example.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public ResponseEntity<List<EmployeeDTO>> getEmployees() {

		List<EmployeeDTO> employeeDTOList = employeeService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(employeeDTOList);
	}

	// Save operation
	@PostMapping("/")
	public ResponseEntity<EmployeeDetail> saveEmployee(@RequestBody EmployeeDTO employeeDto) {
		EmployeeDetail employee = employeeService.saveEmployee(employeeDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable Integer id) {

		EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);

		// If the resource is not found, return a 404 (not found) status code
		if (employeeDTO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		// Return the resource with a 200 (OK) status code
		return ResponseEntity.status(HttpStatus.OK).body(employeeDTO);

	}

	@PutMapping("/{id}")
	public EmployeeDTO updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDto) {
		return employeeService.updateEmployee(id, employeeDto);
	}

	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployee(id);
	}

}
