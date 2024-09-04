package com.demo.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import com.demo.example.dto.AddressDTO;
import com.demo.example.entity.AddressDetail;
import com.demo.example.service.AddressService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/address")
public class AddressController {

	@Autowired
	AddressService addressService;

	@GetMapping("/")
	public ResponseEntity<List<AddressDTO>> getAddresss() {

		List<AddressDTO> addressDTOList = addressService.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(addressDTOList);
	}

	// Save operation
	@PostMapping("/")
	public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO addressDto) {
		
		String json = null;
		AddressDetail address = addressService.saveAddress(addressDto);
		
		ModelMapper modelMapper = new ModelMapper();
		addressDto = modelMapper.map(address, AddressDTO.class); // Address DTO
		
		/*
		try {
			json = new ObjectMapper().writeValueAsString(address);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addressDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getAddressById(@PathVariable Integer id) {
		
		AddressDTO addressDTO = addressService.getAddressById(id);

		// If the resource is not found, return a 404 (not found) status code
		if (addressDTO == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		// Return the resource with a 200 (OK) status code
		return ResponseEntity.status(HttpStatus.OK).body(addressDTO);

	}

	@PutMapping("/{id}")
	public AddressDTO updateAddress(@PathVariable Integer id, @RequestBody AddressDTO addressDto) {
		return addressService.updateAddress(id, addressDto);
	}

	@DeleteMapping("/{id}")
	public void deleteAddress(@PathVariable Integer id) {
		addressService.deleteAddress(id);
	}
	
}
