package com.rsm.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rsm.models.Address;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long>{
	
	List<Address> findAllAddressById(long id);

}
