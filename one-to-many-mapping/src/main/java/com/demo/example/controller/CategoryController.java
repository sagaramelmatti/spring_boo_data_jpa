package com.demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.dto.CategoryDto;
import com.demo.example.entity.Category;
import com.demo.example.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/")
	public List<CategoryDto> getCategorys() {
		return categoryService.findAll();
	}

	// Save operation
	@PostMapping("/")
	public Category saveCategory(@RequestBody CategoryDto categoryDto) {
		return categoryService.saveCategory(categoryDto);
	}

	@GetMapping("/{id}")
	public CategoryDto getCategoryById(@PathVariable Integer id) {
		return categoryService.getCategoryById(id);
	}

	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
		return categoryService.updateCategory(id, category);
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable Integer id) {
		categoryService.deleteCategory(id);
	}
}
