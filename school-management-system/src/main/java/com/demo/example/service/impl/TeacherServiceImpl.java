package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.common.util.MessageConstants;
import com.demo.example.dto.StandardDTO;
import com.demo.example.dto.TeacherDTO;
import com.demo.example.entity.StandardDetail;
import com.demo.example.entity.TeacherDetail;
import com.demo.example.exception.ResourceNotFoundException;
import com.demo.example.repo.TeacherRepository;
import com.demo.example.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TeacherRepository teacherRepository;

	ModelMapper modelMapper = new ModelMapper();

	public List<TeacherDTO> findAll() {
		
		List<TeacherDTO> teacherDtoList = new ArrayList<TeacherDTO>();
		List<TeacherDetail> teacherList = teacherRepository.findAll();

		for (TeacherDetail teacher : teacherList) {
			TeacherDTO teacherDto = modelMapper.map(teacher, TeacherDTO.class);
			
			// set Standard details to teacher
			List<StandardDTO> standardDTOList = new ArrayList<StandardDTO>();

			for (StandardDetail standardDetail : teacher.getStandardDetails()) {
				StandardDTO standardDTO = modelMapper.map(standardDetail, StandardDTO.class);
				standardDTOList.add(standardDTO);
			}

			teacherDto.setStandardDtos(standardDTOList);
			teacherDtoList.add(teacherDto);
		}

		return teacherDtoList;
	}

	public TeacherDetail saveTeacher(TeacherDTO teacherDto) {

		TeacherDetail teacher = modelMapper.map(teacherDto, TeacherDetail.class);
		return teacherRepository.save(teacher);
	}

	public TeacherDTO getTeacherById(Integer id) {
		TeacherDTO teacherDto = null;
		Optional<TeacherDetail> teacherOptinal = teacherRepository.findById(id);

		if (!teacherOptinal.isPresent()) {
			TeacherDetail teacher = teacherOptinal.get();
			teacherDto = modelMapper.map(teacher, TeacherDTO.class);
		}
		return teacherDto;
	}

	public TeacherDetail updateTeacher(Integer id, TeacherDetail teacher) {
		teacher.setId(id);
		return teacherRepository.save(teacher);
	}

	public TeacherDTO updateTeacher(Integer id, TeacherDTO teacherDto) {

		TeacherDetail teacherDetail = teacherRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STUDENT_NOT_FOUND + id));

		teacherDetail.setName(teacherDto.getName());
		teacherDetail.setContactNumber(teacherDto.getContactNumber());
		teacherDetail.setEducation(teacherDto.getEducation());

		TeacherDetail updatedTeacherDetail = teacherRepository.save(teacherDetail);
		return modelMapper.map(updatedTeacherDetail, TeacherDTO.class);

	}

	public void deleteTeacher(Integer id) {

		TeacherDetail teacherDetail = teacherRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.TEACHER_NOT_FOUND + id));

		teacherRepository.delete(teacherDetail);
	}

	/*
	 * @Override public TeacherDetail assignTeacherToTeacher(Integer teacherId,
	 * TeacherDTO projectDTO) {
	 * 
	 * Optional<TeacherDetail> teacherOptional =
	 * teacherRepository.findById(teacherId); TeacherDetail teacher =
	 * teacherOptional.get();
	 * 
	 * 
	 * Optional<Teacher> projectOptional =
	 * projectRepository.findById(projectDTO.getId()); Teacher project =
	 * projectOptional.get();
	 * 
	 * List<Teacher> projects = teacher.getTeachers(); projects.add(project);
	 * 
	 * teacher.setTeachers(projects);
	 * 
	 * return teacherRepository.save(teacher); }
	 */
}