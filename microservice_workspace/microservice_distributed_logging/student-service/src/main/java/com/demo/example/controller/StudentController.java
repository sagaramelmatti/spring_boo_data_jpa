package com.demo.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.dto.StudentDTO;
import com.demo.example.entity.StudentDetail;
import com.demo.example.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	private Logger log = LoggerFactory.getLogger(StudentController.class);

	@GetMapping("/")
	public ResponseEntity<List<StudentDTO>> getStudents() {
		
		log.info("Inside getStudents of Student Service1");

		List<StudentDTO> studentDTOList = studentService.findAll();
		
		log.info("End of getStudents of Student Service1");
		
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
	public StudentDTO updateStudent(@PathVariable Integer id, @RequestBody StudentDTO studentDto) {
		return studentService.updateStudent(id, studentDto);
	}

	@DeleteMapping("/{id}")
	public void deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudent(id);
	}
	
	@GetMapping("/searchStudent")
	public ResponseEntity<List<StudentDTO>> findStudentByStudentName(@RequestParam String name) {

		List<StudentDTO> studentDTOList = studentService.findStudentByStudentName(name);
		return ResponseEntity.status(HttpStatus.OK).body(studentDTOList);
	}
	
/*
	@PostMapping("/assignProject/{abc}")
	public StudentDetail addProjectToStudent(@PathVariable(value = "abc") Integer abc, @RequestBody ProjectDTO projectDTO) {
		return studentService.assignProjectToStudent(abc, projectDTO);
	}
	*/
}
