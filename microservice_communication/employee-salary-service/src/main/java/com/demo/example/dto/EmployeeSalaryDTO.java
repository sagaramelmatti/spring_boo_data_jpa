package com.demo.example.dto;

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
public class EmployeeSalaryDTO {

	private Integer id;

	private String amount;

	private String month;
	
	private String employeeId;	
	
	private String employeeName;
	
	private String employeeMobno;

}