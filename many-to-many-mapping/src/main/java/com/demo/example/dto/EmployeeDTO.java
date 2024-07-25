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
public class EmployeeDTO {

	private Integer id;

	private String name;

	private String email;

	private String technicalSkill;

	private List<ProjectDTO> projectsDtos;
}