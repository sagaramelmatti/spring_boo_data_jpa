package com.demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.dto.InstructorDto;
import com.demo.example.entity.Instructor;
import com.demo.example.service.InstructorService;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

	@Autowired
	InstructorService instructorService;

	@GetMapping("/")
	public List<InstructorDto> getInstructors() {
		return instructorService.findAll();
	}

	// Save operation
	@PostMapping("/")
	public Instructor saveInstructor(@RequestBody InstructorDto instructorDto) {
		return instructorService.saveInstructor(instructorDto);
	}

	@GetMapping("/{id}")
	public InstructorDto getInstructorById(@PathVariable Integer id) {
		return instructorService.getInstructorById(id);
	}

	@PutMapping("/{id}")
	public Instructor updateInstructor(@PathVariable Integer id, @RequestBody Instructor instructor) {
		return instructorService.updateInstructor(id, instructor);
	}

	@DeleteMapping("/{id}")
	public void deleteInstructor(@PathVariable Integer id) {
		instructorService.deleteInstructor(id);
	}
}
