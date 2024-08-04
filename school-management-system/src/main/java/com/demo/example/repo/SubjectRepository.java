package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.SubjectDetail;

public interface SubjectRepository extends JpaRepository<SubjectDetail, Integer> {

}
