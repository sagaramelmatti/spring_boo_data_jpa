package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dto.ProductDto;
import com.demo.example.entity.Product;
import com.demo.example.repo.ProductRepository;
import com.demo.example.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<ProductDto> findAll() {

		List<Product> productList = productRepository.findAll();

		List<ProductDto> productDtoList = new ArrayList<ProductDto>();
		for (Product product : productList) {
			ProductDto productDto = modelMapper.map(product, ProductDto.class);
			productDtoList.add(productDto);
		}
		return productDtoList;
	}

	public Product saveProduct(ProductDto productDto) {

		Product product = modelMapper.map(productDto, Product.class);
		return productRepository.save(product);
	}

	public ProductDto getProductById(Integer id) {

		Optional<Product> productOptinal = productRepository.findById(id);
		Product product = productOptinal.get();

		ProductDto productDto = modelMapper.map(product, ProductDto.class);
		return productDto;
	}

	public Product updateProduct(Integer id, Product product) {
		product.setId(id);
		return productRepository.save(product);
	}

	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
}