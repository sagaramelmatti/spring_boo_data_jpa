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

import com.demo.example.dto.TeacherDTO;
import com.demo.example.entity.TeacherDetail;
import com.demo.example.service.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

	@Autowired
	TeacherService teacherService;

	@GetMapping("/")
	public ResponseEntity<List<TeacherDTO>> getTeachers() {

		List<TeacherDTO> teacherDTOList = teacherService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(teacherDTOList);
	}

	// Save operation
	@PostMapping("/")
	public ResponseEntity<TeacherDetail> saveTeacher(@RequestBody TeacherDTO teacherDto) {
		TeacherDetail teacher = teacherService.saveTeacher(teacherDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(teacher);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getTeacherById(@PathVariable Integer id) {
		
		TeacherDTO teacherDTO = teacherService.getTeacherById(id);

		// If the resource is not found, return a 404 (not found) status code
		if (teacherDTO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		// Return the resource with a 200 (OK) status code
		return ResponseEntity.status(HttpStatus.OK).body(teacherDTO);

	}

	@PutMapping("/{id}")
	public TeacherDTO updateTeacher(@PathVariable Integer id, @RequestBody TeacherDTO teacherDTO) {
		return teacherService.updateTeacher(id, teacherDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteTeacher(@PathVariable Integer id) {
		teacherService.deleteTeacher(id);
	}
	
	/*
	@PostMapping("/assignProject/{abc}")
	public TeacherDetail addProjectToTeacher(@PathVariable(value = "abc") Integer abc, @RequestBody ProjectDTO projectDTO) {
		return teacherService.assignProjectToTeacher(abc, projectDTO);
	}
	*/
}
