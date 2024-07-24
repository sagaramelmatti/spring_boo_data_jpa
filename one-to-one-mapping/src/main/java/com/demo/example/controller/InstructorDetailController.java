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

import com.demo.example.dto.InstructorDetailDto;
import com.demo.example.entity.InstructorDetail;
import com.demo.example.service.InstructorDetailService;

@RestController
@RequestMapping("/instructorDetails")
public class InstructorDetailController {

	@Autowired
	InstructorDetailService instructorDetailService;

	@GetMapping("/")
	public List<InstructorDetailDto> getInstructorDetails() {
		return instructorDetailService.findAll();
	}

	// Save operation
	@PostMapping("/")
	public InstructorDetail saveInstructorDetail(@RequestBody InstructorDetailDto instructorDetailDto) {
		return instructorDetailService.saveInstructorDetail(instructorDetailDto);
	}

	@GetMapping("/{id}")
	public InstructorDetailDto getInstructorDetailById(@PathVariable Integer id) {
		return instructorDetailService.getInstructorDetailById(id);
	}

	@PutMapping("/{id}")
	public InstructorDetail updateInstructorDetail(@PathVariable Integer id, @RequestBody InstructorDetail instructorDetail) {
		return instructorDetailService.updateInstructorDetail(id, instructorDetail);
	}

	@DeleteMapping("/{id}")
	public void deleteInstructorDetail(@PathVariable Integer id) {
		instructorDetailService.deleteInstructorDetail(id);
	}
}
