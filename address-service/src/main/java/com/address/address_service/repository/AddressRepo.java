package com.address.address_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.address.address_service.entity.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

	
	
}
