package com.demo.example.service;

import java.util.List;

import com.demo.example.dto.TeacherDTO;
import com.demo.example.entity.TeacherDetail;

public interface TeacherService {

	public List<TeacherDTO> findAll();

	public TeacherDetail saveTeacher(TeacherDTO studentDto);

	public TeacherDTO getTeacherById(Integer id);

	public TeacherDTO updateTeacher(Integer id, TeacherDTO teacherDTO);

	public void deleteTeacher(Integer id);

}