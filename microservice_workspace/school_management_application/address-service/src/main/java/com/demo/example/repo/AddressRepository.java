package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.AddressDetail;

public interface AddressRepository extends JpaRepository<AddressDetail, Integer> {


}
