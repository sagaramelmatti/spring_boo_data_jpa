package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.StandardDTO;
import com.demo.example.entity.StandardDetail;

public interface StandardService {

	public List<StandardDTO> findAll();

	public StandardDetail saveStandard(StandardDTO standardDto);

	public StandardDTO getStandardById(Integer id);

	public StandardDTO updateStandard(Integer id, StandardDTO standardDto);

	public void deleteStandard(Integer id);
}