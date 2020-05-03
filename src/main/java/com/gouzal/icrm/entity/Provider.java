package com.gouzal.icrm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String CompanyName;
	private String legalType;
	private String mobileNumber;
	private String fixNumber;
	private String email;
	private String ice;
	private String address;

    @ManyToOne
	private City city;
	
}