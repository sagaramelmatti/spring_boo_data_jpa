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

import com.demo.example.dto.StandardDTO;
import com.demo.example.entity.StandardDetail;
import com.demo.example.service.StandardService;

@RestController
@RequestMapping("/api/standards")
public class StandardController {

	@Autowired
	StandardService standardService;

	@GetMapping("/")
	public ResponseEntity<List<StandardDTO>> getStandards() {

		List<StandardDTO> standardDTOList = standardService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(standardDTOList);
	}

	// Save operation
	@PostMapping("/")
	public ResponseEntity<StandardDetail> saveStandard(@RequestBody StandardDTO standardDto) {
		StandardDetail standard = standardService.saveStandard(standardDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(standard);
	}

	@GetMapping("/{id}")
	public StandardDTO getStandardById(@PathVariable Integer id) {
		
		StandardDTO standardDTO = standardService.getStandardById(id);

		// Return the resource with a 200 (OK) status code
		return standardDTO;

	}

	@PutMapping("/{id}")
	public StandardDTO updateStandard(@PathVariable Integer id, @RequestBody StandardDTO standardDTO) {
		return standardService.updateStandard(id, standardDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteStandard(@PathVariable Integer id) {
		standardService.deleteStandard(id);
	}
}
