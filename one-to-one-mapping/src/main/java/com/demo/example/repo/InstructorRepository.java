package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
