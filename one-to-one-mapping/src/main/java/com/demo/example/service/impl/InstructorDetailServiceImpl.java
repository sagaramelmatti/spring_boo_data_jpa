package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dto.InstructorDetailDto;
import com.demo.example.entity.InstructorDetail;
import com.demo.example.repo.InstructorDetailRepository;
import com.demo.example.service.InstructorDetailService;

@Service
public class InstructorDetailServiceImpl implements InstructorDetailService {

	@Autowired
	InstructorDetailRepository instructorDetailRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<InstructorDetailDto> findAll() {

		List<InstructorDetail> instructorDetailList = instructorDetailRepository.findAll();

		List<InstructorDetailDto> instructorDetailDtoList = new ArrayList<InstructorDetailDto>();
		for (InstructorDetail instructorDetail : instructorDetailList) {
			InstructorDetailDto instructorDetailDto = modelMapper.map(instructorDetail, InstructorDetailDto.class);
			instructorDetailDtoList.add(instructorDetailDto);
		}
		return instructorDetailDtoList;
	}

	public InstructorDetail saveInstructorDetail(InstructorDetailDto instructorDetailDto) {

		InstructorDetail instructorDetail = modelMapper.map(instructorDetailDto, InstructorDetail.class);
		return instructorDetailRepository.save(instructorDetail);
	}

	public InstructorDetailDto getInstructorDetailById(Integer id) {

		Optional<InstructorDetail> instructorDetailOptinal = instructorDetailRepository.findById(id);
		InstructorDetail instructorDetail = instructorDetailOptinal.get();

		InstructorDetailDto instructorDetailDto = modelMapper.map(instructorDetail, InstructorDetailDto.class);
		return instructorDetailDto;
	}

	public InstructorDetail updateInstructorDetail(Integer id, InstructorDetail instructorDetail) {
		instructorDetail.setId(id);
		return instructorDetailRepository.save(instructorDetail);
	}

	public void deleteInstructorDetail(Integer id) {
		instructorDetailRepository.deleteById(id);
	}
}