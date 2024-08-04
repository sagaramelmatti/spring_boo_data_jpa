package com.demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.dto.StudentDTO;
import com.demo.example.entity.StudentDetail;
import com.demo.example.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/")
	public ResponseEntity<List<StudentDTO>> getStudents() {

		List<StudentDTO> studentDTOList = studentService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(studentDTOList);
	}

	// Save operation
	@PostMapping("/")
	public ResponseEntity<StudentDetail> saveStudent(@RequestBody StudentDTO studentDto) {
		StudentDetail student = studentService.saveStudent(studentDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable Integer id) {
		
		StudentDTO studentDTO = studentService.getStudentById(id);

		// If the resource is not found, return a 404 (not found) status code
		if (studentDTO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		// Return the resource with a 200 (OK) status code
		return ResponseEntity.status(HttpStatus.OK).body(studentDTO);

	}

	@PutMapping("/{id}")
	public StudentDetail updateStudent(@PathVariable Integer id, @RequestBody StudentDetail student) {
		return studentService.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
	}
	
/*
	@PostMapping("/assignProject/{abc}")
	public StudentDetail addProjectToStudent(@PathVariable(value = "abc") Integer abc, @RequestBody ProjectDTO projectDTO) {
		return studentService.assignProjectToStudent(abc, projectDTO);
	}
	*/
}
