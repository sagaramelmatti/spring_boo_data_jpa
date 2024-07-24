package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.InstructorDetail;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Integer> {

}
