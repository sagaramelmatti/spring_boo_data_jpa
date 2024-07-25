package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.ProjectDTO;
import com.demo.example.entity.Project;

public interface ProjectService {

	public List<ProjectDTO> findAll();

	public Project saveProject(ProjectDTO categoryDto);

	public ProjectDTO getProjectById(Integer id);

	public Project updateProject(Integer id, Project category);

	public void deleteProject(Integer id);
}