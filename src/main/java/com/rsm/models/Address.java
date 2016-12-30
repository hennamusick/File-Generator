package com.rsm.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {

	@Id
	private long id;
	
	private String number;
	
	private String city;
	
	private String district;
	
	@OneToOne
	private User user;
}
