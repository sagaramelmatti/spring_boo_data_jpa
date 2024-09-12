package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.StudentDTO;
import com.demo.example.entity.StudentDetail;

public interface StudentService {

	public List<StudentDTO> findAll();

	public StudentDetail saveStudent(StudentDTO studentDto);

	public StudentDTO getStudentById(Integer id);

	public StudentDTO updateStudent(Integer id, StudentDTO studentDto);

	public void deleteStudent(Integer id);

	public List<StudentDTO> findStudentByStudentName(String name);

	//public StudentDetail assignProjectToStudent(Integer standardId, ProjectDTO projectDTO);
}