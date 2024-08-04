package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.SubjectDTO;
import com.demo.example.entity.SubjectDetail;

public interface SubjectService {

	public List<SubjectDTO> findAll();

	public SubjectDetail saveSubject(SubjectDTO subjectDto);

	public SubjectDTO getSubjectById(Integer id);

	public SubjectDTO updateSubject(Integer id, SubjectDTO subjectDto);

	public void deleteSubject(Integer id);
}