package com.demo.example.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDTO {

	private Integer id;

	private String projectName;

	private String technologyUsed;

    private List<EmployeeDTO> employeesDtos;
	
}