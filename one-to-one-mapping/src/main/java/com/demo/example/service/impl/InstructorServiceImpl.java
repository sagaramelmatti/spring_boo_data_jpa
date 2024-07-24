package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dto.InstructorDto;
import com.demo.example.entity.Instructor;
import com.demo.example.repo.InstructorRepository;
import com.demo.example.service.InstructorService;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	InstructorRepository instructorRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<InstructorDto> findAll() {

		List<Instructor> instructorList = instructorRepository.findAll();

		List<InstructorDto> instructorDtoList = new ArrayList<InstructorDto>();
		for (Instructor instructor : instructorList) {
			InstructorDto instructorDto = modelMapper.map(instructor, InstructorDto.class);
			instructorDtoList.add(instructorDto);
		}
		return instructorDtoList;
	}

	public Instructor saveInstructor(InstructorDto instructorDto) {

		Instructor instructor = modelMapper.map(instructorDto, Instructor.class);
		return instructorRepository.save(instructor);
	}

	public InstructorDto getInstructorById(Integer id) {

		Optional<Instructor> instructorOptinal = instructorRepository.findById(id);
		Instructor instructor = instructorOptinal.get();

		InstructorDto instructorDto = modelMapper.map(instructor, InstructorDto.class);
		
		
		return instructorDto;
	}

	public Instructor updateInstructor(Integer id, Instructor instructor) {
		instructor.setId(id);
		return instructorRepository.save(instructor);
	}

	public void deleteInstructor(Integer id) {
		instructorRepository.deleteById(id);
	}
}