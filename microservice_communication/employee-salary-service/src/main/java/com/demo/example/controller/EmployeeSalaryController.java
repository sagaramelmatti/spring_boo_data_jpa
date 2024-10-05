package com.demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.dto.EmployeeSalaryDTO;
import com.demo.example.entity.EmployeeSalaryDetail;
import com.demo.example.service.EmployeeSalaryService;

@RestController
@RequestMapping("/api/employeeSalaries")
public class EmployeeSalaryController {

	@Autowired
	EmployeeSalaryService employeeSalaryService;

	@GetMapping("/")
	public ResponseEntity<List<EmployeeSalaryDTO>> getEmployeeSalarys() {

		List<EmployeeSalaryDTO> employeeSalaryDTOList = employeeSalaryService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(employeeSalaryDTOList);
	}

	// Save operation
	@PostMapping("/")
	public ResponseEntity<EmployeeSalaryDetail> saveEmployeeSalary(@RequestBody EmployeeSalaryDTO employeeSalaryDto) {
		EmployeeSalaryDetail employeeSalary = employeeSalaryService.saveEmployeeSalary(employeeSalaryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeSalary);
	}
}
