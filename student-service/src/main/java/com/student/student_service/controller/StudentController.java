package com.student.student_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.student_service.request.CreateStudentRequest;
import com.student.student_service.response.StudentResponse;
import com.student.student_service.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	public StudentResponse createAdd(@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createAddress(createStudentRequest);

	}
	@GetMapping("/getById/{id}")
	public StudentResponse getById(@PathVariable long id) {
		return studentService.getById(id);
	
}
	
}
