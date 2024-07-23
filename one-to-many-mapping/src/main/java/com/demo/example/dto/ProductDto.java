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
public class ProductDto {

	private Integer id;
	
	private String name;
	
	private Double price;
	
	private CategoryDto category;
}
