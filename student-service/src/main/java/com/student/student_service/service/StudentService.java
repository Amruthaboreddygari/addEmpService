package com.student.student_service.service;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.student.student_service.entity.Student;
import com.student.student_service.repository.StudentRepository;
import com.student.student_service.request.CreateStudentRequest;
import com.student.student_service.response.AddressResponse;
import com.student.student_service.response.StudentResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private WebClient webClient;
	
	public StudentResponse createAddress(CreateStudentRequest createStudentReq) {
		
		Student student=new Student();
		student.setFirstname(createStudentReq.getFirstname());
		student.setLastname(createStudentReq.getLastname());
		student.setEmail(createStudentReq.getEmail());
		student.setAddressId(createStudentReq.getAddressId());
		studentRepository.save(student);
		StudentResponse studentResponse=new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		return studentResponse;
		
	}
	public StudentResponse getById(long id) {
		log.info("Inside get by Id {}",id);
		Student student=studentRepository.findById(id).get();
		StudentResponse studentResponse=new StudentResponse(student);
		studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		return studentResponse;
		
	}
	public AddressResponse getAddressById(long addressId) {
		Mono<AddressResponse> addressResponse = webClient.get().uri("/getById/"+addressId).retrieve().bodyToMono(AddressResponse.class);
		return addressResponse.block();
	}

	}