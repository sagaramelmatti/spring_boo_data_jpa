package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.StandardDTO;
import com.demo.example.entity.StandardDetail;

public interface StandardService {

	public List<StandardDTO> findAll();

	public StandardDetail saveStandard(StandardDTO productDto);

	public StandardDTO getStandardById(Integer id);

	public StandardDetail updateStandard(Integer id, StandardDetail standardDetail);

	public void deleteStandard(Integer id);

	//public StandardDetail assignProjectToStandard(Integer standardId, ProjectDTO projectDTO);
}