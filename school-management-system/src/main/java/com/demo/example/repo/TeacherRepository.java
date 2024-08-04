package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.TeacherDetail;

public interface TeacherRepository extends JpaRepository<TeacherDetail, Integer> {

}
