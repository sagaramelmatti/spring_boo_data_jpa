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
public class TeacherDTO {

	private Integer id;
	
	private String name;

	private String contactNumber;

	private String education;
	
}