package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
