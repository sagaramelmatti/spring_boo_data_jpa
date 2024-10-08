package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.common.util.MessageConstants;
import com.demo.example.dto.StandardDTO;
import com.demo.example.dto.StudentDTO;
import com.demo.example.entity.StandardDetail;
import com.demo.example.entity.StudentDetail;
import com.demo.example.exception.ResourceNotFoundException;
import com.demo.example.repo.StandardRepository;
import com.demo.example.repo.StudentRepository;
import com.demo.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StandardRepository standardRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	public List<StudentDTO> findAll() {
		List<StudentDTO> studentDtoList = null;
			
		List<StudentDetail> studentList = studentRepository.findAll();

		studentDtoList = new ArrayList<StudentDTO>();
		for (StudentDetail student : studentList) {
			
			StudentDTO studentDto = modelMapper.map(student, StudentDTO.class); // Student DTO
			
			// set Standard details to student
			StandardDTO standardDTO = modelMapper.map(student.getStandardDetail(), StandardDTO.class); // StandardDTO
			
			
			studentDto.setStandardDTO(standardDTO);
			studentDtoList.add(studentDto);
		}
		return studentDtoList;
	}

	public StudentDetail saveStudent(StudentDTO studentDto) {

		StudentDetail student = modelMapper.map(studentDto, StudentDetail.class);
		
		StandardDetail standardDetail = standardRepository.findById(studentDto.getStandardDTO().getId())
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STANDARD_NOT_FOUND + studentDto.getStandardDTO().getId()));
		
		student.setStandardDetail(standardDetail);
		return studentRepository.save(student);
	}

	public StudentDTO getStudentById(Integer id) {
		StudentDTO studentDto = null;
		Optional<StudentDetail> studentOptinal = studentRepository.findById(id);
		
	    if (studentOptinal.isPresent()) {
	    	StudentDetail student = studentOptinal.get();
			studentDto = modelMapper.map(student, StudentDTO.class);
	    }
		
		
		return studentDto;
	}

	public StudentDTO updateStudent(Integer id, StudentDTO studentDto) {

		StudentDetail studentDetail = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STUDENT_NOT_FOUND + id));

		studentDetail.setName(studentDto.getName());
		studentDetail.setAge(studentDto.getAge());
		
		StandardDetail standardDetail = studentDetail.getStandardDetail();
		
		standardDetail.setId(studentDto.getStandardDTO().getId());
		studentDetail.setStandardDetail(standardDetail);

		StudentDetail updatedStudentDetail = studentRepository.save(studentDetail);
		return modelMapper.map(updatedStudentDetail, StudentDTO.class);

	}

	public void deleteStudent(Integer id) {

		StudentDetail studentDetail = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STUDENT_NOT_FOUND + id));

		studentRepository.delete(studentDetail);
	}

	@Override
	public List<StudentDTO> findStudentByStudentName(String name) {
		
		List<StudentDTO> studentDtoList = null;
		name = name.trim();
		List<StudentDetail> studentList = studentRepository.findStudentWithName(name);

		studentDtoList = new ArrayList<StudentDTO>();
		for (StudentDetail student : studentList) {
			
			StudentDTO studentDto = modelMapper.map(student, StudentDTO.class); // Student DTO
			
			// set Standard details to student
			StandardDTO standardDTO = modelMapper.map(student.getStandardDetail(), StandardDTO.class); // StandardDTO
			
			
			studentDto.setStandardDTO(standardDTO);
			studentDtoList.add(studentDto);
		}
		return studentDtoList;
	}

	/*
	@Override
	public StudentDetail assignStudentToStudent(Integer studentId, StudentDTO projectDTO) {

		Optional<StudentDetail> studentOptional = studentRepository.findById(studentId);
		StudentDetail student = studentOptional.get();
		
		
		Optional<Student> projectOptional = projectRepository.findById(projectDTO.getId());
		Student project = projectOptional.get();
		
		List<Student> projects = student.getStudents();
		projects.add(project);
		
		student.setStudents(projects);
		
		return studentRepository.save(student);
	}
	*/
}