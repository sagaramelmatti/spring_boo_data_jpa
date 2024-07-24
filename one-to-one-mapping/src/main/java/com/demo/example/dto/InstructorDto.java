package com.demo.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InstructorDto {

	private Integer id;
	
	private String firstName;
	
	private String lastName;
	
	private InstructorDetailDto instructorDetail;
}
