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

import com.demo.example.dto.AddressDTO;
import com.demo.example.entity.AddressDetail;
import com.demo.example.service.AddressService;

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
	public ResponseEntity<AddressDetail> saveAddress(@RequestBody AddressDTO addressDto) {
		AddressDetail address = addressService.saveAddress(addressDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(address);
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
