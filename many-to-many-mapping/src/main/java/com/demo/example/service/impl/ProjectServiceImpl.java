package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dto.ProjectDTO;
import com.demo.example.entity.Project;
import com.demo.example.repo.ProjectRepository;
import com.demo.example.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<ProjectDTO> findAll() {

		List<Project> projectList = projectRepository.findAll();

		List<ProjectDTO> projectDTOList = new ArrayList<ProjectDTO>();
		for (Project project : projectList) {
			ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);
			projectDTOList.add(projectDTO);
		}
		return projectDTOList;
	}

	public Project saveProject(ProjectDTO projectDTO) {

		Project project = modelMapper.map(projectDTO, Project.class);
		return projectRepository.save(project);
	}

	public ProjectDTO getProjectById(Integer id) {

		Optional<Project> projectOptinal = projectRepository.findById(id);
		Project project = projectOptinal.get();

		ProjectDTO projectDTO = modelMapper.map(project, ProjectDTO.class);
		return projectDTO;
	}

	public Project updateProject(Integer id, Project project) {
		project.setId(id);
		return projectRepository.save(project);
	}

	public void deleteProject(Integer id) {
		projectRepository.deleteById(id);
	}
}