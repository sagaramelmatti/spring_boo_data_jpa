package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.CategoryDto;
import com.demo.example.entity.Category;

public interface CategoryService {

	public List<CategoryDto> findAll();

	public Category saveCategory(CategoryDto categoryDto);

	public CategoryDto getCategoryById(Integer id);

	public Category updateCategory(Integer id, Category category);

	public void deleteCategory(Integer id);
}