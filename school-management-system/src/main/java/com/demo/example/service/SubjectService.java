package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.SubjectDTO;
import com.demo.example.entity.SubjectDetail;

public interface SubjectService {

	public List<SubjectDTO> findAll();

	public SubjectDetail saveSubject(SubjectDTO categoryDto);

	public SubjectDTO getSubjectById(Integer id);

	public SubjectDetail updateSubject(Integer id, SubjectDetail category);

	public void deleteSubject(Integer id);
}