package com.student.student_service.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AddressResponse {
	
	private long id;
	private String street;
	private String city;
	
	public AddressResponse(long addressId, String street, String city) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
