package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.dto.SubjectDTO;
import com.demo.example.entity.SubjectDetail;
import com.demo.example.repo.SubjectRepository;
import com.demo.example.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository projectRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<SubjectDTO> findAll() {

		List<SubjectDetail> projectList = projectRepository.findAll();

		List<SubjectDTO> projectDTOList = new ArrayList<SubjectDTO>();
		for (SubjectDetail project : projectList) {
			SubjectDTO projectDTO = modelMapper.map(project, SubjectDTO.class);
			projectDTOList.add(projectDTO);
		}
		return projectDTOList;
	}

	public SubjectDetail saveSubject(SubjectDTO projectDTO) {

		SubjectDetail project = modelMapper.map(projectDTO, SubjectDetail.class);
		return projectRepository.save(project);
	}

	public SubjectDTO getSubjectById(Integer id) {

		Optional<SubjectDetail> projectOptinal = projectRepository.findById(id);
		SubjectDetail project = projectOptinal.get();

		SubjectDTO projectDTO = modelMapper.map(project, SubjectDTO.class);
		return projectDTO;
	}

	public SubjectDetail updateSubject(Integer id, SubjectDetail project) {
		project.setId(id);
		return projectRepository.save(project);
	}

	public void deleteSubject(Integer id) {
		projectRepository.deleteById(id);
	}
}