package com.demo.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.example.entity.StudentDetail;

public interface StudentRepository extends JpaRepository<StudentDetail, Integer> {

	List<StudentDetail> findByName(String name);
	
	
	@Query("SELECT s FROM StudentDetail s WHERE s.name = :studentName")   // HQL ( JQL)
	
	List<StudentDetail> findStudentWithName(String studentName);

}
