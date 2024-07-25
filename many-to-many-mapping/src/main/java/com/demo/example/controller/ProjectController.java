package com.demo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.example.dto.ProjectDTO;
import com.demo.example.entity.Project;
import com.demo.example.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@GetMapping("/")
	public List<ProjectDTO> getProjects() {
		return projectService.findAll();
	}

	// Save operation
	@PostMapping("/")
	public Project saveProject(@RequestBody ProjectDTO projectDto) {
		return projectService.saveProject(projectDto);
	}

	@GetMapping("/{id}")
	public ProjectDTO getProjectById(@PathVariable Integer id) {
		return projectService.getProjectById(id);
	}

	@PutMapping("/{id}")
	public Project updateProject(@PathVariable Integer id, @RequestBody Project project) {
		return projectService.updateProject(id, project);
	}

	@DeleteMapping("/{id}")
	public void deleteProject(@PathVariable Integer id) {
		projectService.deleteProject(id);
	}
}
