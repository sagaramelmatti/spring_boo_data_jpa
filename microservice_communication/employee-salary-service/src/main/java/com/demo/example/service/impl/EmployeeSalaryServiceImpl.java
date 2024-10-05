package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.example.dto.EmployeeDTO;
import com.demo.example.dto.EmployeeSalaryDTO;
import com.demo.example.entity.EmployeeSalaryDetail;
import com.demo.example.repo.EmployeeSalaryRepository;
import com.demo.example.service.EmployeeSalaryService;

@Service
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {

	@Autowired
	EmployeeSalaryRepository employeeSalaryRepository;

	@Autowired
	private RestTemplate restTemplate;

	ModelMapper modelMapper = new ModelMapper();

	public List<EmployeeSalaryDTO> findAll() {
		List<EmployeeSalaryDTO> employeeSalaryDtoList = null;

		List<EmployeeSalaryDetail> employeeSalaryList = employeeSalaryRepository.findAll();

		employeeSalaryDtoList = new ArrayList<EmployeeSalaryDTO>();
		for (EmployeeSalaryDetail employeeSalary : employeeSalaryList) {

			EmployeeSalaryDTO employeeSalaryDto = modelMapper.map(employeeSalary, EmployeeSalaryDTO.class); // EmployeeSalary
																											// DTO
			EmployeeDTO employeeDTO = restTemplate.getForObject("http://localhost:9191/api/employees/{id}",
					EmployeeDTO.class, employeeSalaryDto.getEmployeeId());
			
			employeeSalaryDto.setEmployeeName(employeeDTO.getName());
			employeeSalaryDto.setEmployeeMobno(employeeDTO.getMobno());

			employeeSalaryDtoList.add(employeeSalaryDto);
		}
		return employeeSalaryDtoList;
	}

	public EmployeeSalaryDetail saveEmployeeSalary(EmployeeSalaryDTO employeeSalaryDto) {

		EmployeeSalaryDetail employeeSalary = modelMapper.map(employeeSalaryDto, EmployeeSalaryDetail.class);

		// Save the employeeSalary entity in the employeeSalary-service repository
		return employeeSalaryRepository.save(employeeSalary);

	}

	public EmployeeSalaryDTO getEmployeeSalaryById(Integer id) {
		EmployeeSalaryDTO employeeSalaryDto = null;
		Optional<EmployeeSalaryDetail> employeeSalaryOptinal = employeeSalaryRepository.findById(id);

		if (employeeSalaryOptinal.isPresent()) {
			EmployeeSalaryDetail employeeSalary = employeeSalaryOptinal.get();
			employeeSalaryDto = modelMapper.map(employeeSalary, EmployeeSalaryDTO.class);
		}

		return employeeSalaryDto;
	}

}