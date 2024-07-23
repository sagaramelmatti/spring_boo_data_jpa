package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.ProductDto;
import com.demo.example.entity.Product;

public interface ProductService {

	public List<ProductDto> findAll();

	public Product saveProduct(ProductDto productDto);

	public ProductDto getProductById(Integer id);

	public Product updateProduct(Integer id, Product product);

	public void deleteProduct(Integer id);
}