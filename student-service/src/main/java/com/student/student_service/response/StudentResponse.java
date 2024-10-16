package com.student.student_service.response;

import com.student.student_service.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StudentResponse {
	
	
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private long addressId;
	
	private AddressResponse addressresponse;
	
	public StudentResponse(Student student) {
		this.id = student.getId();
		this.firstname = student.getFirstname();
		this.lastname = student.getLastname();
		this.email = student.getEmail();
		this.addressId = student.getAddressId();
	}

	

	public void setAddressResponse(AddressResponse addressById) {
		
		
	}

}
