package com.demo.example.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class EmployeeDTO {
	private Long id;
	private String name;
	private String role;

	// Getters and Setters
}