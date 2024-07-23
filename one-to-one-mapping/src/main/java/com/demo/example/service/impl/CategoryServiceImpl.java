package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dto.CategoryDto;
import com.demo.example.entity.Category;
import com.demo.example.repo.CategoryRepository;
import com.demo.example.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<CategoryDto> findAll() {

		List<Category> categoryList = categoryRepository.findAll();

		List<CategoryDto> categoryDtoList = new ArrayList<CategoryDto>();
		for (Category category : categoryList) {
			CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
			categoryDtoList.add(categoryDto);
		}
		return categoryDtoList;
	}

	public Category saveCategory(CategoryDto categoryDto) {

		Category category = modelMapper.map(categoryDto, Category.class);
		return categoryRepository.save(category);
	}

	public CategoryDto getCategoryById(Integer id) {

		Optional<Category> categoryOptinal = categoryRepository.findById(id);
		Category category = categoryOptinal.get();

		CategoryDto categoryDto = modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

	public Category updateCategory(Integer id, Category category) {
		category.setId(id);
		return categoryRepository.save(category);
	}

	public void deleteCategory(Integer id) {
		categoryRepository.deleteById(id);
	}
}