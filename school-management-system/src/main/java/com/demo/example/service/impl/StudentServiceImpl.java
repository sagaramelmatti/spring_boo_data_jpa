package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dto.StandardDTO;
import com.demo.example.dto.StudentDTO;
import com.demo.example.entity.StudentDetail;
import com.demo.example.repo.StudentRepository;
import com.demo.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	public List<StudentDTO> findAll() {
		
		List<StudentDTO> studentDtoList = null;
			

		List<StudentDetail> studentList = studentRepository.findAll();

		studentDtoList = new ArrayList<StudentDTO>();
		
		for (StudentDetail student : studentList) {
			StudentDTO studentDto = modelMapper.map(student, StudentDTO.class);
			StandardDTO standardDTO = modelMapper.map(student.getStandardDetail(), StandardDTO.class);
			studentDto.setStandardDTO(standardDTO);
			studentDtoList.add(studentDto);
		}
		
		
		return studentDtoList;
	}

	public StudentDetail saveStudent(StudentDTO studentDto) {

		StudentDetail student = modelMapper.map(studentDto, StudentDetail.class);
		return studentRepository.save(student);
	}

	public StudentDTO getStudentById(Integer id) {
		StudentDTO studentDto = null;
		Optional<StudentDetail> studentOptinal = studentRepository.findById(id);
		
	    if (!studentOptinal.isPresent()) {
	    	StudentDetail student = studentOptinal.get();
			studentDto = modelMapper.map(student, StudentDTO.class);
	    }
		return studentDto;
	}

	public StudentDetail updateStudent(Integer id, StudentDetail student) {
		student.setId(id);
		return studentRepository.save(student);
	}

	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
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