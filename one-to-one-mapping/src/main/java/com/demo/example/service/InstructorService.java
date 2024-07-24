package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.InstructorDto;
import com.demo.example.entity.Instructor;

public interface InstructorService {

	public List<InstructorDto> findAll();

	public Instructor saveInstructor(InstructorDto instructorDto);

	public InstructorDto getInstructorById(Integer id);

	public Instructor updateInstructor(Integer id, Instructor instructor);

	public void deleteInstructor(Integer id);
}