package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.common.util.MessageConstants;
import com.demo.example.dto.EmployeeDTO;
import com.demo.example.entity.EmployeeDetail;
import com.demo.example.exception.ResourceNotFoundException;
import com.demo.example.repo.EmployeeRepository;
import com.demo.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<EmployeeDTO> findAll() {
		List<EmployeeDTO> employeeDtoList = null;

		List<EmployeeDetail> employeeList = employeeRepository.findAll();

		employeeDtoList = new ArrayList<EmployeeDTO>();
		for (EmployeeDetail employee : employeeList) {

			EmployeeDTO employeeDto = modelMapper.map(employee, EmployeeDTO.class); // Employee DTO
			employeeDtoList.add(employeeDto);
		}
		return employeeDtoList;
	}

	public EmployeeDetail saveEmployee(EmployeeDTO employeeDto) {
		
		EmployeeDetail employee = modelMapper.map(employeeDto, EmployeeDetail.class);

		// Save the employee entity in the employee-service repository
		return employeeRepository.save(employee);

	}

	public EmployeeDTO getEmployeeById(Integer id) {
		EmployeeDTO employeeDto = null;
		Optional<EmployeeDetail> employeeOptinal = employeeRepository.findById(id);

		if (employeeOptinal.isPresent()) {
			EmployeeDetail employee = employeeOptinal.get();
			employeeDto = modelMapper.map(employee, EmployeeDTO.class);
		}

		return employeeDto;
	}

	public EmployeeDTO updateEmployee(Integer id, EmployeeDTO employeeDto) {

		EmployeeDetail employeeDetail = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.EMPLOYEE_NOT_FOUND + id));

		employeeDetail.setName(employeeDto.getName());
		employeeDetail.setAge(Integer.parseInt(employeeDto.getAge()));

		EmployeeDetail updatedEmployeeDetail = employeeRepository.save(employeeDetail);
		return modelMapper.map(updatedEmployeeDetail, EmployeeDTO.class);

	}

	public void deleteEmployee(Integer id) {

		EmployeeDetail employeeDetail = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.EMPLOYEE_NOT_FOUND + id));

		employeeRepository.delete(employeeDetail);
	}

}