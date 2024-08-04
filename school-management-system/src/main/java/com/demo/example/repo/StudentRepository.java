package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.StudentDetail;

public interface StudentRepository extends JpaRepository<StudentDetail, Integer> {

}
