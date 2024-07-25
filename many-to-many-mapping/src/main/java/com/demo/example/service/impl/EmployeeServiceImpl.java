package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dto.EmployeeDTO;
import com.demo.example.dto.ProjectDTO;
import com.demo.example.entity.Employee;
import com.demo.example.entity.Project;
import com.demo.example.repo.EmployeeRepository;
import com.demo.example.repo.ProjectRepository;
import com.demo.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<EmployeeDTO> findAll() {

		List<Employee> employeeList = employeeRepository.findAll();

		List<EmployeeDTO> employeeDtoList = new ArrayList<EmployeeDTO>();
		
		for (Employee employee : employeeList) {
			EmployeeDTO employeeDto = modelMapper.map(employee, EmployeeDTO.class);
			
			/* Set Project List */
			List<ProjectDTO> projectsDtos = new ArrayList<ProjectDTO>();
			
			
			for(Project project : employee.getProjects()) {
				ProjectDTO projectDto = modelMapper.map(project, ProjectDTO.class);
				projectsDtos.add(projectDto);
			}
			employeeDto.setProjectsDtos(projectsDtos);
			
			employeeDtoList.add(employeeDto);
		}
		return employeeDtoList;
	}

	public Employee saveEmployee(EmployeeDTO employeeDto) {

		Employee employee = modelMapper.map(employeeDto, Employee.class);
		return employeeRepository.save(employee);
	}

	public EmployeeDTO getEmployeeById(Integer id) {

		Optional<Employee> employeeOptinal = employeeRepository.findById(id);
		Employee employee = employeeOptinal.get();

		EmployeeDTO employeeDto = modelMapper.map(employee, EmployeeDTO.class);
		return employeeDto;
	}

	public Employee updateEmployee(Integer id, Employee employee) {
		employee.setId(id);
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee assignProjectToEmployee(Integer employeeId, ProjectDTO projectDTO) {

		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
		Employee employee = employeeOptional.get();
		
		
		Optional<Project> projectOptional = projectRepository.findById(projectDTO.getId());
		Project project = projectOptional.get();
		
		List<Project> projects = employee.getProjects();
		projects.add(project);
		
		employee.setProjects(projects);
		
		return employeeRepository.save(employee);
	}
}