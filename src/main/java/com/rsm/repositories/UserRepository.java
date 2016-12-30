package com.rsm.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rsm.models.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
	
	List<User> findAllUserById(long id);
	
	

}
