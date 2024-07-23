package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
