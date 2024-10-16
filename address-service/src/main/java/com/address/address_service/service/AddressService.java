package com.address.address_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.address.address_service.entity.Address;
import com.address.address_service.repository.AddressRepo;
import com.address.address_service.request.CreateAddressRequest;
import com.address.address_service.response.AddressResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AddressService {
	
	@Autowired 
	private AddressRepo addRepo;
	
	public AddressResponse createaddress(CreateAddressRequest createAddRequest) {
		Address address=new Address();
		address.setStreet(createAddRequest.getStreet());
		address.setCity(createAddRequest.getCity());
		addRepo.save(address);
		
		return new AddressResponse(address);
		
	}
	public AddressResponse getById(long id) {
		log.info("Inside get by Id{}",id);
		Address address=addRepo.findById(id).get();
		return new AddressResponse(address);
	}
		
}



