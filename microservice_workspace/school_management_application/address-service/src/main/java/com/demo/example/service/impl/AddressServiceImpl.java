package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.common.util.MessageConstants;
import com.demo.example.dto.AddressDTO;
import com.demo.example.entity.AddressDetail;
import com.demo.example.exception.ResourceNotFoundException;
import com.demo.example.repo.AddressRepository;
import com.demo.example.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	AddressRepository addressRepository;
	
	ModelMapper modelMapper = new ModelMapper();

	public List<AddressDTO> findAll() {
		List<AddressDTO> addressDtoList = null;
			
		List<AddressDetail> addressList = addressRepository.findAll();

		addressDtoList = new ArrayList<AddressDTO>();
		for (AddressDetail address : addressList) {
			
			AddressDTO addressDto = modelMapper.map(address, AddressDTO.class); // Address DTO
			addressDtoList.add(addressDto);
		}
		return addressDtoList;
	}

	public AddressDetail saveAddress(AddressDTO addressDto) {

		AddressDetail address = modelMapper.map(addressDto, AddressDetail.class);
		
		return addressRepository.save(address);
	}

	public AddressDTO getAddressById(Integer id) {
		AddressDTO addressDto = null;
		Optional<AddressDetail> addressOptinal = addressRepository.findById(id);
		
	    if (addressOptinal.isPresent()) {
	    	AddressDetail address = addressOptinal.get();
			addressDto = modelMapper.map(address, AddressDTO.class);
	    }
		
		
		return addressDto;
	}

	public AddressDTO updateAddress(Integer id, AddressDTO addressDto) {

		AddressDetail addressDetail = addressRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.ADDRESS_NOT_FOUND + id));

		addressDetail.setPerAddress(addressDto.getPerAddress());;
		addressDetail.setCity(addressDto.getCity());
		addressDetail.setPinCode(addressDto.getPinCode());
		
		AddressDetail updatedAddressDetail = addressRepository.save(addressDetail);
		return modelMapper.map(updatedAddressDetail, AddressDTO.class);

	}

	public void deleteAddress(Integer id) {

		AddressDetail addressDetail = addressRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.ADDRESS_NOT_FOUND + id));

		addressRepository.delete(addressDetail);
	}

	
}