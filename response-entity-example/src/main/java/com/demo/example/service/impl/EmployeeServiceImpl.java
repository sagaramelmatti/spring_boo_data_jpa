package com.demo.example.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.common.exceptions.EmployeeNotFoundException;
import com.demo.example.common.util.MessageConstants;
import com.demo.example.common.util.Role;
import com.demo.example.dto.EmployeeDTO;
import com.demo.example.entity.Employee;
import com.demo.example.repo.EmployeeRepository;
import com.demo.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = modelMapper.map(employeeDTO, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                        .map(employee -> modelMapper.map(employee, EmployeeDTO.class))
                        .collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.map(value -> modelMapper.map(value, EmployeeDTO.class));
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageConstants.EMPLOYEE_NOT_FOUND + id));

        employee.setName(employeeDTO.getName());
        employee.setRole(Role.MANAGER);

        Employee updatedEmployee = employeeRepository.save(employee);
        return modelMapper.map(updatedEmployee, EmployeeDTO.class);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(MessageConstants.EMPLOYEE_NOT_FOUND + id));
        employeeRepository.delete(employee);
    }
}
