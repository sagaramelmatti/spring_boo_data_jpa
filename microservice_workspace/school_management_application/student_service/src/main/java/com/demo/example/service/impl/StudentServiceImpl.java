package com.demo.example.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.http.HttpStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.example.common.util.MessageConstants;
import com.demo.example.dto.AddressDTO;
import com.demo.example.dto.StandardDTO;
import com.demo.example.dto.StudentDTO;
import com.demo.example.entity.StudentDetail;
import com.demo.example.exception.ResourceNotFoundException;
import com.demo.example.repo.StudentRepository;
import com.demo.example.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	private RestTemplate restTemplate;

	ModelMapper modelMapper = new ModelMapper();

	public List<StudentDTO> findAll() {
		List<StudentDTO> studentDtoList = null;

		List<StudentDetail> studentList = studentRepository.findAll();

		studentDtoList = new ArrayList<StudentDTO>();
		for (StudentDetail student : studentList) {

			StudentDTO studentDto = modelMapper.map(student, StudentDTO.class); // Student DTO

			StandardDTO standardDTO = restTemplate.getForObject("http://localhost:9191/api/standards/{id}",
					StandardDTO.class, student.getStandardId());
			studentDto.setStandardName(standardDTO.getName());
			studentDtoList.add(studentDto);
		}
		return studentDtoList;
	}

	public StudentDetail saveStudent(StudentDTO studentDto) {

		AddressDTO addressDTO = new AddressDTO();
		
		addressDTO.setPerAddress(studentDto.getAddressDTO().getPerAddress());
		addressDTO.setCity(studentDto.getAddressDTO().getCity());
		addressDTO.setPinCode(studentDto.getAddressDTO().getPinCode());
		
		ResponseEntity<?> responseEntity = restTemplate
				.postForEntity("http://localhost:9191/api/address/", addressDTO, AddressDTO.class);

		StudentDetail student = modelMapper.map(studentDto, StudentDetail.class);
		
		// Optionally, you can use the response if needed
	    if(responseEntity.getStatusCode().value()== (HttpStatus.SC_CREATED)) {
	    	addressDTO = (AddressDTO) responseEntity.getBody();
	    	student.setAddressId(addressDTO.getId());
	    }

	    // Save the student entity in the student-service repository
	    return studentRepository.save(student);
		
	}

	public StudentDTO getStudentById(Integer id) {
		StudentDTO studentDto = null;
		Optional<StudentDetail> studentOptinal = studentRepository.findById(id);

		if (studentOptinal.isPresent()) {
			StudentDetail student = studentOptinal.get();
			studentDto = modelMapper.map(student, StudentDTO.class);
		}

		return studentDto;
	}

	public StudentDTO updateStudent(Integer id, StudentDTO studentDto) {

		StudentDetail studentDetail = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STUDENT_NOT_FOUND + id));

		studentDetail.setName(studentDto.getName());
		studentDetail.setAge(Integer.parseInt(studentDto.getAge()));

		StudentDetail updatedStudentDetail = studentRepository.save(studentDetail);
		return modelMapper.map(updatedStudentDetail, StudentDTO.class);

	}

	public void deleteStudent(Integer id) {

		StudentDetail studentDetail = studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(MessageConstants.STUDENT_NOT_FOUND + id));

		studentRepository.delete(studentDetail);
	}

	@Override
	public List<StudentDTO> findStudentByStudentName(String name) {

		List<StudentDTO> studentDtoList = null;
		name = name.trim();
		List<StudentDetail> studentList = studentRepository.findStudentWithName(name);

		studentDtoList = new ArrayList<StudentDTO>();
		for (StudentDetail student : studentList) {

			StudentDTO studentDto = modelMapper.map(student, StudentDTO.class); // Student DTO

			studentDtoList.add(studentDto);
		}
		return studentDtoList;
	}
}