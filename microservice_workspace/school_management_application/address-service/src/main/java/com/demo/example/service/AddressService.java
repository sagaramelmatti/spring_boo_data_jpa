package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.AddressDTO;
import com.demo.example.entity.AddressDetail;

public interface AddressService {

	public List<AddressDTO> findAll();

	public AddressDetail saveAddress(AddressDTO addressDto);

	public AddressDTO getAddressById(Integer id);

	public AddressDTO updateAddress(Integer id, AddressDTO addressDto);

	public void deleteAddress(Integer id);

}