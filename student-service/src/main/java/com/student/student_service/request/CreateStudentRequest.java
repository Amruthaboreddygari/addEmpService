package com.student.student_service.request;

import lombok.Data;

@Data
public class CreateStudentRequest {

	private String firstname;
	private String lastname;
	private String email;
	private long addressId;
}
