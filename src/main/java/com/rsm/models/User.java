package com.rsm.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	private long id;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	@OneToOne
	private Address address;

}
