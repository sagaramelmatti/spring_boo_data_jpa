package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
