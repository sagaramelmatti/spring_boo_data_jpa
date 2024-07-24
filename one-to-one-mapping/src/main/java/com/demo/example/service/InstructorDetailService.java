package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.InstructorDetailDto;
import com.demo.example.entity.InstructorDetail;

public interface InstructorDetailService {

	public List<InstructorDetailDto> findAll();

	public InstructorDetail saveInstructorDetail(InstructorDetailDto instructorDetailDto);

	public InstructorDetailDto getInstructorDetailById(Integer id);

	public InstructorDetail updateInstructorDetail(Integer id, InstructorDetail instructorDetail);

	public void deleteInstructorDetail(Integer id);
}