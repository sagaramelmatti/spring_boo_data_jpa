package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.common.util.MessageConstants;
import com.demo.example.dto.StandardDTO;
import com.demo.example.entity.StandardDetail;
import com.demo.example.exception.ResourceNotFoundException;
import com.demo.example.repo.StandardRepository;
import com.demo.example.service.StandardService;

@Service
public class StandardServiceImpl implements StandardService {

	@Autowired
	StandardRepository standardRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	public List<StandardDTO> findAll() {
		
		List<StandardDTO> standardDtoList = null;
			
		List<StandardDetail> standardList = standardRepository.findAll();

		standardDtoList = new ArrayList<StandardDTO>();
		
		for (StandardDetail standard : standardList) {
			StandardDTO standardDto = modelMapper.map(standard, StandardDTO.class);
			standardDtoList.add(standardDto);
		}
		return standardDtoList;
	}

	public StandardDetail saveStandard(StandardDTO standardDto) {

		StandardDetail standard = modelMapper.map(standardDto, StandardDetail.class);
		return standardRepository.save(standard);
	}

	public StandardDTO getStandardById(Integer id) {
		StandardDTO standardDto = null;
		Optional<StandardDetail> standardOptinal = standardRepository.findById(id);
		
		StandardDetail standard = standardOptinal.get();
		standardDto = modelMapper.map(standard, StandardDTO.class);
		return standardDto;
	}

	public StandardDTO updateStandard(Integer id, StandardDTO standardDto) {
		
		StandardDetail standardDetail = standardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STANDARD_NOT_FOUND + id));
		
		standardDetail.setName(standardDto.getName());
		
		StandardDetail updatedStandardDetail = standardRepository.save(standardDetail);
        return modelMapper.map(updatedStandardDetail, StandardDTO.class);
		
	}

	public void deleteStandard(Integer id) {
		
		StandardDetail standardDetail = standardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STANDARD_NOT_FOUND + id));
		standardRepository.delete(standardDetail);
	}
}